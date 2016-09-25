package com.majorproject.ckaa.travelwithme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

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

public class HotelOnlineActivity extends AppCompatActivity {


    private static final String TAG =HotelOnlineActivity.class.getSimpleName();
    List<GetDataAdapter> GetDataAdapter1;

    RecyclerView recyclerView;

    RecyclerView.LayoutManager recyclerViewlayoutManager;

    RecyclerView.Adapter recyclerViewadapter;

    ProgressBar progressBar;



    String JSON_HotelName = "name";
    String JSON_HotelAddress = "address";
    String JSON_HotelRating = "rating";
    String JSON_HotelPhoto = "photo_link";
    String JSON_HotelBook="hotelbook_url";
    String JSON_HotelLink="hotel_link";
    String JSON_HotelLat= "hotel_latitude";
    String JSON_HOtelLong= "hotel_longitude";
    public static final int Hotel = 0;



    JsonArrayRequest jsonArrayRequest ;


    RequestQueue requestQueue ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        GetDataAdapter1 = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);

        //  Button button = (Button)findViewById(R.id.loadbutton) ;

        recyclerView.setHasFixedSize(true);

        recyclerViewlayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewlayoutManager);
        progressBar.setVisibility(View.VISIBLE);
        JSON_DATA_WEB_CALL();

    }
    public void JSON_DATA_WEB_CALL(){

        jsonArrayRequest = new JsonArrayRequest(Json_Url.hotelUrl,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if(response.length() == 0) {

                            progressBar.setVisibility(View.GONE);

                        }else{
                            progressBar.setVisibility(View.GONE);
                            JSON_PARSE_DATA_AFTER_WEBCALL(response);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG, "onErrorResponse: " + error.getLocalizedMessage());
                        progressBar.setVisibility(View.GONE);
                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);
    }

    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array){

        for(int i = 0; i<array.length(); i++) {

            GetDataAdapter GetDataAdapter2 = new GetDataAdapter();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                //  GetDataAdapter2.setId(json.getInt(JSON_ID));
                GetDataAdapter2.setPhoto(json.getString(JSON_HotelPhoto));
                GetDataAdapter2.setName(json.getString(JSON_HotelName));

                GetDataAdapter2.setAddress(json.getString(JSON_HotelAddress));

                GetDataAdapter2.setRating(json.getInt(JSON_HotelRating));
                  GetDataAdapter2.setHotellink(json.getString(JSON_HotelLink));
                GetDataAdapter2.setHotelbook(json.getString(JSON_HotelBook));
                GetDataAdapter2.setHotel_lat(json.getDouble(JSON_HotelLat));
                GetDataAdapter2.setHotel_long(json.getDouble(JSON_HOtelLong));
                GetDataAdapter2.setType(Hotel);

            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);
        }

        recyclerViewadapter = new Hotel_AmusementRecyclerViewAdapter(GetDataAdapter1, this);

        recyclerView.setAdapter(recyclerViewadapter);
    }
}

