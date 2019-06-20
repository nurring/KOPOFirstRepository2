package kr.ac.kopo.ctc.hanium0617;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NotloginActivity extends AppCompatActivity {

    Toolbar mytoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notlogin);
        Button login;

        //툴바
        mytoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mytoolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false); //타이틀 노출
        actionBar.setHomeAsUpIndicator(R.drawable.ic_clear_24dp); //왼쪽 버튼 아이콘
        actionBar.setDisplayHomeAsUpEnabled(true); //툴바 왼쪽 버튼 활성화

        //로그인하기
        login = (Button) findViewById(R.id.notlogin_loginBtn);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText idEdit, passEdit;
                final String idStr, passStr;
                idEdit = (EditText)findViewById(R.id.notlogin_id);
                passEdit = (EditText)findViewById(R.id.notlogin_pw);
                idStr = idEdit.getText().toString();
                passStr = passEdit.getText().toString();

                if(idStr.contentEquals("iamkyd") && passStr.contentEquals("1111")){
                    Intent intent = new Intent(getApplicationContext(),
                            UserActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"로그인 실패", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    //툴바 메뉴 불러오기
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the munu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    //툴바
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(intent);
                break;
            case R.id.toolbar_user:
                Intent intent1 = new Intent(getApplicationContext(),
                        UserActivity.class);
                startActivity(intent1);
                finish();
                break;
        }
        return true;
    }
}
