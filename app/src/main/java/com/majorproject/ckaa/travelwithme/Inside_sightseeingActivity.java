package com.majorproject.ckaa.travelwithme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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

public class Inside_sightseeingActivity extends AppCompatActivity {
    List<GetDataAdapter> GetDataAdapter1;
    List<GetDataAdapter> GetDataAdapter3;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView recyclerview;
    RecyclerView.Adapter recyclerViewadapter;
    List<GetDataAdapter> data = new ArrayList<>();
   // GetDataAdapter places = new GetDataAdapter();
    ProgressBar progressBar;
    String JSON_SightName = "sight_name";
    String JSON_SightAddress = "sight_address";
    String JSON_SightOpeningTime = "sight_openingtime";
    String JSON_SightPhoto = "sight_photo";
    String JSON_SightFee = "sight_fee";
    String JSON_SightLatitude = "sight_latitude";
    String JSON_SightLongitude = "sight_longitude";
    String JSON_sightlink="sight_websitelink";
    String JSON_HOtelLong = "hotel_longitude";
    String JSON_ResName = "res_name";
    String JSON_ResAddress = "res_address";
//    String museumUrl = "http://192.168.0.128/hotel/museumData.php";
//    String gardenUrl = "http://192.168.0.128/hotel/gardenData.php";
//    String othersUrl = "http://192.168.0.128/hotel/othersData.php";
//    String staticSightUrl = "http://192.168.0.128/TravelWithMe/kathmandu.php";
   // String GET_JSON_DATA_HTTP_URL = "http://192.168.100.84/hotel/museumData.php";
   // String gardenUrl = "http://192.168.100.84/hotel/gardenData.php";
    //String othersUrl = "http://192.168.100.84/hotel/othersData.php";
    public static final int HEADER = 0;
    public static final int CHILD = 1;
    public static final int SightChild = 3;
    public static final int  SightHeader=2;
    JsonArrayRequest jsonArrayRequest;


    RequestQueue requestQueue;


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerview = (RecyclerView) findViewById(R.id.recyclerView1);
//        recyclerViewlayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(recyclerViewlayoutManager);
        GetDataAdapter1 = new ArrayList<>();

        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //recyclerView.setHasFixedSize(true);

        //recyclerViewlayoutManager = new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(recyclerViewlayoutManager);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);

        getStaticData();
        //GetDataAdapter1.add(new GetDataAdapter(SightRecyclerViewAdapter.HEADER,"World Heritage Sites"));
        GetDataAdapter1.add(new GetDataAdapter(SightRecyclerViewAdapter.SightHeader,R.drawable.museum,"Museum/Gallery"));
        //etDataAdapter1.add((GetDataAdapter) GetDataAdapter3);
        //recyclerViewadapter = new SightRecyclerViewAdapter(GetDataAdapter1, this);

        //recyclerView.setAdapter(recyclerViewadapter);
//        recyclerViewadapter = new SightRecyclerViewAdapter(GetDataAdapter1, this);
//
//        recyclerView.setAdapter(recyclerViewadapter);
        SightRecyclerViewAdapter recyclerViewadapter = new SightRecyclerViewAdapter(GetDataAdapter1, this);

        recyclerview.setAdapter(recyclerViewadapter);
        progressBar.setVisibility(View.VISIBLE);
        JSON_DATA_WEB_CALL(Json_Url.museumUrl);

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

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                //  GetDataAdapter2.setId(json.getInt(JSON_ID));
                GetDataAdapter3.setHeritage_photo(json.getString(JSON_SightPhoto));
                GetDataAdapter3.setHeritage_title(json.getString(JSON_SightName));
                GetDataAdapter3.setHeritage_address(json.getString(JSON_SightAddress));
                GetDataAdapter3.setHeritage_hours(json.getString(JSON_SightOpeningTime));
                GetDataAdapter3.setHeritage_entraceFee(json.getString(JSON_SightFee));
                GetDataAdapter3.setHeritage_lat(json.getDouble(JSON_SightLatitude));
                GetDataAdapter3.setHeritage_long(json.getDouble(JSON_SightLongitude));
                GetDataAdapter3.setHeritage_link(json.getString(JSON_sightlink));
                GetDataAdapter3.setType(SightChild);
//                GetDataAdapter2.setAddress(json.getString(JSON_HotelAddress));
//
//                GetDataAdapter2.setRating(json.getInt(JSON_HotelRating));
//                  GetDataAdapter2.setHotellink(json.getString(JSON_HotelLink));
//                GetDataAdapter2.setHotelbook(json.getString(JSON_HotelBook));
//                GetDataAdapter2.setHotel_lat(json.getDouble(JSON_HotelLat));
//                GetDataAdapter2.setHotel_long(json.getDouble(JSON_HOtelLong));

            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter3);
            List<GetDataAdapter> data = new ArrayList<>();
            // GetDataAdapter1.add(new GetDataAdapter(RecyclerViewAdapter.HEADER,"SightSeeing",R.drawable.kathmandu_icon));
          SightRecyclerViewAdapter recyclerViewadapter = new SightRecyclerViewAdapter(GetDataAdapter1, this);

            recyclerview.setAdapter(recyclerViewadapter);

        }


        JSON_DATA_WEB_CALL_SECOND(Json_Url.gardenUrl);
    }

    public void JSON_DATA_WEB_CALL_SECOND(String Url) {
        //final String checkUrl = Url;
        jsonArrayRequest = new JsonArrayRequest(Url,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        progressBar.setVisibility(View.GONE);

                        JSON_PARSE_DATA_AFTER_WEBCALL_SECOND(response);


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

    public void JSON_PARSE_DATA_AFTER_WEBCALL_SECOND(JSONArray array) {
        //GetDataAdapter1.add(new GetDataAdapter(SightRecyclerViewAdapter.SightHeader, "Museum"));
       // GetDataAdapter1.add(new GetDataAdapter(SightRecyclerViewAdapter.SightHeader,R.drawable.garden_icon,"Gardens/Park"));
        for (int i = 0; i < array.length(); i++) {

            GetDataAdapter GetDataAdapter2 = new GetDataAdapter();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                //  GetDataAdapter2.setId(json.getInt(JSON_ID));
                GetDataAdapter2.setHeritage_photo(json.getString(JSON_SightPhoto));
                GetDataAdapter2.setHeritage_title(json.getString(JSON_SightName));
                GetDataAdapter2.setHeritage_address(json.getString(JSON_SightAddress));
                GetDataAdapter2.setHeritage_hours(json.getString(JSON_SightOpeningTime));
                GetDataAdapter2.setHeritage_entraceFee(json.getString(JSON_SightFee));
                GetDataAdapter2.setHeritage_lat(json.getDouble(JSON_SightLatitude));
                GetDataAdapter2.setHeritage_long(json.getDouble(JSON_SightLongitude));
                GetDataAdapter2.setType(SightChild);
//                GetDataAdapter2.setAddress(json.getString(JSON_HotelAddress));
//
//                GetDataAdapter2.setRating(json.getInt(JSON_HotelRating));
//                  GetDataAdapter2.setHotellink(json.getString(JSON_HotelLink));
//                GetDataAdapter2.setHotelbook(json.getString(JSON_HotelBook));
//                GetDataAdapter2.setHotel_lat(json.getDouble(JSON_HotelLat));
//                GetDataAdapter2.setHotel_long(json.getDouble(JSON_HOtelLong));

            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);
           // List<GetDataAdapter> data = new ArrayList<>();
            // GetDataAdapter1.add(new GetDataAdapter(RecyclerViewAdapter.HEADER,"SightSeeing",R.drawable.kathmandu_icon));
            SightRecyclerViewAdapter recyclerViewadapter = new SightRecyclerViewAdapter(GetDataAdapter1, this);

            recyclerview.setAdapter(recyclerViewadapter);

        }
       // GetDataAdapter1.add(new GetDataAdapter(SightRecyclerViewAdapter.SightHeader,R.drawable.garden_icon,"Gardens/Park"));

       JSON_DATA_WEB_CALL_THIRD(Json_Url.othersUrl);
    }

        //GetDataAdapter1.add(new GetDataAdapter(SightRecyclerViewAdapter.SightHeader,R.drawable.garden_icon,"Gardens/Park"));

        //JSON_DATA_WEB_CALL(gardenUrl);

    public void JSON_DATA_WEB_CALL_THIRD(String Url) {
        //final String checkUrl = Url;
        jsonArrayRequest = new JsonArrayRequest(Url,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        progressBar.setVisibility(View.GONE);

                        JSON_PARSE_DATA_AFTER_WEBCALL_THIRD(response);


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

    public void JSON_PARSE_DATA_AFTER_WEBCALL_THIRD(JSONArray array) {
        //GetDataAdapter1.add(new GetDataAdapter(SightRecyclerViewAdapter.SightHeader, "Museum"));
        GetDataAdapter1.add(new GetDataAdapter(SightRecyclerViewAdapter.SightHeader, R.drawable.places_icon, "Others"));
        for (int i = 0; i < array.length(); i++) {

            GetDataAdapter GetDataAdapter4 = new GetDataAdapter();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                //  GetDataAdapter2.setId(json.getInt(JSON_ID));
                GetDataAdapter4.setHeritage_photo(json.getString(JSON_SightPhoto));
                GetDataAdapter4.setHeritage_title(json.getString(JSON_SightName));
                GetDataAdapter4.setHeritage_address(json.getString(JSON_SightAddress));
                GetDataAdapter4.setHeritage_hours(json.getString(JSON_SightOpeningTime));
                GetDataAdapter4.setHeritage_entraceFee(json.getString(JSON_SightFee));
                GetDataAdapter4.setHeritage_lat(json.getDouble(JSON_SightLatitude));
                GetDataAdapter4.setHeritage_long(json.getDouble(JSON_SightLongitude));
                GetDataAdapter4.setType(SightChild);
//                GetDataAdapter2.setAddress(json.getString(JSON_HotelAddress));
//
//                GetDataAdapter2.setRating(json.getInt(JSON_HotelRating));
//                  GetDataAdapter2.setHotellink(json.getString(JSON_HotelLink));
//                GetDataAdapter2.setHotelbook(json.getString(JSON_HotelBook));
//                GetDataAdapter2.setHotel_lat(json.getDouble(JSON_HotelLat));
//                GetDataAdapter2.setHotel_long(json.getDouble(JSON_HOtelLong));

            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter4);
            // List<GetDataAdapter> data = new ArrayList<>();
            // GetDataAdapter1.add(new GetDataAdapter(RecyclerViewAdapter.HEADER,"SightSeeing",R.drawable.kathmandu_icon));
            SightRecyclerViewAdapter recyclerViewadapter = new SightRecyclerViewAdapter(GetDataAdapter1, this);

            recyclerview.setAdapter(recyclerViewadapter);

        }

    }

        private List<GetDataAdapter> getStaticData()
        {
           GetDataAdapter places = new GetDataAdapter(SightRecyclerViewAdapter.HEADER,R.drawable.temple_icon,"World Heritage Sites");
    places.invisibleChildren = new ArrayList<>();

        places.invisibleChildren.add(new GetDataAdapter(SightRecyclerViewAdapter.CHILD,"Pashupatinath Temple",R.drawable.pashupatinath_icon,"Pashupati Nath Road,Kathmandu","Opening hours: Daily, 6 AM - 8 PM","Entrance Fee(Foreigner): Rs 500 per person",27.710755,85.348507,Json_Url.staticSightUrl));
        places.invisibleChildren.add(new GetDataAdapter(SightRecyclerViewAdapter.CHILD,"Swayambhunath Stupa",R.drawable.swayambhu_icon,"Swayambhu,Kathmandu","Opening hours:  Daily, 7 AM - 9 PM","Entrance Fee(Foreigner):Rs 200 per person",27.715054,85.290497,Json_Url.staticSightUrl));
        places.invisibleChildren.add(new GetDataAdapter(SightRecyclerViewAdapter.CHILD,"Boudhanath Stupa",R.drawable.kathmandu_icon,"Boudha,Kathmandu","Opening Times: Daily,7 AM-7 PM ","Entrance Fee(Foreigner):Rs 100 per person",27.721557, 85.361871,Json_Url.staticSightUrl));
        places.invisibleChildren.add(new GetDataAdapter(SightRecyclerViewAdapter.CHILD,"Kathmandu Durbar Square",R.drawable.ktm_durbar_icon,"Basantapur,Kathmandu","Opening hours: Tue - Sat, 10:30 AM - 3 PM","Entrance Fee(Foreigner):Rs 100 per person",27.704328, 85.307296,Json_Url.staticSightUrl));
       GetDataAdapter1.add(places);
        return data;
    }


    }


