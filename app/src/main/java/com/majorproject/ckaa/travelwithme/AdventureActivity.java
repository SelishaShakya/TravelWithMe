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

public class AdventureActivity extends AppCompatActivity {
    String JSON_AdventureName = "adventure_name";
   // String JSON_AdventureDescription = "adventure_description";
    String JSON_AdventurePhoto = "adventure_photo";


    RecyclerView recyclerview;
    ProgressBar progressBar;
    RecyclerView.Adapter recyclerViewadapter;
    List<GetDataAdapter> GetDataAdapter1;
    JsonArrayRequest jsonArrayRequest;
    RequestQueue requestQueue;

   // String GET_JSON_DATA_HTTP_URL = "http://192.168.1.101/uploads/shop.php";
    public static final String TAG = AdventureActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerview = (RecyclerView) findViewById(R.id.recyclerView1);
            progressBar = (ProgressBar) findViewById(R.id.progressBar1);

        recyclerview.setHasFixedSize(true);

        //recyclerViewlayoutManager = new LinearLayoutManager(this);
            GetDataAdapter1 = new ArrayList<>();

            recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            progressBar = (ProgressBar) findViewById(R.id.progressBar1);
            progressBar.setVisibility(View.VISIBLE);
        recyclerViewadapter = new AdventureAdapter(GetDataAdapter1, this);

        recyclerview.setAdapter(recyclerViewadapter);

        JSON_DATA_WEB_CALL();
        }
    public void JSON_DATA_WEB_CALL(){

        jsonArrayRequest = new JsonArrayRequest(Json_Url.adventureUrl,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        progressBar.setVisibility(View.GONE);

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

    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array){

        for(int i = 0; i<array.length(); i++) {
            Log.d(TAG, "JSON_PARSE_DATA_AFTER_WEBCALL: abc");

            GetDataAdapter GetDataAdapter3 = new GetDataAdapter();

            JSONObject json = null;

            try {
                json = array.getJSONObject(i);
                //Log.i(TAG, "JSON_PARSE_DATA_AFTER_WEBCALL: "+json.getString(JSON_ResPopularType));

                //  GetDataAdapter2.setId(json.getInt(JSON_ID));
                //type = json.getString(JSON_SightPopularType);
               // Log.i(TAG, "JSON_PARSE_DATA_AFTER_WEBCALL: "+type);


                        GetDataAdapter3.setAdventure_name(json.getString(JSON_AdventureName));
                        //GetDataAdapter3.setAdventure_description(json.getString(JSON_AdventureDescription));
                        GetDataAdapter3.setAdventure_photo(json.getString(JSON_AdventurePhoto));



                       // GetDataAdapter3.setType(sight);


//                        GetDataAdapter1.add(GetDataAdapter3);
                       Log.i(TAG, "JSON: "+GetDataAdapter3.getAdventure_name());

                }catch (JSONException e) {

                    e.printStackTrace();

                }
            GetDataAdapter1.add(GetDataAdapter3);
//            List<GetDataAdapter> data = new ArrayList<>();
            // GetDataAdapter1.add(new GetDataAdapter(RecyclerViewAdapter.HEADER,"SightSeeing",R.drawable.kathmandu_icon));


        }
        AdventureAdapter recyclerViewadapter = new AdventureAdapter(GetDataAdapter1, this);
        AdventureContentActivity adventureContentActivity =new AdventureContentActivity(GetDataAdapter1);

        recyclerview.setAdapter(recyclerViewadapter);


    }}


