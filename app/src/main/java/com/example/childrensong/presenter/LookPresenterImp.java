package com.example.childrensong.presenter;

import com.example.childrensong.Beans.HandPickBean;
import com.example.childrensong.base.BasePresenter;
import com.example.childrensong.model.LookModelImp;
import com.example.childrensong.utils.LookInterface;

import java.util.List;

public class LookPresenterImp <V extends LookInterface.LookView> extends BasePresenter<LookInterface.LookView> implements LookInterface.LookPresenter {
    private LookModelImp lookModelImp=new LookModelImp();
    @Override
    public void getHttp(int id) {
        if (mView!=null){
            lookModelImp.getData(id, new LookInterface.LookModel.CallBack() {
                @Override
                public void getlookSuccess(List<HandPickBean.DataBean> handPickBeans) {
                    mView.getlookSuccess(handPickBeans);
                }

                @Override
                public void getlookFiladle(String error) {
                    mView.getlookFiladle(error);
                }
            });
        }

    }
}
