package com.majorproject.ckaa.travelwithme;

/**
 * Created by Buddy on 7/12/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by ckaa on 7/12/2016.
 */
public class Night_shoppingRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    public static final int Staticnight = 0;
    public static final int Dynamicnight = 1;
    public static final int Staticshop = 2;
    public static final int Dynamicshop = 3;


    List<GetDataAdapter> getDataAdapter;

    public Night_shoppingRecyclerViewAdapter(List<GetDataAdapter> getDataAdapter, Context context){

        super();

        this.getDataAdapter = getDataAdapter;
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);
//
//        ViewHolder viewHolder = new ViewHolder(v);
        if (viewType == Staticnight) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nightlife_recyclerview_items, parent, false);
            NightLifeViewHolder snight = new NightLifeViewHolder(view);
            return snight;

        } else if (viewType == Dynamicnight) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nightlife_recyclerview_items, parent, false);
            NightLifeViewHolder dnight = new NightLifeViewHolder(view);
            return dnight;
        } else if (viewType == Staticshop)

        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shoppingrecyclerview, parent, false);
            ShoppingViewHolder shop = new ShoppingViewHolder(view);
            return shop;
        }
        else
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shoppingrecyclerview, parent, false);
            ShoppingViewHolder dshop = new ShoppingViewHolder(view);
            return dshop;
        }
    }

       //return viewHolder;


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final GetDataAdapter getDataAdapter1 =  getDataAdapter.get(position);
        if(holder.getItemViewType()==Staticnight)
        {
            final NightLifeViewHolder nightLifeViewHolder = (NightLifeViewHolder) holder;
            nightLifeViewHolder.NightImage.setImageResource(getDataAdapter1.getStatic_night_photo());
            nightLifeViewHolder.NightName.setText(getDataAdapter1.getNight_name());
            nightLifeViewHolder.NightAddress.setText(getDataAdapter1.getNight_address());

            nightLifeViewHolder.NightPhone.setText(getDataAdapter1.getNight_phone());
            Double nlat = getDataAdapter1.getNight_latitude();
            Double nlong = getDataAdapter1.getNight_longitude();
            LatLng fromNight = new LatLng(nlat,nlong);
            final Bundle args = new Bundle();
            args.putParcelable("longLat_dataPrivider",fromNight);

            final String title = getDataAdapter1.getNight_name();
            nightLifeViewHolder.NightMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,mapsecondActivity.class);
                    intent.putExtras(args);
                    intent.putExtra("title", title);
                    context.startActivity(intent);

                }
            });
        }
        else if(holder.getItemViewType()==Dynamicnight){
            final NightLifeViewHolder dynamicnightLifeViewHolder = (NightLifeViewHolder) holder;
            Glide.with(context).load(Json_Url.ip +"hotel/" + getDataAdapter1.getNight_photo()).centerCrop().into(dynamicnightLifeViewHolder.NightImage);
            dynamicnightLifeViewHolder.NightName.setText(getDataAdapter1.getNight_name());
            dynamicnightLifeViewHolder.NightAddress.setText(getDataAdapter1.getNight_address());

            dynamicnightLifeViewHolder.NightPhone.setText(getDataAdapter1.getNight_phone());
            Double nlat = getDataAdapter1.getNight_latitude();
            Double nlong = getDataAdapter1.getNight_longitude();
            LatLng fromNight = new LatLng(nlat,nlong);
            final Bundle args = new Bundle();
            args.putParcelable("longLat_dataPrivider",fromNight);

            final String title = getDataAdapter1.getNight_name();
            dynamicnightLifeViewHolder.NightMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,mapsecondActivity.class);
                    intent.putExtras(args);
                    intent.putExtra("title", title);
                    context.startActivity(intent);

                }
            });
        }
        else if(holder.getItemViewType()==Staticshop)
        {
            final ShoppingViewHolder shoppingholder = (ShoppingViewHolder)holder;
            shoppingholder.ShopImage.setImageResource(getDataAdapter1.getStatic_shop_photo());
            shoppingholder.ShopName.setText(getDataAdapter1.getShop_name());
            shoppingholder.ShopAddress.setText(getDataAdapter1.getShop_address());
            Double nlat = getDataAdapter1.getShop_latitude();
            Double nlong = getDataAdapter1.getShop_longitude();
            LatLng fromShop = new LatLng(nlat,nlong);
            final Bundle args = new Bundle();
            args.putParcelable("longLat_dataPrivider",fromShop);

            final String title = getDataAdapter1.getShop_name();
            shoppingholder.ShopMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,mapsecondActivity.class);
                    intent.putExtras(args);
                    intent.putExtra("title", title);
                    context.startActivity(intent);

                }
            });
        }
        else
        {
            final ShoppingViewHolder dynamicShoppinhholder = (ShoppingViewHolder)holder;
            Glide.with(context).load(Json_Url.ip+"hotel/" + getDataAdapter1.getShop_photo()).centerCrop().into(dynamicShoppinhholder.ShopImage);
            dynamicShoppinhholder.ShopName.setText(getDataAdapter1.getShop_name());
            dynamicShoppinhholder.ShopAddress.setText(getDataAdapter1.getShop_address());
            Double nlat = getDataAdapter1.getShop_latitude();
            Double nlong = getDataAdapter1.getShop_longitude();
            LatLng fromShop = new LatLng(nlat,nlong);
            final Bundle args = new Bundle();
            args.putParcelable("longLat_dataPrivider",fromShop);

            final String title = getDataAdapter1.getShop_name();
            dynamicShoppinhholder.ShopMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,mapsecondActivity.class);
                    intent.putExtras(args);
                    intent.putExtra("title", title);
                    context.startActivity(intent);

                }
            });


        }


    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }

    public int getItemViewType(int position) {
        return getDataAdapter.get(position).getType();
    }
    class NightLifeViewHolder extends RecyclerView.ViewHolder {

        public ImageView NightImage;
        public TextView NightName;
        public TextView NightAddress;
        public TextView NightPhone;
        public Button NightMap;


        public NightLifeViewHolder(View itemView) {

            super(itemView);
            //itemView.setOnClickListener(this);

            //IdTextView = (TextView) itemView.findViewById(R.id.textView2) ;
            NightImage = (ImageView) itemView.findViewById(R.id.nightImage);
            NightName = (TextView) itemView.findViewById(R.id.nightName);
            NightAddress = (TextView) itemView.findViewById(R.id.nightAddress);
            NightPhone = (TextView) itemView.findViewById(R.id.nightPhone);
            NightMap = (Button) itemView.findViewById(R.id.nightMap);

        }
    }

        class ShoppingViewHolder extends RecyclerView.ViewHolder{

            public ImageView ShopImage;
            public TextView ShopName;
            public TextView ShopAddress;

            public Button ShopMap;


            public ShoppingViewHolder(View itemView) {

                super(itemView);
                //itemView.setOnClickListener(this);

                //IdTextView = (TextView) itemView.findViewById(R.id.textView2) ;
                ShopImage = (ImageView) itemView.findViewById(R.id.shopImage);
                ShopName = (TextView) itemView.findViewById(R.id.shopName) ;
                ShopAddress = (TextView) itemView.findViewById(R.id.shopAddress) ;
                ShopMap=(Button)itemView.findViewById(R.id.shopMap);

            }
        }}


       /* @Override
        public void onClick(View v) {
            GetDataAdapter getDataAdapter1 =  getDataAdapter.get(getLayoutPosition());
            Uri url = Uri.parse(getDataAdapter1.getHotellink());
            Intent i = new Intent(Intent.ACTION_VIEW, url);
            context.startActivity(i);

        }*/



