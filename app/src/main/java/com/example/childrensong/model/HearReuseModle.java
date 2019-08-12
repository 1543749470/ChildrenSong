package com.example.childrensong.model;

import com.example.childrensong.Beans.HearFuYongBean;
import com.example.childrensong.http.HttpManager;
import com.example.childrensong.http.MyServer;
import com.example.childrensong.utils.MainContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HearReuseModle implements MainContract.MainModle {


    @Override
    public void getData(final CallBack callBack) {
        HttpManager.getInstance().getServer(MyServer.class)
                .getHearList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HearFuYongBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HearFuYongBean hearFuYongBean) {
                        callBack.showSuccess(hearFuYongBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.showError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
