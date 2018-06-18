package skylark.intern.book.cinetic;

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import skylark.intern.book.cinetic.fragment.CinemaF;
import skylark.intern.book.cinetic.fragment.Detail;
import skylark.intern.book.cinetic.fragment.Showing;
import skylark.intern.book.cinetic.fragment.Showing_In;
import skylark.intern.book.cinetic.fragment.Story;
import skylark.intern.book.cinetic.fragment.Upcoming;
import skylark.intern.book.cinetic.model.Movie;

import static skylark.intern.book.cinetic.DataUtility.movielist;

public class MovieDetail extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView poster;
    String name;
    public static Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        poster = findViewById(R.id.poster);
        final Toolbar mToolbar = (Toolbar) findViewById(R.id.z_toolbar);


        mToolbar.setTitle(R.string.app_name);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow);

        setSupportActionBar(mToolbar);
        Intent i = getIntent();
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        name=i.getStringExtra("mname");


        // TextView t = (TextView) this.findViewById(R.id.story);

        DataUtility.generalMovielist(this);
        if (DataUtility.movielist.size()>0) {
            for (Movie m: DataUtility.movielist){
                if(name.equals(m.getTitle())){
                    movie = m;

//                    Toast.makeText(getApplicationContext(), "image="+m.getTitle()+"\t"+m.getPhoto(), Toast.LENGTH_LONG).show();
                    poster.setImageResource(m.getPhotoland());


                    }

                }

            }
        }


    private void setupViewPager(ViewPager viewPager) {
       ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Showing_In(), "Showing In");
        adapter.addFragment(new Story(), "Story");
        adapter.addFragment(new Detail(), "Detail");
        viewPager.setAdapter(adapter);
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

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
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

}
