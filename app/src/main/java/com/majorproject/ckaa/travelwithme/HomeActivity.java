package com.majorproject.ckaa.travelwithme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

        RecyclerView recyclerview;
        ProgressBar progressBar;
        RecyclerView.Adapter recyclerViewadapter;
        List<GetDataAdapter> GetDataAdapter1;
        public static final  int  guide = 0 ;
        public static final int  phrase = 1;

        public static final int  mDataSetType[] ={guide,phrase};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        //recyclerView.setHasFixedSize(true);

       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//
  //     StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,1);//if image size is different then it displays with differnt size,does not make size constant
      //  GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);//makes size constant n display


        recyclerView.setLayoutManager(linearLayoutManager);
        List<GetDataAdapter> staggeredListContent = getListItemData();
        homeAdapter homeAdapter = new homeAdapter(HomeActivity.this, staggeredListContent);
        recyclerView.setAdapter(homeAdapter);

    }

    public List<GetDataAdapter>getListItemData()
    {
        List<GetDataAdapter> listViewItems = new ArrayList<>();


        listViewItems.add(new GetDataAdapter(homeAdapter.guide ,"Mini Guide","What's popular?"));
        listViewItems.add(new GetDataAdapter(homeAdapter.guide ,"Event Updates","Check out latest events"));
        listViewItems.add(new GetDataAdapter(homeAdapter.phrase ,"Phrase Book","Namste","नमस्ते"));


//        listViewItems.add(new GetDataAdapter("Club 2000","Durbarmarg, Kathmandu","014222686", R.drawable.dynasty,27.712306,85.317554,staticshop));
//        listViewItems.add(new GetDataAdapter("Star Disco","Jawalakhel, Lalitpur","014491397", R.drawable.star,27.676112,85.310844,staticshop));
        return listViewItems;
    }



    }

