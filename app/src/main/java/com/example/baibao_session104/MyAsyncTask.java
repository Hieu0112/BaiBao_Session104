package com.example.baibao_session104;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baibao_session104.model.Item;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class MyAsyncTask extends AsyncTask<Void,Void,Void> {
    private final Context context;
    private final String link;
    private List<Item>list;
    private RecyclerView recyclerView;
    RecycleViewAdapter adapter;

    public MyAsyncTask(Context context, String link, RecyclerView recyclerView) {
        this.context = context;
        this.link = link;
        this.recyclerView = recyclerView;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url=new URL(link);
            URLConnection connection=url.openConnection();
            InputStream is=connection.getInputStream();
            // doc
            list=(List<Item>)MySaxParser.xmlParser(is);
        }catch (Exception e){
            Log.e("doInBackground", "Error parsing XML", e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        adapter= new RecycleViewAdapter(context,list);
        LinearLayoutManager manager=new LinearLayoutManager(context,
                RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}
