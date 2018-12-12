package com.syezdsultanov.instagram_like_app.presenter;


import android.util.Log;
import android.widget.GridView;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.syezdsultanov.instagram_like_app.R;
import com.syezdsultanov.instagram_like_app.data.Image;
import com.syezdsultanov.instagram_like_app.data.rest.NetApiClient;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class UserPresenter extends MvpPresenter<UserView>
        implements Observer<List<Image>> {

    private final String ACCESS_TOKEN = "9627004388.3b23537.c05a60d0106a4c53a32fd6814b64edb8";

    @Override
    public void attachView(UserView view) {
        super.attachView(view);

        getViewState().startLoad();
        loadDate();
    }

    private void loadDate() {

        getViewState().startLoad();
        NetApiClient.getInstance().getReps()
                .subscribe(this);
    }

//    @Override
//    public void onSubscribe(Disposable d) {
//        //nope
//    }
//
//    @Override
//    public void onNext(Image image) {
//        getViewState().setImage(githubUser.getAvatar());
//        getViewState().setName(githubUser.getLogin());
//    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(List<Image> images) {
        Log.d("DTO", "size hjgkgjkg");
        Log.d("DTO", "size = " + images.size());
    }

    @Override
    public void onError(Throwable e) {
        Log.d("DTO", "size hjgkgjkg" + e);
        getViewState().showError(e);
    }

    @Override
    public void onComplete() {
        Log.d("DTO", "size hjgkgjkg");
        getViewState().finishLoad();
    }
}
