package com.majorproject.ckaa.travelwithme;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.majorproject.ckaa.travelwithme.services.ServiceActivity;
import com.majorproject.ckaa.travelwithme.travelTip.Fragment_TravelTip;
import com.majorproject.ckaa.travelwithme.userLogin.SQLiteHandler;
import com.majorproject.ckaa.travelwithme.userLogin.SessionManager;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private SQLiteHandler db;
    private SessionManager session;
    TextView username;
    TextView useremail;
    ImageView logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        db = new SQLiteHandler(getApplicationContext());
        session = new SessionManager(getApplicationContext());
        //if(session.isLoggedIn())

        HashMap<String, String> user = db.getUserDetails();

        String name = user.get("name");
        String email = user.get("email");


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View draw = navigationView.getHeaderView(0);
        username = (TextView) draw.findViewById(R.id.drawerHeaderName);
        useremail = (TextView)draw.findViewById(R.id.drawerHeaderEmail);
        logo = (ImageView) draw.findViewById(R.id.drawerHeaderImage);
        username.setText(name);
        useremail.setText(email);
        logo.setImageResource(R.drawable.travelwithme);





//        Intent homein = new Intent(this,HomeActivity.class);
//        startActivity(homein);

        HomeFragment hfragment= new HomeFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,hfragment);
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("TravelWithMe");

    }
//    public void Hotel1 (View view) {
//        Uri url1 = Uri.parse("http://192.168.0.127/image/hyatt.php");
//        Intent h1intent = new Intent(Intent.ACTION_VIEW, url1);
//        startActivity(h1intent);
//    }
//    public void viewdeal (View view) {
//        Uri url1 = Uri.parse("http://www.booking.com");
//        Intent h1intent = new Intent(Intent.ACTION_VIEW, url1);
//        startActivity(h1intent);
//    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the HomeFragment/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
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

        if (id == R.id.nav_home) {
            HomeFragment hfragment= new HomeFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,hfragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("TravelWithMe");
//            // Handle the camera action
//            Intent homein = new Intent(this,HomeActivity.class);
//            startActivity(homein);



        } else if (id == R.id.nav_traveltip) {
            Fragment_TravelTip fragment= new Fragment_TravelTip();
            android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Travel Tip");

       } else if (id == R.id.nav_hotel) {
            Intent hotelin = new Intent(this,City_Activity.class);
            startActivity(hotelin);

//            Hotel hofragment= new Hotel();
//            android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.fragment_container,hofragment);
//            fragmentTransaction.commit();
//            getSupportActionBar().setTitle("Hotel");

        } else if (id == R.id.nav_places) {
            Intent in = new Intent(this,Adapter_Activity.class);
            startActivity(in);


        } else if (id == R.id.nav_food) {
            Intent Resin = new Intent(this,RestaurantActivity.class);
            startActivity(Resin);


        } else if (id == R.id.nav_service) {
            Intent serin = new Intent(this, ServiceActivity.class);
            startActivity(serin);

        } else if (id == R.id.nav_check) {
            Intent memin = new Intent(this, MemoActivity.class);
            startActivity(memin);
        } else if (id == R.id.nav_map) {
            Map mfragment=new Map();
            android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,mfragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Map");

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
