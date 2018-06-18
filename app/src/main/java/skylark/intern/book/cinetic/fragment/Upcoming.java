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


public class Upcoming extends Fragment {
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
         // Inflate the layout for this fragment
         View v = inflater.inflate(R.layout.fragment__showing, container, false);
         recycler = (RecyclerView) v.findViewById(R.id.recyc);
         //layout changing into list view layout;
         //recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
         //creating recyclerAdapter
         recycler.setLayoutManager(new GridLayoutManager(getContext(),2));
         recycler.addItemDecoration(new SpacesItemDecoration(16));
         //inserting data into arraylist
         movies = new ArrayList<>();
         movies.add(new Movie(R.drawable.ant_man, getString(R.string.ant)));
         movies.add(new Movie(R.drawable.deadpool2, getString(R.string.dead)));
         movies.add(new Movie(R.drawable.aquaman, getString(R.string.aqua)));
         movies.add(new Movie(R.drawable.venom, getString(R.string.ve)));
         movies.add(new Movie(R.drawable.winchester, getString(R.string.win)));
         //Toast.makeText(getActivity(),getActivity().toString(), Toast.LENGTH_SHORT).show();


         recyclerAdapter = new RecyclerAdapter(getActivity(), movies,2);
//         recycler.setClickable(false);
//         recycler.setFocusable(false);
//         recycler.setFocusableInTouchMode(false);
         //adding adapter into recyclerview;

         recycler.setAdapter(recyclerAdapter);

         return  v;

     }

}
