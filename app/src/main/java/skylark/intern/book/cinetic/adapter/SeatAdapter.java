package skylark.intern.book.cinetic.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import skylark.intern.book.cinetic.BookingActivity;
import skylark.intern.book.cinetic.R;
import skylark.intern.book.cinetic.fragment.Booking;
import skylark.intern.book.cinetic.model.Seat;

public class SeatAdapter extends RecyclerView.Adapter<SeatAdapter.SeatView> {
    Context mContent;
    List<Seat> seats;
    TextView tv;

    public SeatAdapter(Context mContent, List<Seat> seat, TextView tv) {
        this.mContent = mContent;
        this.seats = seat;
        this.tv= tv;
    }

    @Override
    public SeatView onCreateViewHolder(ViewGroup parent, int viewType) {
        //loading view into java
        View view = LayoutInflater.from(mContent).inflate(R.layout.seat, null);
        //return student view into recyclerview
        return new SeatAdapter.SeatView(view);
    }

    @Override
    public void onBindViewHolder(final SeatAdapter.SeatView holder, final int position) {
        //insert title into nameview
        holder.seatname.setText(seats.get(position).getSeatName());
        holder.seatname.setBackgroundResource(seats.get(position).getColour());

    }

    @Override
    public int getItemCount() {
        //reutrn array size
        return seats.size();
    }

    public class SeatView extends RecyclerView.ViewHolder {
        TextView seatname,tolseat;

        public SeatView(View itemView) {
            super(itemView);
            tolseat = (TextView) itemView.findViewById(R.id.totalseats);
            seatname = (TextView) itemView.findViewById(R.id.seatno);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String seatName = seats.get(getAdapterPosition()).getSeatName();
                    if(BookingActivity.chosenseat.size()>0){
                        for(Map.Entry<String, Seat> entry:BookingActivity.chosenseat.entrySet()){
                            if(BookingActivity.chosenseat.containsKey(seatName)){
                                seatname.setText(seats.get(getAdapterPosition()).getSeatName());
                                seatname.setBackgroundResource(seats.get(getAdapterPosition()).getColour());
                                BookingActivity.chosenseat.remove(seatName);
                                break;

                            }else {
                                seatname.setText("");
                                seatname.setBackgroundResource(R.drawable.ic_selected);
                                BookingActivity.chosenseat.put(seatName,seats.get(getAdapterPosition()));
                                break;
                            }
                        }
                    }
                    else{
                        seatname.setText("");
                        seatname.setBackgroundResource(R.drawable.ic_selected);
                        BookingActivity.chosenseat.put(seatName,seats.get(getAdapterPosition()));

                    }

                    String result="";
                    int i=0;
                    for (Map.Entry<String, Seat> entry: BookingActivity.chosenseat.entrySet()) {
                        result += entry.getKey();
                        if (i != BookingActivity.chosenseat.size()-1) {
                            result += ",";
                        }
                        i++;
                    }
                    tv.setText(result);
                }
            });
//            seatname.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    tolseat.setText("heyyyy");
//                    seats.get(1).setColour(2);
//                    Toast.makeText(mContent,getLayoutPosition()+"",Toast.LENGTH_SHORT).show();
//                }
//            });

        }
    }
}
