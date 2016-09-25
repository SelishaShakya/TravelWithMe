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

public class popularActivity extends AppCompatActivity {
    String JSON_RestaurantName = "res_name";
    String JSON_RestaurantAddress = "res_address";
    String JSON_RestaurantPhoto = "res_photo";
    String JSON_ResPopularType = "popular_type";
    String JSON_SightName = "sight_name";
    String JSON_SightAddress = "sight_address";
    String JSON_SightPhoto = "sight_photo";
    String JSON_SightPopularType = "popular_type";
    String JSON_PopName="pop_name";
    String JSON_PopDes="pop_des";
    String JSON_PopPhoto="pop_photo";

    public static final int sight = 0;
    public static final int restaurant = 1;
    public static final int popular=2;

    String type;
    RecyclerView recyclerview;
    ProgressBar progressBar;
    RecyclerView.Adapter recyclerViewadapter;
    List <GetDataAdapter> GetDataAdapter1;
    JsonArrayRequest jsonArrayRequest;
    RequestQueue requestQueue;
    public static final String TAG = popularActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //
        recyclerview = (RecyclerView) findViewById(R.id.recyclerView1);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);

        GetDataAdapter1 = new ArrayList<>();

        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar.setVisibility(View.VISIBLE);
        JSON_DATA_WEB_CALL(Json_Url.popularUrl);
    }
    public void JSON_DATA_WEB_CALL(String Url) {
        //final String checkUrl = Url;
        jsonArrayRequest = new JsonArrayRequest(Url,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        progressBar.setVisibility(View.GONE);

                        JSON_PARSE_DATA_AFTER_WEBCALL(response);


                        //  JSON_PARSE_AFTER_WEBCALL(response);
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
        //GetDataAdapter1.add(new GetDataAdapter(SightRecyclerViewAdapter.SightHeader, "Museum"));

        for (int i = 0; i < array.length(); i++) {

            GetDataAdapter GetDataAdapter3 = new GetDataAdapter();
              //  type= "";
            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                Log.i(TAG, "JSON_PARSE_DATA_AFTER_WEBCALL: "+json.getString(JSON_ResPopularType));

                //  GetDataAdapter2.setId(json.getInt(JSON_ID));
                type = json.getString(JSON_SightPopularType);
                Log.i(TAG, "JSON_PARSE_DATA_AFTER_WEBCALL: "+type);
                try {
                    if (type.equals("sight")) {

                        GetDataAdapter3.setHeritage_photo(json.getString(JSON_SightPhoto));
                        GetDataAdapter3.setHeritage_title(json.getString(JSON_SightName));
                        GetDataAdapter3.setHeritage_address(json.getString(JSON_SightAddress));
                        GetDataAdapter3.setType(sight);
//                        GetDataAdapter1.add(GetDataAdapter3);
                        Log.i(TAG, "JSON: "+GetDataAdapter3.getHeritage_title());
                    } else  if (type.equals("restaurant")){
                        GetDataAdapter3.setRestaurant_photo(json.getString(JSON_RestaurantPhoto));
                        GetDataAdapter3.setRestaurant_title(json.getString(JSON_RestaurantName));
                        GetDataAdapter3.setRestaurant_address(json.getString(JSON_RestaurantAddress));
                        GetDataAdapter3.setType(restaurant);
                        Log.i(TAG, "JSON_PARSE_DATA_AFTER: "+GetDataAdapter3.getRestaurant_title());
                        //GetDataAdapter1.add(GetDataAdapter3);
                   }else if(type.equals("popular")){
                        GetDataAdapter3.setPop_photo(json.getString(JSON_PopPhoto));
                        GetDataAdapter3.setPop_name(json.getString(JSON_PopName));
                        GetDataAdapter3.setPop_des(json.getString(JSON_PopDes));
                        GetDataAdapter3.setType(popular);
                        Log.d(TAG, "JSON_PARSE_DATA_AFTER_WEBCALL:(abc) "+GetDataAdapter3.getPop_name());

                    }

                }catch (JSONException e) {

                    e.printStackTrace();

                }

//                GetDataAdapter2.setAddress(json.getString(JSON_HotelAddress));
//
//                GetDataAdapter2.setRating(json.getInt(JSON_HotelRating));
//                  GetDataAdapter2.setHotellink(json.getString(JSON_HotelLink));
//                GetDataAdapter2.setHotelbook(json.getString(JSON_HotelBook));
//                GetDataAdapter2.setHotel_lat(json.getDouble(JSON_HotelLat));
//                GetDataAd
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
// apter2.setHotel_long(json.getDouble(JSON_HOtelLong));

            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter3);
//            List<GetDataAdapter> data = new ArrayList<>();
            // GetDataAdapter1.add(new GetDataAdapter(RecyclerViewAdapter.HEADER,"SightSeeing",R.drawable.kathmandu_icon));
            popularAdapter recyclerViewadapter = new popularAdapter(GetDataAdapter1, this);

            recyclerview.setAdapter(recyclerViewadapter);

        }


    }
    }
