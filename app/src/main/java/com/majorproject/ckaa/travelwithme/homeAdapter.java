package com.majorproject.ckaa.travelwithme;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.majorproject.ckaa.travelwithme.eventUpdate.EventActivity;
import com.majorproject.ckaa.travelwithme.phrasebook.PhrasebookActivity;

import java.util.List;


/**
 * Created by ckaa on 8/24/2016.
 */
public class homeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    private int[] mDataSetTypes;
    List<GetDataAdapter>getDataAdapter;
    public static final  int  guide = 0 ;
    public static final int  phrase = 1;

    public homeAdapter (Context context, List<GetDataAdapter> getDataAdapter)
{
    this.context = context;
    // this.mDataSetTypes = mDatasetType;
    this.getDataAdapter = getDataAdapter;


}

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == guide) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.guidetype_layout, parent, false);
            guideViewHolder guide = new guideViewHolder(view);
            return guide;
        }
        else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phrasetype_layout, parent, false);
            phraseViewHolder phrase= new phraseViewHolder(view);
            return phrase;


        }

    }

        @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            final GetDataAdapter getDataAdapter1 =  getDataAdapter.get(position);
            if(holder.getItemViewType()==guide)
            {
                final guideViewHolder guideHolder = (guideViewHolder) holder;
               // guideHolder.NightImage.setImageResource(getDataAdapter1.getStatic_night_photo());
                guideHolder.guideicon.setImageResource(getDataAdapter1.getIcon());
                guideHolder.guideitemFirst.setText(getDataAdapter1.getItemName());
                guideHolder.guideitemSecond.setText(getDataAdapter1.getSubitemName());

            }
            else
            {

                final phraseViewHolder phraseHolder = (phraseViewHolder) holder;
                // guideHolder.NightImage.setImageResource(getDataAdapter1.getStatic_night_photo());
                phraseHolder.phraseicon.setImageResource(getDataAdapter1.getIcon());
                phraseHolder.phraseitemFirst.setText(getDataAdapter1.getPhrase_child_title());
                phraseHolder.phraseitemSecond.setText(getDataAdapter1.getPhrase_english());
                phraseHolder.phraseitemThird.setText(getDataAdapter1.getPhrase_nepali());



            }




    }

    /**
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return getDataAdapter.size();
    }
    public int getItemViewType(int position) {
        return getDataAdapter.get(position).getType();
    }

    class guideViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //public ImageView popularImage;
        public TextView guideitemFirst;
        public TextView guideitemSecond;
        public ImageView guideicon;


        public guideViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            guideitemFirst = (TextView) itemView.findViewById(R.id.guide_item_one);
            guideitemSecond = (TextView) itemView.findViewById(R.id.guide_sub_item);
            guideicon = (ImageView)itemView.findViewById(R.id.guide_icon);

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
                case 0 :
                    Intent intentmini = new Intent(context, popularActivity.class);
                    context.startActivity(intentmini);
                    break;
                case 1:
                    Intent intentadventure = new Intent(context, AdventureActivity.class);
                    context.startActivity(intentadventure);
                    break;
                case 3:
                    Intent intentupdate = new Intent(context, EventActivity.class);
                    context.startActivity(intentupdate);
                    break;

                case 4:
                    Intent intentconverter = new Intent(context, CurrencyConverterActivity.class);
                    context.startActivity(intentconverter);
                    break;

            }









        }
    }
    class phraseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView phraseitemFirst;
        public TextView phraseitemSecond;
        public  TextView phraseitemThird;
        public ImageView phraseicon;



        public phraseViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            phraseitemFirst = (TextView) itemView .findViewById(R.id.phrasetype_itemfirst);
            phraseitemSecond = (TextView) itemView .findViewById(R.id.phrasetype_itemsecond);
            phraseitemThird = (TextView) itemView .findViewById(R.id.phrasetype_itemthird);
            phraseicon = (ImageView)itemView.findViewById(R.id.phrase_icon);


        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
            Intent intentphrase = new Intent(context, PhrasebookActivity.class);
            context.startActivity(intentphrase);

        }
    }



    //public ImageView popularImage;



}


