package com.example.childrensong.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.childrensong.R;
import com.example.childrensong.base.SimpleFragment;

//缓存界面
public class CacheFragment extends SimpleFragment {
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
