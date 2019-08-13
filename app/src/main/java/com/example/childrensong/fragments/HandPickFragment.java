package com.example.childrensong.fragments;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.childrensong.Beans.HandPickBean;
import com.example.childrensong.R;
import com.example.childrensong.adapters.LookAdapter;
import com.example.childrensong.base.BaseFragment;
import com.example.childrensong.base.BasePresenter;
import com.example.childrensong.presenter.LookPresenterImp;
import com.example.childrensong.utils.LookInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HandPickFragment extends BaseFragment<LookInterface.LookView, BasePresenter<LookInterface.LookView>> implements LookInterface.LookView {

    @BindView(R.id.handpickRec)
    RecyclerView handpickRec;
    Unbinder unbinder;
    private LookPresenterImp<LookInterface.LookView> lookViewLookPresenterImp;
    int id = 1;
    private LookAdapter lookAdapter;
    private LookPresenterImp<LookInterface.LookView> lookViewLookPresenterImp1;
    private int id1;

    @Override
    protected void initView() {
        id1 = getArguments().getInt("id");
        lookViewLookPresenterImp.getHttp(id1);
        handpickRec.setLayoutManager(new LinearLayoutManager(getActivity()));
        handpickRec.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        lookAdapter = new LookAdapter(getActivity());
        handpickRec.setAdapter(lookAdapter);
    }

    @Override
    protected int createLayout() {
        return R.layout.handpick_fragment_layout;
    }

    @Override
    protected BasePresenter<LookInterface.LookView> createPresenter() {
        lookViewLookPresenterImp = new LookPresenterImp<>();
        return lookViewLookPresenterImp;
    }

    private static final String TAG = "HandPickFragment";

    @Override
    public void getlookSuccess(List<HandPickBean.DataBean> handPickBeans) {
        Log.e(TAG, "getlookSuccess: " + handPickBeans);
        lookAdapter.addData(handPickBeans);
    }

    @Override
    public void getlookFiladle(String error) {
        Log.e(TAG, "getlookFiladle: " + error);
    }




}
