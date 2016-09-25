package com.majorproject.ckaa.travelwithme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class City_Activity extends AppCompatActivity {
    private int CITY = 2;
    //private int mDatasetTypes[] = {CITY,CITY,CITY,CITY,CITY};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

//        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,1);//if image size is different then it displays with differnt size,does not make size constant
        //GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);//makes size constant n display


        recyclerView.setLayoutManager(linearLayoutManager);
        List<ItemObjects> staggeredListContent=getListItemData();
        SolventRecyclerViewAdapter rcAdapter=new SolventRecyclerViewAdapter(City_Activity.this,staggeredListContent);
        recyclerView.setAdapter(rcAdapter);
      //  Button loadBtn = (Button)findViewById(R.id.loadBtn);

//        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
//        recyclerView.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//
//        recyclerView.setLayoutManager(linearLayoutManager);
//        List<ItemObjects> staggeredListContent=getListItemData();
//        SolventRecyclerViewAdapter rcAdapter=new SolventRecyclerViewAdapter(HotelStaticActivity.this,staggeredListContent);
//        recyclerView.setAdapter(rcAdapter);
    }

    private List<ItemObjects> getListItemData() {
        List<ItemObjects> listViewItems = new ArrayList<>();
        listViewItems.add(new ItemObjects(SolventRecyclerViewAdapter.CITY,"Kathmandu Hotels",R.drawable.kathmandu_image));
        listViewItems.add(new ItemObjects(SolventRecyclerViewAdapter.CITY,"Pokhara Hotels", R.drawable.pokhara_icon));
        listViewItems.add(new ItemObjects(SolventRecyclerViewAdapter.CITY,"Lumbini Hotels", R.drawable.lumbini_icon));
        listViewItems.add(new ItemObjects(SolventRecyclerViewAdapter.CITY,"Chitwan Hotels", R.drawable.chitwan_icon));
        listViewItems.add(new ItemObjects(SolventRecyclerViewAdapter.CITY,"Mustang Hotels", R.drawable.mustang_icon));

        return listViewItems;
    }

    }

