package com.majorproject.ckaa.travelwithme;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by Buddy on 6/19/2016.
 */
public class SolventRecyclerViewAdapter extends RecyclerView.Adapter<SolventViewHolder> {
    private int[] mDataSetTypes;
    //
    HotelStaticActivity main = new HotelStaticActivity();
   
    public static final int HOTEL= 0;
    public static final int ONLINE_BUTTON = 1;
    public static final int CITY = 2;
    private List<ItemObjects> itemList;

    public SolventRecyclerViewAdapter(Context context, List<ItemObjects> itemList) {
        this.context = context;
        this.itemList = itemList;
       // mDataSetTypes = DataSetType;
    }

    private Context context;

    @Override
    public SolventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (viewType == HOTEL) {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.hotel_recyclerview, parent, false);

            return new MainHolder(v, context);
        } else if(viewType ==ONLINE_BUTTON){
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.online_buttonlayout, parent, false);
            return new ButtonHolder(v, context);
}
            else {
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.city_layout, parent, false);
                return new CityHolder(v, context);

            }
//        View layoutView= LayoutInflater.from(parent.getContext()).inflate(R.online_buttonlayout.hotel_recyclerview,parent,false);
//        SolventViewHolder rcv=new SolventViewHolder(layoutView, context);
//        return rcv;


        }


    @Override
    public void onBindViewHolder(SolventViewHolder holder, final int position) {


        if (holder.getItemViewType() == HOTEL) {
            MainHolder holderMain = (MainHolder) holder;
            holderMain.hotelName.setText(itemList.get(position).getName());
            holderMain.hotelImage.setImageResource(itemList.get(position).getHotelphoto());
            holderMain.hotelAddress.setText(itemList.get(position).getAddress());
            holderMain.ratingBar.setNumStars(itemList.get(position).getRating());
            holderMain.hotel_book.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //itemList.get(position).getHotel_bookBtn();
                    Uri url = Uri.parse(itemList.get(position).getHotel_bookBtn());
                    Intent i = new Intent(Intent.ACTION_VIEW, url);
                    context.startActivity(i);
                }
            });
            Double fromLat = itemList.get(position).getMlat();
            Double fromLong = itemList.get(position).getMlong();
            LatLng fromPostion = new LatLng(fromLat,fromLong );
           final String title = itemList.get(position).getName();
            final Bundle args = new Bundle();
            args.putParcelable("longLat_dataPrivider", fromPostion);
            holderMain.MapButn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent inten = new Intent(context, mapsecondActivity.class);
                    inten.putExtras(args);
                    inten.putExtra("title",title);
                    //  getSupportActionBar().setTitle("Map");

                    context.startActivity(inten);
                }
            });
        }
        //holder.temp.setText(mDataSet[position]);

        else if(holder.getItemViewType() == ONLINE_BUTTON) {
            final ButtonHolder holderButton = (ButtonHolder) holder;

            holderButton.load.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.getContext();
//                    holderButton.progressBar.setVisibility(View.VISIBLE);
//                    main.JSON_DATA_WEB_CALL();
                    Intent intent = new Intent(context, HotelOnlineActivity.class);
                    context.startActivity(intent);
                }
            });
        }
        else
        {
            CityHolder holderCity = (CityHolder) holder;
            holderCity.CityName.setText(itemList.get(position).getCity_name());
            holderCity.CityImage.setImageResource(itemList.get(position).getCityphoto());




        }
//        holder.hotelName.setText(itemList.get(position).getName());
//        holder.hotelImage.setImageResource(itemList.get(position).getPhoto());
//        holder.hotelAddress.setText(itemList.get(position).getAddress());
//        holder.ratingBar.setNumStars(itemList.get(position).getRating());
//        holder.hotel_book.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //itemList.get(position).getHotel_bookBtn();
//                Uri url = Uri.parse( itemList.get(position).getHotel_bookBtn());
//                Intent i = new Intent(Intent.ACTION_VIEW,url);
//                context.startActivity(i);
//            }
//        });
//    }



    }
    @Override
    public int getItemCount() {
        return itemList.size();
    }
    @Override
    public int getItemViewType(int position) {
        return itemList.get(position).getType();
    }
}

