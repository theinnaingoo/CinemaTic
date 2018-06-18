package skylark.intern.book.cinetic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import skylark.intern.book.cinetic.R;
import skylark.intern.book.cinetic.fragment.Voucher;
import skylark.intern.book.cinetic.model.TicketBooking;

public class VoucherAdapter extends RecyclerView.Adapter<VoucherAdapter.VoucherView>  {
    Context cContext;
    List<TicketBooking> tkbook;

    public VoucherAdapter(Context cContext, List<TicketBooking> tkbook) {
        this.cContext = cContext;
        this.tkbook = tkbook;
    }
    @Override
    public VoucherAdapter.VoucherView onCreateViewHolder(ViewGroup parent, int viewType) {
        //loading view into java
        View view = LayoutInflater.from(cContext).inflate(R.layout.voucher, parent, false);
        //return view into recyclerview
        return new VoucherAdapter.VoucherView(view);
    }

    @Override
    public void onBindViewHolder(VoucherAdapter.VoucherView holder, final int position) {
        //insert title into nameview
        holder.mvname.setText(tkbook.get(position).getMoviename());
        holder.cinema.setText(tkbook.get(position).getCinema());
        holder.date.setText(tkbook.get(position).getDate());
        holder.time.setText(tkbook.get(position).getShowtime());
        holder.seat.setText(tkbook.get(position).getSeat());
        holder.photo.setImageBitmap(tkbook.get(position).getBmap());
    }

    @Override
    public int getItemCount() {
        //return array size
        return tkbook.size();
    }

    public class VoucherView extends RecyclerView.ViewHolder {
        //ImageView photo;
        TextView cinema, mvname,date,seat,time;
        ImageView photo;

        public VoucherView(View itemView) {
            super(itemView);
            mvname = itemView.findViewById(R.id.qrmoviename);
            photo = itemView.findViewById(R.id.qrshowcine);
            cinema = itemView.findViewById(R.id.qrcinema);
            seat = itemView.findViewById(R.id.qrseat);
            date = itemView.findViewById(R.id.qrdate);
            time = itemView.findViewById(R.id.qrtime);

        }
}}
