package com.leonestudios.puppiesgram.RestApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Adaptador {
    public EndpointsApi establecerConexionRestApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.URL_Servidor)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(EndpointsApi.class);
    }

}
