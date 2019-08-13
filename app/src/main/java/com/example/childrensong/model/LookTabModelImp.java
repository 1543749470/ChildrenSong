package com.example.childrensong.model;

import android.util.Log;

import com.example.childrensong.Beans.TabHandpickBeans;
import com.example.childrensong.R;
import com.example.childrensong.http.Globle;
import com.example.childrensong.http.HttpManager;
import com.example.childrensong.http.MyServer;
import com.example.childrensong.utils.LookTabInterface;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LookTabModelImp implements LookTabInterface.LookTabModel {
    private static final String TAG = "LookTabModelImp";

    @Override
    public void getData(int id, final CallBack callBack) {
//        HttpManager.getInstance().getServer(MyServer.class)
//                .getTabHandpick("api/v1/album_categories?offset=0&limit=100&addition_album_count=20&channel=new")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<TabHandpickBeans>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.e(TAG, "onSubscribe: ");
//                    }
//
//                    @Override
//                    public void onNext(TabHandpickBeans tabHandpickBeans) {
//                        Log.e(TAG, "onNext: "+tabHandpickBeans );
//                        callBack.getlooktabSuccess(tabHandpickBeans.getData());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError: "+e.getMessage() );
//                        callBack.getlooktabFiladle(e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.e(TAG, "onComplete: " );
//                    }
//                });
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Globle.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        myServer.getTabHandpick("api/v1/album_categories?offset=0&limit=100&addition_album_count=20&channel=new").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TabHandpickBeans>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "onSubscribe: " );
                    }

                    @Override
                    public void onNext(TabHandpickBeans tabHandpickBeans) {
                        Log.e(TAG, "onNext: "+tabHandpickBeans.getData() );
                        callBack.getlooktabSuccess(tabHandpickBeans.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " );
                        callBack.getlooktabFiladle(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: " );
                    }
                });


    }

}
