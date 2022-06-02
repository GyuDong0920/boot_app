package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    private FragmentBanner fragmentBanner;
    private FragmentBanner fragmentBanner2;
    private Button btnCreate;
    private Button btnDelete;
    private LinearLayout container;
    private Button btnCreate2;
    private Button btnDelete2;
    private LinearLayout container2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnCreate = findViewById(R.id.btnCreate);
        btnDelete = findViewById(R.id.btnDelete);
        container = findViewById(R.id.container);
        btnCreate2 = findViewById(R.id.btnCreate2);
        btnDelete2 = findViewById(R.id.btnDelete2);
        container2 = findViewById(R.id.container2);

        btnCreate.setOnClickListener(view -> {
            fragmentBanner = new FragmentBanner();

            //프래그먼트를 동적으로 만들기 위해서 필요한 준비물
            // 1. FragmentManager (프래그먼트 트랜잭션 객체를 가져올 수 있다.)
            // 2. FragmentTransaction Transaction -> 작업에 단위 (시작과 끝이 있다.)
            // 여러개 부분 부분 작업들을 한 단위로 만들어 준다.

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            // 지금부터 트랜잭션 처리를 할꺼야 !!!

            // 실행 코드 XML 파일 만들어 둔 영역(view component에 올려라)
            transaction.replace(R.id.container,fragmentBanner);

            transaction.commit(); // 너가 시간이 될때 완료해 (시스템에 요청)
//            transaction.commitNow(); // 지금 당장해 !!! (시스템에 요청)
//            transaction.commitAllowingStateLoss(); // 위험 (commit이 없어질 수 있다.)

        });

        // 프래그먼트 제거하는 방법
        btnDelete.setOnClickListener(view -> {

            // remove
            // 두가지가 필요함
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragmentBanner);
//                transaction.detach(fragmentBanner);
            transaction.commit();

        });
        btnCreate2.setOnClickListener(view -> {
            fragmentBanner2 = new FragmentBanner();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            transaction.replace(R.id.container2,fragmentBanner2);
            transaction.commit();
        });

        btnDelete2.setOnClickListener(view -> {

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
          transaction.remove(fragmentBanner2);
          transaction.commit();


        });
    }
}