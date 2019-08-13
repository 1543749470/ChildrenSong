package com.example.childrensong.utils;

import com.example.childrensong.Beans.HandPickBean;

import java.util.List;

public interface LookInterface {
    interface LookView{

        void getlookSuccess(List<HandPickBean.DataBean> handPickBeans);
        void getlookFiladle(String error);
    }
    interface LookPresenter{
        void getHttp(int id);
    }

    interface LookModel{
        interface CallBack{
            void getlookSuccess(List<HandPickBean.DataBean> handPickBeans);
            void getlookFiladle(String error);
        }
        void getData(int id,CallBack callBack);
    }
}
