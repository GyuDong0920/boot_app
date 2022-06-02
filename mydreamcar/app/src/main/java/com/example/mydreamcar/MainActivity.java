package com.example.mydreamcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Cars> carlist = Cars.getCars();

        LinearLayout container = findViewById(R.id.carListContainer);

        LayoutInflater inflater = LayoutInflater.from(this);

        carlist.forEach(cars -> {
            View itemView = inflater.inflate(R.layout.item_car, container, false);

            ImageView imageView = itemView.findViewById(R.id.carImageView);
            TextView carNameTextView = itemView.findViewById(R.id.carNameTextView);
            TextView caryearTextView = itemView.findViewById(R.id.carYearTextView);
            TextView carPriceTextView = itemView.findViewById(R.id.carPriceTextView);

            carNameTextView.setText(cars.name);
            caryearTextView.setText(cars.year);
            carPriceTextView.setText(cars.price);

            Glide.with(this)
                    .load(cars.ImageUrl)
                    .into(imageView);

            container.addView(itemView);

            imageView.setOnClickListener(view -> {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=%EB%9E%8C%EB%B3%B4%EB%A5%B4%EA%B8%B0%EB%8B%88+%EC%9A%B0%EB%9D%BC%EC%B9%B8&oquery=%EC%9E%90%EB%8F%99%EC%B0%A8&tqi=hoJPDlprvxZssDFQNJlssssst%2FR-371008"));
                startActivity(intent);

            });
        });

    }
}