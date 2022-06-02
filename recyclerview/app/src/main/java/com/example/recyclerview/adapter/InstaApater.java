package com.example.recyclerview.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.recyclerview.R;
import com.example.recyclerview.interfaces.OnFooditemClickListener;
import com.example.recyclerview.models.Insta;

import java.util.ArrayList;

// 뷰와 데이터를 연결해주는 어댑터!
// 뷰홀더 만들기
public class InstaApater extends RecyclerView.Adapter<InstaApater.MyViewHolder>{

    // 멤버 변수
    ArrayList<Insta> list;
    Context context;
    OnFooditemClickListener onFoodItemClickListener;

    public InstaApater(ArrayList<Insta> list, Context context, OnFooditemClickListener onFoodItemClickListener) {
        this.list = list;
        this.context = context;
        this.onFoodItemClickListener = onFoodItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater
                .from(context)
                .inflate(R.layout.item_insta, parent, false);
        // new ViewHolder 생성해
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        // BindViewHolder (화면과 연결)
        // 데이터 맵핑
        Log.d("TAG","position :" + position);
        Insta food = list.get(position);
        Glide.with(context)
                .load(food.getThumbnail())
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.thumbnail);
        holder.title.setText(food.getTilte());
        holder.subtitle.setText(food.getSubTitle());
        holder.detail.setText(food.getDetail());


    }

    @Override
    public int getItemCount() {
        // 0으로 되어있을 경우 아무것도 생성안됌...!
        return list.size();
    }

    // 1. 내부 클래스 만들기
    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbnail;
        TextView title;
        TextView subtitle;
        TextView detail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbnail = itemView.findViewById(R.id.thumbnailImageView);
            title = itemView.findViewById(R.id.titleTextview);
            subtitle = itemView.findViewById(R.id.subtitleTextview);
            detail = itemView.findViewById(R.id.detailTextview);

            itemView.setOnClickListener(view -> {
                Toast.makeText(view.getContext()
                        ,"앵뇽"+getLayoutPosition(), Toast.LENGTH_SHORT).show();
                // 콜백 메서드 호출
                onFoodItemClickListener.onItemClicked(itemView, getLayoutPosition());
        });

        }

    } // end of innerClass

} // end of class
