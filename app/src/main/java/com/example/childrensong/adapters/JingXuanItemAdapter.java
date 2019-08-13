package com.example.childrensong.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.childrensong.Beans.JIngxuanBeans;
import com.example.childrensong.R;
import com.example.childrensong.WebActivity;

import java.util.ArrayList;
import java.util.List;

public class JingXuanItemAdapter extends RecyclerView.Adapter<JingXuanItemAdapter.ViewHolder> {
    Context context;
    ArrayList<JIngxuanBeans.DataBean.ItemBean> dataBeans = new ArrayList<>();

    public JingXuanItemAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_handpick_there, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.title.setText(dataBeans.get(i).getName());
        Glide.with(context)
                .load(dataBeans.get(i).getImage())
                .into(viewHolder.image1);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("data",dataBeans.get(i).getResource());
                context.startActivity(intent);
            }
        });
        viewHolder.xia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public void addData(List<JIngxuanBeans.DataBean> handPickBeans) {
        if (dataBeans!=null){
            dataBeans.clear();
            for (int i = 0; i < handPickBeans.size(); i++) {

                dataBeans.add(handPickBeans.get(i).getItem());
            }
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image1;
        private TextView title;
        private ImageView xia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.item_handpick_there_image1);
            title = itemView.findViewById(R.id.item_handpick_there_title);
            xia = itemView.findViewById(R.id.xia_there_image);
        }
    }
}
