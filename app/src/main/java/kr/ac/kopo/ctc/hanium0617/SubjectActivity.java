package kr.ac.kopo.ctc.hanium0617;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;


public class SubjectActivity extends AppCompatActivity {

    Toolbar mytoolbar;
    LinearLayout sinfo, srefund;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        //툴바 사용 설정
        mytoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mytoolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true); //커스터마이징 ㄱㄱ
        actionBar.setDisplayShowTitleEnabled(false); //타이틀 노출
        actionBar.setDisplayHomeAsUpEnabled(true); //왼쪽 버튼 사용
        actionBar.setHomeAsUpIndicator(R.drawable.menu); //왼쪽 버튼 아이콘

        //fragment 지정
        sinfo = (LinearLayout) findViewById(R.id.subject_info);
        srefund = (LinearLayout) findViewById(R.id.subject_refund);

        sinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment1 fragment1 = new Fragment1();
                transaction.replace(R.id.main_frame, fragment1);
                transaction.commit();
            }
        });

        srefund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment2 fragment2 = new Fragment2();
                transaction.replace(R.id.main_frame, fragment2);
                transaction.commit();
            }
        });
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
