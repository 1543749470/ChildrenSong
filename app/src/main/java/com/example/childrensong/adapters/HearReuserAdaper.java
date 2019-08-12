package com.example.childrensong.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.childrensong.Beans.HearFuYongBean;
import com.example.childrensong.R;

import java.util.ArrayList;
import java.util.List;

public class HearReuserAdaper extends RecyclerView.Adapter<HearReuserAdaper.ViewHoler> {

    List<HearFuYongBean.DataBean>  list = new ArrayList<>();
    Context context;

    public HearReuserAdaper(Context context) {
        this.context = context;
    }

    public void  initdata( List<HearFuYongBean.DataBean>  list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public HearReuserAdaper.ViewHoler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.hear_reuse_item_layout, null);
        return new ViewHoler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HearReuserAdaper.ViewHoler viewHoler, int i) {
        viewHoler.titlehear.setText(list.get(i).getName());
        viewHoler.articlehear.setText(list.get(i).getDescription());
        viewHoler.countReuse.setText(list.get(i).getCount()+"首");
        Glide.with(context).load(list.get(i).getImage()).into(viewHoler.imghear);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        ImageView imghear;
        TextView titlehear;
        TextView articlehear;
        TextView countReuse;
        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            imghear=   itemView.findViewById(R.id.imghear);
            titlehear=   itemView.findViewById(R.id.titlehear);
            articlehear=  itemView.findViewById(R.id.articlehear);
            countReuse=  itemView.findViewById(R.id.countReuse);
        }
    }
}
