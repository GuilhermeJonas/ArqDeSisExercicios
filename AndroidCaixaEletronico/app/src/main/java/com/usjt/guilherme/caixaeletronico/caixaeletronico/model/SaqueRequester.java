package com.usjt.guilherme.caixaeletronico.caixaeletronico.model;

import android.content.Context;
import android.net.ConnectivityManager;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by jonas_000 on 06/11/2016.
 */
public class SaqueRequester {
    OkHttpClient client = new OkHttpClient();

    public boolean post (String url, JSONObject json) throws IOException {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        FormBody.Builder formBody = new FormBody.Builder();
        RequestBody body = null;
        boolean resposta;
        System.out.println(url);
        try {
             body = RequestBody.create(JSON,json.toString());
            body.toString();

           } catch (Exception e) {
            e.printStackTrace();
        }
        //formBody.add("body",sb.toString());

        System.out.println("formBody: "+formBody.toString());
        //Request request = new Request.Builder().url(url).post(formBody).build();

        Request request = new Request.Builder().url(url).post(body).build();

        System.out.println("request: "+request);
        Response response = client.newCall(request).execute();
        resposta = response.isSuccessful();
        System.out.println(response);
        return resposta;
    }
    public boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isConnected();
    }

}
