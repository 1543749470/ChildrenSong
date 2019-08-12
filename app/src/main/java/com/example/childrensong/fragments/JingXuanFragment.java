package com.example.childrensong.fragments;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.childrensong.Beans.HandpickImageBeans;
import com.example.childrensong.Beans.JIngxuanBeans;
import com.example.childrensong.R;
import com.example.childrensong.adapters.JingXuanItemAdapter;
import com.example.childrensong.adapters.JingXuanOneAdapter;
import com.example.childrensong.base.BaseFragment;
import com.example.childrensong.base.BasePresenter;
import com.example.childrensong.presenter.JingXuanPresenterImp;
import com.example.childrensong.utils.JingXuanInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class JingXuanFragment extends BaseFragment<JingXuanInterface.JingXuanView, BasePresenter<JingXuanInterface.JingXuanView>> implements JingXuanInterface.JingXuanView {
    @BindView(R.id.JXRec)
    RecyclerView JXRec;
    Unbinder unbinder;
    @BindView(R.id.JXRectwo)
    RecyclerView JXRectwo;
    @BindView(R.id.item_handpick_image1)
    ImageView itemHandpickImage1;
    @BindView(R.id.item_handpick_image2)
    ImageView itemHandpickImage2;
    @BindView(R.id.item_handpick_image3)
    ImageView itemHandpickImage3;
    Unbinder unbinder1;
    private JingXuanPresenterImp<JingXuanInterface.JingXuanView> jingXuanViewJingXuanPresenterImp;
    int id;
    private JingXuanOneAdapter jingXuanOneAdapter;
    private JingXuanItemAdapter jingXuanItemAdapter;

    @Override
    protected void initView() {
        jingXuanViewJingXuanPresenterImp.getHttp(id);
        itemHandpickImage1.setImageResource(R.drawable.timg);
        itemHandpickImage2.setImageResource(R.drawable.meng);
        itemHandpickImage3.setImageResource(R.drawable.wang);
        JXRec.setLayoutManager(new GridLayoutManager(getActivity(), 5));
        jingXuanOneAdapter = new JingXuanOneAdapter(getActivity());
        JXRec.setAdapter(jingXuanOneAdapter);



        JXRectwo.setLayoutManager(new LinearLayoutManager(getActivity()));
        JXRectwo.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        jingXuanItemAdapter = new JingXuanItemAdapter(getActivity());
        JXRectwo.setAdapter(jingXuanItemAdapter);

    }

    @Override
    protected int createLayout() {
        return R.layout.jingxuanfragment_layout;
    }

    @Override
    protected BasePresenter<JingXuanInterface.JingXuanView> createPresenter() {
        jingXuanViewJingXuanPresenterImp = new JingXuanPresenterImp<>();
        return jingXuanViewJingXuanPresenterImp;
    }

    private static final String TAG = "JingXuanFragment";

    @Override
    public void gettwoSuccess(List<HandpickImageBeans.DataBean> handPickBeans) {
        Log.e(TAG, "gettwoSuccess: " + handPickBeans.toString());
        jingXuanOneAdapter.addData(handPickBeans);
    }

    @Override
    public void getitemSuccess(List<JIngxuanBeans.DataBean> handPickBeans) {
        Log.e(TAG, "getitemSuccess: "+handPickBeans.toString() );
        jingXuanItemAdapter.addData(handPickBeans);
    }

    @Override
    public void getitemFiladle(String error) {

    }



}
