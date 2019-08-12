package com.example.childrensong.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.childrensong.Beans.HandpickImageBeans;
import com.example.childrensong.R;

import java.util.ArrayList;
import java.util.List;

public class JingXuanOneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<HandpickImageBeans.DataBean> dataBeans =new ArrayList<>();

    public JingXuanOneAdapter(Context context) {
        this.context = context;
    }
    int a = 7;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        if (i==0){
//            View view = View.inflate(context, R.layout.item_handpiick, null);
//            return new OneViewHolder(view);
//        }else{
            View view = View.inflate(context, R.layout.item_handpick_two, null);
            return new TwoViewHolder(view);
//        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
//        int itemViewType = getItemViewType(i);
//        if (itemViewType==0){
//            OneViewHolder holder = (OneViewHolder) viewHolder;
//            holder.image1.setImageResource(R.drawable.timg);
//            holder.image2.setImageResource(R.drawable.meng);
//            holder.image3.setImageResource(R.drawable.wang);
//
//        }else{

            TwoViewHolder holder = (TwoViewHolder) viewHolder;
//            i=i-1;
        holder.title.setText(dataBeans.get(i).getName());
            Glide.with(context)
                    .load(dataBeans.get(i).getIcon_url())
                    .into(holder.there_image);
//        }

    }


    @Override
    public int getItemCount() {
        return dataBeans.size();
    }
//
//    @Override
//    public int getItemViewType(int position) {
//        if (position==0){
//            return 0;
//        }else{
//            return 1;
//        }
//    }

    public void addData(List<HandpickImageBeans.DataBean> handPickBeans) {
            if (dataBeans!=null){
                dataBeans.clear();
                dataBeans.addAll(handPickBeans);
                notifyDataSetChanged();

            }

    }

    class OneViewHolder extends RecyclerView.ViewHolder{

        private ImageView image1;
        private ImageView image2;
        private ImageView image3;

        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.item_handpick_image1);
            image2 = itemView.findViewById(R.id.item_handpick_image2);
            image3 = itemView.findViewById(R.id.item_handpick_image3);
        }
    }
    class TwoViewHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private ImageView there_image;

        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_handpick_two_title);
            there_image = itemView.findViewById(R.id.item_handpick_two_image1);
        }
    }
}
