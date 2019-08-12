package com.example.childrensong.utils;

import com.example.childrensong.Beans.TabHandpickBeans;

import java.util.List;

public interface LookTabInterface {
    interface LookTabView  {
        void getlooktabSuccess(List<TabHandpickBeans.DataBean> albumsBeans);
        void getlooktabFiladle(String error);
    }
    interface LookTabPresenter{
        void getHttp(int id);
    }
    interface LookTabModel{
        interface CallBack{
            void getlooktabSuccess(List<TabHandpickBeans.DataBean> albumsBeans);
            void getlooktabFiladle(String error);
        }
        void getData(int id, CallBack callBack);
    }
}
