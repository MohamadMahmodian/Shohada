package com.example.shohada;

import android.content.Context;
import android.os.StrictMode;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dorsa on 10/16/2018.
 */

public class Connection {

    public int setConnectionTimeout = 0;
    public int setSoTimeout = 0;
    private String url = null;
    private Context context = null;

    public Connection(Context Context, String URL) {
        url = URL;
        context = Context;
    }

    public response_structure Sync_PostData(Map<String, String> params) throws Exception {

        String responseJSON = "";
        response_structure data = null;
        try {
            HttpParams my_httpParams = new BasicHttpParams();
            if (setConnectionTimeout == 0)
                setConnectionTimeout = 10000;
            if (setSoTimeout == 0)
                setSoTimeout = 20000;
            HttpConnectionParams.setConnectionTimeout(my_httpParams, setConnectionTimeout);
            HttpConnectionParams.setSoTimeout(my_httpParams, setSoTimeout);

            //DefaultHttpClient httpclient = new DefaultHttpClient(my_httpParams);
            HttpClient httpclient = new DefaultHttpClient(my_httpParams);
            HttpPost httppost = new HttpPost(url);

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            for (Map.Entry<String, String> entry : params.entrySet()) {
                nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }

            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            HttpResponse response = httpclient.execute(httppost);
            responseJSON = EntityUtils.toString(response.getEntity(), "UTF-8");


            data = new Gson().fromJson(responseJSON, response_structure.class);

        }catch (JsonSyntaxException e){
            throw new JsonSyntaxException("اطلاعات دریافتی از سرور قابل پردازش نمی باشد" + "\n Response : " + responseJSON);
        }catch (Exception e){
            throw new Exception(e.getMessage() + "\n Response : " + responseJSON);
        }

        return data;

    }


    public static class response_structure {

        public String result;
        public Object data;

    }

}