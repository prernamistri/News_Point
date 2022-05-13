package com.rajaystudios.application.newspoint;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {
private  static Retrofit retrofit = null;

    public static ApiInterface getApiinterface(){
    if(retrofit == null){
        retrofit = new Retrofit.Builder().baseUrl(ApiInterface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

    }
    return retrofit.create(ApiInterface.class);

    }

}
