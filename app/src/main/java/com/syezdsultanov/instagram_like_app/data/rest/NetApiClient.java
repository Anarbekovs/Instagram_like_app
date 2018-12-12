package com.syezdsultanov.instagram_like_app.data.rest;

import com.syezdsultanov.instagram_like_app.data.Endpoints;
import com.syezdsultanov.instagram_like_app.data.Image;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NetApiClient {

    private static final NetApiClient ourInstance = new NetApiClient();

    public static NetApiClient getInstance() {
        return ourInstance;
    }

    private Endpoints netApi = new com.syezdsultanov.instagram_like_app.data.rest.ServiceGenerator().createService(Endpoints.class);

    private NetApiClient() {
    }

    public Observable<List<Image>> getReps() {
        return netApi.getImages()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
