package com.example.deathnote;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText diaryEditText;
    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diaryEditText = findViewById(R.id.diaryEditText);

        // 사용자가 이전에 적었던 비밀 일기장 불러와야한다.
        SharedPreferences notePreference = getSharedPreferences("diary",Context.MODE_PRIVATE);
        diaryEditText.setText(notePreference.getString("detail",""));

        // thread 기능 구현
        Runnable runnable = () -> {
            SharedPreferences Preference = getSharedPreferences("diary",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = Preference.edit();
            editor.putString("detail",diaryEditText.getText().toString());
            editor.apply();
        };

        // 사용자가 한글자 한글자 입력할 때 마다 이벤트 리스너를 등록해서 변경 사항을 가지고 오기
        diaryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("TAG","char : " + s);
                Log.d("TAG","start : " + start);
                Log.d("TAG","count : " + count);
                Log.d("TAG","after : " + after);
            }
            // 1 2 3 4 5 6 7
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 한글자 한글자 입력이 들어 올때 마다 SharedPreference 저장 할 예정
                // 여기서에서 다른 쓰레드 한테 일 해달라고 요청 함!!!
                // a : 0.5초 딜레이
                // ab : 0.5초 딜레이 -- 삭제
                // abc : 0.5초 딜레이 -- 삭제
                // abcd : 0.5초 딜레이 2초
                handler.removeCallbacks(runnable);
//                handler.post(runnable);
                handler.postDelayed(runnable, 500);
                // 새로운 쓰레드를 만들어서 비동기로 저장하게 하고싶음
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}