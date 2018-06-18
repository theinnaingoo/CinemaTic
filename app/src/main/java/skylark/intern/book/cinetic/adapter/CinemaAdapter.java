package skylark.intern.book.cinetic.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import skylark.intern.book.cinetic.R;
import skylark.intern.book.cinetic.cinemas.MDagonCentre_II;
import skylark.intern.book.cinetic.cinemas.MGaMone;
import skylark.intern.book.cinetic.cinemas.MSanPya;
import skylark.intern.book.cinetic.cinemas.MTheinGyi;
import skylark.intern.book.cinetic.cinemas.MWaziyar;
import skylark.intern.book.cinetic.cinemas.ShaeSaung;
import skylark.intern.book.cinetic.cinemas.ThaMaDa;
import skylark.intern.book.cinetic.cinemas.Twin;
import skylark.intern.book.cinetic.model.Cinema;

public class CinemaAdapter extends RecyclerView.Adapter<CinemaAdapter.CinemaView>  {


    Context cContext;
    List<Cinema> cinemas;

    public CinemaAdapter(Context cContext, List<Cinema> cinemas) {
        this.cContext = cContext;
        this.cinemas = cinemas;
    }



    @Override
    public CinemaView onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(cContext).inflate(R.layout.cine,parent,false);
        return new CinemaView(v);
    }

    @Override
    public void onBindViewHolder(CinemaView holder, int position) {
        holder.cinemaName.setText(cinemas.get(position).getName());
        holder.phone.setText(cinemas.get(position).getPh());
        holder.address.setText(cinemas.get(position).getAdd());


    }

    @Override
    public int getItemCount() {
        return cinemas.size();
    }

    public class CinemaView extends RecyclerView.ViewHolder {

        TextView cinemaName;
        TextView phone;
        TextView address;
        CardView cd;

        public CinemaView(View itemView) {
            super(itemView);
            cinemaName = (TextView) itemView.findViewById(R.id.cinema);
            phone=(TextView) itemView.findViewById(R.id.phone);
            address = (TextView) itemView.findViewById(R.id.address);
            cd = itemView.findViewById(R.id.card);

            cd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (getAdapterPosition()){
                        case 0:
                            cContext.startActivity(new Intent(cContext,MSanPya.class));
                            break;
                        case 1:
                            cContext.startActivity(new Intent(cContext,MGaMone.class));
                            break;
                        case 2:
                            cContext.startActivity(new Intent(cContext,MDagonCentre_II.class));
                            break;
                        case 3:
                            cContext.startActivity(new Intent(cContext,MWaziyar.class));
                            break;
                        case 4:
                            cContext.startActivity(new Intent(cContext,MTheinGyi.class));
                            break;
                        case 5:
                            cContext.startActivity(new Intent(cContext,Twin.class));
                            break;
                        case 6:
                            cContext.startActivity(new Intent(cContext,ThaMaDa.class));
                            break;
                        case 7:
                            cContext.startActivity(new Intent(cContext,ShaeSaung.class));
                            break;

                    }
                }
            });

        }
    }
}
