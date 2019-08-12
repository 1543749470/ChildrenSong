package com.example.childrensong.utils;

import com.example.childrensong.Beans.PartnerBeans;
import com.example.childrensong.Beans.TabHandpickBeans;

import java.util.List;

public interface PartnerInterface {
    interface PartnerView  {
        void getlookSuccess(List<PartnerBeans.DataBean> albumsBeans);
        void getlookFiladle(String error);
    }
    interface PartnerPresenter{
        void getHttp();
    }
    interface PartnerModel{
        interface CallBack{
            void getlookSuccess(List<PartnerBeans.DataBean> albumsBeans);
            void getlookFiladle(String error);
        }
        void getData( CallBack callBack);
    }
}
