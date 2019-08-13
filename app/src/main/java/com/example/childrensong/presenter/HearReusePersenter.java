package com.example.childrensong.presenter;

import com.example.childrensong.Beans.HearFuYongBean;
import com.example.childrensong.base.BasePresenter;
import com.example.childrensong.fragments.Hear.ReuseFragment;
import com.example.childrensong.model.HearReuseModle;
import com.example.childrensong.utils.LookInterface;
import com.example.childrensong.utils.MainContract;


public class HearReusePersenter extends BasePresenter<ReuseFragment> implements MainContract.MainPresenter {

    @Override
    public void http() {
        HearReuseModle hearReuseModle = new HearReuseModle();
        hearReuseModle.getData(new MainContract.MainModle.CallBack<HearFuYongBean>() {
            @Override
            public void showSuccess(HearFuYongBean hearFuYongBean) {
                mView.showSuccesses(hearFuYongBean);
            }

            @Override
            public void showError(String error) {
                mView.showError(error);
            }
        });

    }
}
