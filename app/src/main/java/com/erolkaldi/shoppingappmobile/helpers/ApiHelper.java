package com.erolkaldi.shoppingappmobile.helpers;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.RequestQueue;

import java.util.HashMap;
import java.util.Map;

public class ApiHelper extends Application {
    private SharedPreferences shared;
    private SharedPreferences.Editor editor;
    private RequestQueue queue;
    private Context context;
    public ApiHelper(Context ctx){
        shared=ctx.getSharedPreferences("shoppingapp",Context.MODE_PRIVATE);
        editor= shared.edit();
        this.context=ctx;
    }
    public String getString(String name){
        return shared.getString(name,"");
    }

    public String getUrl(){
        return "http://192.168.40.94:6000/api/";
    }

    public void setSharedString(String name,String value){
        editor.putString(name, value);
        editor.commit();
    }
    public Integer getInt(String name){
        return shared.getInt(name,0);
    }
    public void setSharedInt(String name,Integer value){
        editor.putInt(name, value);
        editor.commit();
    }
    public boolean getBoolean(String name){
        return shared.getBoolean(name,false);
    }
    public void setSharedBoolean(String name,boolean value){
        editor.putBoolean(name, value);
        editor.commit();
    }
    public Map<String, String> setHeaders() {
        Map<String, String> params = new HashMap<String,String>();
        params.put("Content-Type", "application/json; charset=UTF-8");
        params.put("Authorization", shared.getString("token",""));
        return params;
    }

}
