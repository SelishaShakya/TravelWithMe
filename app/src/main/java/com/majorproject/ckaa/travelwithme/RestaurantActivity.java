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

public class RestaurantActivity extends AppCompatActivity {
RecyclerView recyclerview;
    ProgressBar progressBar;
    List<GetDataAdapter> GetDataAdapter1;
    List<GetDataAdapter> data = new ArrayList<>();
    JsonArrayRequest jsonArrayRequest;
    public static final int HEADER = 0;
    public static final int RestaurantChild = 3;
    String JSON_RestaurantName = "res_name";
    String JSON_RestaurantAddress = "res_address";
    String JSON_RestaurantOpeningTime = "res_openingTime";
    String JSON_RestaurantPhoto = "res_photo";
   String JSON_RestaurantNumber = "res_phno";
    String JSON_RestaurantLatitude = "res_latitude";
    String JSON_RestaurantLongitude = "res_longitude";
   // String GET_JSON_DATA_HTTP_URL = "http://192.168.0.128/hotel/museumData.php";
//   String italianUrl = "http://192.168.0.131/hotel/italianRes.php";
//   String veganUrl = "http://192.168.0.131/hotel/veganRes.php";
//    String internationalUrl = "http://192.168.0.131/hotel/internationalRes.php";



    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerview = (RecyclerView) findViewById(R.id.recyclerView1);
        GetDataAdapter1 = new ArrayList<>();

        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        getStaticdataFirst();
        getStaticdataSecond();
        RestaurantRecyclerViewAdapter recyclerViewadapter = new RestaurantRecyclerViewAdapter(GetDataAdapter1, this);

        recyclerview.setAdapter(recyclerViewadapter);
        GetDataAdapter1.add(new GetDataAdapter(RestaurantRecyclerViewAdapter.RestaurantHeader, R.drawable.pasta,"Italian Cuisine"));
        progressBar.setVisibility(View.VISIBLE);
        JSON_DATA_WEB_CALL();

    }
    public void JSON_DATA_WEB_CALL() {
        //final String checkUrl = Url;
        jsonArrayRequest = new JsonArrayRequest(Json_Url.italianUrl,

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
        //GetDataAdapter1.add(new GetDataAdapter(RestaurantRecyclerViewAdapter.SightHeader, "Museum"));

        for (int i = 0; i < array.length(); i++) {

            GetDataAdapter GetDataAdapter3 = new GetDataAdapter();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                //  GetDataAdapter2.setId(json.getInt(JSON_ID));
                GetDataAdapter3.setRestaurant_photo((json.getString(JSON_RestaurantPhoto)));
                GetDataAdapter3.setRestaurant_title(json.getString(JSON_RestaurantName));
                GetDataAdapter3.setRestaurant_address(json.getString(JSON_RestaurantAddress));
                GetDataAdapter3.setRestaurant_openingTime(json.getString(JSON_RestaurantOpeningTime));
                GetDataAdapter3.setRestaurant_number(json.getString(JSON_RestaurantNumber));
                GetDataAdapter3.setRestaurant_lat(json.getDouble(JSON_RestaurantLatitude));
                GetDataAdapter3.setRestaurant_long(json.getDouble(JSON_RestaurantLongitude));
                //GetDataAdapter3.setHeritage_link(json.getString(JSON_sightlink));
                GetDataAdapter3.setType(RestaurantChild);
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
//            RestaurantRecyclerViewAdapter recyclerViewadapter = new RestaurantRecyclerViewAdapter(GetDataAdapter1, this);
//
//            recyclerview.setAdapter(recyclerViewadapter);
            RestaurantRecyclerViewAdapter recyclerViewadapter = new RestaurantRecyclerViewAdapter(GetDataAdapter1, this);

            recyclerview.setAdapter(recyclerViewadapter);
        }
        GetDataAdapter1.add(new GetDataAdapter(RestaurantRecyclerViewAdapter.RestaurantHeader, R.drawable.vegan,"Vegan/Vegetarian"));


        JSON_DATA_WEB_CALL_SECOND(Json_Url.veganUrl);

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
        //GetDataAdapter1.add(new GetDataAdapter(RestaurantRecyclerViewAdapter.SightHeader, "Museum"));
       // GetDataAdapter1.add(new GetDataAdapter(RestaurantRecyclerViewAdapter.RestaurantHeader,R.drawable.garden_icon,"Gardens/Park"));
        for (int i = 0; i < array.length(); i++) {

            GetDataAdapter GetDataAdapter2 = new GetDataAdapter();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                //  GetDataAdapter2.setId(json.getInt(JSON_ID));
                GetDataAdapter2.setRestaurant_photo((json.getString(JSON_RestaurantPhoto)));
                GetDataAdapter2.setRestaurant_title(json.getString(JSON_RestaurantName));
                GetDataAdapter2.setRestaurant_address(json.getString(JSON_RestaurantAddress));
                GetDataAdapter2.setRestaurant_openingTime(json.getString(JSON_RestaurantOpeningTime));
                GetDataAdapter2.setRestaurant_number(json.getString(JSON_RestaurantNumber));
                GetDataAdapter2.setRestaurant_lat(json.getDouble(JSON_RestaurantLatitude));
                GetDataAdapter2.setRestaurant_long(json.getDouble(JSON_RestaurantLongitude));
                GetDataAdapter2.setType(RestaurantChild);
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
            RestaurantRecyclerViewAdapter recyclerViewadapter = new RestaurantRecyclerViewAdapter(GetDataAdapter1, this);

            recyclerview.setAdapter(recyclerViewadapter);

        }
        // GetDataAdapter1.add(new GetDataAdapter(RestaurantRecyclerViewAdapter.SightHeader,R.drawable.garden_icon,"Gardens/Park"));
        GetDataAdapter1.add(new GetDataAdapter(RestaurantRecyclerViewAdapter.RestaurantHeader, R.drawable.international,"International"));

        JSON_DATA_WEB_CALL_THIRD(Json_Url.internationalUrl);
    }

    //GetDataAdapter1.add(new GetDataAdapter(RestaurantRecyclerViewAdapter.SightHeader,R.drawable.garden_icon,"Gardens/Park"));

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
        //GetDataAdapter1.add(new GetDataAdapter(RestaurantRecyclerViewAdapter.SightHeader, "Museum"));
        //GetDataAdapter1.add(new GetDataAdapter(RestaurantRecyclerViewAdapter.SightHeader, R.drawable.places_icon, "Others"));
        for (int i = 0; i < array.length(); i++) {

            GetDataAdapter GetDataAdapter4 = new GetDataAdapter();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                //  GetDataAdapter2.setId(json.getInt(JSON_ID));
                GetDataAdapter4.setRestaurant_photo((json.getString(JSON_RestaurantPhoto)));
                GetDataAdapter4.setRestaurant_title(json.getString(JSON_RestaurantName));
                GetDataAdapter4.setRestaurant_address(json.getString(JSON_RestaurantAddress));
                GetDataAdapter4.setRestaurant_openingTime(json.getString(JSON_RestaurantOpeningTime));
                GetDataAdapter4.setRestaurant_number(json.getString(JSON_RestaurantNumber));
                GetDataAdapter4.setRestaurant_lat(json.getDouble(JSON_RestaurantLatitude));
                GetDataAdapter4.setRestaurant_long(json.getDouble(JSON_RestaurantLongitude));
                GetDataAdapter4.setType(RestaurantChild);
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
            RestaurantRecyclerViewAdapter recyclerViewadapter = new RestaurantRecyclerViewAdapter(GetDataAdapter1, this);

            recyclerview.setAdapter(recyclerViewadapter);

        }
    }
        private List<GetDataAdapter> getStaticdataFirst()
    {
        GetDataAdapter res = new GetDataAdapter(RestaurantRecyclerViewAdapter.HEADER,R.drawable.chinese,"Chinese");
        res.invisibleChildren = new ArrayList<>();
        res.invisibleChildren.add(new GetDataAdapter(RestaurantRecyclerViewAdapter.CHILD,"Kunga Hotel Restaurant & Bar","Boudha Rd, Kathmandu",R.drawable.kunga_restaurant,"8AM to 10PM","01-4915117",27.7233174425356,85.36293374621891));
        res.invisibleChildren.add(new GetDataAdapter(RestaurantRecyclerViewAdapter.CHILD,"Royal Dragon Chinese Restaurant","Durbar Marg,Kathmandu",R.drawable.royal_dragon_chinese,"9AM to 10PM","01-4239563",27.712277,85.317585));
        GetDataAdapter1.add(res);
        return data;
    }
    private List<GetDataAdapter> getStaticdataSecond()
    {
        GetDataAdapter resTwo = new GetDataAdapter(RestaurantRecyclerViewAdapter.HEADER,R.drawable.vegetarian,"Indian");
        resTwo.invisibleChildren = new ArrayList<>();
        resTwo.invisibleChildren.add(new GetDataAdapter(RestaurantRecyclerViewAdapter.CHILD,"Third Eye","JP Road, Kathmandu",R.drawable.the_third_eye,"10AM-10PM","01-4260289",27.717245,85.32396
        ));
        resTwo.invisibleChildren.add(new GetDataAdapter(RestaurantRecyclerViewAdapter.CHILD,"Ghar-e-Kebab","Durbar Marg,Kathmandu",R.drawable.ghar_e_kabab,"6AM-11PM","01-4221711",27.706457,85.316426));
        resTwo.invisibleChildren.add(new GetDataAdapter(RestaurantRecyclerViewAdapter.CHILD,"Angan, Pashupati foods","Layaku Marg, Kathmandu",R.drawable.angan_image,"8AM-8PM","01-4240778",27.703802,85.308987));

        GetDataAdapter1.add(resTwo);
        return data;
    }


}
