package com.example.childrensong.http;

import com.example.childrensong.Beans.HandPickBean;
<<<<<<< HEAD
import com.example.childrensong.Beans.HandpickImageBeans;
import com.example.childrensong.Beans.JIngxuanBeans;
import com.example.childrensong.Beans.TabHandpickBeans;
=======
import com.example.childrensong.Beans.HearBean;
import com.example.childrensong.Beans.HearFuYongBean;
>>>>>>> 94c9bc13ef91184506db07bccfa32a7a5608176c

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MyServer {
    @GET
    Observable<HandPickBean> gethandPick(@Url String url);




<<<<<<< HEAD


    //tab栏
    @GET
    Observable<TabHandpickBeans> getTabHandpick(@Url String url);



    //精选布局2
    @GET
    Observable<HandpickImageBeans> getJingXuanTwo(@Url String url);

    //精选item
    @GET
    Observable<JIngxuanBeans> getJingXuanItem(@Url String url);

=======
    @GET("api/v1/audio_categories?channel=original")
    Observable<HearBean>   getHearDate();


    @GET("api/v1/audio_categories/1/playlists?channel=new&offset=0&limit=20")
    Observable<HearFuYongBean>   getHearList();



>>>>>>> 94c9bc13ef91184506db07bccfa32a7a5608176c
}
