package skylark.intern.book.cinetic.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import skylark.intern.book.cinetic.MovieDetail;
import skylark.intern.book.cinetic.R;
import skylark.intern.book.cinetic.model.History;
import skylark.intern.book.cinetic.model.Movie;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HisView> {
    Context mContent;
    List<History> his;

    public HistoryAdapter(Context mContent, List<History> his) {
        this.mContent = mContent;
        this.his = his;
    }

    @Override
    public HistoryAdapter.HisView onCreateViewHolder(ViewGroup parent, int viewType) {
        //loading view into java
        View view = LayoutInflater.from(mContent).inflate(R.layout.bk_history, null);
        //return student view into recyclerview
        return new HistoryAdapter.HisView(view);
    }

    @Override
    public void onBindViewHolder(HistoryAdapter.HisView holder, final int position) {
        //insert title into nameview
        holder.movie.setText(his.get(position).getMoviename());
        holder.date.setText(his.get(position).getDate());
        holder.histext.setText(his.get(position).getNoofseat()+" seats  @"+ his.get(position).getCinema());
        holder.photo.setImageResource(his.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        //reutrn array size
        return his.size();
    }

    public class HisView extends RecyclerView.ViewHolder {
        //ImageView photo;
        TextView movie,date,histext;
        ImageView photo;

        public HisView(View itemView) {
            super(itemView);
            movie = (TextView) itemView.findViewById(R.id.hismvname);
            date = (TextView) itemView.findViewById(R.id.hisdate);
            histext = (TextView) itemView.findViewById(R.id.histext);
            photo = (ImageView) itemView.findViewById(R.id.hismvphoto);
//            photo.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Intent i = new Intent(mContent, MovieDetail.class);
//
//                }
//            });

        }
    }
}
