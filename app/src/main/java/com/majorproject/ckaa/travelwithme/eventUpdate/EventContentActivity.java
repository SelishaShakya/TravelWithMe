package com.majorproject.ckaa.travelwithme.eventUpdate;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.majorproject.ckaa.travelwithme.Json_Url;
import com.majorproject.ckaa.travelwithme.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EventContentActivity extends AppCompatActivity {
    String JSON_EventName = "event_name";
    String JSON_EventDescription = "event_description";
    String JSON_EventPhoto = "event_photo";
    String JSON_EventVenue="event_venue";
    String JSON_EventDate="event_date";


    public Context context;
    public TextView Event_title;
    public ImageView Event_image;
    public TextView Event_description;
    public TextView Event_venue;
    public TextView Event_date;
    public List<GetNewDataAdapter> GetDataAdapter1;
    int eventposition;

    // List<GetDataAdapter> GetDataAdapter1;
    JsonArrayRequest jsonArrayRequest;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            GetDataAdapter1 = new ArrayList<>();
            Bundle extract = getIntent().getExtras();
            eventposition = extract.getInt("currentposition");
            JSON_DATA_WEB_CALL();

        }
    public void JSON_DATA_WEB_CALL(){

        jsonArrayRequest = new JsonArrayRequest(Json_Url.eventNotificationUrl,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {


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
           // Log.d(TAG, "JSON_PARSE_DATA_AFTER_WEBCALL: abc");

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
                GetDataAdapter3.setEvent_venue(json.getString(JSON_EventVenue));
                GetDataAdapter3.setEvent_description(json.getString(JSON_EventDescription));
                GetDataAdapter3.setEvent_photo(json.getString(JSON_EventPhoto));





                // GetDataAdapter3.setType(sight);


//                        GetDataAdapter1.add(GetDataAdapter3);
                //  Log.i(TAG, "JSON: "+GetDataAdapter3.getEvent_name());

            }catch (JSONException e) {

                e.printStackTrace();

            }
            GetDataAdapter1.add(GetDataAdapter3);
//            List<GetDataAdapter> data = new ArrayList<>();
            // GetDataAdapter1.add(new GetDataAdapter(RecyclerViewAdapter.HEADER,"SightSeeing",R.drawable.kathmandu_icon));


        }
        viewContent(getApplicationContext());
    }
    public void viewContent(Context context){
        Event_title=(TextView)findViewById(R.id.event_title);
        Event_image=(ImageView)findViewById(R.id.event_image);
        Event_description=(TextView)findViewById(R.id.event_description);
        Event_date=(TextView)findViewById(R.id.event_date);
        Event_venue=(TextView)findViewById(R.id.event_venue);

        GetNewDataAdapter getDataAdapter1= GetDataAdapter1.get(eventposition);
        Event_title.setText(getDataAdapter1.getEvent_name());
        Event_description.setText(getDataAdapter1.getEvent_description());
        Event_date.setText(getDataAdapter1.getEvent_date());
        Event_venue.setText(getDataAdapter1.getEvent_venue());
        //Log.d(TAG, "viewContent: "+getDataAdapter1.getPopular_image());
        Glide.with(context).load(Json_Url.ip+"hotel/"+ getDataAdapter1.getEvent_photo()).centerCrop().into(Event_image);

    }
    }
