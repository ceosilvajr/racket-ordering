package com.ceosilvajr.app.onlineshoppingcart.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import com.ceosilvajr.app.onlineshoppingcart.R;
import com.ceosilvajr.app.onlineshoppingcart.objects.User;
import com.google.gson.Gson;

/**
 * Created by ceosilvajr on 8/3/15.
 */
public class UserManager {

    private static final String USER = "user";

    public static User get(Context context) {
        Gson gson = new Gson();
        Resources res = context.getResources();
        SharedPreferences myPrefs = context.getSharedPreferences(
                res.getString(R.string.package_name), 0);
        String json = myPrefs.getString(USER, "");
        return gson.fromJson(json, User.class);
    }

    public static void save(User user, Context context) {
        Gson gson = new Gson();
        Resources res = context.getResources();

        SharedPreferences myPrefs = context.getSharedPreferences(
                res.getString(R.string.package_name), 0);
        SharedPreferences.Editor e = myPrefs.edit();

        String json = gson.toJson(user);
        e.putString(USER, json);
        e.apply();

    }

    public static void delete(Context context) {
        Resources res = context.getResources();
        SharedPreferences myPrefs = context.getSharedPreferences(
                res.getString(R.string.package_name), 0);
        SharedPreferences.Editor e = myPrefs.edit();
        e.remove(USER);
        e.apply();
    }
}
