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
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CategoryActivity extends AppCompatActivity {

    Toolbar mytoolbar;
    TextView mapBtn;

    //expandable List를 위한 변수
    ExpandableListView listView;
    ExpandableListAdapter listAdapter;
    List<String> listDataHeader;
    HashMap<String,List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        //맵 (임시)
        mapBtn = (TextView) findViewById(R.id.map);
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        MapActivity.class);
                startActivity(intent);
            }
        });

        //툴바 사용 설정
        mytoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mytoolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false); //타이틀 노출
        actionBar.setHomeAsUpIndicator(R.drawable.ic_clear_24dp); //왼쪽 버튼 아이콘

        //expandablelistview 구현
        listView = (ExpandableListView)findViewById(R.id.category_Exp);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);
    }


    //expandableList 내의 실제 리스트 내용
    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("음악");
        listDataHeader.add("미술");
        listDataHeader.add("공예");
        listDataHeader.add("요리");
        listDataHeader.add("생활");
        listDataHeader.add("운동");

        List<String> mus = new ArrayList<>();
        mus.add("피아노");
        mus.add("보컬");
        mus.add("기타");
        mus.add("드럼");
        mus.add("믹싱");

        List<String> art = new ArrayList<>();
        art.add("수채화");
        art.add("유화");
        art.add("동양화");
        art.add("스케치");
        art.add("사진");
        art.add("영상");
        art.add("캘리그라피");

        List<String> cra = new ArrayList<>();
        cra.add("비누");
        cra.add("캔들");
        cra.add("도예");
        cra.add("플라워");

        List<String> coo = new ArrayList<>();
        coo.add("한식");
        coo.add("일식");
        coo.add("양식");
        coo.add("베이킹");

        List<String> liv = new ArrayList<>();
        liv.add("반려동물");
        liv.add("인테리어");
        liv.add("조경");
        liv.add("DIY");

        List<String> exc = new ArrayList<>();
        exc.add("스쿠버다이빙");
        exc.add("글램핑");

        listHash.put(listDataHeader.get(0),mus);
        listHash.put(listDataHeader.get(1),art);
        listHash.put(listDataHeader.get(2),coo);
        listHash.put(listDataHeader.get(3),cra);
        listHash.put(listDataHeader.get(4),liv);
        listHash.put(listDataHeader.get(5),exc);
    }


    //툴바 레이아웃 불러오기
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return true;
    }

    //툴바 레이아웃 내 아이템들 효과 주기
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(intent);
                break;
            case R.id.toolbar_search:
                Toast.makeText(this, "search",Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolbar_user:
                Toast.makeText(this, "user",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
