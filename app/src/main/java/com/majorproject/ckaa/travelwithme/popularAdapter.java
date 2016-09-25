package com.majorproject.ckaa.travelwithme;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by ckaa on 8/23/2016.
 */
public class popularAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    public static final int sight = 0;
    public static final int restaurant = 1;
    List<GetDataAdapter> getDataAdapter;
    public popularAdapter(List<GetDataAdapter> getDataAdapter, Context context){

        super();

        this.getDataAdapter = getDataAdapter;
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == sight) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_cardlayout, parent, false);
            popularViewHolder sightt = new popularViewHolder(view);
            return sightt;
        } else if (viewType == restaurant) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_cardlayout, parent, false);
            popularViewHolder res = new popularViewHolder(view);
            return res;

        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_cardlayout, parent, false);
            popularViewHolder pop = new popularViewHolder(view);
            return pop;
        }
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final GetDataAdapter getDataAdapter1 =  getDataAdapter.get(position);
        final popularViewHolder popularViewHolder = (popularViewHolder) holder;
        if(holder.getItemViewType()==sight)
        {
            Glide.with(context).load(Json_Url.ip+"hotel/"+getDataAdapter1.getHeritage_photo()).centerCrop().into(popularViewHolder.popularImage);
            //popularViewHolder.popularImage.setImageResource();
            popularViewHolder.popularName.setText(getDataAdapter1.getHeritage_title());
            popularViewHolder.popularAddress.setText(getDataAdapter1.getHeritage_address());


        }
        else if(holder.getItemViewType()==restaurant){
            Glide.with(context).load(Json_Url.ip+"hotel/" + getDataAdapter1.getRestaurant_photo()).centerCrop().into(popularViewHolder.popularImage);
            //popularViewHolder.popularImage.setImageResource(getDataAdapter1.getRestaurant_photo());
            popularViewHolder.popularName.setText(getDataAdapter1.getRestaurant_title());
            popularViewHolder.popularAddress.setText(getDataAdapter1.getRestaurant_address());


        }else{
            Glide.with(context).load(Json_Url.ip +"hotel/" + getDataAdapter1.getPop_photo()).centerCrop().into(popularViewHolder.popularImage);
            popularViewHolder.popularName.setText(getDataAdapter1.getPop_name());
            popularViewHolder.popularAddress.setText(getDataAdapter1.getPop_des());

        }


    }


    @Override
    public int getItemCount() {
        return getDataAdapter.size();
    }
    public int getItemViewType(int position) {
        return getDataAdapter.get(position).getType();
    }
    class popularViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView popularImage;
        public TextView popularName;
        public TextView popularAddress;




        public popularViewHolder(View itemView) {

        super(itemView);
        itemView.setOnClickListener(this);

        //IdTextView = (TextView) itemView.findViewById(R.id.textView2) ;
        popularImage = (ImageView) itemView.findViewById(R.id.popular_image);
        popularName = (TextView) itemView.findViewById(R.id.popular_name) ;
        popularAddress = (TextView) itemView.findViewById(R.id.popular_address) ;


        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
            GetDataAdapter getDataAdapter1 = getDataAdapter.get(getLayoutPosition());
            Intent i = new Intent(context,PopularContentActivity.class);
                i.putExtra("currentposition", getAdapterPosition());
            context.startActivity(i);

        }
    }


}
