package com.majorproject.ckaa.travelwithme.phrasebook;

/**
 * Created by Buddy on 8/11/2016.
 *
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.majorproject.ckaa.travelwithme.GetDataAdapter;
import com.majorproject.ckaa.travelwithme.R;

import java.util.ArrayList;
import java.util.List;

public class PhrasebookRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        public static final int PHRASEBOOK_HEADER = 0;
        public static final int PHRASEBOOK_CHILD = 1;
        public static final int PHRASEBOOK_BANK_HEADER=2;
        public static final int PHRASEBOOK_BANK_CHILD = 3;


        static List<GetDataAdapter> getDataAdapter;
        public  static Context context;
        public PhrasebookRecyclerAdapter(List<GetDataAdapter> getDataAdapter, Context context){
            super();
            this.getDataAdapter = getDataAdapter;
            this.context = context;

        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
            //return null;
            View view = null;
            Context context = parent.getContext();

            if (type == PHRASEBOOK_HEADER) {

                LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.phrasebook_header, parent, false);
                ListHeaderViewHolder header = new ListHeaderViewHolder(view);
                return header;
            } else {
                LayoutInflater inflaterr = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflaterr.inflate(R.layout.phrasebook_child, parent, false);
                PhrasebookChildViewHolder child = new PhrasebookChildViewHolder(view);
                return child;

            }
        }


        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            final GetDataAdapter getDataAdapter1 = getDataAdapter.get(position);
            //  switch (getDataAdapter1.getType()) {
            if (holder.getItemViewType() == PHRASEBOOK_HEADER) {
                final ListHeaderViewHolder itemController = (ListHeaderViewHolder) holder;
                itemController.refferalItem = getDataAdapter1;
                //Glide.with(context).load("http://192.168.0.119/hotel/" + getDataAdapter1.getPhoto()).centerCrop().into(itemController.expand_image);
                itemController.header_title.setText(getDataAdapter1.getPhrase_header_title());
//
               // itemController.header_image.setImageResource(getDataAdapter1.getServiceHeaderImage());
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
                            while (getDataAdapter.size() > pos + 1 && getDataAdapter.get(pos + 1).getType()== PHRASEBOOK_CHILD) {
                                getDataAdapter1.invisibleChildren.add(getDataAdapter.remove(pos + 1));
                                count++;
                            }
                            notifyItemRangeRemoved(pos + 1, count);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.circle_plus);
                        } else {
                            int pos = getDataAdapter.indexOf(itemController.refferalItem);
                            int index = pos + 1;
                            for (GetDataAdapter i : getDataAdapter1.invisibleChildren) {
                                getDataAdapter.add(index, i);
                                index++;
                            }
                            notifyItemRangeInserted(pos + 1, index - pos - 1);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.circle_minus);
                            getDataAdapter1.invisibleChildren = null;
                        }
                    }
                });

            } else{

                final PhrasebookChildViewHolder Childitem = (PhrasebookChildViewHolder) holder;
                Childitem.refferalItem = getDataAdapter1;
                // Glide.with(context).load("http://192.168.0.119/hotel/" + getDataAdapter1.getHeritage_photo()).centerCrop().into(ChilditemController.sight_child_image);


                Childitem.phrase_child_title.setText(getDataAdapter1.getPhrase_child_title());
                Childitem.phrase_nepali.setText(getDataAdapter1.getPhrase_nepali());
                Childitem.phrase_english.setText(getDataAdapter1.getPhrase_english());



            }

        }


        @Override
        public int getItemCount() {
            return getDataAdapter.size();
        }
        @Override
        public int getItemViewType(int position) {
            return getDataAdapter.get(position).getType();
        }


        private static class ListHeaderViewHolder extends RecyclerView.ViewHolder {
            public TextView header_title;
            public ImageView btn_expand_toggle;
            //public ImageView header_image;
            public GetDataAdapter refferalItem;

            public ListHeaderViewHolder(View itemView) {
                super(itemView);
                //header_image = (ImageView) itemView.findViewById(R.id.phrasebook_header_image);
                header_title = (TextView) itemView.findViewById(R.id.phrasebook_header_title);
                btn_expand_toggle = (ImageView) itemView.findViewById(R.id.btn_expand_toggle);
            }
        }


        private static class PhrasebookChildViewHolder extends RecyclerView.ViewHolder{
            private TextView phrase_child_title;
            private TextView phrase_nepali;
            private TextView phrase_english;

            public GetDataAdapter refferalItem;

            public PhrasebookChildViewHolder(View itemView) {
                super(itemView);
                //itemView.setOnClickListener(this);


                phrase_child_title = (TextView) itemView.findViewById(R.id.phrasebook_child_title);
                phrase_nepali =(TextView) itemView.findViewById(R.id.phrase_nepali);
                phrase_english= (TextView) itemView.findViewById(R.id.phrase_english);

            }



        }

    }



