package com.example.childrensong.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.childrensong.Beans.HandPickBean;
import com.example.childrensong.R;

import java.util.ArrayList;
import java.util.List;

public class LookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<HandPickBean.DataBean> list = new ArrayList<>();

    public LookAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_look, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.look_item_title.setText(list.get(i).getName());
        holder.look_item_content.setText(list.get(i).getDescription());
        holder.look_item_seties.setText("共"+list.get(i).getVideo_count()+"级");
        Glide.with(context)
                .load(list.get(i).getImage_url())
                .into(holder.look_item_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(List<HandPickBean.DataBean> handPickBeans) {
        if (list!=null){
            list.clear();
            list.addAll(handPickBeans);
            notifyDataSetChanged();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView look_item_img;
        private TextView look_item_title;
        private TextView look_item_content;
        private TextView look_item_seties;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            look_item_img = itemView.findViewById(R.id.look_item_img);
            look_item_title = itemView.findViewById(R.id.look_item_title);
            look_item_content = itemView.findViewById(R.id.look_item_content);
            look_item_seties = itemView.findViewById(R.id.look_item_seties);

        }
    }
}
