package com.example.lottogame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName(); // MainActivity
    private Button addBtn;
    private Button initBtn;
    private Button runBtn;
    private NumberPicker numberPicker;
    private ArrayList<TextView> numberTextViewList = new ArrayList<>();
    private Set<Integer> pickerNumberSet = new HashSet<>();
    private boolean didRun = false;

    // 게임 실행 했으면 다시 실행 안되게 처리 ( 초기화 버튼 누른 후 다시 게임 가능)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();
        getRandomNumber();
        //        Log.d(TAG,"getRandomNumber : " + getRandomNumber());
    }


    private void initData() {
        addBtn = findViewById(R.id.addButton);
        initBtn = findViewById(R.id.initButton);
        runBtn = findViewById(R.id.runButton);
        numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(45);
        numberTextViewList.add(findViewById(R.id.textview1));
        numberTextViewList.add(findViewById(R.id.textview2));
        numberTextViewList.add(findViewById(R.id.textview3));
        numberTextViewList.add(findViewById(R.id.textview4));
        numberTextViewList.add(findViewById(R.id.textview5));
        numberTextViewList.add(findViewById(R.id.textview6));

    }

    private void addEventListener() {
        runBtn.setOnClickListener(view -> {
            if(!didRun) {
                List<Integer> list = getRandomNumber();
                list.addAll(pickerNumberSet);
                Collections.sort(list);
                for (int i = 0; i < list.size(); i++) {
                    numberTextViewList.get(i).setText(String.valueOf(list.get(i)));
                    numberTextViewList.get(i).setVisibility(View.VISIBLE);
                    numberTextViewList.get(i).setBackground(setTextViewBackground(list.get(i)));
                    didRun = true;
                }
            } else if(didRun) {
                Toast.makeText(this, "초기화 후에 시도하세요", Toast.LENGTH_SHORT).show();
                return;
            }


        });
        addBtn.setOnClickListener(view -> {
            if (didRun) {
                Toast.makeText(this, "초기화 후에 시도하세요", Toast.LENGTH_SHORT).show();
                return;
            }
            // 1.numberPicker 현재 값을 불러 온다.
            int selectedNumber = numberPicker.getValue();
            Log.d(TAG, "seletedNumber :" + selectedNumber);

            // 번호는 5개까지 선택 가능
            if (pickerNumberSet.size() >= 5) {
                Toast.makeText(this, "선택 번호는 다섯개까지 가능합니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            // 똑같은 번호 선택시 예외 처리
            if (pickerNumberSet.contains(selectedNumber)) {
                Toast.makeText(this, "같은 번호가 이미 있습니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            TextView textView = numberTextViewList.get(pickerNumberSet.size());
            textView.setVisibility(View.VISIBLE);
            textView.setText(String.valueOf(selectedNumber));
            pickerNumberSet.add(selectedNumber);
        });
        initBtn.setOnClickListener(view -> {
            didRun = false;
            pickerNumberSet.clear();
            for (TextView tv : numberTextViewList) {
                tv.setVisibility(View.GONE);
            } return;
        });
    }

    private List<Integer> getRandomNumber() {
        ArrayList<Integer> list = new ArrayList<>();
        // 1 ~ 45 미리 만들어 보자
        for (int i = 1; i < 46; i++) {
            // 자료구조에 담기
            if (pickerNumberSet.contains(i)) {
                continue;
            }
            list.add(i); // 1 ~ 45까지 값이 담김
        }
        Collections.shuffle(list);
        return list.subList(0, 6 - pickerNumberSet.size());
    }

    private Drawable setTextViewBackground(int number) {
        Drawable drawable = null;
        if (number <= 9) {
            drawable = ContextCompat.getDrawable(this, R.drawable.roundbackground1);
        } else if (number <= 19) {
            drawable = ContextCompat.getDrawable(this, R.drawable.roundbackground2);
        } else if (number <= 29) {
            drawable = ContextCompat.getDrawable(this, R.drawable.roundbackground3);
        } else if (number <= 39) {
            drawable = ContextCompat.getDrawable(this, R.drawable.roundbackground4);
        } else {
            drawable = ContextCompat.getDrawable(this, R.drawable.roundbackground5);
        }

        return drawable;
    }
}