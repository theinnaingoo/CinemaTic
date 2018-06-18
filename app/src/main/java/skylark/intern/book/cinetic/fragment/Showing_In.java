package skylark.intern.book.cinetic.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import skylark.intern.book.cinetic.R;
import skylark.intern.book.cinetic.adapter.CinemaAdapter;
import skylark.intern.book.cinetic.adapter.RecyclerAdapter;
import skylark.intern.book.cinetic.adapter.ShowInAdapter;
import skylark.intern.book.cinetic.cinemas.SpacesItemDecoration;
import skylark.intern.book.cinetic.model.Cinema;
import skylark.intern.book.cinetic.model.Movie;


public class Showing_In extends Fragment {
    RecyclerView recycler;

    List<Cinema> cinema;
    ShowInAdapter showAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_showing__in, container, false);
        recycler = (RecyclerView) v.findViewById(R.id.cinerecyc);
        //layout changing into list view layout;

        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        //inserting data into arraylist
        cinema = new ArrayList<>();
        Cinema san =new Cinema( getString(R.string.msan) ," 09260887035, 0926887036",getString(R.string.msanlo));
        san.setPhoto(R.drawable.mingalar_san_pya);

        Cinema mga = new Cinema( getString(R.string.mga) ," 09779054671, 09779054672",getString(R.string.mgalo));
        mga.setPhoto(R.drawable.mingalar_gamonepwint);

        Cinema mda = new Cinema( getString(R.string.mda)," 0973254091, 0973254092",getString(R.string.mdalo));
        mda.setPhoto(R.drawable.mingalar_dagonii);

        Cinema mwaz = new Cinema( getString(R.string.mwaz) ," 09261901155, 0926191166",getString(R.string.mwazlo));
        mwaz.setPhoto(R.drawable.mingalar_waziyar);

        Cinema mthe =new Cinema( getString(R.string.mthe) ," 01243057, 01243058",getString(R.string.mthe));
        mthe.setPhoto(R.drawable.mingalr_thein_gyi_zay);

        Cinema twin = new Cinema( getString(R.string.twin) ," 01372594, 0973235560",getString(R.string.twinlo));
        twin.setPhoto(R.drawable.twin);

        Cinema presid = new Cinema( getString(R.string.presid)," 01246962, 09246963",getString(R.string.presidlo));
        presid.setPhoto(R.drawable.thamada);

        Cinema east  =new Cinema( getString(R.string.east) ," 01252113, 01388034",getString(R.string.eastlo));
        east.setPhoto(R.drawable.shaesaung);

        cinema.add(san);
        cinema.add(mga);
        cinema.add(mda);
        cinema.add(mwaz);
        cinema.add(mthe);
        cinema.add(twin);
        cinema.add(presid);
        cinema.add(east);
        // Inflate the layout for this fragment

        showAdapter = new ShowInAdapter( getActivity(), cinema);
        //adding adapter into recyclerview;
        recycler.setAdapter(showAdapter);
        return  v;
    }


}
