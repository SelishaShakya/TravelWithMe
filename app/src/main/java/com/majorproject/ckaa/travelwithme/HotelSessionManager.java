package com.majorproject.ckaa.travelwithme;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by ckaa on 8/26/2016.
 */
public class HotelSessionManager {

    private static String TAG = HotelSessionManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences hpref;

    SharedPreferences.Editor heditor;
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME ="HotelDetails";

    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";

    public HotelSessionManager(Context context) {
        this._context = context;
        hpref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        heditor = hpref.edit();
    }

    public void setHotelLogin(boolean isLoggedIn) {

        heditor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);

        // commit changes
                heditor.commit();

        Log.d(TAG, "User hotel session modified!");
    }

    public boolean isHotelLoggedIn(){
        return hpref.getBoolean(KEY_IS_LOGGEDIN, false);
    }





}
