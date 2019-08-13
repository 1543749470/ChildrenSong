package com.example.childrensong.utils;

import com.example.childrensong.Beans.HandpickImageBeans;
import com.example.childrensong.Beans.JIngxuanBeans;

import java.util.List;

public interface JingXuanInterface {
    interface JingXuanView{
        void gettwoSuccess(List<HandpickImageBeans.DataBean> handPickBeans);
        void getitemSuccess(List<JIngxuanBeans.DataBean> handPickBeans);
        void getitemFiladle(String error);
    }
    interface JingXuanPresenter{
        void getHttp(int id);
    }
    interface JingXuanModel{
        interface CallBack{
            void gettwoSuccess(List<HandpickImageBeans.DataBean> handPickBeans);
            void getitemSuccess(List<JIngxuanBeans.DataBean> handPickBeans);
            void getitemFiladle(String error);
        }
        void getData(int id,CallBack callBack);
    }
}
