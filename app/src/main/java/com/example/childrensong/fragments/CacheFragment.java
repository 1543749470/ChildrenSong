package com.example.childrensong.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.childrensong.R;
import com.example.childrensong.base.SimpleFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

//缓存界面
public class CacheFragment extends SimpleFragment {

    @BindView(R.id.cacheTab)
    TabLayout cacheTab;
    @BindView(R.id.cacheVP)
    ViewPager cacheVP;
    Unbinder unbinder;

    @Override
    protected void initView() {


    }

    @Override
    protected int createLayout() {
        return R.layout.cache_fragmennt_layout;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.cache,menu);
    }
}
