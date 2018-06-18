package skylark.intern.book.cinetic.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import skylark.intern.book.cinetic.BookingDetail;
import skylark.intern.book.cinetic.R;
import skylark.intern.book.cinetic.model.Seat;
import skylark.intern.book.cinetic.model.TicketBooking;


public class Show extends Fragment {
        TextView incinema,inseat,indate,intime,inmoviename;
        ImageView photo;
        List<Seat> seat;
        public static String seats="";
        Button show_next;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View v = inflater.inflate(R.layout.fragment_show, container, false);
            incinema = v.findViewById(R.id.incinema);
            inseat= v.findViewById(R.id.inseat);
            indate = v.findViewById(R.id.indate);
            intime = v.findViewById(R.id.intime);
            inmoviename= v.findViewById(R.id.moviename);
            photo = v.findViewById(R.id.showcine);
            show_next = v.findViewById(R.id.show_next);

            show_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    BookingDetail.viewPager.setCurrentItem(1);
                    BookingDetail.tabLayout.getTabAt(1).select();
                    View view = BookingDetail.tabLayout.getTabAt(1).getCustomView();
                    ImageView imgvTab = (ImageView) view.findViewById(R.id.image);
                    TextView tvTab = (TextView) view.findViewById(R.id.tv_tab);

                    imgvTab.setImageResource(R.drawable.ic_tick);
                    tvTab.setTextColor(getResources().getColor(R.color.colorPrimary));
                    tvTab.setTypeface(null, Typeface.BOLD);
                }
            });
            seat = new ArrayList<>();
            seat = BookingDetail.tickt.getSeatlist();
            seats="";
            if(seat.size()>0 ){
                int i = 0;

                for(Seat s: seat){
                    seats += s.getSeatName();
                    if(i != seat.size()-1){
                        seats +=",";
                    }
                    i++;
                }

            }

//            Toast.makeText(getActivity(),seat.get(0).getSeatName().toString(),Toast.LENGTH_LONG).show();
            incinema.setText(BookingDetail.tickt.getCinema());
            inseat.setText(seats);
            indate.setText(BookingDetail.tickt.getDate());
            intime.setText(BookingDetail.tickt.getShowtime());
            inmoviename.setText(BookingDetail.tickt.getMoviename());
            if(BookingDetail.tickt.getMoviename().equals("Infinity War")){
                photo.setImageResource(R.drawable.inifinity_landscape1);
            }else if(BookingDetail.tickt.getMoviename().equals("The Shape of Water")){
                photo.setImageResource(R.drawable.the_sow_landscape1);
            }else if(BookingDetail.tickt.getMoviename().equals("Dunkrik")){
                photo.setImageResource(R.drawable.dunkrik_landscape1);
            }else photo.setImageResource(R.drawable.the_gtsm_landscape1);

            return  v;
        }


    }
