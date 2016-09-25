package com.majorproject.ckaa.travelwithme;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Buddy on 6/19/2016.
 */
public class AttractionRecyclerViewAdapter extends RecyclerView.Adapter<AttractionViewHolder> {
    private int mDataSetType[];
    public static final int AttrtcnType = 1;
    public static final int city = 0;

AppCompatActivity app = new AppCompatActivity();
    private List<ItemObjects> itemList;
    int position;
    public AttractionRecyclerViewAdapter(Context context, List<ItemObjects> itemList, int DataSetType[]) {
        this.context = context;
        this.itemList = itemList;
        mDataSetType =DataSetType;
    }

    private Context context;
    @Override
    public AttractionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View layoutView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
//        SolventViewHolder rcv=new SolventViewHolder(layoutView,context);
//        return rcv;
        View v;
        if(viewType==city)
        {
            v= LayoutInflater.from(parent.getContext()).inflate(R.layout.city_layout,parent,false);
            return new AttractionCityHolder(v,context);
        }
        else
        {
            v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout_ktmattraction,parent,false);
            return new AttractnItemHolder(v,context);
        }

    }

    @Override
    public void onBindViewHolder(AttractionViewHolder holder, final int position) {

        if (holder.getItemViewType() == city) {
            AttractionCityHolder Cityholder = (AttractionCityHolder) holder;
            Cityholder.cityName.setText(itemList.get(position).getItem_name());
            Cityholder.cityImage.setImageResource(itemList.get(position).getPhoto());
//            Double fromLat = itemList.get(position).getMlat();
//            Double fromLong = itemList.get(position).getMlong();
//            LatLng fromPostion = new LatLng(fromLat, fromLong);
//            final String city = itemList.get(position).getItem_name();
//            final Bundle args = new Bundle();
//            args.putParcelable("longLat_dataPrivider", fromPostion);
//            Cityholder.Butn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent inten = new Intent(context, MapActivity.class);
//                    inten.putExtras(args);
//                    inten.putExtra("title", city);
//                    //  getSupportActionBar().setTitle("Map");
//
//                    context.startActivity(inten);
//                }
//            });
        }
        else
        {
            AttractnItemHolder AttractionHolder = (AttractnItemHolder) holder;
            AttractionHolder.Item_photo.setImageResource(itemList.get(position).getPhoto());
            AttractionHolder.Item_name.setText(itemList.get(position).getItem_name());



        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
    @Override
    public int getItemViewType(int position) {
        return mDataSetType[position];
    }
}
