package com.majorproject.ckaa.travelwithme.eventUpdate;

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
import com.majorproject.ckaa.travelwithme.Json_Url;
import com.majorproject.ckaa.travelwithme.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity {
    String JSON_EventName = "event_name";
    // String JSON_AdventureDescription = "adventure_description";
    String JSON_EventPhoto = "event_photo";
    String JSON_EventDate="event_date";


    RecyclerView recyclerview;
    ProgressBar progressBar;
    RecyclerView.Adapter recyclerViewadapter;
    List<GetNewDataAdapter> GetDataAdapter1;
    JsonArrayRequest jsonArrayRequest;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerView1);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);

        recyclerview.setHasFixedSize(true);

        //recyclerViewlayoutManager = new LinearLayoutManager(this);
        GetDataAdapter1 = new ArrayList<>();

        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar.setVisibility(View.VISIBLE);
        recyclerViewadapter = new EventAdapter(GetDataAdapter1, this);

        recyclerview.setAdapter(recyclerViewadapter);

        JSON_DATA_WEB_CALL();
    }
    public void JSON_DATA_WEB_CALL(){

        jsonArrayRequest = new JsonArrayRequest(Json_Url.eventNotificationUrl,

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
            //Log.d(TAG, "JSON_PARSE_DATA_AFTER_WEBCALL: abc");

            GetNewDataAdapter GetDataAdapter3 = new GetNewDataAdapter();

            JSONObject json = null;

            try {
                json = array.getJSONObject(i);
                //Log.i(TAG, "JSON_PARSE_DATA_AFTER_WEBCALL: "+json.getString(JSON_ResPopularType));

                //  GetDataAdapter2.setId(json.getInt(JSON_ID));
                //type = json.getString(JSON_SightPopularType);
                // Log.i(TAG, "JSON_PARSE_DATA_AFTER_WEBCALL: "+type);


                GetDataAdapter3.setEvent_name(json.getString(JSON_EventName));
                GetDataAdapter3.setEvent_date(json.getString(JSON_EventDate));
                //GetDataAdapter3.setAdventure_description(json.getString(JSON_AdventureDescription));
                GetDataAdapter3.setEvent_photo(json.getString(JSON_EventPhoto));



                // GetDataAdapter3.setType(sight);


//                        GetDataAdapter1.add(GetDataAdapter3);
               // Log.i(TAG, "JSON: "+GetDataAdapter3.getAdventure_name());

            }catch (JSONException e) {

                e.printStackTrace();

            }
            GetDataAdapter1.add(GetDataAdapter3);
//            List<GetDataAdapter> data = new ArrayList<>();
            // GetDataAdapter1.add(new GetDataAdapter(RecyclerViewAdapter.HEADER,"SightSeeing",R.drawable.kathmandu_icon));


        }
        EventAdapter recyclerViewadapter = new EventAdapter(GetDataAdapter1, this);

        recyclerview.setAdapter(recyclerViewadapter);


    }}
