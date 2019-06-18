package kr.ac.kopo.ctc.hanium0617;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.widget.Toolbar;

import javax.security.auth.Subject;

public class MainActivity extends AppCompatActivity {

    Toolbar mytoolbar;
    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //툴바 사용 설정
        mytoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mytoolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true); //커스터마이징 ㄱㄱ
        actionBar.setDisplayShowTitleEnabled(false); //타이틀 노출
        actionBar.setDisplayHomeAsUpEnabled(true); //왼쪽 버튼 사용
        actionBar.setHomeAsUpIndicator(R.drawable.menu); //왼쪽 버튼 아이콘


        //이미지 배열
        int images[] = {R.drawable.switch1, R.drawable.switch2, R.drawable. switch3, R.drawable.switch4};
        v_flipper = findViewById(R.id.v_flipper);

        //for loop
        for (int image: images){
            flipperImages(image);
        }
        TableRow tableRow = (TableRow)findViewById(R.id.row3);
        tableRow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),
                        SubjectActivity.class);
                startActivity(intent);
            }


        });

    }
    //이미지 flipping
    public void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000); //3 sec
        v_flipper.setAutoStart(true);

        //animation
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
//            case R.id.menu_search:
//                Toast.makeText(this,"menu",Toast.LENGTH_SHORT).show();
            case R.id.first:
                Toast.makeText(this, "1111",Toast.LENGTH_SHORT).show();
                break;
            case R.id.second:
                Toast.makeText(this, "2222",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

}
