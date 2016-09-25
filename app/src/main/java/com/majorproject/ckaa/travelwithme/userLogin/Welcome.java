package com.majorproject.ckaa.travelwithme.userLogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.majorproject.ckaa.travelwithme.HotelSessionManager;
import com.majorproject.ckaa.travelwithme.MainActivity;
import com.majorproject.ckaa.travelwithme.R;
import com.majorproject.ckaa.travelwithme.SQLiteHandlerr;
//import com.majorproject.ckaa.travelwithme.hotel.HotelSessionManager;
//import com.majorproject.ckaa.travelwithme.hotel.SQLiteHandlerr;

public class Welcome extends AppCompatActivity {


           // private GoogleApiClient client;
            private SQLiteHandler db;
            private SessionManager session;
            private SQLiteHandlerr dbh;
            private Button btnLogout;
            private Button  btnwelcome;
             private HotelSessionManager hsession;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_welcome);

            btnLogout = (Button) findViewById(R.id.btnLogout);
            btnwelcome = (Button) findViewById(R.id.btnwelcome);

            // SqLite database handler
            db = new SQLiteHandler(getApplicationContext());
                dbh = new SQLiteHandlerr(getApplicationContext());

            // session manager
            session = new SessionManager(getApplicationContext());
            hsession = new HotelSessionManager(getApplicationContext());
            if (!session.isLoggedIn()) {
                logoutUser();
            }


            btnLogout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    logoutUser();
                }
            });

            btnwelcome.setOnClickListener(new View.OnClickListener(){
                @Override

                public  void  onClick (View v)
                {   welcomeUser();
                }




            });
        }

        private void logoutUser() {
            session.setLogin(false);
            hsession.setHotelLogin(false);
            db.deleteUsers();
            dbh.deleteHotel();



            // Launching the login activity
            Intent intent = new Intent(Welcome.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        private  void welcomeUser(){

            // session.setLogin(true);
            Intent in = new Intent(this, MainActivity.class);
            startActivity(in);
            finish();
        }
        @Override
        public void onStart() {
            super.onStart();}

        @Override
        public void onStop() {
            super.onStop();}

        }



