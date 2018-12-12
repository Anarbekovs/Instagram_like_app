package com.syezdsultanov.instagram_like_app.data.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.syezdsultanov.instagram_like_app.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

    public <S> S createService(Class<S> serviceClass) {
        return new Retrofit.Builder()
                .baseUrl("https://api.instagram.com/v1/users/self/media/recent/?access_token=9627004388.3b23537.c05a60d0106a4c53a32fd6814b64edb8")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getClient()).build().create(serviceClass);
    }

    private OkHttpClient getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel((BuildConfig.DEBUG) ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }
}
