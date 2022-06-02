package com.example.secretdiary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private NumberPicker numberPicker1;
    private NumberPicker numberPicker2;
    private NumberPicker numberPicker3;

    private Button btnOpen;
    private Button btnReset;

    private SharedPreferences passwordPreferences;

    // 프로그램 흐름상 (두가지 모드)
    private boolean changePasswordMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();
    }

    private void initData() {
        numberPicker1 = findViewById(R.id.numberPicker1);
        numberPicker2 = findViewById(R.id.numberPicker2);
        numberPicker3 = findViewById(R.id.numberPicker3);
        numberPicker1.setMaxValue(9);
        numberPicker1.setMaxValue(0);
        numberPicker2.setMaxValue(9);
        numberPicker2.setMaxValue(0);
        numberPicker3.setMaxValue(9);
        numberPicker3.setMaxValue(0);

        btnOpen = findViewById(R.id.btnOpen);
        btnReset = findViewById(R.id.resetPassword);

        passwordPreferences = getSharedPreferences("password", Context.MODE_PRIVATE);

    }

    private void addEventListener() {
        // 비밀 다이어리 오픈 버튼을 눌렀을때 동작처리
        btnOpen.setOnClickListener(view -> {
            if (changePasswordMode) {
                // 작은 버튼을 눌러서 색상이 변경 되었을 때 진행을 시키면 안된다.
                Toast.makeText(this, "비밀번호 변경 중 입니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            // 저장 되어 있는 패스워드 데이터를 불러와서 확인 해야 한다.
            // 패스워드 저장하는 방식 - 로컬 DB (SQL Lite) , sharedPreference
//            passwordPreferences = getSharedPreferences("password", Context.MODE_PRIVATE);

            String passwordFromUser = getUserNumber();

            // 값을(비밀번호)를 설정하지 않았을 경우에는 초기값 세팅으로 처리
            // 000이 초기값 <---> 000 이여야 : OK
            // 사용자가 패스워드를 333으로 저장했으면 333 : OK
            // 사용자가 333 설정하고 123하면 : X
            if (passwordPreferences.getString("password", "000").equals(passwordFromUser)) {
                // 패스워드확인 성공했을 경우에만 들어옴
                Intent intent = new Intent(this, DiaryActivity.class); // 화면전환 변경할 것!!!
                startActivity(intent);
            } else {
                showErrorAlertDialog();
            }
        });
        // 비밀번호 변경 버튼 눌렀을때 동작처리
        btnReset.setOnClickListener(view -> {
//               passwordPreferences = getSharedPreferences("password",Context.MODE_PRIVATE);
            String passwordFromUser = getUserNumber();

            // 비밀번호를 변경 중인 경우, 처음 변경하겠다고 누르는 경우
            if(changePasswordMode) {
                // 비밀번호를 변경하는 경우 ---> 저장 처리
                changePasswordMode = false;
                btnReset.setBackgroundColor(Color.BLACK);
            } else {
                // 비밀번호 변경 모드 활성화 시키기
                // 단, 현재 넘버피커 숫자가 내가 정한 비밀번호와 일치해야
                // 변경모드로 만들어 줘야 한다.
                if(passwordPreferences.getString("password","000").equals(passwordFromUser)) {
                    changePasswordMode = true;
                    Toast.makeText(this, "변경할 패스워드를 입력해주세요", Toast.LENGTH_SHORT).show();
                    btnReset.setBackgroundColor(Color.RED);
                } else {
                    showErrorAlertDialog();
                }
            }

        });

    }

    private void showErrorAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("실패")
                .setMessage("비밀번호가 잘못되었습니다.")
                .setPositiveButton("닫기", (dialogInterface, i) -> {
                    //동작 정의 안함!
                    Log.d("TAG", "11111");
                });
        builder.show();
    }

    private String getUserNumber() {
        String passwordFromUser = "" +
                numberPicker1.getValue() +
                numberPicker2.getValue() +
                numberPicker3.getValue();
        return passwordFromUser;
    }

}