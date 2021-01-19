package com.leonestudios.puppiesgram;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.leonestudios.puppiesgram.RestApi.Adaptador;
import com.leonestudios.puppiesgram.RestApi.EndpointsApi;

public class DarToque extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String id = "1,2,3";
        String receptor = "";
        Adaptador RestApiAdaptador = new Adaptador();
        EndpointsApi endpoints = RestApiAdaptador.establecerConexionRestApi();


    }
}
