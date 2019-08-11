package com.example.childrensong.model;

import android.util.Log;

import com.example.childrensong.Beans.HandPickBean;
import com.example.childrensong.http.HttpManager;
import com.example.childrensong.http.MyServer;
import com.example.childrensong.utils.LookInterface;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LookModelImp implements LookInterface.LookModel {
    private static final String TAG = "LookModelImp";
    @Override
    public void getData(int id, final CallBack callBack) {
        HttpManager.getInstance().getServer(MyServer.class)
                .gethandPick("api/v1/album_categories/"+id+"/albums?channel=new&offset=0&limit=20&sensitive=8")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HandPickBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "onSubscribe: " );
                    }

                    @Override
                    public void onNext(HandPickBean handPickBean) {
                        Log.e(TAG, "onNext: "+handPickBean );
                        callBack.getlookSuccess(handPickBean.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.getMessage() );
                        callBack.getlookFiladle(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: " );
                    }
                });
    }
}
