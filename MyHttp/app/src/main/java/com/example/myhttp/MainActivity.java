package com.example.myhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.myhttp.models.Todo;
import com.example.myhttp.models.Todo2;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnNet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNet = findViewById(R.id.btnNetwork);
        // 단 하나의 추상메서드만 가지고있기 때문에 람다식으로 변경해 사용할 수 있다.
        btnNet.setOnClickListener(view -> {
            new Thread(() -> {
                httpGetTest();
            }).start();
        });
//       try{
//           httpGetTest();
//       }catch (NetworkOnMainThreadException e) {
//           // 네트워크를 사용하려면 쓰레드를 따로 생성해 배정해주어야한다.
//           Toast.makeText(this, "에러가 발생", Toast.LENGTH_SHORT).show();
//       }

    }



    private void httpGetTest(){
        // https://jsonplaceholder.typicode.com/todos/1
        String urlString = "https://jsonplaceholder.typicode.com/posts";
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // 참고
            // connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // 통신 성공했을 때
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        connection.getInputStream(),
                        "UTF-8"
                ));
                // 1. 한 라인(한줄)
                //reader.readLine();

//                String line = null;
//                StringBuffer sb = new StringBuffer();
//
//                while( (line = reader.readLine()) != null ) {
//                    sb.append(line + "\n");
//                }
//                Log.d("TAG", sb.toString());

                // Dto를 만들어야함

                // 문자열 --> 하나의 OBJECT 로 변환 하는 방법
//                Todo todo1 = new Gson().fromJson(reader, Todo.class);
//                Log.d("TAG",todo1.title);

                // 문자열 --> 배열 타입으로 변환 하는 방법
//                Todo[] todos = new Gson().fromJson(reader, Todo[].class);
//                Log.d("TAG",todos.toString());

                // 문자열 --> ArrayList 타입으로 변환 하는 방법

                // ArrayList 타입으로 변환하는 방법
                // 1.
                Type todoListType = new TypeToken<ArrayList<Todo2>>() {}.getType();
                // 2.
                ArrayList<Todo2> todoList = new Gson().fromJson(reader, todoListType);

                for(Todo2 t: todoList) {
                    Log.d("TAG","userId : " + t.userId);
                    Log.d("TAG","id : " +  t.id);
                    Log.d("TAG", "title : " + t.title );
                    Log.d("TAG","body : " + t.body );
                }

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}