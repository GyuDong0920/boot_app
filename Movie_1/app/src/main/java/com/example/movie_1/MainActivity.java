package com.example.movie_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.movie_1.databinding.ActivityMainBinding;
import com.example.movie_1.interfaces.OnchangeToolBarTitle;
import com.example.movie_1.utils.FragmentType;



public class MainActivity extends AppCompatActivity implements OnchangeToolBarTitle {

    // 뷰 바인딩 생성 방법
    // 1. 안드로이드가 만들어준 객체 선언
    private ActivityMainBinding binding;
    private InfoFragment infoFragment;

    public ActivityMainBinding getBinding() {
        return binding;
    }

    public void setBinding(ActivityMainBinding binding) {
        this.binding = binding;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 2. 객체 초기화
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // 3. 연결
        setContentView(binding.getRoot());
        replaceFargment(FragmentType.MOVIE);
        addBottomNavListener();
    }

    private void replaceFargment(FragmentType type) {
        Fragment fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (type == FragmentType.MOVIE) {
            fragment = MovieFragment.getInstance(this); // MOVIE TAG
        } else {
            fragment = InfoFragment.getInstance(this); // INFO TAG
            // 메서드 통해서 callBack 받아보기
//            InfoFragment infoFragment = InfoFragment.newInstance();
//            infoFragment.setOnchangeToolBarTitle(this);
            //InfoFragment.newInstance().setOnchangeToolBarTitle(this);
        }
        // 문자열로 이름 지어서 구분 해 놓는 녀석 --> Tag
        transaction.replace(binding.mainContainer.getId(), fragment, type.toString());
        transaction.commit();
    }

    private void addBottomNavListener() {
        binding.bottomNavigation.setOnItemSelectedListener(event -> {
            switch (event.getItemId()) {
                case com.example.movie_1.R.id.page1:
                    replaceFargment(FragmentType.MOVIE);
                    break;
                case R.id.page2:
                    replaceFargment(FragmentType.INFO);
                    break;
            }
            return true;
        });
    }


    @Override
    public void onBackPressed() {
        // info fragment 라면 한번은 movie 갔다가 --> 동작
        // movie fragment 라면 종료!
        // mainContainer 에 올라와있는 녀석이 --> 현재 movie fragment인지 info fragment인지 구분할수있으면
        // 아래와 같은 기능(뒤로가기 기능)을 만들수 있다.
        String fragmentTag = getSupportFragmentManager().findFragmentByTag(FragmentType.INFO.toString()).getTag();
        if (fragmentTag.equals(FragmentType.INFO.toString())) {
//            replaceFargment(FragmentType.MOVIE);
            View view = binding.bottomNavigation.findViewById(R.id.page1);
            view.performClick();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void onSetupType(String title) {
        // 플래그먼트에서 호출 하면 여기로 코드가 돌아온다.
//        if (title.equals(Define.PAGE_TITLE_MOVIE)){
//            binding.topAppBar.setTitle(title);
//            binding.topAppBar.setVisibility(View.VISIBLE);
//        }else if(title.equals(Define.PAGE_TITLE_INFO)){
//            binding.topAppBar.setVisibility(View.GONE);
//        }
        switch (title) {
            case "MOVIE":
                Log.d("TAG", "@@@" + title);
                binding.topAppbar.setTitle(title);
                binding.topAppbar.setVisibility(View.VISIBLE);
                break;
            case "INFO":
                Log.d("TAG", "@@@" + title);
                binding.topAppbar.setVisibility(View.GONE);
                break;
        }
    }
}