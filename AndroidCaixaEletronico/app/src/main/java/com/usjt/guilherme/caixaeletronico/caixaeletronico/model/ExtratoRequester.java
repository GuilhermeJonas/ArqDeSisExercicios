package com.usjt.guilherme.caixaeletronico.caixaeletronico.model;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by jonas_000 on 05/11/2016.
 */
public class ExtratoRequester {
    public boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
