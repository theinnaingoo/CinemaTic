package skylark.intern.book.cinetic.adapter;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import skylark.intern.book.cinetic.BookingActivity;
import skylark.intern.book.cinetic.MovieDetail;
import skylark.intern.book.cinetic.R;
import skylark.intern.book.cinetic.cinemas.MSanPya;
import skylark.intern.book.cinetic.fragment.Upcoming;
import skylark.intern.book.cinetic.model.Movie;

/**
 * Created by User on 5/9/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Movieview> {

    Context mContent;
    List<Movie> movies;
    int key;

    public RecyclerAdapter(Context mContent, List<Movie> movies,int key) {
        this.mContent = mContent;
        this.movies = movies;
        this.key=key;
    }

    @Override
    public Movieview onCreateViewHolder(ViewGroup parent, int viewType) {
        //loading view into java
        View view = LayoutInflater.from(mContent).inflate(R.layout.item, null);
        //return student view into recyclerview
        return new Movieview(view);
    }

    @Override
    public void onBindViewHolder(Movieview holder, final int position) {
        //insert title into nameview
        holder.title.setText(movies.get(position).getTitle());
        //insert photo into photoview
        holder.photo.setImageResource(movies.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        //reutrn array size
        return movies.size();
    }

    public class Movieview extends RecyclerView.ViewHolder {
        ImageView photo;
        TextView title;

        public Movieview(View itemView) {
            super(itemView);
            //findviewbyid work
            //int i = itemView.getId();

            //Toast.makeText(mContent,getLayoutPosition()+"",Toast.LENGTH_SHORT).show();
            photo = (ImageView) itemView.findViewById(R.id.photo);
            title = (TextView) itemView.findViewById(R.id.title);

            photo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(key==1){
                        Intent i = new Intent(mContent, MovieDetail.class);
                        i.putExtra("mname", movies.get(getAdapterPosition()).getTitle());
                        mContent.startActivity(i);

                    }else if(key==3){
                        Intent i = new Intent(mContent, BookingActivity.class);
                        i.putExtra("nname", movies.get(getAdapterPosition()).getTitle());
                        mContent.startActivity(i);
                    }else Toast.makeText(mContent,"Detail information aren't available now",Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

}