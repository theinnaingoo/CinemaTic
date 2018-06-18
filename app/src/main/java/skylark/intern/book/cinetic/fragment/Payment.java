package skylark.intern.book.cinetic.fragment;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import skylark.intern.book.cinetic.BookingDetail;
import skylark.intern.book.cinetic.R;
import skylark.intern.book.cinetic.model.Seat;
import skylark.intern.book.cinetic.model.TicketBooking;
import skylark.intern.book.cinetic.model.User;


public class Payment extends Fragment {
      User payuser;
      private   TextView name,amount;
      private    List<Seat> payseat;
      private int totalamt;
      private   String[] month;
      private   String[] year;
      private   Spinner spinner,spinne;
      private   List<String> monthList,yearList;
      private ImageView visa,master,paypal;
      private Button pay;
      public static List<TicketBooking> payticks;
      User buser;

      private   Calendar calendar = Calendar.getInstance();
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View v = inflater.inflate(R.layout.fragment_payment, container, false);
            buser= new User(160722,"Ma Yamin Thu","09262742288","maungzwe.tutgo@gmail.com","QAZqaz123$%^");
            initializeUIComponent(v);
            initializeData(v);

            spinner.setAdapter(adapter(monthList));
            spinne.setAdapter(adapter(yearList));


            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selectedItemText = (String) parent.getItemAtPosition(position);
                    // If user change the default selection
                    // First item is disable and it is used for hint
                    if(position > 0){
                        // Notify the selected item text
                        Toast.makeText(getActivity(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            spinne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selectedItemText = (String) parent.getItemAtPosition(position);
                    // If user change the default selection
                    // First item is disable and it is used for hint
                    if(position > 0){
                        // Notify the selected item text
                        Toast.makeText(getActivity(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            return  v;
        }

        private void initializeUIComponent(View v) {

            spinner =  v.findViewById(R.id.exp_m);
            spinne = v.findViewById(R.id.exp_y);
            name =v.findViewById(R.id.name);
            amount = v.findViewById(R.id.amount);
            visa = v.findViewById(R.id.visa);
            master = v.findViewById(R.id.master);
            paypal = v.findViewById(R.id.paypal);
            pay = v.findViewById(R.id.pay);
            month = new String[]{"MM", "01", "02", "03", "04", "05", "06", "07", "08","09", "10", "11", "12"};
            year = new String[]{"YY","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};

        }

        private void initializeData(View v) {
            pay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    BookingDetail.viewPager.setCurrentItem(2);
                    BookingDetail.tabLayout.getTabAt(2).select();
                    View view = BookingDetail.tabLayout.getTabAt(2).getCustomView();
                    ImageView imgvTab = (ImageView) view.findViewById(R.id.image);
                    TextView tvTab = (TextView) view.findViewById(R.id.tv_tab);

                    imgvTab.setImageResource(R.drawable.ic_tick);
                    tvTab.setTextColor(getResources().getColor(R.color.colorPrimary));
                    tvTab.setTypeface(null, Typeface.BOLD);
                }
            });

            visa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),"Visa service will available later ",Toast.LENGTH_SHORT).show();
                }
            });
            master.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),"Master service will available later ",Toast.LENGTH_SHORT).show();
                }
            });
            paypal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),"Paypal service will available later ",Toast.LENGTH_SHORT).show();

                }
            });
            monthList = new ArrayList<>(Arrays.asList(month));
            yearList = new ArrayList<>(Arrays.asList(year));
            payuser= BookingDetail.tickt.getUser();
            try{
                name.setText(buser.getUsername());
            }catch (NullPointerException e){
                e.printStackTrace();
            }
            payseat = BookingDetail.tickt.getSeatlist();
            for(Seat s:payseat){
                totalamt+= Integer.parseInt(s.getSeatPrice());
            }
            amount.setText(totalamt+"");
        }

        private ArrayAdapter<String> adapter(List<String> list) {
            final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                    getActivity(), R.layout.spinner_item, list) {
                @Override
                public boolean isEnabled(int position) {
                    if (position == 0) {
                        // Disable the first item from Spinner
                        // First item will be use for hint
                        return false;
                    } else {
                        return true;
                    }
                }

                @Override
                public View getDropDownView(int position, View convertView,
                                            ViewGroup parent) {
                    View view = super.getDropDownView(position, convertView, parent);
                    TextView tv = (TextView) view;
                    if (position == 0) {
                        // Set the hint text color gray
                        tv.setTextColor(Color.GRAY);
                    } else {
                        tv.setTextColor(Color.BLACK);
                    }
                    return view;
                }
            };
            spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
            return spinnerArrayAdapter;
        }
    }
