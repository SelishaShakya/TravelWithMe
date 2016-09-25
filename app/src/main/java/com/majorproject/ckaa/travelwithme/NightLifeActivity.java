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

public class NightLifeActivity extends AppCompatActivity {


    List<GetDataAdapter> GetDataAdapter1;

    RecyclerView recyclerView;

    RecyclerView.LayoutManager recyclerViewlayoutManager;

    RecyclerView.Adapter recyclerViewadapter;

    ProgressBar progressBar;
    public static final int Staticnight = 0;
    public static final int Dynamicnight = 1;


    //String JSON_ID = "id";
    String JSON_NightName = "night_name";
    String JSON_NightAddress = "night_address";
    String JSON_NightPhone = "night_phone";
    String JSON_NightPhoto = "night_photo";
    String JSON_NightLatitude="night_latitude";
    String JSON_NightLongitude="night_longitude";

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



        // button = (Button)findViewById(R.id.button) ;

        recyclerView.setHasFixedSize(true);

        recyclerViewlayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(recyclerViewlayoutManager);
        GetDataAdapter1=getListItemData();
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar.setVisibility(View.VISIBLE);

        recyclerViewadapter = new Night_shoppingRecyclerViewAdapter(GetDataAdapter1, this);

        recyclerView.setAdapter(recyclerViewadapter);

        JSON_DATA_WEB_CALL();

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                progressBar.setVisibility(View.VISIBLE);
//
//                JSON_DATA_WEB_CALL();
//
//            }
//        });

    }

    public void JSON_DATA_WEB_CALL(){

        jsonArrayRequest = new JsonArrayRequest(Json_Url.nightUrl,

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

            GetDataAdapter GetDataAdapter2 = new GetDataAdapter();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                //  GetDataAdapter2.setId(json.getInt(JSON_ID));

                GetDataAdapter2.setNight_name(json.getString(JSON_NightName));

                GetDataAdapter2.setNight_address(json.getString(JSON_NightAddress));

                GetDataAdapter2.setNight_phone(json.getString(JSON_NightPhone));
                GetDataAdapter2.setNight_photo(json.getString(JSON_NightPhoto));
                GetDataAdapter2.setNight_latitude(json.getDouble(JSON_NightLatitude));
                GetDataAdapter2.setNight_longitude(json.getDouble(JSON_NightLongitude));
                GetDataAdapter2.setType(Dynamicnight);
            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);
        }

        recyclerViewadapter = new Night_shoppingRecyclerViewAdapter(GetDataAdapter1, this);

        recyclerView.setAdapter(recyclerViewadapter);
    }

    private List<GetDataAdapter> getListItemData() {
        List<GetDataAdapter> listViewItems = new ArrayList<>();
        listViewItems.add(new GetDataAdapter(Night_shoppingRecyclerViewAdapter.Staticnight,"Club Dynasty","Sundhara, Kathmandu","014256779",R.drawable.paddy,27.6959,85.3429));
        listViewItems.add(new GetDataAdapter(Night_shoppingRecyclerViewAdapter.Staticnight,"Club 2000","Durbarmarg, Kathmandu","014222686", R.drawable.dynasty,27.712306,85.317554));
        listViewItems.add(new GetDataAdapter(Night_shoppingRecyclerViewAdapter.Staticnight,"Star Disco","Jawalakhel, Lalitpur","014491397", R.drawable.star,27.676112,85.310844));
        return listViewItems;
    }
}