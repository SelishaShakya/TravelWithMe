package com.majorproject.ckaa.travelwithme.travelTip;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.majorproject.ckaa.travelwithme.R;

/**
 * Created by ckaa on 5/2/2016.
 */
public class Fragment_TravelTip extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 6 ;

    Toolbar toolbar = null;

    public Fragment_TravelTip()
    {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View x =  inflater.inflate(R.layout.fragment_traveltip,null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        // Inflate the layout for this fragment
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return x;
    }
    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new Fragment_entry();
                case 1 : return new Fragment_Connection();
                case 2 : return new Fragment_Accomodation();
                case 3 : return new Fragment_permits();
                case 4 : return new Fragment_HealthGuide();
                case 5 : return new Fragment_CulturalEttiquete();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "ENTRY REQUIREMENT";
                case 1 :
                    return "Air/Road Connections To Nepal";
                case 2 :
                    return "Accomodation";
                case 3 :
                    return "PERMITS AND FEES";
                case 4 :
                    return "HEALTH GUIDE";
                case 5 :
                    return "CULTURAL ETIQUETTE";

            }
            return null;
        }
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
