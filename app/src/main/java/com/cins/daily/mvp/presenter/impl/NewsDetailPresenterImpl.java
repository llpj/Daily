package com.cins.daily.mvp.presenter.impl;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;

import com.cins.daily.mvp.entity.NewsDetail;
import com.cins.daily.mvp.interactor.NewsDetailInteractor;
import com.cins.daily.mvp.interactor.impl.NewsDetailInteractorImpl;
import com.cins.daily.mvp.presenter.NewsDetailPresenter;
import com.cins.daily.mvp.presenter.base.BasePresenterImpl;
import com.cins.daily.mvp.view.NewsDetailView;

import javax.inject.Inject;

import static android.content.Context.CLIPBOARD_SERVICE;

/**
 * Created by Eric on 2017/1/18.
 */

public class NewsDetailPresenterImpl extends BasePresenterImpl<NewsDetailView, NewsDetail>
        implements NewsDetailPresenter {

    private NewsDetailInteractor<NewsDetail> mNewsDetailInteractor;
    private String mPostId;

    @Inject
    public NewsDetailPresenterImpl(NewsDetailInteractorImpl newsDetailInteractor) {
        mNewsDetailInteractor = newsDetailInteractor;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mSubscription = mNewsDetailInteractor.loadNewsDetail(this, mPostId);
    }

    @Override
    public void success(NewsDetail data) {
        super.success(data);
        mView.setNewsDetail(data);
    }

    @Override
    public void setPosId(String postId) {
        mPostId = postId;
    }
}
