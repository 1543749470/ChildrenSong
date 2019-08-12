package com.example.childrensong.utils;


public interface MainContract {

    interface MainView<T>{

        void showSuccesses(T t);

        void showError(String error);
    }

    interface MainPresenter{
        void http();
    }
    interface MainModle{
        interface CallBack<T>{
            void showSuccess(T t);
            void showError(String error);
        }
        void getData(CallBack callBack);
    }

    interface MainPresenterKnow{
        void http(int id);
    }

    interface MainModleKnow{
        interface CallBack<T>{
            void showSuccess(T t);
            void showError(String error);
        }
        void getData(CallBack callBack, int id);
    }

}
