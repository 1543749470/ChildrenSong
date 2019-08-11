package com.example.childrensong.http;

import com.example.childrensong.Beans.HandPickBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MyServer {
    @GET
    Observable<HandPickBean> gethandPick(@Url String url);
}
