package com.example.childrensong.http;

import com.example.childrensong.Beans.HandPickBean;
import com.example.childrensong.Beans.HandpickImageBeans;
import com.example.childrensong.Beans.JIngxuanBeans;
import com.example.childrensong.Beans.TabHandpickBeans;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MyServer {
    @GET
    Observable<HandPickBean> gethandPick(@Url String url);






    //tab栏
    @GET
    Observable<TabHandpickBeans> getTabHandpick(@Url String url);



    //精选布局2
    @GET
    Observable<HandpickImageBeans> getJingXuanTwo(@Url String url);

    //精选item
    @GET
    Observable<JIngxuanBeans> getJingXuanItem(@Url String url);

}
