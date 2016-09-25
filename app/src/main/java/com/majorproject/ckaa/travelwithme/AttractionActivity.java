package com.majorproject.ckaa.travelwithme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class AttractionActivity extends AppCompatActivity {
    private int AttrctnType = 1;
    private int mDataSetType[] = {AttrctnType,AttrctnType,AttrctnType,AttrctnType,AttrctnType,AttrctnType,AttrctnType,AttrctnType,AttrctnType,AttrctnType};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);
        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.AttractionRecycler);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        List<ItemObjects> gridLayoutContent = getListItemData();
        AttractionRecyclerViewAdapter rcAdapter = new AttractionRecyclerViewAdapter(AttractionActivity.this, gridLayoutContent,mDataSetType);
        recyclerView.setAdapter(rcAdapter);


    }

    private List<ItemObjects> getListItemData() {
        List<ItemObjects> ListItem = new ArrayList<>();
        ListItem.add(new ItemObjects("Sightseeing",R.drawable.binoculors_icon ));
        ListItem.add(new ItemObjects("Hiking",R.drawable.hiking_icon ));

        ListItem.add(new ItemObjects("NightLife",R.drawable.wine));
        ListItem.add(new ItemObjects("Amusements",R.drawable.amuse_icon ));
        ListItem.add(new ItemObjects("Tour",R.drawable.map_icon ));
        ListItem.add(new ItemObjects("Shopping",R.drawable.shopping_icon ));
        ListItem.add(new ItemObjects("Activities",R.drawable.speaker_icon ));
        ListItem.add(new ItemObjects("New Suggestion",R.drawable.suggestion));

        return ListItem;

    }
}