package com.majorproject.ckaa.travelwithme;

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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Buddy on 8/9/2016.
 */
public class HikingHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<GetDataAdapter> itemList;
    public static final int HEADER = 0;
    public static final int CHILD = 1;

    public HikingHeaderAdapter(Context context, List<GetDataAdapter> itemList) {

        super();
        this.context = context;
        this.itemList = itemList;
    }

    public Context context;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View view=null;
        switch (type) {
            case HEADER:
                LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.activity_hiking_header, parent, false);
                ListHeaderViewHolder header = new ListHeaderViewHolder(view);
                return header;
            case CHILD:
                LayoutInflater inflaterr = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflaterr.inflate(R.layout.activity_hiking_child, parent, false);
                ListChildViewHolder child = new ListChildViewHolder(view);
                return child;


        }
        return null;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final GetDataAdapter item = itemList.get(position);
        switch (item.getType()) {
            case HEADER:
                final ListHeaderViewHolder itemController = (ListHeaderViewHolder) holder;
                itemController.refferalItem = item;
               itemController.expand_image.setImageResource(item.getHiking_photo());
                itemController.header_title.setText(item.getHiking_header());
                if (item.invisibleChildren == null) {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.circle_minus);
                } else {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.circle_plus);
                }
                itemController.btn_expand_toggle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (item.invisibleChildren == null) {
                            item.invisibleChildren = new ArrayList<GetDataAdapter>();
                            int count = 0;
                            int pos = itemList.indexOf(itemController.refferalItem);
                            while (itemList.size() > pos + 1 && itemList.get(pos + 1).getType() == CHILD) {
                                item.invisibleChildren.add(itemList.remove(pos + 1));
                                count++;
                            }
                            notifyItemRangeRemoved(pos + 1, count);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.circle_plus);
                        } else {
                            int pos = itemList.indexOf(itemController.refferalItem);
                            int index = pos + 1;
                            for (GetDataAdapter i : item.invisibleChildren) {
                                itemList.add(index, i);
                                index++;
                            }
                            notifyItemRangeInserted(pos + 1, index - pos - 1);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.circle_minus);
                            item.invisibleChildren = null;
                        }
                    }
                });
                break;
            case CHILD:
                final ListChildViewHolder ChilditemController = (ListChildViewHolder) holder;
                ChilditemController.refferalItem = item;
                ChilditemController.hike_name.setText(item.getHike_name());
                ChilditemController.hike_startendData.setText(item.getHike_startend());
                ChilditemController.hike_durationData.setText(item.getHike_duration());
                ChilditemController.hike_altitudeData.setText(item.getHike_altitude());
                ChilditemController.hike_timeData.setText(item.getHike_time());
                ChilditemController.hike_priceData.setText(item.getHike_price());
                ChilditemController.hike_highlightsData.setText(item.getHike_highlights());
                Glide.with(context).load(Json_Url.ip+"hotel/"+item.getHike_photo()).into(ChilditemController.hike_photo);
                Double mlat = item.getHike_latitude();
                Double mlong = item.getHike_longitude();
                LatLng fromHike = new LatLng(mlat,mlong);
               //final  String title = item.getHiking_header();
               final Bundle args = new Bundle();
                args.putParcelable("longLat_dataPrivider",fromHike);
                ChilditemController.hike_map.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context,mapsecondActivity.class);
                        i.putExtras(args);
                       // i.putExtra("title",title);
                        context.startActivity(i);

                    }
                });

                //ImageView itemImageView = (ImageView)holder.itemView;
//                TextView itemTextView = (TextView) holder.itemView;
//                //itemImageView.setImageResource(ItemList.get(position).getPhoto());
//                itemTextView.setText(ItemList.get(position).getItem_name());

                break;
        }
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }
    public int getItemViewType(int position) {
        return itemList.get(position).getType();
    }
}
    class ListHeaderViewHolder extends RecyclerView.ViewHolder {
    public TextView header_title;
    public ImageView btn_expand_toggle;
    public ImageView expand_image;
    public GetDataAdapter refferalItem;

    public ListHeaderViewHolder(View itemView) {
        super(itemView);
        expand_image = (ImageView)itemView.findViewById(R.id.hiking_header_image);
        header_title = (TextView) itemView.findViewById(R.id.hiking_header_tilte);
        btn_expand_toggle = (ImageView) itemView.findViewById(R.id.btn_expand_toggle);
    }
}
    class ListChildViewHolder extends RecyclerView.ViewHolder {
//    private TextView child_title;
//    private ImageView child_image;
    public GetDataAdapter refferalItem;

        public TextView hike_name;
        public TextView hike_startendLabel;
        public TextView hike_startendData;
        public TextView hike_durationLabel;
        public TextView hike_durationData;
        public TextView hike_altitudeLabel;
        public TextView hike_altitudeData;
        public TextView hike_timeLabel;
        public TextView hike_timeData;
        public TextView hike_priceLabel;
        public TextView hike_priceData;
        public TextView hike_highlightsData;
        public TextView hike_highlightsLabel;
        public ImageView hike_photo;
        public Button hike_map;
//        hike_latitude;
//        hike_longitude;

    public ListChildViewHolder(View itemView) {
        super(itemView);
        hike_name= (TextView) itemView.findViewById(R.id.hikeName);
        hike_startendData = (TextView)itemView.findViewById(R.id.hikeStartEndData);
        hike_startendLabel = (TextView)itemView.findViewById(R.id.hikeStartEndLabel);
        hike_durationLabel=(TextView)itemView.findViewById(R.id.hikeDurationLabel);
        hike_durationData=(TextView)itemView.findViewById(R.id.hikeDurationData);
        hike_altitudeLabel=(TextView)itemView.findViewById(R.id.hikeAltitudeLabel);
        hike_altitudeData=(TextView)itemView.findViewById(R.id.hikeAltitudeData);
        hike_timeLabel=(TextView)itemView.findViewById(R.id.hikeTimeLabel);
        hike_timeData=(TextView)itemView.findViewById(R.id.hikeTimeData);
        hike_priceLabel=(TextView)itemView.findViewById(R.id.hikePriceLabel);
        hike_priceData=(TextView)itemView.findViewById(R.id.hikePriceData);
        hike_highlightsData=(TextView)itemView.findViewById(R.id.hikeHighlightsData);
        hike_highlightsLabel=(TextView)itemView.findViewById(R.id.hikeHighlightsLabel);
        hike_photo=(ImageView) itemView.findViewById(R.id.hikeImage);
        hike_map = (Button)itemView.findViewById(R.id.hikeMap);

    }
}
