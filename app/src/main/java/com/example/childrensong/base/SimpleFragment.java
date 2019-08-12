package com.example.childrensong.base;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class SimpleFragment extends Fragment {

    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(createLayout(), null);
        bind = ButterKnife.bind(this, inflate);
        initView();
        return inflate;
    }

    protected abstract void initView();

    protected abstract int createLayout();




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (bind!=null){
            bind.unbind();
        }
    }
}
