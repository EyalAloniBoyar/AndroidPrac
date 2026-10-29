package com.example.recyclerviewprac_02;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Item> mdata;

    public MyAdapter(ArrayList<Item> data) {
        mdata = data;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final ImageView ivImage;
        public final TextView tvText;
        public final TextView tvText2;

        public ViewHolder(View itemView){
            super(itemView);
            ivImage = itemView.findViewById(R.id.img);
            tvText =  itemView.findViewById(R.id.txt1);
            tvText2 = itemView.findViewById(R.id.txt2);
        }


    }
    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.tvText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getLayoutPosition();

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        Item item = mdata.get(position);
        holder.tvText.setText(item.getName());
        holder.tvText2.setText(item.getDescription());
        holder.ivImage.setImageResource(R.drawable.dog);
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }
}
