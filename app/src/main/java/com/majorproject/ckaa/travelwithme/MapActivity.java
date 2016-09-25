package com.majorproject.ckaa.travelwithme;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity {
MapView mMapView;
    private GoogleMap googleMap;
    MarkerOptions marker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mMapView = (MapView) findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);


        mMapView.onResume();
        Intent i = getIntent();

        LatLng ll = i.getParcelableExtra("longLat_dataPrivider");
        Bundle extract = getIntent().getExtras();
        String Markertitle = extract.getString("title");
        // Intent i = getIntent();
        //Bundle arg = getIntent().getExtras();
        double[] latitude = i.getDoubleArrayExtra("latitude");
        double[] longitude = i.getDoubleArrayExtra("longitude");
        LatLng mainLatLng = i.getParcelableExtra("LatLng");
        // Bundle extract = getIntent().getExtras();

       // String title = extract.getString("title");
        String type = extract.getString("type");
        String[] childTitle = i.getStringArrayExtra("childTitle");


        // needed to get the map to display immediately
        try {
            MapsInitializer.initialize(getApplicationContext());

            googleMap = mMapView.getMap();
            // latitude and longitude


            // create marker
            MarkerOptions marker1 = new MarkerOptions().position(ll).title(Markertitle);
            marker1.icon(BitmapDescriptorFactory
                    .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

            // adding marker
            googleMap.addMarker(marker1);
//
            CameraPosition cameraPosition = new CameraPosition.Builder()
//                .target(new LatLng(27.700769, 85.300140)).zoom(12).build();
                    .target(ll).zoom(14).build();
            googleMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));
            if (latitude.length > 0 )
            // create marker
            {
                for (int j = 0; j < latitude.length; j++)
                //MarkerOptions marker = new MarkerOptions().position(ll).title(ti);
                {
//            for (int k = 0; k < longitude.length; k++) {
                    marker = new MarkerOptions().position(new LatLng(latitude[j], longitude[j])).title(childTitle[j]);
                    // marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.firstaid));
                    // marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
                    AddMarker(type);
                    // adding marker

//                marker.icon(BitmapDescriptorFactory
//                        .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


            if (googleMap != null) {
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                googleMap.setMyLocationEnabled(true);
                //  googleMap.setTrafficEnabled(true);
            }

            // Perform any camera updates here
            //return v;

    }

    public  void AddMarker (String type )
    {
        switch (type)
        {
            case "hospital": marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.firstaid));
                googleMap.addMarker(marker);
                break;
            case "medicalstore":marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.drugstore));
                googleMap.addMarker(marker);
            case "bank":marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.bank_map));
                googleMap.addMarker(marker);

        }

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



