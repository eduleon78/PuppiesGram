package com.leonestudios.puppiesgram.RestApi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class EndpointsApi {
    @FormUrlEncoded
    @POST(value = ConstantesRestApi.PATH_TOKEN)
    Call<ModeloRespuesta> registrarToken(@Field("token") String token) {
        return null;
    }

    @GET(ConstantesRestApi.PATH_TOKEN)
    public Call<ModeloRespuesta> darToque(@Field("id") String id, @Field("receptor") String receptor) {
        return null;
    }

    public android.telecom.Call getRecentMedia() {
        return null;
    }
}
