package com.majorproject.ckaa.travelwithme;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

//import com.majorproject.ckaa.travelwithme.hotel.HotelActivity;

/**
 * Created by Buddy on 6/19/2016.
 */
public class SolventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView hotelName;
    public ImageView hotelImage;
    public TextView hotelAddress;
    public RatingBar ratingBar;
    public Button hotel_book;
    public Button hotel_deal;
    public Context context;
    public TextView CityName;
    public ImageView CityImage;
    public  Button MapButn;


    @Override
    public void onClick(View v) {

        v.getContext();
        int position = getAdapterPosition();
        switch (position) {

            case 0:
                Uri url1 = Uri.parse(Json_Url.ip +"TravelWithMe/annapurna.php");
                Intent h1intent = new Intent(Intent.ACTION_VIEW, url1);
                context.startActivity(h1intent);
                break;
            case 1:
                Uri url2 = Uri.parse(Json_Url.ip +"TravelWithMe/gokarna.php");
                Intent secondintent = new Intent(Intent.ACTION_VIEW, url2);
                context.startActivity(secondintent);
                break;
            case 2:
                Uri url3 = Uri.parse(Json_Url.ip +"TravelWithMe/shanker.php");
                Intent thirdintent = new Intent(Intent.ACTION_VIEW, url3);
                context.startActivity(thirdintent);
                break;

            // Toast.makeText(v.getContext(), "+position"+getAdapterPosition(), Toast.LENGTH_SHORT).show();

        }
    }

    public SolventViewHolder(View itemView) {
        super(itemView);
//        this.context = context;
//        itemView.setOnClickListener(this);
//        hotelName=(TextView)itemView.findViewById(R.id.hotelName);
//        hotelImage=(ImageView)itemView.findViewById(R.id.hotelImage);
//        hotelAddress=(TextView)itemView.findViewById(R.id.hotelAddress);
//        ratingBar=(RatingBar)itemView.findViewById(R.id.ratingBar);
//        hotel_book=(Button)itemView.findViewById(R.id.hotel_book);
//        hotel_deal=(Button)itemView.findViewById(R.id.hotel_deal);
    }}

class MainHolder extends SolventViewHolder {
//TextView temp;

public MainHolder(View itemView, Context context) {
    super(itemView);
    this.context = context;
    itemView.setOnClickListener(this);
    this.hotelName=(TextView)itemView.findViewById(R.id.hotelName);
    this.hotelImage=(ImageView)itemView.findViewById(R.id.hotelImage);
    this.hotelAddress=(TextView)itemView.findViewById(R.id.hotelAddress);
    this.ratingBar=(RatingBar)itemView.findViewById(R.id.ratingBar);
    this.hotel_book=(Button)itemView.findViewById(R.id.hotel_book);
  //  this.hotel_deal=(Button)itemView.findViewById(R.id.hotel_deal);
    this.MapButn=(Button)itemView.findViewById(R.id.Map);
    //this.temp = (TextView) itemView.findViewById(R.id.);
}
}

class ButtonHolder extends SolventViewHolder {
    Button load;
    ProgressBar progressBar;
    public ButtonHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        this.load = (Button) itemView.findViewById(R.id.loadbutton);
        progressBar = (ProgressBar)  itemView.findViewById(R.id.progressBar1);
    }
}


class CityHolder extends SolventViewHolder  implements View.OnClickListener{
    //TextView temp;

    public CityHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        itemView.setOnClickListener(this);
        this.CityName=(TextView)itemView.findViewById(R.id.city_name);
        this.CityImage=(ImageView)itemView.findViewById(R.id.city_image);

        //this.temp = (TextView) itemView.findViewById(R.id.);
    }
    @Override
    public void onClick(View v) {
       v.getContext();
        Intent i = new Intent(context,HotelActivity.class);

        context.startActivity(i);

    }
}




