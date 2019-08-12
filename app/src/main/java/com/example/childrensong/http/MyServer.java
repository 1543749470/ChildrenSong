package com.example.childrensong.http;

import com.example.childrensong.Beans.HandPickBean;
import com.example.childrensong.Beans.HearBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MyServer {
    @GET
    Observable<HandPickBean> gethandPick(@Url String url);




    @GET("api/v1/audio_categories?channel=original")
    Observable<HearBean>   getHearDate();

}
