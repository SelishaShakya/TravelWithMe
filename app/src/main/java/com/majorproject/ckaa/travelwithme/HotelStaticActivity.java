package com.majorproject.ckaa.travelwithme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;

import java.util.ArrayList;
import java.util.List;

public class HotelStaticActivity extends AppCompatActivity {

    List<GetDataAdapter> GetDataAdapter1;

    RecyclerView recyclerView;

    RecyclerView.LayoutManager recyclerViewlayoutManager;

    RecyclerView.Adapter recyclerViewadapter;

    ProgressBar progressBar;

    String GET_JSON_DATA_HTTP_URL = "http://192.168.0.106/hotel/Hoteldata.php";
    //String JSON_ID = "id";
    String JSON_HotelName = "name";
    String JSON_HotelAddress = "address";
    String JSON_HotelRating = "rating";
    String JSON_HotelPhoto = "photo_link";
    String JSON_HotelBook="hotelbook_url";
    String JSON_HotelLink="hotel_link";
    public static final int HOTEL= 0;
    public static final int ONLINE_BUTTON = 1;

    private int mDatasetTypes[] = {HOTEL,HOTEL,HOTEL,ONLINE_BUTTON};
    JsonArrayRequest jsonArrayRequest ;


    RequestQueue requestQueue ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // getSupportActionBar().setTitle("Hotels");
        setSupportActionBar(toolbar);

        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GetDataAdapter1 = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);

    //  Button button = (Button)findViewById(R.id.loadbutton) ;

        recyclerView.setHasFixedSize(true);

        recyclerViewlayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(recyclerViewlayoutManager);
        List<ItemObjects> staggeredListContent=getListItemData();
        SolventRecyclerViewAdapter rcAdapter=new SolventRecyclerViewAdapter(HotelStaticActivity.this,staggeredListContent);
        recyclerView.setAdapter(rcAdapter);

        // progressBar.setVisibility(View.VISIBLE);

       //JSON_DATA_WEB_CALL();

//       button.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//
//                progressBar.setVisibility(View.VISIBLE);
//                JSON_DATA_WEB_CALL();
//            }
//        });
//
   }
    private List<ItemObjects> getListItemData() {
        List<ItemObjects> listViewItems = new ArrayList<>();
        listViewItems.add(new ItemObjects(SolventRecyclerViewAdapter.HOTEL,"Hotel de l Annapurna", R.drawable.hotel_annapurna_icon,"Durbar Marg,Kathmandu",5,"http://www.annapurna-hotel.com/accommodations.php",27.711088, 85.316368));
        listViewItems.add(new ItemObjects(SolventRecyclerViewAdapter.HOTEL,"Gokarna Forest Resort", R.drawable.gokarna_forest_resort_icon,"Thali, Kathmandu",4,"http://www.booking.com/hotel/np/gokarna-forest-resort.en-gb.html",27.727269, 85.396191));
        listViewItems.add(new ItemObjects(SolventRecyclerViewAdapter.HOTEL,"Hotel Shanker", R.drawable.shanker_icon,"Lazimpat,Kathmandu",3,"http://www.booking.com/hotel/np/shanker-kathmandu.en-gb.html",27.719049, 85.320090));
        listViewItems.add(new ItemObjects(SolventRecyclerViewAdapter.ONLINE_BUTTON,"For Further information go online"));
        return listViewItems;
    }


//    public void JSON_DATA_WEB_CALL(){
//
//        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL,
//
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//
//                        progressBar.setVisibility(View.GONE);
//
//                        JSON_PARSE_DATA_AFTER_WEBCALL(response);
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                });
//
//        requestQueue = Volley.newRequestQueue(this);
//
//        requestQueue.add(jsonArrayRequest);
//    }
//
//    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array){
//
//        for(int i = 0; i<array.length(); i++) {
//
//            GetDataAdapter GetDataAdapter2 = new GetDataAdapter();
//
//            JSONObject json = null;
//            try {
//                json = array.getJSONObject(i);
//
//              //  GetDataAdapter2.setId(json.getInt(JSON_ID));
//                GetDataAdapter2.setPhoto(json.getString(JSON_HotelPhoto));
//                GetDataAdapter2.setName(json.getString(JSON_HotelName));
//
//                GetDataAdapter2.setAddress(json.getString(JSON_HotelAddress));
//
//                GetDataAdapter2.setRating(json.getInt(JSON_HotelRating));
//                //   GetDataAdapter2.setHotellink(json.getString(JSON_HotelLink));
//                GetDataAdapter2.setHotelbook(json.getString(JSON_HotelBook));
//
//            } catch (JSONException e) {
//
//                e.printStackTrace();
//            }
//            GetDataAdapter1.add(GetDataAdapter2);
//        }
//
//        recyclerViewadapter = new Hotel_AmusementRecyclerViewAdapter(GetDataAdapter1, this);
//
//        recyclerView.setAdapter(recyclerViewadapter);
//    }
}






