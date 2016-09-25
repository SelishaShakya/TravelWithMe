package com.majorproject.ckaa.travelwithme;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    RecyclerView recyclerview;
    ProgressBar progressBar;
    RecyclerView.Adapter recyclerViewadapter;
    List<GetDataAdapter> GetDataAdapter1;
    public static final  int  guide = 0 ;
    public Context context;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView1);
        //recyclerView.setHasFixedSize(true);
        this.context =  container.getContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//
        // Inflate the layout for this fragment

        recyclerView.setLayoutManager(linearLayoutManager);
        List<GetDataAdapter> staggeredListContent = getListItemData();
        homeAdapter homeAdapter = new homeAdapter(context, staggeredListContent);
        recyclerView.setAdapter(homeAdapter);
        return v;

    }

    public List<GetDataAdapter>getListItemData()
    {
        List<GetDataAdapter> listViewItems = new ArrayList<>();

        listViewItems.add(new GetDataAdapter(homeAdapter.guide ,"Mini Guide","What's popular?",R.drawable.guide));
        listViewItems.add(new GetDataAdapter(homeAdapter.guide ,"Adventures","Adventure Awaits",R.drawable.adventure));

        listViewItems.add(new GetDataAdapter(homeAdapter.phrase ,"Phrase Book","Namaste","नमस्ते",R.drawable.phrasebookk));
        listViewItems.add(new GetDataAdapter(homeAdapter.guide ,"Event Updates","Check out latest events",R.drawable.eventupdate));
        listViewItems.add(new GetDataAdapter(homeAdapter.guide ,"Currency Converter","convert into Nrs.",R.drawable.currencyconverter));



//        listViewItems.add(new GetDataAdapter("Club 2000","Durbarmarg, Kathmandu","014222686", R.drawable.dynasty,27.712306,85.317554,staticshop));
//        listViewItems.add(new GetDataAdapter("Star Disco","Jawalakhel, Lalitpur","014491397", R.drawable.star,27.676112,85.310844,staticshop));
        return listViewItems;
    }





}
