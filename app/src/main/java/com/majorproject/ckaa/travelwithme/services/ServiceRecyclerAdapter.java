package com.majorproject.ckaa.travelwithme.services;

/**
 * Created by Buddy on 8/11/2016.
 *
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.majorproject.ckaa.travelwithme.MapActivity;
import com.majorproject.ckaa.travelwithme.R;

import java.util.ArrayList;
import java.util.List;
public class ServiceRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        public static final int SERVICE_HEADER = 0;
        public static final int SERVICE_CHILD = 1;
        public static final int SERVICE_BANK_HEADER=2;
        public static final int SERVICE_BANK_CHILD = 3;
        public static ArrayList<double[]> locationsLat;
        public static ArrayList<double[]>locationsLong;
        public static String title;
        public static double[] arrayLat;
        public static double[] arrayLong;
        public static double mainlat;
        public static double mainlong;
        public static String childType;
        public static String[] childTitle;

    private static final String TAG = ServiceRecyclerAdapter.class.getSimpleName();
        static List<GetDataAdapterr> getDataAdapter;
        public  static Context context;
        public ServiceRecyclerAdapter(List<GetDataAdapterr> getDataAdapter, Context context){
            super();
            this.getDataAdapter = getDataAdapter;
            this.context = context;

        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
            //return null;
            View view = null;
            Context context = parent.getContext();

            if (type == SERVICE_HEADER) {

                LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.service_header, parent, false);
                ListHeaderViewHolder header = new ListHeaderViewHolder(view);
                return header;
            } else if(type==SERVICE_CHILD) {
                LayoutInflater inflaterr = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflaterr.inflate(R.layout.service_child, parent, false);
                ServiceChildViewHolder child = new ServiceChildViewHolder(view);
                return child;
            }else if (type == SERVICE_BANK_HEADER) {

                LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.service_header, parent, false);
                ListHeaderViewHolder header = new ListHeaderViewHolder(view);
                return header;
            }else{
                LayoutInflater inflaterr = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflaterr.inflate(R.layout.service_bank_child, parent, false);
                ServiceBankChildViewHolder bankchild = new ServiceBankChildViewHolder(view);
                return bankchild;
            }
        }


        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            final GetDataAdapterr getDataAdapter1 = getDataAdapter.get(position);
            //  switch (getDataAdapter1.getType()) {
            if (holder.getItemViewType() == SERVICE_HEADER) {
                final ListHeaderViewHolder itemController = (ListHeaderViewHolder) holder;
                itemController.refferalItem = getDataAdapter1;
                //Glide.with(context).load("http://192.168.0.119/hotel/" + getDataAdapter1.getPhoto()).centerCrop().into(itemController.expand_image);
                itemController.header_title.setText(getDataAdapter1.getServiceHeaderName());
//
                itemController.header_image.setImageResource(getDataAdapter1.getServiceHeaderImage());
//                itemController.header_title.setText(item.getItem_name());
                if (getDataAdapter1.invisibleChildren == null) {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.circle_minus);
                } else {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.circle_plus);
                }
                itemController.btn_expand_toggle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (getDataAdapter1.invisibleChildren == null) {
                            getDataAdapter1.invisibleChildren = new ArrayList<>();
                            int count = 0;
                            int pos = getDataAdapter.indexOf(itemController.refferalItem);
                            while (getDataAdapter.size() > pos + 1 && getDataAdapter.get(pos + 1).getService_type() == SERVICE_CHILD) {
                                getDataAdapter1.invisibleChildren.add(getDataAdapter.remove(pos + 1));
                                count++;
                            }
                            notifyItemRangeRemoved(pos + 1, count);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.circle_plus);
                        } else {
                            int pos = getDataAdapter.indexOf(itemController.refferalItem);
                            int index = pos + 1;
                            for (GetDataAdapterr i : getDataAdapter1.invisibleChildren) {
                                getDataAdapter.add(index, i);
                                index++;
                            }
                            notifyItemRangeInserted(pos + 1, index - pos - 1);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.circle_minus);
                            getDataAdapter1.invisibleChildren = null;
                        }
                    }
                });
            } else if (holder.getItemViewType() == SERVICE_BANK_HEADER) {
                final ListHeaderViewHolder itemController = (ListHeaderViewHolder) holder;
                itemController.refferalItem = getDataAdapter1;
                //Glide.with(context).load("http://192.168.0.119/hotel/" + getDataAdapter1.getPhoto()).centerCrop().into(itemController.expand_image);
                itemController.header_title.setText(getDataAdapter1.getServiceHeaderName());
//
                itemController.header_image.setImageResource(getDataAdapter1.getServiceHeaderImage());
//                itemController.header_title.setText(item.getItem_name());
                if (getDataAdapter1.invisibleChildren == null) {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.circle_minus);
                } else {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.circle_plus);
                }
                itemController.btn_expand_toggle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (getDataAdapter1.invisibleChildren == null) {
                            getDataAdapter1.invisibleChildren = new ArrayList<>();
                            int count = 0;
                            int pos = getDataAdapter.indexOf(itemController.refferalItem);
                            while (getDataAdapter.size() > pos + 1 && getDataAdapter.get(pos + 1).getService_type() == SERVICE_BANK_CHILD) {
                                getDataAdapter1.invisibleChildren.add(getDataAdapter.remove(pos + 1));
                                count++;
                            }
                            notifyItemRangeRemoved(pos + 1, count);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.circle_plus);
                        } else {
                            int pos = getDataAdapter.indexOf(itemController.refferalItem);
                            int index = pos + 1;
                            for (GetDataAdapterr i : getDataAdapter1.invisibleChildren) {
                                getDataAdapter.add(index, i);
                                index++;
                            }
                            notifyItemRangeInserted(pos + 1, index - pos - 1);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.circle_minus);
                            getDataAdapter1.invisibleChildren = null;
                        }
                    }
                });
            } else if(holder.getItemViewType() == SERVICE_CHILD){

                final ServiceChildViewHolder Childitem = (ServiceChildViewHolder) holder;
                Childitem.refferalItem = getDataAdapter1;
                // Glide.with(context).load("http://192.168.0.119/hotel/" + getDataAdapter1.getHeritage_photo()).centerCrop().into(ChilditemController.sight_child_image);


                Childitem.service_child_name.setText(getDataAdapter1.getServiceName());
                Childitem.service_child_address.setText(getDataAdapter1.getServiceAddress());
                Childitem.service_child_info.setText(getDataAdapter1.getServiceInfo());

                Double mlat = getDataAdapter1.getServiceLatitude();
                Double mlong =getDataAdapter1.getServiceLongitude();


                // LatLng fromPosition= new LatLng(mlat,mlong);

//                LatLng fromPostion = new LatLng(mlat,mlong);
//                final Bundle args = new Bundle();
//                final String  title = getDataAdapter1.getStatic_heritage_title();
//
//                args.putParcelable("longLat_dataPrivider", fromPostion);


                //ImageView itemImageView = (ImageView)holder.itemView;
//                TextView itemTextView = (TextView) holder.itemView;
//                //itemImageView.setImageResource(ItemList.get(position).getPhoto());
//                itemTextView.setText(ItemList.get(position).getItem_name());


            }else{

                final ServiceBankChildViewHolder Childitem = (ServiceBankChildViewHolder) holder;
                Childitem.refferalItem = getDataAdapter1;
                // Glide.with(context).load("http://192.168.0.119/hotel/" + getDataAdapter1.getHeritage_photo()).centerCrop().into(ChilditemController.sight_child_image);


                Childitem.service_bank_child_name.setText(getDataAdapter1.getServiceName());
                Childitem.service_bank_child_address1.setText(getDataAdapter1.getServiceAddress1());
                Childitem.service_bank_child_info1.setText(getDataAdapter1.getServiceInfo1());
                Childitem.service_bank_child_address2.setText(getDataAdapter1.getServiceAddress2());
                Childitem.service_bank_child_info2.setText(getDataAdapter1.getServiceInfo2());
                Childitem.service_bank_child_address3.setText(getDataAdapter1.getServiceAddress3());
                Childitem.service_bank_child_info3.setText(getDataAdapter1.getServiceInfo3());

                Double mlat = getDataAdapter1.getServiceLatitude();
                Double mlong =getDataAdapter1.getServiceLongitude();


                // LatLng fromPosition= new LatLng(mlat,mlong);

//                LatLng fromPostion = new LatLng(mlat,mlong);
//                final Bundle args = new Bundle();
//                final String  title = getDataAdapter1.getStatic_heritage_title();
//
//                args.putParcelable("longLat_dataPrivider", fromPostion);


                //ImageView itemImageView = (ImageView)holder.itemView;
//                TextView itemTextView = (TextView) holder.itemView;
//                //itemImageView.setImageResource(ItemList.get(position).getPhoto());
//                itemTextView.setText(ItemList.get(position).getItem_name());


            }

        }


        @Override
        public int getItemCount() {
            return getDataAdapter.size();
        }
        @Override
        public int getItemViewType(int position) {
            return getDataAdapter.get(position).getService_type();
        }


        private static class ListHeaderViewHolder extends RecyclerView.ViewHolder {
            public TextView header_title;
            public ImageView btn_expand_toggle;
            public ImageView header_image;
            public GetDataAdapterr refferalItem;

            public ListHeaderViewHolder(View itemView) {
                super(itemView);
                header_image = (ImageView) itemView.findViewById(R.id.service_header_image);
                header_title = (TextView) itemView.findViewById(R.id.service_header_title);
                btn_expand_toggle = (ImageView) itemView.findViewById(R.id.btn_expand_toggle);
            }
        }


        private static class ServiceChildViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            private TextView service_child_name;
            private TextView service_child_address;
            private TextView service_child_info;

            public GetDataAdapterr refferalItem;

            public ServiceChildViewHolder(View itemView) {
                super(itemView);
                itemView.setOnClickListener(this);


                service_child_name = (TextView) itemView.findViewById(R.id.serviceName);
                service_child_address =(TextView) itemView.findViewById(R.id.serviceAddress);
                service_child_info= (TextView) itemView.findViewById(R.id.serviceInfo);


            }

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
                public void onClick(View v) {
                GetDataAdapterr getDataAdapter1 = getDataAdapter.get(getLayoutPosition());
                arrayLat = getDataAdapter1.getServiceArray();
                arrayLong = getDataAdapter1.getServiceLongArray();
                mainlat = getDataAdapter1.getServiceLatitude();
                mainlong = getDataAdapter1.getServiceLongitude();
                title = getDataAdapter1.getServiceName();
                childType = getDataAdapter1.getChildType();
                childTitle=getDataAdapter1.getChildArray();
                Log.i(TAG, "onClick: "+childType);

//                for (int i = 0; i < 2; i++)
//                {   Log.i(TAG, "onClick: " + arrayLat[i] + "......" + arrayLong[i]);
//                double[] array = {0.111, 89.0004, 678.889};
//                Log.i(TAG, "onClick: " + array[i]);
//            }
                   Bundle args = new Bundle();
                LatLng service = new LatLng(mainlat,mainlong);
                args.putParcelable("longLat_dataPrivider",service);

//               // LatLng fromArray = new LatLng(locationsLat.(arrayLat,arrayLong));
//                    args.putDoubleArray("latitude",arrayLat);
//                    args.putDoubleArray("longitude",arrayLong);

                    Intent in = new Intent(context,MapActivity.class);
                    in.putExtra("latitude",arrayLat);
                    in.putExtra("longitude",arrayLong);
                    in.putExtra("title",title);
                    in.putExtra("type",childType);
                    in.putExtra("childTitle",childTitle);
                    in.putExtras(args);
                    context.startActivity(in);





                }






        }

    private static class ServiceBankChildViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView service_bank_child_name;
        private TextView service_bank_child_address1;
        private TextView service_bank_child_address2;
        private TextView service_bank_child_address3;
        private TextView service_bank_child_info1;
        private TextView service_bank_child_info2;
        private TextView service_bank_child_info3;

        public GetDataAdapterr refferalItem;

        public ServiceBankChildViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);


            service_bank_child_name = (TextView) itemView.findViewById(R.id.serviceName);
            service_bank_child_address1 =(TextView) itemView.findViewById(R.id.serviceAddress1);
            service_bank_child_info1= (TextView) itemView.findViewById(R.id.serviceInfo1);
            service_bank_child_address2 =(TextView) itemView.findViewById(R.id.serviceAddress2);
            service_bank_child_info2= (TextView) itemView.findViewById(R.id.serviceInfo2);
            service_bank_child_address3 =(TextView) itemView.findViewById(R.id.serviceAddress3);
            service_bank_child_info3= (TextView) itemView.findViewById(R.id.serviceInfo3);

        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
            GetDataAdapterr getDataAdapter1 = getDataAdapter.get(getLayoutPosition());
            arrayLat = getDataAdapter1.getServiceArray();
            arrayLong = getDataAdapter1.getServiceLongArray();
            mainlat = getDataAdapter1.getServiceLatitude();
            mainlong = getDataAdapter1.getServiceLongitude();
            title = getDataAdapter1.getServiceName();
            childType = getDataAdapter1.getChildType();
            childTitle=getDataAdapter1.getChildArray();
            Log.i(TAG, "onClick: "+childType);
            Bundle args = new Bundle();
            LatLng service = new LatLng(mainlat,mainlong);
            args.putParcelable("longLat_dataPrivider",service);

//               // LatLng fromArray = new LatLng(locationsLat.(arrayLat,arrayLong));
//                    args.putDoubleArray("latitude",arrayLat);
//                    args.putDoubleArray("longitude",arrayLong);

            Intent in = new Intent(context,MapActivity.class);
            in.putExtra("latitude",arrayLat);
            in.putExtra("longitude",arrayLong);
            in.putExtra("title",title);
            in.putExtra("type",childType);
            in.putExtra("childTitle",childTitle);
            in.putExtras(args);
            context.startActivity(in);






        }





    }


    }



