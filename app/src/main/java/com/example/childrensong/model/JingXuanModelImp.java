package com.example.childrensong.model;

import android.util.Log;

import com.example.childrensong.Beans.HandpickImageBeans;
import com.example.childrensong.Beans.JIngxuanBeans;
import com.example.childrensong.http.Globle;
import com.example.childrensong.http.HttpManager;
import com.example.childrensong.http.MyServer;
import com.example.childrensong.utils.JingXuanInterface;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class JingXuanModelImp implements JingXuanInterface.JingXuanModel {
    private static final String TAG = "JingXuanModelImp";
    @Override
    public void getData(int id, final CallBack callBack) {
        //精选第二个布局的八张图片
        Retrofit build = new Retrofit.Builder()
                .baseUrl(Globle.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        build.create(MyServer.class)
                .getJingXuanTwo("api/v1/albums/home_recommended?channel=new&offset=0&limit=16")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HandpickImageBeans>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "onSubscribe: " );
                    }

                    @Override
                    public void onNext(HandpickImageBeans handpickImageBeans) {
                        Log.e(TAG, "onNext: "+handpickImageBeans.getData() );
                        callBack.gettwoSuccess(handpickImageBeans.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " );
                        callBack.getitemFiladle(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: " );
                    }
                });


        //精选列表数据(第三个布局)
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Globle.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofit.create(MyServer.class)
                .getJingXuanItem("api/v1/home_items?type=4&channel=new&offset=0&limit=20&sensitive=8")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JIngxuanBeans>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "onSubscribe: " );
                    }

                    @Override
                    public void onNext(JIngxuanBeans jIngxuanBeans) {
                        Log.e(TAG, "onNext: "+jIngxuanBeans.getData() );
                        callBack.getitemSuccess(jIngxuanBeans.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.getMessage() );
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: " );
                    }
                });
    }
}
