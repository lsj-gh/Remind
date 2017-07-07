package com.example.administrator.mapleone.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.mapleone.R;
import com.example.administrator.mapleone.bean.People;

import java.util.List;

/**
 * Created by Administrator on 2017/5/5 0005.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private List<People> mPeoples;
    private OnItemClickListener onItemClickListener;

    public MyRecyclerViewAdapter(List<People> peoples) {
        this.mPeoples = peoples;
    }

    public interface OnItemClickListener {
        void OnClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_age;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.name);
//            tv_age = (TextView) itemView.findViewById(R.id.age);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        People people = mPeoples.get(position);
        holder.tv_name.setText(people.getName());
//        holder.tv_age.setText("wayside---" + people.getAge());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.OnClick(holder.itemView, holder.getLayoutPosition());
            }
        });
    }


    @Override
    public int getItemCount() {
        return mPeoples.size();
    }
}
