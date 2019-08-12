package com.example.childrensong.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.childrensong.Beans.HearBean;
import com.example.childrensong.R;
import com.example.childrensong.adapters.HearVpAdaper;
import com.example.childrensong.base.SimpleFragment;
import com.example.childrensong.fragments.Hear.ChoicenessFragment;
import com.example.childrensong.http.Globle;
import com.example.childrensong.http.MyServer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

//宝宝听界面
public class HearFragment extends SimpleFragment {
    @BindView(R.id.hear_table)
    TabLayout mTable;
    @BindView(R.id.hear_vp)
    ViewPager mVp;
    private ArrayList<Fragment> list;
    private FragmentManager childFragmentManager;
    private ArrayList<String> tablist;


    @Override
    protected void initView() {
        list = new ArrayList<>();
        childFragmentManager = getChildFragmentManager();
        ChoicenessFragment choicenessFragment = new ChoicenessFragment();
        list.add(choicenessFragment);
        tablist = new ArrayList<>();
        tablist.add("精选");


        initdata();
    }

    private void initdata() {
        Observable<HearBean> hearDate = new Retrofit.Builder()
                .baseUrl(Globle.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MyServer.class)
                .getHearDate();
        hearDate.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HearBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HearBean hearBean) {
                        List<HearBean.DataBean> data = hearBean.getData();
                        for (int i = 0; i < data.size(); i++) {
                            String name = data.get(i).getName();
                            tablist.add(name);
                        }

                        HearVpAdaper hearVpAdaper = new HearVpAdaper(childFragmentManager, list, tablist);
                        mVp.setAdapter(hearVpAdaper);
                        mTable.setupWithViewPager(mVp);


                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    @Override
    protected int createLayout() {
        return R.layout.hear_fragment_layout;
    }
}
