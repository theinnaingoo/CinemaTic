package skylark.intern.book.cinetic.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import skylark.intern.book.cinetic.R;
import skylark.intern.book.cinetic.adapter.RecyclerAdapter;
import skylark.intern.book.cinetic.model.Movie;


public class cin_show extends Fragment {
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
        //layout changing into list view layout;
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        //creating recyclerAdapter
        //recycler.setLayoutManager(new GridLayoutManager(getContext(),2));
        //inserting data into arraylist
        movies = new ArrayList<>();
        movies.add(new Movie(R.drawable.inifinity_war, getString(R.string.init)));
        movies.add(new Movie(R.drawable.the_shape_of_water, getString(R.string.tsow)));
        movies.add(new Movie(R.drawable.dunkrik, getString(R.string.dun)));
        movies.add(new Movie(R.drawable.the_greatest_showman, getString(R.string.tgsm)));
        movies.add(new Movie(R.drawable.dunkrik, getString(R.string.dun)));



        recyclerAdapter = new RecyclerAdapter(getActivity(), movies,1);
        //adding adapter into recyclerview;
        recycler.setAdapter(recyclerAdapter);

        return  v;
    }


}
