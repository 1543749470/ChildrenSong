package com.example.childrensong.fragments;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.childrensong.Beans.PartnerBeans;
import com.example.childrensong.R;
import com.example.childrensong.base.BaseFragment;
import com.example.childrensong.base.BasePresenter;
import com.example.childrensong.utils.PartnerInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PartnerFragment extends BaseFragment<PartnerInterface.PartnerView, BasePresenter<PartnerInterface.PartnerView>> implements PartnerInterface.PartnerView {
    @BindView(R.id.partner_rec)
    RecyclerView partnerRec;
    Unbinder unbinder;

    @Override
    protected BasePresenter<PartnerInterface.PartnerView> createPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        partnerRec.setLayoutManager(new GridLayoutManager(getContext(),3));

    }

    @Override
    protected int createLayout() {
        return R.layout.partner_fragment_layout;
    }

    @Override
    public void getlookSuccess(List<PartnerBeans.DataBean> albumsBeans) {

    }

    @Override
    public void getlookFiladle(String error) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
