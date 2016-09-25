package com.majorproject.ckaa.travelwithme;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AdventureContentActivity extends AppCompatActivity {

    private static final String TAG =AdventureContentActivity.class.getSimpleName() ;
    String JSON_AdventureName = "adventure_name";
    String JSON_AdventureDescription = "adventure_description";
    String JSON_AdventurePhoto = "adventure_photo";


    public Context context;
    public TextView Adventure_title;
    public ImageView Adventure_image;
    public TextView Adventure_description;
    public List<GetDataAdapter> GetDataAdapter1;
    int adventureposition;

   // List<GetDataAdapter> GetDataAdapter1;
    JsonArrayRequest jsonArrayRequest;
    RequestQueue requestQueue;

    public AdventureContentActivity() {
    }

    public AdventureContentActivity(List<GetDataAdapter> getDataAdapter1) {
        GetDataAdapter1 = getDataAdapter1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure_content);
        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GetDataAdapter1 = new ArrayList<>();
        Bundle extract = getIntent().getExtras();
        adventureposition = extract.getInt("currentposition");
        JSON_DATA_WEB_CALL();

    }
    public void JSON_DATA_WEB_CALL(){

        jsonArrayRequest = new JsonArrayRequest(Json_Url.adventureContent,

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
                GetDataAdapter3.setAdventure_description(json.getString(JSON_AdventureDescription));
                GetDataAdapter3.setAdventure_photo(json.getString(JSON_AdventurePhoto));



                // GetDataAdapter3.setType(sight);


//                        GetDataAdapter1.add(GetDataAdapter3);
              //  Log.i(TAG, "JSON: "+GetDataAdapter3.getAdventure_name());

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
        Adventure_title=(TextView)findViewById(R.id.adventure_title);
        Adventure_image=(ImageView)findViewById(R.id.adventure_image);
        Adventure_description=(TextView)findViewById(R.id.adventure_description);

        GetDataAdapter getDataAdapter1= GetDataAdapter1.get(adventureposition);
        Adventure_title.setText(getDataAdapter1.getAdventure_name());
        Adventure_description.setText(getDataAdapter1.getAdventure_description());
        //Log.d(TAG, "viewContent: "+getDataAdapter1.getPopular_image());
        Glide.with(context).load(Json_Url.ip+"hotel/"+ getDataAdapter1.getAdventure_photo()).centerCrop().into(Adventure_image);

    }
}
