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
import android.widget.Toast;

import skylark.intern.book.cinetic.R;
import skylark.intern.book.cinetic.adapter.VoucherAdapter;


public class MyTickets extends Fragment {
    private RecyclerView recyc;
    private VoucherAdapter voucherAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_tickets, container, false);

            recyc = view.findViewById(R.id.myticket);
            recyc.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            voucherAdapter = new VoucherAdapter(getActivity(), Voucher.voutick);
            recyc.setAdapter(voucherAdapter);

        //}else   Toast.makeText(getActivity(), "You don't have any booked tickets.", Toast.LENGTH_LONG).show();

        return view;
    }
}
