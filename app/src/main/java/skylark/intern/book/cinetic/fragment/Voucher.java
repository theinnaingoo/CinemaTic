package skylark.intern.book.cinetic.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.github.sumimakito.awesomeqr.AwesomeQRCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import skylark.intern.book.cinetic.BookingDetail;
import skylark.intern.book.cinetic.R;
import skylark.intern.book.cinetic.ScreenShot;
import skylark.intern.book.cinetic.adapter.VoucherAdapter;
import skylark.intern.book.cinetic.model.Seat;
import skylark.intern.book.cinetic.model.TicketBooking;


public class Voucher extends Fragment {


    private Bitmap bg;
    private List<Seat> seat;
    private List<TicketBooking> tickqr;
    public static List<TicketBooking> voutick = new ArrayList<>();
    private RecyclerView qrcyc;
    private VoucherAdapter voucherAdapter;
    Button btn_save,btn_share;
    LinearLayout linear;
    public static int REQUEST_PERMISSIONS = 1;
    boolean boolean_permission=true;
    boolean boolean_save;
    String s;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_voucher, container, false);

        //v.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        View v = inflater.inflate(R.layout.fragment_voucher, container, false);
        tickqr =new ArrayList<>();
        seat = BookingDetail.tickt.getSeatlist();
        qrcyc = v.findViewById(R.id.qrcyc);
        btn_save = (Button) v.findViewById(R.id.btn_save);
        btn_share = (Button)v.findViewById(R.id.btn_share);
        linear = (LinearLayout)v.findViewById(R.id.linear);
        init();
        qrcyc.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //qrcyc.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
     //  initializeData(v);
        bg = ((BitmapDrawable) getResources().getDrawable(R.drawable.qr_back)).getBitmap();
//        if(voutick.size()<=0){
//            voutick = new ArrayList<>();
//        }
        if(seat.size()>0){
            for(Seat s: seat){
                String st = BookingDetail.tickt.getMoviename()+"\n"
                        +BookingDetail.tickt.getCinema()+"\n"
                        +BookingDetail.tickt.getDate()+"\n"
                        +s.getSeatName()+"\n"
                        +BookingDetail.tickt.getShowtime();
                Bitmap qrCode = AwesomeQRCode.create(st, 800, 20, 0.3f, Color.BLACK, Color.WHITE, bg, true, true);
//                qr.setImageBitmap(qrCode);
                TicketBooking tbk = new TicketBooking(BookingDetail.tickt.getDate(),BookingDetail.tickt.getCinema(),BookingDetail.tickt.getShowtime(),BookingDetail.tickt.getMoviename());
                tbk.setSeat(s.getSeatName());
                tbk.setBmap(qrCode);
                tickqr.add(tbk);
                voutick.add(tbk);
            }
        }

        voucherAdapter= new VoucherAdapter(getActivity(),tickqr);
        qrcyc.setAdapter(voucherAdapter);

        return  v;
    }
    private void init() {


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (boolean_save) {
                  Toast.makeText(getActivity(),"Already saved",Toast.LENGTH_LONG).show();

                }else {
                    if (boolean_permission) {
                        Bitmap bitmap1 = loadBitmapFromView(linear, linear.getWidth(), linear.getHeight());
                        saveBitmap(bitmap1);


                    } else {

                    }
                }

            }
        });

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (boolean_save) {
                    Toast.makeText(getActivity(),"Already saved",Toast.LENGTH_LONG).show();

                }else {
                    if (boolean_permission) {
                        Bitmap bitmap1 = loadBitmapFromView(linear, linear.getWidth(), linear.getHeight());
                        saveBitmap(bitmap1);
                      






                    } else {

                    }
                }

            }





        });
    }
    public void saveBitmap(Bitmap bitmap) {
         s ="TIC_"+BookingDetail.tickt.getDate()+"_"+BookingDetail.tickt.getMoviename()+"_"+ Show.seats+".jpg";
       // File imagePath = new File("/sdcard/screenshotdemo.jpg");
        FileOutputStream fos;
        try {
            File imagePath = new File(Environment.getExternalStorageDirectory()
                    + File.separator + "Tickets" + File.separator);
            imagePath.mkdirs();
            File sdImageMainDirectory = new File(imagePath, s);
            fos = new FileOutputStream(sdImageMainDirectory);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            Toast.makeText(getActivity(),sdImageMainDirectory.getAbsolutePath()+"",Toast.LENGTH_SHORT).show();
            boolean_save = true;

            btn_save.setText("Saved");

            Log.e("ImageSave", "Saveimage");
        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
    }

    public static Bitmap loadBitmapFromView(View v, int width, int height) {
        Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.draw(c);

        return b;
    }

}
