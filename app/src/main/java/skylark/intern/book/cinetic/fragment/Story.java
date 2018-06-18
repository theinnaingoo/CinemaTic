package skylark.intern.book.cinetic.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.MapView;

import java.util.ArrayList;
import java.util.List;

import skylark.intern.book.cinetic.MovieDetail;
import skylark.intern.book.cinetic.R;
import skylark.intern.book.cinetic.adapter.RecyclerAdapter;
import skylark.intern.book.cinetic.cinemas.SpacesItemDecoration;
import skylark.intern.book.cinetic.model.Movie;




public class Story extends Fragment {
//    RecyclerView recycler;
//
//    List<Movie> movies;
//    RecyclerAdapter recyclerAdapter;
//    TextView story;
    TextView tv;
    Movie movie;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_story, container, false);
        //story = v.findViewById(R.id.story);
        try {
            if (MovieDetail.movie !=null) {
                movie = MovieDetail.movie;
                tv = (TextView) v.findViewById(R.id.story);
                tv.setText(movie.getStory());
            }
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }

        return  v;
    }

    public void changeText(String text){

        tv.setText(text);
    }

}
