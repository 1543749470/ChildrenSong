package com.example.childrensong.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.childrensong.R;

import java.util.ArrayList;
import java.util.List;

public class PartnerAdapter extends RecyclerView.Adapter<PartnerAdapter.ViewHolder> {
    Context context;

    public PartnerAdapter(Context context) {
        this.context = context;
    }
    List<String> strings=new ArrayList<>();
    public void initData( List<String> strings){
        this.strings=strings;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(View.inflate(context, R.layout.item_partner,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(strings.get(i)).into(viewHolder.item_partner_image);
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView item_partner_image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_partner_image=itemView.findViewById(R.id.item_partner_image);
        }
    }
}
