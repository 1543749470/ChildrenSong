package com.example.childrensong.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class BaseFragment<V,P extends BasePresenter<V>>extends SimpleFragment {
        public P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter=createPresenter();
        super.onCreate(savedInstanceState);
        if (mPresenter!=null){
            mPresenter.attach((V) this);
        }
    }

    protected abstract P createPresenter();
    public void showProgressBar(){}
    public void hideProgressBar(){}

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }
}
