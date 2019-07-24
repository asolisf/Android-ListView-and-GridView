package com.alansolisflores.listviewgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.MainListView);

        final List<String> nameList = new ArrayList<String>();
        nameList.add("Alan");
        nameList.add("Andy");
        nameList.add("Angel");
        nameList.add("Eduardo");
        nameList.add("Oscar");

        ArrayAdapter<String> namesAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nameList);

        listView.setAdapter(namesAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String name = nameList.get(position);
                Toast.makeText(MainActivity.this,name,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
