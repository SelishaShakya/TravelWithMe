package com.majorproject.ckaa.travelwithme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Activity extends AppCompatActivity {
    private  int city = 0;
    private int mDataSetType[] = {city,city,city,city,city};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setHomeButtonEnabled(true);
// If your minSdkVersion is 11 or higher use:
        //getActionBar().setDisplayHomeAsUpEnabled(true);
       // ActionBar ab = getActionBar();
        //ab.setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);


//        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,1);//if image size is different then it displays with differnt size,does not make size constant
        //GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);//makes size constant n display


        recyclerView.setLayoutManager(linearLayoutManager);
        List<ItemObjects> staggeredListContent = getListItemData();
        AttractionRecyclerViewAdapter rcAdapter = new AttractionRecyclerViewAdapter(Adapter_Activity.this, staggeredListContent,mDataSetType);
        recyclerView.setAdapter(rcAdapter);


//        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
//        recyclerView.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//
//        recyclerView.setLayoutManager(linearLayoutManager);
//        List<ItemObjects> staggeredListContent=getListItemData();
//        AttractionRecyclerViewAdapter rcAdapter=new AttractionRecyclerViewAdapter(MainActivity.this,staggeredListContent);
//        recyclerView.setAdapter(rcAdapter);
    }

    private List<ItemObjects> getListItemData() {
        List<ItemObjects> listViewItems = new ArrayList<>();
        listViewItems.add(new ItemObjects("Kathmandu Attraction", R.drawable.kathmandu_image));
        listViewItems.add(new ItemObjects("Pokhara Attraction", R.drawable.pokhara_icon));
        listViewItems.add(new ItemObjects("Lumbini Attraction", R.drawable.lumbini_icon));
        listViewItems.add(new ItemObjects("Chitwan Attraction", R.drawable.chitwan_icon));
        listViewItems.add(new ItemObjects("Mustang Attraction", R.drawable.mustang_icon));
        return listViewItems;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                Intent intent = new Intent(this,MainActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
//                this.finish();
//                // app icon in action bar clicked; go home
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

}


