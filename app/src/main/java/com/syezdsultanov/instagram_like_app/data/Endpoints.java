package com.syezdsultanov.instagram_like_app.data;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Endpoints {

@GET(".")
Observable<List<Image>> getImages();
}
