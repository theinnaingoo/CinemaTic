package skylark.intern.book.cinetic.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import skylark.intern.book.cinetic.adapter.HistoryAdapter;
import skylark.intern.book.cinetic.model.Cinema;
import skylark.intern.book.cinetic.model.History;


public class BookingHistory extends Fragment {

    RecyclerView recy;
    List<History> his;
    HistoryAdapter historyAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booking_history, container, false);
        //creating recyclerAdapter
        recy = (RecyclerView) view.findViewById(R.id.hisrecyc);
        recy.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        //inserting data into arraylist
        his = new ArrayList<>();
        his.add(new History(getString(R.string.init),"4/22/2018","2",getString(R.string.msan),R.drawable.inifinity_war));
        his.add(new History(getString(R.string.tsow),"5/1/2018","1",getString(R.string.mga),R.drawable.the_shape_of_water));
        his.add(new History(getString(R.string.tgsm),"3/31/2018","10",getString(R.string.mwaz),R.drawable.the_greatest_showman));
        historyAdapter = new HistoryAdapter( getActivity(), his);
        //adding adapter into recyclerview;
        recy.setAdapter(historyAdapter);
        return view;
    }
}
