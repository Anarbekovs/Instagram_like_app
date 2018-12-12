package com.syezdsultanov.instagram_like_app.presenter;

import com.arellomobile.mvp.MvpView;

public interface UserView extends MvpView {
    void setName(String name);

    void setImage(String imageUrl);

    void showError(Throwable e);

    void startLoad();

    void finishLoad();
}
