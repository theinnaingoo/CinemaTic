package skylark.intern.book.cinetic.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import skylark.intern.book.cinetic.R;
import skylark.intern.book.cinetic.adapter.RecyclerAdapter;
import skylark.intern.book.cinetic.cinemas.SpacesItemDecoration;
import skylark.intern.book.cinetic.model.Movie;


public class Showing extends Fragment {

    RecyclerView recycler;

    List<Movie> movies;
    RecyclerAdapter recyclerAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment__showing, container, false);
        recycler = (RecyclerView) v.findViewById(R.id.recyc);

        recycler.setLayoutManager(new GridLayoutManager(getContext(),2));
        recycler.addItemDecoration(new SpacesItemDecoration(16));
        //inserting data into arraylist
        movies = new ArrayList<>();
        movies.add(new Movie(R.drawable.inifinity_war, getString(R.string.init)));
        movies.add(new Movie(R.drawable.the_shape_of_water, getString(R.string.tsow)));
        movies.add(new Movie(R.drawable.dunkrik, getString(R.string.dun)));
        movies.add(new Movie(R.drawable.the_greatest_showman, getString(R.string.tgsm)));
        //Toast.makeText(getActivity(),getActivity().toString(),Toast.LENGTH_SHORT).show();


        recyclerAdapter = new RecyclerAdapter(getActivity(), movies,1);
        //adding adapter into recyclerview;     recycler.setClickable(false);
        recycler.setAdapter(recyclerAdapter);
        return  v;
    }


}
