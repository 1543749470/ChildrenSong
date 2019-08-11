package com.example.childrensong.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class BaseActivity<V,P extends BasePresenter<V>>extends SimpleActivity {
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
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }
}
