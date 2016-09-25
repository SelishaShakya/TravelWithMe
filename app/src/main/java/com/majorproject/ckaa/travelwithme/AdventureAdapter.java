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
 * Created by Buddy on 8/27/2016.
 */
public class AdventureAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<GetDataAdapter> getDataAdapter;

    public AdventureAdapter(List<GetDataAdapter> getDataAdapter, Context context) {
        this.getDataAdapter = getDataAdapter;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adventure_recyclerview, parent, false);
        return new AdventureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final GetDataAdapter getDataAdapter1 =  getDataAdapter.get(position);
        final AdventureViewHolder popularViewHolder = (AdventureViewHolder) holder;
        Glide.with(context).load(Json_Url.ip+"hotel/"+getDataAdapter1.getAdventure_photo()).centerCrop().into(popularViewHolder.AdventureImage);
            //popularViewHolder.popularImage.setImageResource();
            popularViewHolder.AdventureName.setText(getDataAdapter1.getAdventure_name());
            //popularViewHolder.popularAddress.setText(getDataAdapter1.getAdventure_description());

    }

    @Override
    public int getItemCount() {
        return getDataAdapter.size();
    }
    class AdventureViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView AdventureImage;
        public TextView AdventureName;

        public AdventureViewHolder(View itemView) {

            super(itemView);
            itemView.setOnClickListener(this);

            //IdTextView = (TextView) itemView.findViewById(R.id.textView2) ;
            AdventureImage = (ImageView) itemView.findViewById(R.id.adventure_recycler_image);
            AdventureName = (TextView) itemView.findViewById(R.id.adventure_name) ;

        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
            GetDataAdapter getDataAdapter1 = getDataAdapter.get(getLayoutPosition());
            Intent i = new Intent(context,AdventureContentActivity.class);
            i.putExtra("currentposition", getAdapterPosition());
            context.startActivity(i);

        }
    }
}
