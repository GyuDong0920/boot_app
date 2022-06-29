package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.instagram.Repository.SignUpService;
import com.example.instagram.databinding.ActivitySignUpBinding;
import com.example.instagram.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;
    private SignUpService signUpService;
    public List<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        clickSignUpbutton();
        signUpService = SignUpService.retrofit.create(SignUpService.class);

    }
    private void clickSignUpbutton() {
        binding.singUpButton.setOnClickListener(v -> {
            User user = makeSignUp();
            if(user != null){
                requestJoin(user);
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private void requestJoin(User user) {

        signUpService.sign(user).
                enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User user = response.body();
                        userList.add(user);
                    }
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                    }
                });
    }
    private boolean checkEmpty(User user){
        if(user.getId() == null || user.getId().equals("")){
            Toast.makeText(this, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show();
            return false;
        }else if(user.getUserName() == null || user.getUserName().equals("")){
            Toast.makeText(this, "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
            return false;
        }else if(user.getNickName() == null || user.getNickName().equals("")){
            Toast.makeText(this, "닉네임을 입력해주세요", Toast.LENGTH_SHORT).show();
            return false;
        }else if(user.getPassword() == null || user.getPassword().equals("")){
            Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private User makeSignUp() {
        String id = binding.signIdEditTextView.getEditText().getText().toString();
        String name = binding.userNameTextView.getEditText().getText().toString();
        String nickName = binding.userNickNameTextView.getEditText().getText().toString();
        String password = binding.passwordTextView.getEditText().getText().toString();
        User joinUser = new User();
        joinUser.setId(id);
        joinUser.setUserName(name);
        joinUser.setNickName(nickName);
        joinUser.setPassword(password);
        if(checkEmpty(joinUser)){
            return joinUser;
        }else{
            return null;
        }


    }


}