package skylark.intern.book.cinetic;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

import skylark.intern.book.cinetic.adapter.SeatAdapter;
import skylark.intern.book.cinetic.model.Seat;
import skylark.intern.book.cinetic.model.TicketBooking;
import skylark.intern.book.cinetic.model.User;

import static android.media.CamcorderProfile.get;

public class BookingActivity extends AppCompatActivity {
    String name,dt,cineman,stime;
    Intent i;
    //EditText ;
    TextView seats,date;
    private ImageView poster;
    AppCompatSpinner cinema_name,time;
    RecyclerView recycler;
    List<Seat> seat,list;
    SeatAdapter seatAdapter;
    Calendar myCalendar = Calendar.getInstance();
    Button reset,book;
    public static TreeMap<String, Seat> chosenseat = new TreeMap<>();
    TicketBooking tkbk;
    User buser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        Toolbar tbar =(Toolbar) findViewById(R.id.z_toolbar);
        tbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        setSupportActionBar(tbar);
        tbar.setNavigationIcon(R.drawable.ic_arrow);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},00);

        //declaration item
        cinema_name = findViewById(R.id.cinema);
        time = findViewById(R.id.show_time);
        date = findViewById(R.id.choosedate);
        seats = findViewById(R.id.totalseats);
        reset = findViewById(R.id.reset);
        book = findViewById(R.id.book);
        i = getIntent();
        name = i.getStringExtra("nname");
        poster = findViewById(R.id.bkphoto);


        //Assigning date to calender dialog
        final DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();

            }

        };

        //Click event for date EditText view
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePickerDialog(BookingActivity.this, dateSetListener, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //Click event for reset button
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclersetup();
                seats.setText("Your Seat(s)");
                chosenseat.clear();
                if(chosenseat.size()<=0){
                    Toast.makeText(getApplicationContext(),"Cleared",Toast.LENGTH_LONG).show();
                }
            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BookingActivity.this,BookingDetail.class);
                dt = date.getText().toString();
                cineman = cinema_name.getSelectedItem().toString();
                stime = time.getSelectedItem().toString();
                //User user=Navigation.user;
                list = new ArrayList<>(chosenseat.values());

                tkbk = new TicketBooking(dt,cineman,stime,name);
                tkbk.setSeatlist(list);
                i.putExtra("ticket",tkbk);
                startActivity(i);
            }
        });



        //Assigning date to showTime spinner
        String[] showTime = new String[]{"Choose Time","9:30 AM","12:30 PM", "3:30 PM","6:30 PM"};
        ArrayAdapter<String> showtimeAdapter = new ArrayAdapter<>(this, R.layout.spinner_item_time, showTime);
        time.setAdapter(showtimeAdapter);

        //Assigning cinema name to cinemas spinner
        String[] cinemas = new String[]{"Choose Cinema",getString(R.string.msan), getString(R.string.mga), getString(R.string.mthe),getString(R.string.mda),getString(R.string.twin),getString(R.string.east),getString(R.string.presid),getString(R.string.mwaz)};
        ArrayAdapter<String> cinema = new ArrayAdapter<>(this, R.layout.spinner_item, cinemas);
        cinema_name.setAdapter(cinema);

        //get string form intent
        //set image to image view
        try {
            if (name.equals(getString(R.string.init))) {
                poster.setImageResource(R.drawable.inifinity_landscape1);
            } else if (name.equals(getString(R.string.tsow))) {
                poster.setImageResource(R.drawable.the_sow_landscape1);
            } else if (name.equals(getString(R.string.dun))) {
                poster.setImageResource(R.drawable.dunkrik_landscape1);
            } else if (name.equals(getString(R.string.tgsm))) {
                poster.setImageResource(R.drawable.the_gtsm_landscape1);
            }
        }catch (NullPointerException e){
            Toast.makeText(this,e+"",Toast.LENGTH_LONG).show();
        }

        recyclersetup();

    }


    //Recycler Setup in new method because we need to call it 2 times
    private void recyclersetup(){
        recycler = (RecyclerView) this.findViewById(R.id.rec);
        recycler.setLayoutManager(new GridLayoutManager(this,5));
        seat = new ArrayList<>();

        //loop 3 times because we have 3 different types
        for(int i=0; i<3 ;i++){
            //first time of loop, this yellow team
            if(i==0){
                for(int j=0; j<10; j++){
                    seat.add(new Seat(j+1,"Y"+(j+1) ,"Y"));
                }

            }
            //second time of loop, this is Green Team
            else if(i == 1){

                for(int j=0; j<20; j++){
                    seat.add(new Seat(j+11,"G"+(j+1) ,"G"));
                }

            }
            //third time of loop, this is Red Team
            else if(i==2){

                for(int j=0; j<20; j++){
                    seat.add(new Seat(j+31,"R"+(j+1) ,"R"));
                }
            }
        }

        seatAdapter= new SeatAdapter(this,seat,seats);
        recycler.setAdapter(seatAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;

        }

        return true;
    }

    //Set date to EditText
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        Toast.makeText(this,sdf.format(myCalendar.getTime()),Toast.LENGTH_LONG).show();
        date.setText(sdf.format(myCalendar.getTime()));
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        chosenseat.clear();
    }
}
