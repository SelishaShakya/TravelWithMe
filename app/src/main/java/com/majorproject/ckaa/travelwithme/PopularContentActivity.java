package com.majorproject.ckaa.travelwithme;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
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

public class PopularContentActivity extends AppCompatActivity {
    private static final String TAG = PopularContentActivity.class.getSimpleName();
    public static List<GetDataAdapter> GetDataAdapter1;
//    RecyclerView recyclerView;
//
//    RecyclerView.LayoutManager recyclerViewlayoutManager;


   // RecyclerView.Adapter recyclerViewadapter;
    String JSON_popularname = "popular_name";
    String JSON_popularaddress = "popular_address";
    String JSON_popularimage = "popular_image";
    String JSON_popularcategory = "popular_category";
    String JSON_populardescription = "popular_description";
    int popularposition;


    ProgressBar progressBar;

    JsonArrayRequest jsonArrayRequest;
    public Context context;
//    List<GetDataAdapter>getDataAdapter;

    RequestQueue requestQueue;

   public TextView popular_title;
    public ImageView popular_image;
    public TextView popular_address;
    public TextView popular_category;
    public TextView popular_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popular_content_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GetDataAdapter1 = new ArrayList<>();
//
//
//        recyclerView = (RecyclerView) findViewById(R.id.popular_recyclerView);
//
//        // button = (Button)findViewById(R.id.button) ;
//
//        recyclerView.setHasFixedSize(true);
//
//        recyclerViewlayoutManager = new LinearLayoutManager(this);
//
//        recyclerView.setLayoutManager(recyclerViewlayoutManager);
       // progressBar = (ProgressBar) findViewById(R.id.popular_progressBar);
        //progressBar.setVisibility(View.VISIBLE);
        Bundle extract = getIntent().getExtras();
        popularposition = extract.getInt("currentposition");
        JSON_DATA_WEB_CALL(Json_Url.popularContentUrl);

    }

    public void JSON_DATA_WEB_CALL(String url) {

        jsonArrayRequest = new JsonArrayRequest(url,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        //progressBar.setVisibility(View.GONE);

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

    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            GetDataAdapter GetDataAdapter2 = new GetDataAdapter();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                //  GetDataAdapter2.setId(json.getInt(JSON_ID));

                GetDataAdapter2.setPopular_name(json.getString(JSON_popularname));

                GetDataAdapter2.setPopular_address(json.getString(JSON_popularaddress));

                GetDataAdapter2.setPopular_image(json.getString(JSON_popularimage));
                GetDataAdapter2.setPopular_description(json.getString(JSON_populardescription));
                GetDataAdapter2.setPopular_category(json.getString(JSON_popularcategory));
                //GetDataAdapter2.setPopularposition(popularposition);
            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);


        }

//        recyclerViewadapter = new PopularContentAdapter(GetDataAdapter1, this);
//
//        recyclerView.setAdapter(recyclerViewadapter);




        viewContent(getApplicationContext());
    }

    public void viewContent(Context context){

            popular_title=(TextView)findViewById(R.id.popular_title);
            popular_image=(ImageView)findViewById(R.id.popular_image);
            popular_address=(TextView)findViewById(R.id.popular_address);
            popular_category=(TextView)findViewById(R.id.popular_category);
            popular_description=(TextView)findViewById(R.id.popular_description);

        GetDataAdapter getDataAdapter1= GetDataAdapter1.get(popularposition);
        popular_title.setText(getDataAdapter1.getPopular_name());
        popular_address.setText(getDataAdapter1.getPopular_address());
        Log.d(TAG, "viewContent: "+getDataAdapter1.getPopular_image());
        Glide.with(context).load(Json_Url.ip+"hotel/"+ getDataAdapter1.getPopular_image()).centerCrop().into(popular_image);
        popular_category.setText(getDataAdapter1.getPopular_category());
        popular_description.setText(getDataAdapter1.getPopular_description());

    }


}
