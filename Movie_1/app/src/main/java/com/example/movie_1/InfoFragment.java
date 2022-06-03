package com.example.movie_1;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.movie_1.databinding.FragmentInfoBinding;
import com.example.movie_1.interfaces.OnchangeToolBarTitle;
import com.example.movie_1.utils.Define;



public class InfoFragment extends Fragment {
    private FragmentInfoBinding binding;
    private MainActivity mainActivity;
    //    OnInfoItemClicked onInfoItemClicked;
    private OnchangeToolBarTitle onchangeToolBarTitle;

    //싱글톤
    private static InfoFragment infoFragment;

    // 메서드를 통해서 callback 보내는 방법
//    public void setOnchangeToolBarTitle(OnchangeToolBarTitle onchangeToolBarTitle) {
//        this.onchangeToolBarTitle = onchangeToolBarTitle;
//    }

    public InfoFragment(OnchangeToolBarTitle onchangeToolBarTitle) {
        this.onchangeToolBarTitle = onchangeToolBarTitle;
    }

    public static InfoFragment getInstance(OnchangeToolBarTitle onchangeToolBarTitle) {
        if(infoFragment == null){
            infoFragment = new InfoFragment(onchangeToolBarTitle);
        }
        return infoFragment;
//        InfoFragment fragment = new InfoFragment(onchangeToolBarTitle);
//        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // 콜백으로 topBar 타이틀 변경
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 뷰 결합하기 위해 메모리 초기화
        binding = FragmentInfoBinding.inflate(inflater, container, false);
        onchangeToolBarTitle.onSetupType(Define.MOVIE_TITLE);
        return binding.getRoot();
    }

    private void setupWebView(){
        WebView webView = binding.mWebView;
        webView.loadUrl("https://yts.mx/");
    }
}