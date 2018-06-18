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
import skylark.intern.book.cinetic.adapter.CinemaAdapter;
import skylark.intern.book.cinetic.model.Cinema;


public class CinemaF extends Fragment {


    RecyclerView recy;

    List<Cinema> cinema;
    CinemaAdapter cinemaAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_cinema, container, false);

        //layout changing into list view layout;
        //creating recyclerAdapter
        recy = (RecyclerView) v.findViewById(R.id.recyc);
        recy.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        //inserting data into arraylist
        cinema = new ArrayList<>();
        cinema.add(new Cinema( getString(R.string.msan) ," 09260887035, 0926887036",getString(R.string.msanlo)));
        cinema.add(new Cinema( getString(R.string.mga) ," 09779054671, 09779054672",getString(R.string.mgalo)));
        cinema.add(new Cinema( getString(R.string.mda)," 0973254091, 0973254092",getString(R.string.mdalo)));
        cinema.add(new Cinema( getString(R.string.mwaz) ," 09261901155, 0926191166, 09261901177",getString(R.string.mwazlo)));
        cinema.add(new Cinema( getString(R.string.mthe) ," 01243057, 01243058",getString(R.string.mthe)));
        cinema.add(new Cinema( getString(R.string.twin) ," 01372594, 0973235560",getString(R.string.twinlo)));
        cinema.add(new Cinema( getString(R.string.presid)," 01246962, 09246963",getString(R.string.presidlo)));
        cinema.add(new Cinema( getString(R.string.east) ," 01252113, 01388034",getString(R.string.eastlo)));

        // Inflate the layout for this fragment

        cinemaAdapter = new CinemaAdapter( getActivity(), cinema);
        //adding adapter into recyclerview;
        recy.setAdapter(cinemaAdapter);
        return v;
    }
}
