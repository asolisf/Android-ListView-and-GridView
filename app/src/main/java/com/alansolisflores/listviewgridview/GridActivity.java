package com.alansolisflores.listviewgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private final List<String> nameList = new ArrayList<String>();

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = findViewById(R.id.namesGridView);

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

        gridView.setAdapter(new MyAdapter(GridActivity.this,R.layout.grid_item,nameList));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String name = nameList.get(position);
                Toast.makeText(GridActivity.this,name,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
