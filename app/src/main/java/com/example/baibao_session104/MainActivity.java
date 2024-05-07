package com.example.baibao_session104;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycleView);
        String link="https://vnexpress.net/rss/du-lich.rss";
        MyAsyncTask myAsyncTask=new MyAsyncTask(MainActivity.this,link,recyclerView);
        myAsyncTask.execute();
    }
}