package com.majorproject.ckaa.travelwithme;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class Map extends Fragment {


    public Map() {
        // Required empty public constructor
    }
    MapView mMapView;
    private GoogleMap googleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflate and return the layout
        View v = inflater.inflate(R.layout.fragment_map, container,
                false);
        mMapView = (MapView) v.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();// needed to get the map to display immediately

        try {            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        googleMap = mMapView.getMap();
        // latitude and longitude
        double latitudektm = 27.700769;
        double longitudektm = 85.300140;
//        double latboudha = 27.7211;
//        double longboudha=85.3641666667;
//        double latpashu=27.7102716;
//        double longpashu=85.3486741;
//        double latsymbu=27.7192103;
//        double longsymbu=85.2955242;
//        double latktmdrs=27.704177;
       // double longktmdrs=85.3055589;

        // create marker
        MarkerOptions marker = new MarkerOptions().position(
                new LatLng(latitudektm, longitudektm)).title("Kathmandu");
//        MarkerOptions marker2 = new MarkerOptions().position(
//                new LatLng(latboudha, longboudha)).title("Boudhanath");
//        MarkerOptions marker3 = new MarkerOptions().position(
//                new LatLng(latpashu, longpashu)).title("Pashupatinath Temple");
//        MarkerOptions marker4 = new MarkerOptions().position(
//                new LatLng(latsymbu, longsymbu)).title("Swyambhu");
//        MarkerOptions marker5 = new MarkerOptions().position(
//                new LatLng(latktmdrs, longktmdrs)).title("Kathmandu Durbar Square");





        // Changing marker icon
        marker.icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

        // adding marker
        googleMap.addMarker(marker);
//        googleMap.addMarker(marker2);
//        googleMap.addMarker(marker3);
//        googleMap.addMarker(marker4);
//        googleMap.addMarker(marker5);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(27.700769, 85.300140)).zoom(12).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));

        // Perform any camera updates here
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}






