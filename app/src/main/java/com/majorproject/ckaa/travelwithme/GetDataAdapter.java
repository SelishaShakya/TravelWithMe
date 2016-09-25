package com.majorproject.ckaa.travelwithme;

import java.util.List;

/**
 * Created by ckaa on 7/12/2016.
 */
public class GetDataAdapter {
    String name;
    String  photo;
    String address;
    int rating;
    String hotellink;
    String hotelbook;
    Double Hotel_lat;
    Double Hotel_long;
    int type;
    String amusement_name;
    String night_name;
    String  night_photo;
    String night_address;
    double night_latitude;
    double night_longitude;
    String night_phone;
    int static_night_photo;
    public GetDataAdapter(int type,String night_name,String night_address, String night_phone,int static_night_photo, double night_latitude, double night_longitude) {
        this.night_phone = night_phone;
        this.night_longitude = night_longitude;
        this.night_latitude = night_latitude;
        this.night_address = night_address;
        this.static_night_photo = static_night_photo;
        this.night_name = night_name;
        this.type=type;
    }
    String shop_name;
    String  shop_photo;
    String shop_address;
    double shop_latitude;
    double shop_longitude;
    String shop_phone;
    int static_shop_photo;

    public GetDataAdapter( int type,String shop_name, String shop_address,int static_shop_photo, double shop_latitude, double shop_longitude) {
        this.shop_name = shop_name;
        this.shop_address = shop_address;
        this.shop_latitude = shop_latitude;
        this.shop_longitude = shop_longitude;
        this.static_shop_photo = static_shop_photo;
        this.type = type;
    }
    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_photo() {
        return shop_photo;
    }

    public void setShop_photo(String shop_photo) {
        this.shop_photo = shop_photo;
    }

    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }

    public double getShop_latitude() {
        return shop_latitude;
    }

    public void setShop_latitude(double shop_latitude) {
        this.shop_latitude = shop_latitude;
    }

    public double getShop_longitude() {
        return shop_longitude;
    }

    public void setShop_longitude(double shop_longitude) {
        this.shop_longitude = shop_longitude;
    }

    public String getShop_phone() {
        return shop_phone;
    }

    public void setShop_phone(String shop_phone) {
        this.shop_phone = shop_phone;
    }

    public int getStatic_shop_photo() {
        return static_shop_photo;
    }

    public void setStatic_shop_photo(int static_shop_photo) {
        this.static_shop_photo = static_shop_photo;
    }

    public String getNight_name() {
        return night_name;
    }

    public void setNight_name(String night_name) {
        this.night_name = night_name;
    }

    public String getNight_photo() {
        return night_photo;
    }

    public void setNight_photo(String night_photo) {
        this.night_photo = night_photo;
    }

    public String getNight_address() {
        return night_address;
    }

    public void setNight_address(String night_address) {
        this.night_address = night_address;
    }

    public double getNight_latitude() {
        return night_latitude;
    }

    public void setNight_latitude(double night_latitude) {
        this.night_latitude = night_latitude;
    }

    public double getNight_longitude() {
        return night_longitude;
    }

    public void setNight_longitude(double night_longitude) {
        this.night_longitude = night_longitude;
    }

    public String getNight_phone() {
        return night_phone;
    }

    public void setNight_phone(String night_phone) {
        this.night_phone = night_phone;
    }

    public int getStatic_night_photo() {
        return static_night_photo;
    }

    public void setStatic_night_photo(int static_night_photo) {
        this.static_night_photo = static_night_photo;
    }

    public GetDataAdapter() {
    }

    public GetDataAdapter( int type,String amusement_name, String amusement_address, String amusement_phone, int static_amusement_photo, String amusement_openingtime, String amusement_fee, double amusement_latitude, double amusement_longitude) {
        this.amusement_name = amusement_name;
        this.amusement_address = amusement_address;
        this.amusement_phone = amusement_phone;
        this.static_amusement_photo = static_amusement_photo;
        this.amusement_openingtime = amusement_openingtime;
        this.amusement_fee = amusement_fee;
        this.amusement_latitude = amusement_latitude;
        this.amusement_longitude = amusement_longitude;
        this.type = type;
    }

    public String getAmusement_name() {
        return amusement_name;
    }

    public void setAmusement_name(String amusement_name) {
        this.amusement_name = amusement_name;
    }

    public String getAmusement_photo() {
        return amusement_photo;
    }

    public void setAmusement_photo(String amusement_photo) {
        this.amusement_photo = amusement_photo;
    }

    public String getAmusement_address() {
        return amusement_address;
    }

    public void setAmusement_address(String amusement_address) {
        this.amusement_address = amusement_address;
    }

    public double getAmusement_latitude() {
        return amusement_latitude;
    }

    public void setAmusement_latitude(double amusement_latitude) {
        this.amusement_latitude = amusement_latitude;
    }

    public double getAmusement_longitude() {
        return amusement_longitude;
    }

    public void setAmusement_longitude(double amusement_longitude) {
        this.amusement_longitude = amusement_longitude;
    }

    public int getStatic_amusement_photo() {
        return static_amusement_photo;
    }

    public void setStatic_amusement_photo(int static_amusement_photo) {
        this.static_amusement_photo = static_amusement_photo;
    }

    public String getAmusement_phone() {
        return amusement_phone;
    }

    public void setAmusement_phone(String amusement_phone) {
        this.amusement_phone = amusement_phone;
    }

    public String getAmusement_openingtime() {
        return amusement_openingtime;
    }

    public void setAmusement_openingtime(String amusement_openingtime) {
        this.amusement_openingtime = amusement_openingtime;
    }

    public String getAmusement_fee() {
        return amusement_fee;
    }

    public void setAmusement_fee(String amusement_fee) {
        this.amusement_fee = amusement_fee;
    }

    String  amusement_photo;
    String amusement_address;
    double amusement_latitude;
    double amusement_longitude;
    int static_amusement_photo;
   // int amusement_type;
    String amusement_phone;
    String amusement_openingtime;
    String amusement_fee;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Double getHotel_lat() {
        return Hotel_lat;
    }

    public void setHotel_lat(Double hotel_lat) {
        Hotel_lat = hotel_lat;
    }

    public Double getHotel_long() {
        return Hotel_long;
    }

    public void setHotel_long(Double hotel_long) {
        Hotel_long = hotel_long;
    }
    //    int Id;
//    String name;
//    String phone_number;
//    String subject;


    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String getHotellink() {
        return hotellink;
    }

    public void setHotellink(String hotellink) {
        this.hotellink = hotellink;
    }

    public String getHotelbook() {
        return hotelbook;
    }

    public void setHotelbook(String hotelbook) {
        this.hotelbook = hotelbook;
    }

    String restaurant_title;
    String restaurant_address;
    String restaurant_photo;
    int static_restaurant_photo;
    String restaurant_openingTime;
    String restaurant_number;
    Double restaurant_lat;
    Double restaurant_long;

    public GetDataAdapter(int type,String restaurant_title, String restaurant_address, int static_restaurant_photo, String restaurant_openingTime, String restaurant_number, Double restaurant_lat, Double restaurant_long) {
        this.restaurant_title = restaurant_title;
        this.restaurant_address = restaurant_address;
        this.static_restaurant_photo = static_restaurant_photo;
        this.restaurant_openingTime = restaurant_openingTime;
        this.restaurant_number = restaurant_number;
        this.restaurant_lat = restaurant_lat;
        this.restaurant_long = restaurant_long;
        this.type = type;
    }

    public String getRestaurant_title() {
        return restaurant_title;
    }

    public void setRestaurant_title(String restaurant_title) {
        this.restaurant_title = restaurant_title;
    }

    public String getRestaurant_address() {
        return restaurant_address;
    }

    public void setRestaurant_address(String restaurant_address) {
        this.restaurant_address = restaurant_address;
    }

    public String getRestaurant_photo() {
        return restaurant_photo;
    }

    public void setRestaurant_photo(String restaurant_photo) {
        this.restaurant_photo = restaurant_photo;
    }

    public int getStatic_restaurant_photo() {
        return static_restaurant_photo;
    }

    public void setStatic_restaurant_photo(int static_restaurant_photo) {
        this.static_restaurant_photo = static_restaurant_photo;
    }

    public String getRestaurant_openingTime() {
        return restaurant_openingTime;
    }

    public void setRestaurant_openingTime(String restaurant_openingTime) {
        this.restaurant_openingTime = restaurant_openingTime;
    }

    public String getRestaurant_number() {
        return restaurant_number;
    }

    public void setRestaurant_number(String restaurant_number) {
        this.restaurant_number = restaurant_number;
    }

    public Double getRestaurant_lat() {
        return restaurant_lat;
    }

    public void setRestaurant_lat(Double restaurant_lat) {
        this.restaurant_lat = restaurant_lat;
    }

    public Double getRestaurant_long() {
        return restaurant_long;
    }

    public void setRestaurant_long(Double restaurant_long) {
        this.restaurant_long = restaurant_long;
    }

    String heritage_title;
    String heritage_address;
    String heritage_hours;
    String heritage_entraceFee;
    Double heritage_lat;
    Double heritage_long;
    String heritage_photo;
    String static_heritage_title;
    String static_heritage_address;
    String static_heritage_hours;
    String static_heritage_entraceFee;
    Double static_heritage_lat;
    Double static_heritage_long;
    int static_heritage_photo;
    String heritage_link;
    String static_heritage_link;

    public String getHeritage_link() {
        return heritage_link;
    }

    public void setHeritage_link(String heritage_link) {
        this.heritage_link = heritage_link;
    }

    public String getStatic_heritage_link() {
        return static_heritage_link;
    }

    public void setStatic_heritage_link(String static_heritage_link) {
        this.static_heritage_link = static_heritage_link;
    }

  //  public List<GetDataAdapter> invisibleChildren;

    public  GetDataAdapter(int type ,  String static_heritage_title, int static_heritage_photo,String static_heritage_address, String static_heritage_hours, String static_heritage_entraceFee, Double static_heritage_lat, Double static_heritage_long,String static_heritage_link) {
        this.static_heritage_title = static_heritage_title;
        this.static_heritage_address = static_heritage_address;
        this.static_heritage_hours = static_heritage_hours;
        this.static_heritage_entraceFee = static_heritage_entraceFee;
        this.static_heritage_lat = static_heritage_lat;
        this.static_heritage_long = static_heritage_long;
        this.static_heritage_photo = static_heritage_photo;
        this.static_heritage_link = static_heritage_link;
        this.type = type;
    }

    public void setHeritage_lat(Double heritage_lat) {

        this.heritage_lat = heritage_lat;
    }

    public void setHeritage_long(Double heritage_long) {
        this.heritage_long = heritage_long;
    }

    public String getStatic_heritage_title() {
        return static_heritage_title;
    }

    public void setStatic_heritage_title(String static_heritage_title) {
        this.static_heritage_title = static_heritage_title;
    }

    public String getStatic_heritage_address() {
        return static_heritage_address;
    }

    public void setStatic_heritage_address(String static_heritage_address) {
        this.static_heritage_address = static_heritage_address;
    }

    public String getStatic_heritage_hours() {
        return static_heritage_hours;
    }

    public void setStatic_heritage_hours(String static_heritage_hours) {
        this.static_heritage_hours = static_heritage_hours;
    }

    public String getStatic_heritage_entraceFee() {
        return static_heritage_entraceFee;
    }

    public void setStatic_heritage_entraceFee(String static_heritage_entraceFee) {
        this.static_heritage_entraceFee = static_heritage_entraceFee;
    }

    public Double getStatic_heritage_lat() {
        return static_heritage_lat;
    }

    public void setStatic_heritage_lat(Double static_heritage_lat) {
        this.static_heritage_lat = static_heritage_lat;
    }

    public Double getStatic_heritage_long() {
        return static_heritage_long;
    }

    public void setStatic_heritage_long(Double static_heritage_long) {
        this.static_heritage_long = static_heritage_long;
    }

    public int getStatic_heritage_photo() {
        return static_heritage_photo;
    }

    public void setStatic_heritage_photo(int static_heritage_photo) {
        this.static_heritage_photo = static_heritage_photo;
    }
    public String getHeritage_photo() {
        return heritage_photo;
    }

    public void setHeritage_photo(String heritage_photo) {
        this.heritage_photo = heritage_photo;
    }

    public String getHeritage_address() {
        return heritage_address;
    }

    public void setHeritage_address(String heritage_address) {
        this.heritage_address = heritage_address;
    }

    public String getHeritage_hours() {
        return heritage_hours;
    }

    public void setHeritage_hours(String heritage_hours) {
        this.heritage_hours = heritage_hours;
    }

    public String getHeritage_entraceFee() {
        return heritage_entraceFee;
    }

    public void setHeritage_entraceFee(String heritage_entraceFee) {
        this.heritage_entraceFee = heritage_entraceFee;
    }

    public double getHeritage_lat() {
        return heritage_lat;
    }

    public void setHeritage_lat(double heritage_lat) {
        this.heritage_lat = heritage_lat;
    }

    public double getHeritage_long() {
        return heritage_long;
    }

    public void setHeritage_long(double heritage_long) {
        this.heritage_long = heritage_long;
    }

    public String getHeritage_title() {
        return heritage_title;
    }

    public void setHeritage_title(String heritage_title) {
        this.heritage_title = heritage_title;
    }
    public GetDataAdapter( int type ,int static_heritage_photo,String static_heritage_title) {
        this.type = type;
        this.static_heritage_title = static_heritage_title;
        this.static_heritage_photo=static_heritage_photo;
    }
    int hiking_photo;
    String hiking_header;
    String hike_name;
    String hike_startend;
    String hike_duration;
    String hike_altitude;
    String hike_time;
    String hike_price;
    String hike_highlights;
    String hike_photo;
    double hike_latitude;
    double hike_longitude;
    public GetDataAdapter(String hiking_header, int hiking_photo, int type) {
        this.hiking_photo = hiking_photo;
        this.hiking_header = hiking_header;
        this.type=type;
    }
    public int getHiking_photo() {
        return hiking_photo;
    }

    public void setHiking_photo(int hiking_photo) {
        this.hiking_photo = hiking_photo;
    }

    public String getHiking_header() {
        return hiking_header;
    }

    public void setHiking_header(String hiking_header) {
        this.hiking_header = hiking_header;
    }

    public String getHike_name() {
        return hike_name;
    }

    public void setHike_name(String hike_name) {
        this.hike_name = hike_name;
    }

    public String getHike_startend() {
        return hike_startend;
    }

    public void setHike_startend(String hike_startend) {
        this.hike_startend = hike_startend;
    }

    public String getHike_duration() {
        return hike_duration;
    }

    public void setHike_duration(String hike_duration) {
        this.hike_duration = hike_duration;
    }

    public String getHike_altitude() {
        return hike_altitude;
    }

    public void setHike_altitude(String hike_altitude) {
        this.hike_altitude = hike_altitude;
    }

    public String getHike_time() {
        return hike_time;
    }

    public void setHike_time(String hike_time) {
        this.hike_time = hike_time;
    }

    public String getHike_price() {
        return hike_price;
    }

    public void setHike_price(String hike_price) {
        this.hike_price = hike_price;
    }

    public String getHike_highlights() {
        return hike_highlights;
    }

    public void setHike_highlights(String hike_highlights) {
        this.hike_highlights = hike_highlights;
    }

    public String getHike_photo() {
        return hike_photo;
    }

    public void setHike_photo(String hike_photo) {
        this.hike_photo = hike_photo;
    }

    public double getHike_latitude() {
        return hike_latitude;
    }

    public void setHike_latitude(double hike_latitude) {
        this.hike_latitude = hike_latitude;
    }

    public double getHike_longitude() {
        return hike_longitude;
    }

    public void setHike_longitude(double hike_longitude) {
        this.hike_longitude = hike_longitude;
    }
    String itemName;
    String subitemName;
    String nepalifont;
    public GetDataAdapter(int type, String itemName, String subitemName) {
        this.type = type;
        this.itemName = itemName;
        this.subitemName = subitemName;
    }

//    public GetDataAdapter(int type, String itemName, String subitemName, String nepalifont) {
//        this.type = type;
//        this.itemName = itemName;
//        this.subitemName = subitemName;
//        this.nepalifont = nepalifont;
//    }

    String phrase_header_title;
    String phrase_child_title;
    String phrase_nepali;
    int phrasebook_type;
    public List<GetDataAdapter> invisibleChildren;
    String phrase_english;
    int icon;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
// public GetDataAdapter() {
    //}
public GetDataAdapter(int type, String itemName, String subitemName, int icon) {
    this.type = type;
    this.itemName = itemName;
    this.subitemName = subitemName;
    this.icon = icon;
}
    public GetDataAdapter(int type, String phrase_header_title) {
        this.type = type;
        this.phrase_header_title = phrase_header_title;
    }
    public GetDataAdapter(int type, String phrase_child_title, String phrase_english, String phrase_nepali , int icon) {
        this.type = type;
        this.phrase_child_title = phrase_child_title;
        this.phrase_nepali = phrase_nepali;
        this.phrase_english = phrase_english;
        this.icon = icon;
    }

    public GetDataAdapter(int type, String phrase_child_title, String phrase_english, String phrase_nepali) {
        this.type = type;
        this.phrase_child_title = phrase_child_title;
        this.phrase_nepali = phrase_nepali;
        this.phrase_english = phrase_english;
    }

    public String getPhrase_header_title() {
        return phrase_header_title;
    }

    public String getPhrase_child_title() {
        return phrase_child_title;
    }

    public String getPhrase_nepali() {
        return phrase_nepali;
    }

    public int getPhrasebook_type() {
        return phrasebook_type;
    }

    public String getPhrase_english() {
        return phrase_english;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSubitemName() {
        return subitemName;
    }

    public void setSubitemName(String subitemName) {
        this.subitemName = subitemName;
    }

    public String getNepalifont() {
        return nepalifont;
    }

    public void setNepalifont(String nepalifont) {
        this.nepalifont = nepalifont;
    }


    String popular_name;
    String popular_address;
    String popular_category;
    String popular_image;
    String popular_description;
    int popularposition;

    String pop_name;
    String pop_des;
    String pop_photo;

    public String getPop_name() {
        return pop_name;
    }

    public void setPop_name(String pop_name) {
        this.pop_name = pop_name;
    }

    public String getPop_des() {
        return pop_des;
    }

    public void setPop_des(String pop_des) {
        this.pop_des = pop_des;
    }

    public String getPop_photo() {
        return pop_photo;
    }

    public void setPop_photo(String pop_photo) {
        this.pop_photo = pop_photo;
    }

    public int getPopularposition() {
        return popularposition;
    }

    public void setPopularposition(int popularposition) {
        this.popularposition = popularposition;
    }

    public String getPopular_name() {
        return popular_name;
    }

    public void setPopular_name(String popular_name) {
        this.popular_name = popular_name;
    }

    public String getPopular_address() {
        return popular_address;
    }

    public void setPopular_address(String popular_address) {
        this.popular_address = popular_address;
    }

    public String getPopular_category() {
        return popular_category;
    }

    public void setPopular_category(String popular_category) {
        this.popular_category = popular_category;
    }

    public String getPopular_description() {
        return popular_description;
    }

    public void setPopular_description(String popular_description) {
        this.popular_description = popular_description;
    }

    public String getPopular_image() {
        return popular_image;
    }

    public void setPopular_image(String popular_image) {
        this.popular_image = popular_image;
    }


    String adventure_name;
    String adventure_description;
    String adventure_photo;

    public String getAdventure_name() {
        return adventure_name;
    }

    public void setAdventure_name(String adventure_name) {
        this.adventure_name = adventure_name;
    }

    public String getAdventure_description() {
        return adventure_description;
    }

    public void setAdventure_description(String adventure_description) {
        this.adventure_description = adventure_description;
    }

    public String getAdventure_photo() {
        return adventure_photo;
    }

    public void setAdventure_photo(String adventure_photo) {
        this.adventure_photo = adventure_photo;
    }



}

