package com.example.childrensong.presenter;

import com.example.childrensong.Beans.HandpickImageBeans;
import com.example.childrensong.Beans.JIngxuanBeans;
import com.example.childrensong.base.BasePresenter;
import com.example.childrensong.model.JingXuanModelImp;
import com.example.childrensong.utils.JingXuanInterface;

import java.util.List;

public class JingXuanPresenterImp <V extends JingXuanInterface.JingXuanView> extends BasePresenter<JingXuanInterface.JingXuanView> implements JingXuanInterface.JingXuanPresenter {
    private JingXuanModelImp jingXuanModelImp = new JingXuanModelImp();
    @Override
    public void getHttp(int id) {
        if (mView!=null){
            jingXuanModelImp.getData(id, new JingXuanInterface.JingXuanModel.CallBack() {
                @Override
                public void gettwoSuccess(List<HandpickImageBeans.DataBean> handPickBeans) {
                    mView.gettwoSuccess(handPickBeans);
                }

                @Override
                public void getitemSuccess(List<JIngxuanBeans.DataBean> handPickBeans) {
                    mView.getitemSuccess(handPickBeans);
                }

                @Override
                public void getitemFiladle(String error) {
                    mView.getitemFiladle(error);
                }
            });
        }
    }
}
