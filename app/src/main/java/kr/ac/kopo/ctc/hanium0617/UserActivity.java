package kr.ac.kopo.ctc.hanium0617;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
public class UserActivity extends AppCompatActivity {

    Toolbar mytoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        //툴바
        mytoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mytoolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false); //타이틀 노출
        actionBar.setHomeAsUpIndicator(R.drawable.ic_clear_24dp); //왼쪽 버튼 아이콘
        actionBar.setDisplayHomeAsUpEnabled(true); //툴바 왼쪽 버튼 활성화
    }


    //툴바 메뉴 불러오기
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the munu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
//        MenuItem searchItem = menu.findItem(R.id.toolbar_search);
//        SearchView searchView = (SearchView)menu.findItem(R.id.toolbar_search).getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                return false;
//            }
//        });
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

