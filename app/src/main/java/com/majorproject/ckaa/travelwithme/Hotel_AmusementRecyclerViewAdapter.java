package com.majorproject.ckaa.travelwithme;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by ckaa on 7/12/2016.
 */
public class Hotel_AmusementRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    public static final int Hotel = 0;
    public static final int StaticAmuse = 1;
    public static final int DynamicAmuse = 2;
    List<GetDataAdapter> getDataAdapter;

    public Hotel_AmusementRecyclerViewAdapter(List<GetDataAdapter> getDataAdapter, Context context) {

        super();

        this.getDataAdapter = getDataAdapter;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        if (viewType == Hotel) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_recyclerview, parent, false);
            HotelViewHolder hotel = new HotelViewHolder(view);
            return hotel;

        }
        if (viewType == StaticAmuse) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.amusementrecyclerview, parent, false);
            AmusementViewHolder staticamuse = new AmusementViewHolder(view);
            return staticamuse;
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.amusementrecyclerview, parent, false);
            AmusementViewHolder dynamicamuse = new AmusementViewHolder(view);
            return dynamicamuse;
        }


    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == Hotel) {
            final HotelViewHolder Hotelholder = (HotelViewHolder) holder;
            final GetDataAdapter getDataAdapter1 = getDataAdapter.get(position);
            Glide.with(context).load(Json_Url.ip + "hotel/" + getDataAdapter1.getPhoto()).centerCrop().into(Hotelholder.HotelImageView);
            Hotelholder.NameTextView.setText(getDataAdapter1.getName());

            // holder.IdTextView.setText(String.valueOf(getDataAdapter1.getId()));

            Hotelholder.AddressTextView.setText(getDataAdapter1.getAddress());

            Hotelholder.HotelRatingBar.setNumStars(getDataAdapter1.getRating());
            Hotelholder.HotelBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //itemList.get(position).getHotel_bookBtn();
                    Uri url = Uri.parse(getDataAdapter1.getHotelbook());
                    Intent i = new Intent(Intent.ACTION_VIEW, url);
                    context.startActivity(i);
                }
            });
            Double fromLat = getDataAdapter1.getHotel_lat();
            Double fromLong = getDataAdapter1.getHotel_long();
            LatLng fromPostion = new LatLng(fromLat, fromLong);
            final String title = getDataAdapter1.getName();

            final Bundle args = new Bundle();
            args.putParcelable("longLat_dataPrivider", fromPostion);


            Hotelholder.SeeMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent inten = new Intent(context, mapsecondActivity.class);
                    inten.putExtras(args);
                    inten.putExtra("title", title);
                    context.startActivity(inten);
                }
            });

        } else if (holder.getItemViewType() == StaticAmuse) {
            final AmusementViewHolder Amuseholder = (AmusementViewHolder) holder;
            final GetDataAdapter getDataAdapter1 = getDataAdapter.get(position);
            Amuseholder.AmusementImage.setImageResource(getDataAdapter1.getStatic_amusement_photo());
            Amuseholder.AmusementName.setText(getDataAdapter1.getAmusement_name());
            Amuseholder.AmusementAddress.setText(getDataAdapter1.getAmusement_address());
            Amuseholder.AmusementPhone.setText("Phone: "+getDataAdapter1.getAmusement_phone());
            Amuseholder.AmusementOpeningTime.setText(getDataAdapter1.getAmusement_openingtime());
            Amuseholder.AmusementFee.setText(getDataAdapter1.getAmusement_fee());
            final String title = getDataAdapter1.getAmusement_name();
            Double Alat = getDataAdapter1.getAmusement_latitude();
            Double Along = getDataAdapter1.getAmusement_longitude();
            LatLng fromAmuse = new LatLng(Alat,Along);
            final Bundle args = new Bundle();
            args.putParcelable("longLat_dataPrivider",fromAmuse);




            Amuseholder.AmusementMap.setOnClickListener(new View.OnClickListener() {
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
            final AmusementViewHolder Amuseholder = (AmusementViewHolder)holder;
            final GetDataAdapter getDataAdapter1 = getDataAdapter.get(position);
            Glide.with(context).load(Json_Url.ip+"hotel/" + getDataAdapter1.getAmusement_photo()).centerCrop().into(Amuseholder.AmusementImage);
            Amuseholder.AmusementName.setText(getDataAdapter1.getAmusement_name());
            Amuseholder.AmusementAddress.setText(getDataAdapter1.getAmusement_address());
            Amuseholder.AmusementPhone.setText("Phone: "+getDataAdapter1.getAmusement_phone());
            Amuseholder.AmusementOpeningTime.setText(getDataAdapter1.getAmusement_openingtime());
            Amuseholder.AmusementFee.setText(getDataAdapter1.getAmusement_fee());
            final String title = getDataAdapter1.getAmusement_name();
            Double Alat = getDataAdapter1.getAmusement_latitude();
            Double Along = getDataAdapter1.getAmusement_longitude();
            LatLng fromAmuse = new LatLng(Alat,Along);
            final Bundle args = new Bundle();
            args.putParcelable("longLat_dataPrivider",fromAmuse);
            Amuseholder.AmusementMap.setOnClickListener(new View.OnClickListener() {
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
        public int getItemCount () {

            return getDataAdapter.size();
        }
    @Override
    public int getItemViewType(int position) {
        return getDataAdapter.get(position).getType();
    }


    class HotelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public ImageView HotelImageView;
            public TextView NameTextView;
            public TextView AddressTextView;
            public RatingBar HotelRatingBar;
            public Button HotelBook;
            public CardView HotelLink;
            public Button SeeMap;


            public HotelViewHolder(View itemView) {

                super(itemView);
                itemView.setOnClickListener(this);
                //IdTextView = (TextView) itemView.findViewById(R.id.textView2) ;
                HotelImageView = (ImageView) itemView.findViewById(R.id.hotelImage);
                NameTextView = (TextView) itemView.findViewById(R.id.hotelName);
                AddressTextView = (TextView) itemView.findViewById(R.id.hotelAddress);
                HotelRatingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);
                HotelBook = (Button) itemView.findViewById(R.id.hotel_book);
                SeeMap = (Button) itemView.findViewById(R.id.Map);


            }

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                GetDataAdapter getDataAdapter1 = getDataAdapter.get(getLayoutPosition());
                Uri url = Uri.parse(Json_Url.ip + getDataAdapter1.getHotellink());
                Intent i = new Intent(Intent.ACTION_VIEW, url);
                context.startActivity(i);

            }
        }

        class AmusementViewHolder extends RecyclerView.ViewHolder {

            public ImageView AmusementImage;
            public TextView AmusementName;
            public TextView AmusementAddress;
            public TextView AmusementPhone;
            public TextView AmusementOpeningTime;
            public TextView AmusementFee;
            public TextView EntranceFee;
            public TextView OpeningTime;

            public Button AmusementMap;


            public AmusementViewHolder(View itemView) {

                super(itemView);
                //itemView.setOnClickListener(this);

                //IdTextView = (TextView) itemView.findViewById(R.id.textView2) ;
                AmusementImage = (ImageView) itemView.findViewById(R.id.amuseImage);
                AmusementName = (TextView) itemView.findViewById(R.id.amuseName);
                AmusementAddress = (TextView) itemView.findViewById(R.id.amuseAddress);
                AmusementPhone = (TextView) itemView.findViewById(R.id.amusePhone);
                AmusementOpeningTime = (TextView) itemView.findViewById(R.id.amuseOpening);
                AmusementFee = (TextView) itemView.findViewById(R.id.amuseFee);
                AmusementMap = (Button) itemView.findViewById(R.id.amusementMap);
                EntranceFee = (TextView) itemView.findViewById(R.id.amuseEntranceFee);
                OpeningTime = (TextView) itemView.findViewById(R.id.amuseOpeningTime);


            }
        }

    }

