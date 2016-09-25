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

public class AmusementActivity extends AppCompatActivity {

    List<GetDataAdapter> GetDataAdapter1;

    RecyclerView recyclerView;

    RecyclerView.LayoutManager recyclerViewlayoutManager;

    RecyclerView.Adapter recyclerViewadapter;

    ProgressBar progressBar;
    public static final int staticamuse=0;
    public static final int Dynamicamuse=2;

    //String JSON_ID = "id";
    String JSON_AmusementName = "amuse_name";
    String JSON_AmusementAddress = "amuse_address";
   String JSON_AmusementPhone = "amuse_phone";
    String JSON_AmusementPhoto = "amuse_photo";
    String JSON_AmusementOpeningTime="amuse_openingtime";
    String JSON_AmusementFee="amuse_fee";
    String JSON_AmusementLatitude="amuse_latitude";
    String JSON_AmusementLongitude="amuse_longitude";

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

        recyclerViewadapter = new Hotel_AmusementRecyclerViewAdapter(GetDataAdapter1, this);

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

        jsonArrayRequest = new JsonArrayRequest(Json_Url.amusementUrl,

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

                GetDataAdapter2.setAmusement_name(json.getString(JSON_AmusementName));

                GetDataAdapter2.setAmusement_address(json.getString(JSON_AmusementAddress));
                GetDataAdapter2.setAmusement_photo(json.getString(JSON_AmusementPhoto));
                GetDataAdapter2.setAmusement_phone(json.getString(JSON_AmusementPhone));
                GetDataAdapter2.setAmusement_openingtime(json.getString(JSON_AmusementOpeningTime));
                GetDataAdapter2.setAmusement_fee(json.getString(JSON_AmusementFee));
                GetDataAdapter2.setAmusement_latitude(json.getDouble(JSON_AmusementLatitude));
                GetDataAdapter2.setAmusement_longitude(json.getDouble(JSON_AmusementLongitude));
                GetDataAdapter2.setType(Dynamicamuse);
            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);
        }

        recyclerViewadapter = new Hotel_AmusementRecyclerViewAdapter(GetDataAdapter1, this);

        recyclerView.setAdapter(recyclerViewadapter);
    }

    private List<GetDataAdapter> getListItemData() {
        List<GetDataAdapter> listViewItems = new ArrayList<>();
        listViewItems.add(new GetDataAdapter(Hotel_AmusementRecyclerViewAdapter.StaticAmuse,"Maidan Futsal","Battisputali, Kathmandu","01-4497642",R.drawable.maidan_futsal,"Mon – Sun: 7:00 am – 10:00 pm","",27.702023,85.343398));
        listViewItems.add(new GetDataAdapter(Hotel_AmusementRecyclerViewAdapter.StaticAmuse,"Grassroots Recreational Center","Mandikatar, Kathmandu","01-4375276", R.drawable.grassroot_recreational,"Mon – Sun: 6:00 am – 10:00 pm","",27.734276,85.345225));
        return listViewItems;
    }

}