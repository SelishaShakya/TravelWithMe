package com.majorproject.ckaa.travelwithme;

import java.util.List;

/**
 * Created by Buddy on 6/19/2016.
 */
public class ItemObjects {

    private String name;
    private int Hotelphoto;
    private String address;
    private int rating;
    private String hotel_bookBtn;
    private String city_name;
    private int Cityphoto;


    public int getType() {
        return type;
    }





        private String item_name;
        private int photo;
        private String map;
        private Double mlat;
        private Double mlong;
        public int type;
        private  int child_image;
        public List<ItemObjects> invisibleChildren;

        public ItemObjects( int type ,String item_name, int photo,String map,Double mlat,Double mlong) {
            this.item_name = item_name;
            this.photo = photo;
            this.map = map;
            this.mlat=mlat;
            this.mlong=mlong;
            this.type = type;
        }

   public  ItemObjects(String item_name, int photo)
   {
       this.item_name = item_name;
       this.photo = photo;
       //this.map = map;
     //  this.mlat=mlat;
      // this.mlong=mlong;



   }
    public String getMap() {
            return map;
        }

        public void setMap(String map) {
            this.map = map;
        }

        public String getItem_name() {
            return item_name;
        }

        public void setItem_name(String item_name) {
            this.item_name = item_name;
        }

        public int getPhoto() {
            return photo;
        }

        public void setPhoto(int photo) {
            this.photo = photo;
        }


    public void setType(int type) {
        this.type = type;
    }

    public ItemObjects(String name) {
        this.name = name;

    }

    public ItemObjects(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public ItemObjects(int type, String name, int Hotelphoto, String address, int rating, String hotel_bookBtn, Double mlat, Double mlong) {
        this.name = name;
        this.Hotelphoto = Hotelphoto;
        this.address=address;
        this.rating=rating;
        this.hotel_bookBtn = hotel_bookBtn;
        this.mlat=mlat;
        this.mlong=mlong;
        this.type= type;
    }
       public ItemObjects(int type, String city_name,int Cityphoto)
       {
           this.city_name=city_name;
           this.Cityphoto=Cityphoto;
           this.type = type;
       }

    public String getCity_name() {
        return city_name;
    }

    public Double getMlat() {
        return mlat;
    }

    public void setMlat(Double mlat) {
        this.mlat = mlat;
    }

    public Double getMlong() {
        return mlong;
    }

    public void setMlong(Double mlong) {
        this.mlong = mlong;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public int getCityphoto() {
        return Cityphoto;
    }

    public void setCityphoto(int cityphoto) {
        Cityphoto = cityphoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHotelphoto() {
        return Hotelphoto;
    }

    public void setHotelphoto(int photo) {
        this.Hotelphoto = Hotelphoto;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getHotel_bookBtn() {
        return hotel_bookBtn;
    }

    public void setHotel_bookBtn(String hotel_bookBtn) {
        this.hotel_bookBtn = hotel_bookBtn;
    }
}

