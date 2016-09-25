package com.majorproject.ckaa.travelwithme;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by ckaa on 7/6/2016.
 */
public class AttractionViewHolder extends RecyclerView.ViewHolder{
//public class SolventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView cityName;
    public ImageView cityImage;
   //private Context context;
    public Button Butn;
    public LatLng fromPostion;
    public TextView Item_name;
    public ImageView Item_photo;
    public Context context;

    // ArrayList<ItemObjects> cities = new ArrayList<ItemObjects>();
   // private List<ItemObjects> itemList;
//    @Override
//    public void onClick(View v) {
//
//        //ItemObjects item = this.cities.get(position);
//        v.getContext();
//        int position = getAdapterPosition();
//       // position.v.getContext();
//        switch(position){
//
//            case 0:
//                Intent firstintent = new Intent(context,Welcome.class);
//                context.startActivity(firstintent);
//
//              //  getSupportActionBar().setTitle("Map");
//                break;
//            case 1:
//                Intent secondintent = new Intent(context,secondActivity.class);
//                context.startActivity(secondintent);
//                break;
//            case 2:
//                Intent thirdintent = new Intent(context,Welcome.class);
//                context.startActivity(thirdintent);
//                break;
//            case 3:
//                Intent fourthintent = new Intent(context,secondActivity.class);
//                context.startActivity(fourthintent);
//                break;
//        //context.startActivity(new Intent(context,Welcome.class));
//
//
//        }
////context.startActivity(new Intent(context,Welcome.class));
//        Intent intent = new Intent(SolventViewHolder.class, Welcome.class);
//        ActivityCompat.startActivity(intent);
       // Toast.makeText(v.getContext(), "+position"+getAdapterPosition(), Toast.LENGTH_SHORT).show();



    public AttractionViewHolder(View itemView) {

        super(itemView);
//       // AttractionRecyclerViewAdapter solvent = new AttractionRecyclerViewAdapter( context, itemList);
//        //this.cities = cities;
//        this.context = context;
//        itemView.setOnClickListener(this);
//        cityName=(TextView)itemView.findViewById(R.id.item_title);
//        cityImage=(ImageView)itemView.findViewById(R.id.item_image);
//        Butn = (Button)itemView.findViewById(R.id.mapButn);
    }
}

class AttractionCityHolder extends AttractionViewHolder implements View.OnClickListener {


    public AttractionCityHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        itemView.setOnClickListener(this);
        cityName = (TextView) itemView.findViewById(R.id.city_name);
        cityImage = (ImageView) itemView.findViewById(R.id.city_image);
      //  Butn = (Button) itemView.findViewById(R.id.cityMap);


    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        v.getContext();
        int position = getAdapterPosition();
        switch (position) {
            case 0:
                Intent intent = new Intent(context, AttractionActivity.class);
                context.startActivity(intent);

                break;


        }
    }
}
class AttractnItemHolder extends AttractionViewHolder implements View.OnClickListener {

    public AttractnItemHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        itemView.setOnClickListener(this);
        Item_name = (TextView) itemView.findViewById(R.id.ktm_attrctn_tilte);
        Item_photo = (ImageView) itemView.findViewById(R.id.ktm_attractn_icon);
    }

    @Override
    public void onClick(View v) {
        v.getContext();
        int position = getAdapterPosition();
        switch (position) {
            case 0:
                Intent in = new Intent(context, Inside_sightseeingActivity.class);
                context.startActivity(in);

                break;
            case 1:
                Intent i = new Intent(context, HikingActivity.class);
                context.startActivity(i);

                break;
            case 2:
                Intent nightI = new Intent(context, NightLifeActivity.class);
                context.startActivity(nightI);

                break;
            case 3:
                Intent amuseI = new Intent(context, AmusementActivity.class);
                context.startActivity(amuseI);

                break;
            case 5:
                Intent shopI = new Intent(context, ShoppingActivity.class);
                context.startActivity(shopI);

                break;


        }


    }


}
