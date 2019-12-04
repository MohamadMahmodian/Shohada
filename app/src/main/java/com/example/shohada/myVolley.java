package com.example.shohada;

import android.content.Context;
import android.content.Intent;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.util.HashMap;
import java.util.Map;

import ir.android_studio.ati_school_student.Class.Exception.GoToLogin_Exception;
import ir.android_studio.ati_school_student.Class.InterfaceProject.iii;
import ir.android_studio.ati_school_student.new_ui.Main2Activity;

/**
 * Created by dorsa on 10/16/2018.
 */

public class myVolley implements com.android.volley.Response.ErrorListener,com.android.volley.Response.Listener<String> {

    Context context;

    public myVolley(final Context Context, String User__id, final Map<String, String> Params) {

        context = Context;
        RequestQueue mRequestQueue = com.android.volley.toolbox.Volley.newRequestQueue(Context);
        StringRequest mStringRequest = new StringRequest(Request.Method.POST, MCS.getAPIServerAddress(Context, User__id), this, this) {
            @Override
            protected Map<String, String> getParams() {

                return Params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };

        mRequestQueue.add(mStringRequest);

    }

    public myVolley(final Context Context, String URL, String _______, final Map<String, String> Params) {

        context = Context;
        RequestQueue mRequestQueue = com.android.volley.toolbox.Volley.newRequestQueue(Context);
        StringRequest mStringRequest = new StringRequest(Request.Method.POST, URL, this, this) {
            @Override
            protected Map<String, String> getParams() {

                return Params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };

        mStringRequest.setRetryPolicy(new DefaultRetryPolicy(
                50000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        mRequestQueue.add(mStringRequest);


    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(String response) {


        iii.info_student info_student = null;
        SHP_General shp_general = new SHP_General(context);

        try {
            Connection.response_structure jsonObj = new Gson().fromJson(response, Connection.response_structure.class);
            String result = jsonObj.result;
            Object data = jsonObj.data;



            if (!result.equals("ok")) {

                if (((LinkedTreeMap) data).containsKey("exception")) {

                    String session_id = ((LinkedTreeMap) data).get("session_id").toString();
                    info_student =  shp_general.get_user(session_id);

                    if (((LinkedTreeMap) data).get("exception").toString().equals("Expire_Exception")) {


                        //<editor-fold desc="Agen Login">
                        String url =  MCS.getServerLoginAddress(context,info_student.Active_User__Id);
                        iii.retLogin_Sync retLogin_Sync = Login.Login_Sync(context,url,MCS.getCurrent_Version(context),info_student.Login_UserName,info_student.Login_Password);

                        //<editor-fold desc="update_general">
                        shp_general.update_user(retLogin_Sync.Active_User_Session,retLogin_Sync.Active_User_Name,
                                retLogin_Sync.Active_User_Family,retLogin_Sync.Active_User__Id,retLogin_Sync.Pattern,retLogin_Sync.User_Type);
                        //</editor-fold>

                        //Login.Login_ASync(context, MCS.SharedPreferences(context, info_student.Active_User__Id));
                        //</editor-fold>

                    } else if (((LinkedTreeMap) data).get("exception").toString().equals("User_Not_Active_Exception")) {

                        shp_general.delete_student(info_student.Active_User__Id);

                        //<editor-fold desc="Clear Information SharedPreferences">
                        MCS.SharedPreferences(context,info_student.Active_User__Id).edit().clear().apply();
                        //</editor-fold>

                        //<editor-fold desc="Open MainActivity And After EXIT_APP">
                        Intent intent = new Intent(context, Main2Activity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("EXIT_APP", true);
                        context.startActivity(intent);
                        //</editor-fold>

                    }
                }
            }
        } catch (GoToLogin_Exception e) {

            //<editor-fold desc="Clear Information SharedPreferences">

            shp_general.delete_student(info_student.Active_User__Id);

            //<editor-fold desc="Clear Information SharedPreferences">
            MCS.SharedPreferences(context,info_student.Active_User__Id).edit().clear().apply();
            //</editor-fold>

            //</editor-fold>

            //<editor-fold desc="Open MainActivity And After EXIT_APP">
            Intent intent = new Intent(context, Main2Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT_APP", true);
            context.startActivity(intent);
            //</editor-fold>
        } catch (Exception e) {

        }
    }
}