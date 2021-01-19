package com.leonestudios.puppiesgram.RestApi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IEndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<ContactoResponse> getRecentMedia();
}