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


public class HikingActivity extends AppCompatActivity {
    List<GetDataAdapter> GetDataAdapter1;




    //String JSON_ID = "id";
    String JSON_HikeName = "hike_name";
    String JSON_HikeStartEnd = "hike_startend";
    String JSON_HikeDuration = "hike_duration";
    String JSON_HikeAltitude = "hike_altitude";
    String JSON_HikeTime="hike_time";
    String JSON_HikePrice="hike_price";
    String JSON_HikeHighlights="hike_highlights";
    String JSON_HikePhoto="hike_photo";
    String JSON_HikeLatitude="hike_latitude";
    String JSON_HikeLongitude="hike_longitude";
    String JSON_ID="hike_id";
    RecyclerView recyclerView;

    JsonArrayRequest jsonArrayRequest ;
    RecyclerView.Adapter recyclerViewadapter;
    ProgressBar progressBar;
    RequestQueue requestQueue ;
    public static int CHILD=1;
    public static int HEADER=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView=(RecyclerView)findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        GetDataAdapter1 = new ArrayList<>();
       progressBar = (ProgressBar) findViewById(R.id.progressBar1);

//        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,1);//if image size is different then it displays with differnt size,does not make size constant
//        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);//makes size constant n display
        recyclerView.setLayoutManager(linearLayoutManager);

        //recyclerView.setLayoutManager(gridLayoutManager);
       /* List<GetDataAdapter> staggeredListContent=getListItemData();
        HikingHeaderAdapter rcAdapter=new HikingHeaderAdapter(HikingActivity.this,staggeredListContent);
        recyclerView.setAdapter(rcAdapter);*/
        progressBar.setVisibility(View.VISIBLE);
        JSON_DATA_WEB_CALL();
    }
    public void JSON_DATA_WEB_CALL(){

        jsonArrayRequest = new JsonArrayRequest(Json_Url.hikingUrl,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        progressBar.setVisibility(View.GONE);
                      //  progressBar.setVisibility(View.GONE);

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
            switch(i) {
                case 0:
                    GetDataAdapter1.add(new GetDataAdapter("Adventure Mission Trail day hike", R.drawable.bajrabarahi, HEADER));
                    break;
                case 1:
                    GetDataAdapter1.add(new GetDataAdapter("Champadevi", R.drawable.champadevi, HEADER));
                    break;
                case 2:
                    GetDataAdapter1.add(new GetDataAdapter("Phulchoki", R.drawable.phulchoki, HEADER));
                    break;
                case 3:
                    GetDataAdapter1.add(new GetDataAdapter("One Day Kakani to Bhanjayang Hike", R.drawable.kakani, HEADER));
                    break;
                case 4:
                    GetDataAdapter1.add(new GetDataAdapter("Namobuddha", R.drawable.namobuddha, HEADER));
                    break;
                case 5:
                    GetDataAdapter1.add(new GetDataAdapter("One Day Shivapuri Hiking from Budhanilkantha via Nagi Gumpa", R.drawable.shivapuri, HEADER));
                    break;
            }

            GetDataAdapter GetDataAdapter2 = new GetDataAdapter();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                //GetDataAdapter2.setHike_id(json.getInt(JSON_ID));

                GetDataAdapter2.setHike_name(json.getString(JSON_HikeName));

                GetDataAdapter2.setHike_startend(json.getString(JSON_HikeStartEnd));
                GetDataAdapter2.setHike_duration(json.getString(JSON_HikeDuration));
                GetDataAdapter2.setHike_altitude(json.getString(JSON_HikeAltitude));
                GetDataAdapter2.setHike_time(json.getString(JSON_HikeTime));
                GetDataAdapter2.setHike_price(json.getString(JSON_HikePrice));
                GetDataAdapter2.setHike_highlights(json.getString(JSON_HikeHighlights));
                GetDataAdapter2.setHike_photo(json.getString(JSON_HikePhoto));
                GetDataAdapter2.setHike_latitude(json.getDouble(JSON_HikeLatitude));
                GetDataAdapter2.setHike_longitude(json.getDouble(JSON_HikeLongitude));
                GetDataAdapter2.setType(CHILD);
                GetDataAdapter1.add(GetDataAdapter2);

                recyclerViewadapter = new HikingHeaderAdapter(this,GetDataAdapter1);

                recyclerView.setAdapter(recyclerViewadapter);

            } catch (JSONException e) {

                e.printStackTrace();
            }

        }


    }


//    private List<GetDataAdapter> getListItemData() {
//        List<GetDataAdapter> listViewItems = new ArrayList<>();
//        listViewItems.add(new GetDataAdapter("Adventure Mission Trail day hike", R.drawable.bajrabarahi,HEADER));
//        listViewItems.add(new GetDataAdapter("Champadevi", R.drawable.champadevi,HEADER));
//        listViewItems.add(new GetDataAdapter("Phulchoki", R.drawable.phulchoki,HEADER));
//        listViewItems.add(new GetDataAdapter("One Day Kakani to Bhanjayang Hike", R.drawable.kakani,HEADER));
//        listViewItems.add(new GetDataAdapter("Namobuddha", R.drawable.namobuddha,HEADER));
//        listViewItems.add(new GetDataAdapter("One Day Shivapuri Hiking from Budhanilkantha via Nagi Gumpa", R.drawable.shivapuri,HEADER));
//
//
//        return listViewItems;
//    }
}
