package com.leonestudios.puppiesgram.adapter;

import com.leonestudios.puppiesgram.RestApi.ConstantesRestApi;
import com.leonestudios.puppiesgram.RestApi.EndpointsApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public EndpointsApi establecerConexionesRestApiInstagram(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(EndpointsApi.class);
    }
}
