package rs.co.sbb.sbbworkorders.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
/**
 * Created by Predrag.Tasic on 6/6/2017.
 */

public class SaveSharedPreference {

    static final String ID = "id";
    static final String USER = "user";

    public static SharedPreferences getSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setId(Context context, String id){

        SharedPreferences.Editor editor = getSharedPreferences(context).edit();

        editor.putString(ID, id);

        editor.commit();
    }


    public static void setUser(Context context, String user){

        SharedPreferences.Editor editor = getSharedPreferences(context).edit();

        editor.putString(USER, user);

        editor.commit();
    }

    public static String getId(Context context){
        return getSharedPreferences(context).getString(ID,"");
    }

    public static String getUser(Context context){
        return getSharedPreferences(context).getString(USER,"");
    }
}
