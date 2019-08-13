package com.example.childrensong.presenter;

import com.example.childrensong.Beans.TabHandpickBeans;
import com.example.childrensong.base.BasePresenter;
import com.example.childrensong.model.LookTabModelImp;
import com.example.childrensong.utils.LookTabInterface;

import java.util.List;

public class LookTabPresenterImp<V extends LookTabInterface.LookTabView> extends BasePresenter<LookTabInterface.LookTabView> implements LookTabInterface.LookTabPresenter {
    private LookTabModelImp lookTabModelImp = new LookTabModelImp();
    @Override
    public void getHttp(int id) {
        if (mView!=null){
            lookTabModelImp.getData(id, new LookTabInterface.LookTabModel.CallBack() {
                @Override
                public void getlooktabSuccess(List<TabHandpickBeans.DataBean> albumsBeans) {
                    mView.getlooktabSuccess(albumsBeans);
                }

                @Override
                public void getlooktabFiladle(String error) {
                    mView.getlooktabFiladle(error);
                }
            });
        }
    }
}
