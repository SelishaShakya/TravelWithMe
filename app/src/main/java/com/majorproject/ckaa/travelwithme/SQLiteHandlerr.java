package com.majorproject.ckaa.travelwithme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ckaa on 8/21/2016.
 */
public class SQLiteHandlerr extends SQLiteOpenHelper {
    private static final String TAG = SQLiteHandlerr.class.getSimpleName();

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "travelwithme";

    // Login table name
    private static final String TABLE_Hotel = "tbl_hotels";
    // Login Table Columns names
    private static final String KEY_Id = "id";
    private static final String KEY_Name = "name";
    private static final String KEY_Address = "address";
    private static final String KEY_Rating = "rating";
    private static final String KEY_PhotoLink = "photo_link";
    private static final String KEY_HotelLatitude = "hotel_latitude";
    private static final String KEY_HotelLongitude = "hotel_longitude";
    private static final String KEY_HotelBookUrl = "hotelbook_url";
    private static final String KEY_HotelLink = "hotel_link";
    List<GetDataAdapter> GetDataAdapter1;
    GetDataAdapter GetDataAdapter2;
    public static final int Hotel = 0;
    List<GetDataAdapter> getDataAdapter;

    public SQLiteHandlerr(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_HOTEL_TABLE =" CREATE TABLE " + TABLE_Hotel + "("
                + KEY_Id + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_Name + " TEXT,"
                + KEY_Address + " TEXT," + KEY_Rating + " INTEGER,"
                + KEY_PhotoLink + " TEXT," + KEY_HotelLatitude + " DOUBLE,"+ KEY_HotelLongitude + " DOUBLE,"
                + KEY_HotelBookUrl + " TEXT," + KEY_HotelLink + " TEXT"+  ")";
        db.execSQL(CREATE_HOTEL_TABLE);

        Log.d(TAG, "Database tables created");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_Hotel);

        // Create tables again
        onCreate(db);

    }
    public void addHotel(String name, String address, Integer rating , String photo_link,Double hotel_latitude,Double hotel_longitude,String hotelbook_url , String hotel_link) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(KEY_Id,id);
        values.put(KEY_Name, name); // Name
        values.put(KEY_Address,address); // Address
        values.put(KEY_Rating, rating); // Rating
        values.put(KEY_PhotoLink, photo_link); // photolink
        values.put(KEY_HotelLatitude,hotel_latitude);
        values.put(KEY_HotelLongitude,hotel_longitude);
        values.put(KEY_HotelBookUrl,hotelbook_url);
        values.put(KEY_HotelLink,hotel_link);

        // Inserting Row
        db.insert(TABLE_Hotel, null, values);
        Log.i(TAG, "addHotel: "+hotel_link);
        Log.i(TAG, "addHotel: "+name);
        db.close(); // Closing database connection

        //Log.d(TAG, "New user inserted into sqlite: " + id)
        ;
    }

//        public  void addHotel( GetDataAdapter getDataAdapterList) {
//            SQLiteDatabase db = this.getWritableDatabase();
//
//           //this.getDataAdapter = getDataAdapterList;
//                //getDataAdapter = getDataAdapterList;
//
//                ContentValues values = new ContentValues();
//           // GetDataAdapter getData = getDataAdapter.get()
//
//            values.put(KEY_Id,"1");
//            values.put(KEY_Name, getDataAdapterList.getName());
//            values.put(KEY_Address,getDataAdapterList.getAddress()); // Address
//         values.put(KEY_Rating, getDataAdapterList.getRating()); // Rating
//        values.put(KEY_PhotoLink, getDataAdapterList.getPhoto()); // photolink
//        values.put(KEY_HotelLatitude,getDataAdapterList.getHotel_lat());
//        values.put(KEY_HotelLongitude,getDataAdapterList.getHotel_long());
//        values.put(KEY_HotelBookUrl,getDataAdapterList.getHotelbook());
//        //values.put(KEY_HotelLink,getDataAdapterList.getHotellink());
//            db.insert(TABLE_Hotel, null, values);
//        Log.d(TAG, "addHotel: "+getDataAdapterList.getName());
//        Log.d(TAG, "addHotel: "+getDataAdapterList.getHotel_lat());
//        db.close(); // Closing database connection
//w
//        //Log.d(TAG, "New user inserted into sqlite: " + id)
//
//
//        }
//





    /**
     * Getting hotel data from database
     * */
    public List<GetDataAdapter> getAllData(){
        String selectQuery = "SELECT  * FROM " + TABLE_Hotel;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        GetDataAdapter1 = new ArrayList<>();
//        String namee  = cursor.getString(1);
//        Log.i(TAG, "getAllData: "+namee);
//        // Move to first row
         cursor.moveToFirst();
      //  if (cursor.getCount() > 0) {

        do
              //  Log.i(TAG, "get: .........."+cursor.getString(1));
             // GetDataAdapter GetDataAdapter2 = new GetDataAdapter();

          {
              GetDataAdapter2 = new GetDataAdapter();
              GetDataAdapter2.setName(cursor.getString(1));
              String name = GetDataAdapter2.getName();
              Log.i(TAG, "getAllData:" + name);
              GetDataAdapter2.setAddress(cursor.getString(2));
              GetDataAdapter2.setRating(cursor.getInt(3));
              GetDataAdapter2.setPhoto(cursor.getString(4));
              GetDataAdapter2.setHotel_lat(cursor.getDouble(5));
              GetDataAdapter2.setHotel_long(cursor.getDouble(6));
              GetDataAdapter2.setHotelbook(cursor.getString(7));
             GetDataAdapter2.setHotellink(cursor.getString(8));
              GetDataAdapter2.setType(Hotel);
              Log.i(TAG, "onClick:" + cursor.getString(1));
               GetDataAdapter1.add(GetDataAdapter2);


      //}//}

    }while (cursor.moveToNext());
      //  GetDataAdapter1.add(GetDataAdapter2);
        cursor.close();
        db.close();
        // return user
   //   Log.d(TAG, "Fetching user from Sqlite: " +GetDataAdapter2.getHotel_lat());

      //  return user;


        return GetDataAdapter1;
    }
    public HashMap<String, String> getHotelDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "SELECT  * FROM " + TABLE_Hotel;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            user.put("name", cursor.getString(1));
            user.put("address", cursor.getString(2));
            user.put("rating",String.valueOf(cursor.getInt(3)));
            user.put("photo_link", cursor.getString(4));
            user.put("hotel_latitude",String.valueOf(cursor.getDouble(5)));
            user.put("hotel_longitude",String.valueOf(cursor.getDouble(6)));
            user.put("hotelbook_url",cursor.getString(7));
            user.put("hotel_link",cursor.getString(8));


        }
        cursor.close();
        db.close();
        // return user
        Log.d(TAG, "Fetching user from Sqlite: " + user.toString());

        return user;
    }


    /**
     * Re create database Delete all tables and create them again
     * */
    public void deleteHotel() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete(TABLE_Hotel, null, null);
        db.close();

        Log.d(TAG, "Deleted all user info from sqlite");
    }
}
