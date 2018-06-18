package skylark.intern.book.cinetic;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import skylark.intern.book.cinetic.fragment.Detail;
import skylark.intern.book.cinetic.fragment.Payment;
import skylark.intern.book.cinetic.fragment.Show;
import skylark.intern.book.cinetic.model.TabLayoutUtils;
import skylark.intern.book.cinetic.fragment.Story;
import skylark.intern.book.cinetic.fragment.Voucher;
import skylark.intern.book.cinetic.model.CustomViewpager;
import skylark.intern.book.cinetic.model.TicketBooking;
import skylark.intern.book.cinetic.model.User;

public class BookingDetail extends AppCompatActivity {

    public static CustomViewpager viewPager;
    public static TabLayout tabLayout;
   public static   ViewPagerAdapter adapter;
    public static TicketBooking tickt;
    User buser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_detail);
        viewPager = (CustomViewpager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager.setPagingEnabled(false);
        Toolbar tbar =(Toolbar) findViewById(R.id.z_toolbar);
        tbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        setSupportActionBar(tbar);
        tbar.setNavigationIcon(R.drawable.ic_arrow);


        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Show(), "FragmentOne");
        adapter.addFragment(new Payment(), "FragmentTwo");
        adapter.addFragment(new Voucher(), "FragmentThree");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        tabLayout.setScrollPosition(0, 0f, true);
        viewPager.setCurrentItem(0);
        tabLayout.getTabAt(0).select();
        Intent i = getIntent();
        tickt = (TicketBooking)i.getSerializableExtra("ticket");
        //Toast.makeText(this,tickt.getMoviename(),Toast.LENGTH_LONG).show();

        int tabIconColor = ContextCompat.getColor(this, R.color.colorPrimaryLight);

        View view = tabLayout.getTabAt(0).getCustomView();
        ImageView imgvTab = (ImageView) view.findViewById(R.id.image);
        TextView tvTab = (TextView) view.findViewById(R.id.tv_tab);

        imgvTab.setImageResource(R.drawable.ic_tick);
        tvTab.setTextColor(getResources().getColor(R.color.colorPrimary));
        tvTab.setTypeface(null, Typeface.BOLD);

        TabLayoutUtils.enableTabs( tabLayout, false );

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                adapter.getItem(tab.getPosition()).setUserVisibleHint(false);
                View view = tab.getCustomView();
                ImageView imgvTab = (ImageView) view.findViewById(R.id.image);
                TextView tvTab = (TextView) view.findViewById(R.id.tv_tab);
                imgvTab.setImageResource(R.drawable.ic_tick);
                tvTab.setTextColor(getResources().getColor(R.color.colorPrimary));
                tvTab.setTypeface(null, Typeface.BOLD);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                ImageView imgvTab = (ImageView) view.findViewById(R.id.image);
                TextView tvTab = (TextView) view.findViewById(R.id.tv_tab);
                imgvTab.setImageResource(R.drawable.ic_tick);
                tvTab.setTextColor(getResources().getColor(R.color.colorPrimary));
                tvTab.setTypeface(null, Typeface.BOLD);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupTabIcons() {
        View view5 = LayoutInflater.from(this).inflate(R.layout.tabs, null);
        TextView tv5 = (TextView) view5.findViewById(R.id.tv_tab);
        ImageView imgv5 = (ImageView) view5.findViewById(R.id.image);
        tv5.setText("Ticket Booking");
        imgv5.setImageResource(R.drawable.ic_circle);
        tabLayout.getTabAt(0).setCustomView(view5);

        View view2 = LayoutInflater.from(this).inflate(R.layout.tabs, null);
        TextView tv2 = (TextView) view2.findViewById(R.id.tv_tab);
        ImageView imgv2 = (ImageView) view2.findViewById(R.id.image);
        tv2.setText("Payment");
        imgv2.setImageResource(R.drawable.ic_circle);
        tabLayout.getTabAt(1).setCustomView(view2);

        View view3 = LayoutInflater.from(this).inflate(R.layout.tabs, null);
        TextView  tv3 = (TextView) view3.findViewById(R.id.tv_tab);
        ImageView imgv3 = (ImageView) view3.findViewById(R.id.image);
        tv3.setText("Voucher");
        imgv3.setImageResource(R.drawable.ic_circle);
        tabLayout.getTabAt(2).setCustomView(view3);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            //Log.i("PromoFragment", "getItem"+position);
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            //Log.i("PromoFragment", "getCount"+mFragmentList.size());
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;

        }

        return true;
    }



    @Override
    public void onBackPressed() {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                //set title
                .setTitle("Are you finish?")
                //set message
                .setMessage("Are you complete in this section?")
                //set positive button
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //set what would happen when positive button is clicked
                        BookingDetail.super.onBackPressed();
                        tickt.getSeatlist().clear();

                    }
                })
                //set negative button
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //set what should happen when negative button is clicked

                    }
                })
                .show();


    }
}