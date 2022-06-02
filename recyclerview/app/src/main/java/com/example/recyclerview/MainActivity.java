package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.recyclerview.adapter.InstaApater;
import com.example.recyclerview.interfaces.OnFooditemClickListener;
import com.example.recyclerview.models.Insta;

import java.util.ArrayList;

/*
* RecyclerView
*
* -- 장점
* -- ListView 개선판
* -- viewHolder 포함(findviewById를 줄이기 위한 녀석)
* -- 유연하다.
* -- LayoutMananger, Adapter 클래스
* */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InstaApater instaApater = new InstaApater(Insta.getSampleData(), this, new OnFooditemClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
                Log.d("TAG","ggg");

            }
        });

        // 통신 JSON으로 받아오는 부분
        ArrayList<Insta> listSample = Insta.getSampleData();
        // 리싸이클러뷰를 사용하기 위해서
        // 1. Adapter 클래스를 직접 생성해야 한다.

        // 2. LayoutManger 생성 해서 Adapter 클래스와 연결해야 한다.


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
 //           recyclerView.setLayoutManager(new GridLayoutManager(this, 2));


}
}