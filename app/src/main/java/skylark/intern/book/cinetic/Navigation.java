package skylark.intern.book.cinetic;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import skylark.intern.book.cinetic.fragment.BookingHistory;
import skylark.intern.book.cinetic.fragment.Frg_Main;
import skylark.intern.book.cinetic.fragment.MyTickets;
import skylark.intern.book.cinetic.fragment.Profile;
import skylark.intern.book.cinetic.model.User;

public class Navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static User user;
    FragmentManager fManager;
    FragmentTransaction fTransaction;
    Boolean isLogin = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //committed by thein naing oo
        //it's just a test.

        fManager = getSupportFragmentManager();
        fTransaction = fManager.beginTransaction();
        fTransaction.replace(R.id.frame_layout, new Frg_Main()).commit();
        user= new User(160722,"Mg Thein Naing Oo","09262742288","maungzwe.tutgo@gmail.com","QAZqaz123$%^");


        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


   }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startMain);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.profile) {

           fTransaction = getSupportFragmentManager().beginTransaction();
           fTransaction.replace(R.id.frame_layout,new Profile()).commit();

            // Handle the camera action
        } else if (id == R.id.history) {

            fTransaction = getSupportFragmentManager().beginTransaction();
            fTransaction.replace(R.id.frame_layout,new BookingHistory()).commit();


        } else if (id == R.id.mytickets){

            fTransaction = getSupportFragmentManager().beginTransaction();
            fTransaction.replace(R.id.frame_layout,new MyTickets()).commit();

        }
        else if (id == R.id.about) {
            Intent i = new Intent(Navigation.this,LoginActivity.class);
            startActivity(i);




        } else if (id == R.id.nav_share) {




        } else if (id == R.id.nav_logout) {

            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    //set title
                    .setTitle("Logout?")
                    //set message
                    .setMessage("Are you sure want to logout from this account?")
                    //set positive button
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //set what would happen when positive button is clicked
                            SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("UserData", MODE_PRIVATE).edit();
                            editor.putBoolean("isLogin",isLogin);
                            editor.commit();
                            Intent in = new Intent(getApplicationContext(),LoginActivity.class);
                            startActivity(in);

                            Toast.makeText(getApplicationContext(),"You has been logout",Toast.LENGTH_SHORT).show();


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
        else if (id == R.id.home) {

            fTransaction = getSupportFragmentManager().beginTransaction();
            fTransaction.replace(R.id.frame_layout,new Frg_Main()).commit();


        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
