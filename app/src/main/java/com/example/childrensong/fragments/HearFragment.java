package com.example.childrensong.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.childrensong.R;
import com.example.childrensong.base.SimpleFragment;

//宝宝听界面
public class HearFragment extends SimpleFragment {
    @Override
    protected void initView() {

    }

    @Override
    protected int createLayout() {
        return R.layout.hear_fragment_layout;
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
        getActivity().getMenuInflater().inflate(R.menu.ting_search_black,menu);
    }
}
