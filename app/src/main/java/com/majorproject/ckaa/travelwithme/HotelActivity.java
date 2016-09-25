package com.majorproject.ckaa.travelwithme;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class HotelActivity extends AppCompatActivity {
    private ProgressDialog pDialog;
    private HotelSessionManager hsession;
    public static final String TAG = HotelActivity.class.getSimpleName();
    List<GetDataAdapter>GetDataAdapter1;
    RecyclerView recyclerView;

    RecyclerView.LayoutManager recyclerViewlayoutManager;

    RecyclerView.Adapter recyclerViewadapter;
    String JSON_HotelName = "name";
    String JSON_HotelAddress = "address";
    String JSON_HotelRating = "rating";
    String JSON_HotelPhoto = "photo_link";
    String JSON_HotelBook="hotelbook_url";
    String JSON_HotelLink="hotel_link";
    String JSON_HotelLat= "hotel_latitude";
    String JSON_HOtelLong= "hotel_longitude";
    public static final int Hotel = 0;
    private SQLiteHandlerr db;


    JsonArrayRequest jsonArrayRequest ;
    public  static Context context;

    GetDataAdapter gett = new GetDataAdapter();
    RequestQueue requestQueue ;
    Button btnsync;
   // private SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        recyclerViewlayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewlayoutManager);
        btnsync = (Button)findViewById(R.id.btnSync);

        // Session manager
        hsession = new HotelSessionManager(getApplicationContext());
        GetDataAdapter1 = new ArrayList<>();
        // SQLite database handler
        db = new SQLiteHandlerr(getApplicationContext());
        if(hsession.isHotelLoggedIn())
        {
            GetDataAdapter1 = db.getAllData();

//            String name = gett.getName();
//            Log.i(TAG, "onCreate: " + name);
           recyclerViewadapter = new Hotel_AmusementRecyclerViewAdapter(GetDataAdapter1, this);

            recyclerView.setAdapter(recyclerViewadapter);
        }
       // else{}
        btnsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JSON_DATA_WEB_CALL();
                pDialog.setMessage("Loading data ...");
                showDialog();


            }
        });

    }

    public void JSON_DATA_WEB_CALL() {

        jsonArrayRequest = new JsonArrayRequest(Json_Url.hotelUrl,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                       // progressBar.setVisibility(View.GONE);
                        hideDialog();
                        JSON_PARSE_DATA_AFTER_WEBCALL(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);
    }

    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array) {
        hsession.setHotelLogin(false);
        db.deleteHotel();




        hsession.setHotelLogin(true);

        for (int i = 0; i < array.length(); i++) {

            GetDataAdapter GetDataAdapter2 = new GetDataAdapter();


            //Integer id = 0;
            String photo = "";
            String name = "";

            String address = "";
            Integer rating = 0;
            String hotellink = "";
            String hotelbook = "";
            Double hotelLat = 0.0;
            Double hotelLong = 0.0;
            List<GetDataAdapter> insert = new ArrayList<>();
            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                Log.i(TAG, "JSON_PARSE_DATA_AFTER_WEBCALL: " + " ononononn");
                //GetDataAdapter2.setId(json.getInt(JSON_ID));
//                GetDataAdapter2.setPhoto(json.getString(JSON_HotelPhoto));
//                GetDataAdapter2.setName(json.getString(JSON_HotelName));
//
//                GetDataAdapter2.setAddress(json.getString(JSON_HotelAddress));
//
//                GetDataAdapter2.setRating(json.getInt(JSON_HotelRating));
//                  GetDataAdapter2.setHotellink(json.getString(JSON_HotelLink));
//                GetDataAdapter2.setHotelbook(json.getString(JSON_HotelBook));
//                GetDataAdapter2.setHotel_lat(json.getDouble(JSON_HotelLat));
//                GetDataAdapter2.setHotel_long(json.getDouble(JSON_HOtelLong));
//                GetDataAdapter2.setType(Hotel);
//               db.addHotel(GetDataAdapter2);

                // GetDataAdapter2.setId(json.getInt(JSON_ID));
                // id = json.getInt(hotel_id);
                photo = json.getString(JSON_HotelPhoto);
                name = json.getString(JSON_HotelName);

                address = json.getString(JSON_HotelAddress);
                rating = json.getInt(JSON_HotelRating);
                hotellink = json.getString(JSON_HotelLink);
                hotelbook = json.getString(JSON_HotelBook);
                hotelLat = json.getDouble(JSON_HotelLat);
                hotelLong = json.getDouble(JSON_HOtelLong);
                Log.i(TAG, "JSON_PARSE_DATA_AFTER_WEBCALL: " + name);
                Log.i(TAG, "JSON_PARSE_DATA_AFTER_WEBCALL: " + hotellink);
                Log.i(TAG, "JSON_PARSE_DATA_AFTER_WEBCALL: " + hotelLat);
                // GetDataAdapter2.setType(Hotel);
                // insert.add(GetDataAdapter2);


                db.addHotel(name, address, rating, photo, hotelLat, hotelLong, hotelbook, hotellink);

            } catch (JSONException e) {

                e.printStackTrace();
            }
            //GetDataAdapter1.add(GetDataAdapter2);
            //  db.addHotel(GetDataAdapter1);


        }
        GetDataAdapter1 = db.getAllData();

        String name = gett.getName();
        Log.i(TAG, "onCreate: " + name);
        recyclerViewadapter = new Hotel_AmusementRecyclerViewAdapter(GetDataAdapter1, this);

        recyclerView.setAdapter(recyclerViewadapter);
//        recyclerViewadapter = new Hotel_AmusementRecyclerViewAdapter(GetDataAdapter1, this);
//
//        recyclerView.setAdapter(recyclerViewadapter);
    }
    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
