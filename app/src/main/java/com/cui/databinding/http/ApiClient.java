package com.cui.databinding.http;

import com.google.gson.Gson;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by cuiyang on 15/12/21.
 */
public final class ApiClient {

    private ApiClient() {
    }

    private static final String API_HOST = "https://api.douban.com/v2/";

    private static final Gson gson = new Gson();

    private static final Retrofit retrofit_rx = new Retrofit.Builder()
            .baseUrl(API_HOST)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();


    public static final ApiService SERVICE_rx = retrofit_rx.create(ApiService.class);
}
