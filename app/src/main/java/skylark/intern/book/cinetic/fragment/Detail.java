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

import java.util.ArrayList;
import java.util.List;

import skylark.intern.book.cinetic.MovieDetail;
import skylark.intern.book.cinetic.R;
import skylark.intern.book.cinetic.adapter.RecyclerAdapter;
import skylark.intern.book.cinetic.cinemas.SpacesItemDecoration;
import skylark.intern.book.cinetic.model.Movie;


public class Detail extends Fragment {
    Movie movie;
    TextView lang,cast,gene,direct,time,certi;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail, container, false);

        try {
            if (MovieDetail.movie !=null) {
                movie = MovieDetail.movie;
                lang = (TextView) v.findViewById(R.id.language);
                cast = v.findViewById(R.id.cast);
                gene = (TextView) v.findViewById(R.id.gener);
                direct = (TextView) v.findViewById(R.id.director);
                time = (TextView) v.findViewById(R.id.time);
                certi = (TextView) v.findViewById(R.id.certifi);

                //assigning text to appropriate text view
                lang.setText(movie.getLanguage());
                cast.setText(movie.getCast());
                gene.setText(movie.getGenere());
                direct.setText(movie.getDirector());
                time.setText(movie.getRuntime());
                certi.setText(movie.getCertification());

            }
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }

        return  v;
    }


}
