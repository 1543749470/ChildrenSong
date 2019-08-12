package com.example.childrensong.fragments.Hear;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.childrensong.Beans.HearFuYongBean;
import com.example.childrensong.R;
import com.example.childrensong.adapters.HearReuserAdaper;
import com.example.childrensong.base.BaseFragment;
import com.example.childrensong.presenter.HearReusePersenter;
import com.example.childrensong.utils.MainContract;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReuseFragment extends BaseFragment<ReuseFragment, HearReusePersenter> implements MainContract.MainView<HearFuYongBean> {


    @BindView(R.id.HearRecyc)
    RecyclerView mRecyc;
    @BindView(R.id.hearsma)
    SmartRefreshLayout sma;
    Unbinder unbinder;
    private HearReuserAdaper adaper;

    @Override
    protected HearReusePersenter createPresenter() {
        return new HearReusePersenter();
    }

    @Override
    protected void initView() {
        mRecyc.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyc.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
        adaper = new HearReuserAdaper(getActivity());
        mRecyc.setAdapter(adaper);

        mPresenter.http();


    }

    @Override
    protected int createLayout() {
        return R.layout.fragment_reuse;
    }

    @Override
    public void showSuccesses(HearFuYongBean hearFuYongBean) {
        adaper.initdata(hearFuYongBean.getData());
    }

    @Override
    public void showError(String error) {

    }

}
