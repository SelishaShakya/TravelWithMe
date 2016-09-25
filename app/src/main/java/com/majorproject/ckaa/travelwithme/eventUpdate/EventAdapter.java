package com.majorproject.ckaa.travelwithme.eventUpdate;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.majorproject.ckaa.travelwithme.Json_Url;
import com.majorproject.ckaa.travelwithme.R;

import java.util.List;

/**
 * Created by Buddy on 8/28/2016.
 */
public class EventAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<GetNewDataAdapter> getDataAdapter;

    public EventAdapter(List<GetNewDataAdapter> getDataAdapter, Context context) {
        this.getDataAdapter = getDataAdapter;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_recyclerview, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final GetNewDataAdapter getDataAdapter1 =  getDataAdapter.get(position);
        final EventViewHolder popularViewHolder = (EventViewHolder) holder;
        Glide.with(context).load(Json_Url.ip +"hotel/"+getDataAdapter1.getEvent_photo()).centerCrop().into(popularViewHolder.EventImage);
        //popularViewHolder.popularImage.setImageResource();
        popularViewHolder.EventName.setText(getDataAdapter1.getEvent_name());
        popularViewHolder.EventDate.setText(getDataAdapter1.getEvent_date());

    }

    @Override
    public int getItemCount() {
        return getDataAdapter.size();
    }

    class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView EventImage;
        public TextView EventName;
        public TextView EventDate;

        public EventViewHolder(View itemView) {

            super(itemView);
            itemView.setOnClickListener(this);

            //IdTextView = (TextView) itemView.findViewById(R.id.textView2) ;
            EventImage = (ImageView) itemView.findViewById(R.id.event_recycler_image);
            EventName = (TextView) itemView.findViewById(R.id.event_title_name) ;
            EventDate=(TextView)itemView.findViewById(R.id.event_title_date);

        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
            GetNewDataAdapter getDataAdapter1 = getDataAdapter.get(getLayoutPosition());
            Intent i = new Intent(context,EventContentActivity.class);
            i.putExtra("currentposition", getAdapterPosition());
            context.startActivity(i);

        }
    }
}
