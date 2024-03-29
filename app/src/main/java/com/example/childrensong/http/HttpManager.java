package com.example.childrensong.http;

import android.util.Log;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {

    private static volatile HttpManager httpManager;

    public HttpManager() {
    }
    public static HttpManager getInstance(){
        if (httpManager==null){
            synchronized (HttpManager.class){
                if (httpManager==null){
                    httpManager=new HttpManager();
                }
            }
        }
        return httpManager;
    }

    private Retrofit getRetrofit(){
//        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(new ReceiveCookiesInterceptor())
//                .build();
//        OkHttpClient client1 = new OkHttpClient.Builder()
//                .addInterceptor(new AddCookiesInterceptor())
//                .build();
        return new Retrofit.Builder()
                .baseUrl(Globle.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkhttpClient())
//                .client(client)
//                .client(client1)
                .build();
    }
    public <T> T getServer(Class<T> tClass){
        return getRetrofit().create(tClass);
    }
    private OkHttpClient getOkhttpClient() {
         //日志过滤器
                 HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                     @Override
                     public void log(String message) {
                         try {
                             String text = URLDecoder.decode(message, "utf-8");
                             Log.e("OKHttp1-----", text);
                         } catch (UnsupportedEncodingException e) {
                             e.printStackTrace();
                             Log.e("OKHttp2-----", message);
                         }
                     }
                 });
                 httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                //指定缓存的路径
        Cache cache = new Cache(new File(MyApp.getInstance().getCacheDir(), "Cache1"), 1024 * 1024 * 10);
        MyCacheinterceptor myCacheinterceptor = new MyCacheinterceptor();
        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                //失败自动重连
                .retryOnConnectionFailure(true)
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .addInterceptor(myCacheinterceptor)
                .addNetworkInterceptor(myCacheinterceptor)
                .build();


    }
    //post不可以做缓存
    private class MyCacheinterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            //这里就是说判读我们的网络条件，要是有网络的话我么就直接获取网络上面的数据，要是没有网络的话我么就去缓存里面取数据
            if (!HttpUtils.isNetWorkAvailable(MyApp.getInstance())){
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();

            }
            //利用拦截器发送出去
            Response proceed = chain.proceed(request);
            if (HttpUtils.isNetWorkAvailable(MyApp.getInstance())){
                int MaxAge=0;

                return proceed.newBuilder()
                        // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                        .removeHeader("Pragma")
                        .header("Cache-Control","public ,max-age="+MaxAge)
                        .build();
            }else{
                int MaxStale=15;
                return proceed.newBuilder()
                        // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                        .removeHeader("Pragma")
                        .header("Cache-Control","public ,max-age="+MaxStale)
                        .build();

            }
        }
    }
}
