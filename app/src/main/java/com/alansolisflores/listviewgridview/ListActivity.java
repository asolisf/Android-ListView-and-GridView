package com.alansolisflores.listviewgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listView;

    private final List<String> nameList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.MainListView);

        nameList.add("Alan");
        nameList.add("Andy");
        nameList.add("Angel");
        nameList.add("Eduardo");
        nameList.add("Oscar");
        nameList.add("Guillermo");
        nameList.add("Enrique");
        nameList.add("Arturo");
        nameList.add("Hugo");
        nameList.add("Abel");
        nameList.add("Cesar");
        nameList.add("Luka");
        nameList.add("Abril");
        nameList.add("Ariel");
        nameList.add("Rodrigo");

        /*ArrayAdapter<String> namesAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nameList);

        listView.setAdapter(namesAdapter);*/

        listView.setAdapter(new MyAdapter(ListActivity.this,R.layout.item_layout,nameList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String name = nameList.get(position);
                Toast.makeText(ListActivity.this,name,Toast.LENGTH_SHORT).show();
            }
        });
    }
}