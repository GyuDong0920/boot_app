package com.example.myglide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView imageView1 = findViewById(R.id.gImageView1);
        ImageView imageView2 = findViewById(R.id.gImageView2);
        ImageView imageView3 = findViewById(R.id.gImageView3);
        ImageView imageView4 = findViewById(R.id.gImageView4);
        ImageView imageView5 = findViewById(R.id.gImageView5);
        ImageView imageView6 = findViewById(R.id.gImageView6);

        // 6개 이미지에 ( 인물 사진 ) 그리기 !!
        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2022/05/20/13/29/dogs-7209506_960_720.jpg")
                .circleCrop()
                .into(imageView1);
        Glide.with(this)
                .load("data:image/jpeg;base64,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")
                .circleCrop()
                .into(imageView2);
        Glide.with(this)
                .load("data:image/jpeg;base64,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")
                .circleCrop()
                .into(imageView3);
        Glide.with(this)
                .load("data:image/jpeg;base64,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")
                .circleCrop()
                .into(imageView4);
        Glide.with(this)
                .load("data:image/jpeg;base64,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")
                .circleCrop()
                .into(imageView5);
        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2022/02/08/06/18/bird-7000837_960_720.jpg")
                .circleCrop()
                .into(imageView6);
    }
}