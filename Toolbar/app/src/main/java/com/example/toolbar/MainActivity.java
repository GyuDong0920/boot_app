package com.example.toolbar;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    // 값을 돌려받을 때 사용하는 코드 // ob 두개를 매개변수로 넣어줌
    ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                Log.d("TAG","comeback 돌아왔다~");
                if(result.getResultCode() == Activity.RESULT_OK) {
                    // 정상 동작
                    Intent data = result.getData();
                    int returnValue = data.getIntExtra("result", 0);
                    textView.setText(returnValue + "");
                } else {
                    // 실패 !!
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tool_bar);
//        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        textView = findViewById(R.id.tempTextView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.memuItem1:
                Log.d("TAG", "1번 클릭");
                Intent intent = new Intent(this, SubActivity.class);
                intent.putExtra("value1",10);
//                startActivity(intent); 값을 돌려받지 않을 때 쓰는 코드
                // 값을 돌려 받아야 될 때 !!!
                startActivityResult.launch(intent);
                break;
            case R.id.memuItem2:
                Log.d("TAG", "2번 클릭");
                break;
            case R.id.memuItem3:
                Log.d("TAG", "3번 클릭");
                break;
        }


        return true;
    }
}
