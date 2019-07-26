package com.alansolisflores.listviewgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GridActivity extends AppCompatActivity {

    private final List<String> nameList = new ArrayList<String>();

    private GridView gridView;

    private int counter = 0;

    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        this.gridView = findViewById(R.id.namesGridView);

        this.nameList.add("Alan");
        this.nameList.add("Andy");
        this.nameList.add("Angel");
        this.nameList.add("Eduardo");
        this.nameList.add("Oscar");
        this.nameList.add("Guillermo");
        this.nameList.add("Enrique");
        this.nameList.add("Arturo");
        this.nameList.add("Hugo");
        this.nameList.add("Abel");
        this.nameList.add("Cesar");

        this.myAdapter = new MyAdapter(GridActivity.this,R.layout.grid_item,nameList);

        this.gridView.setAdapter(this.myAdapter);

        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String name = nameList.get(position);
                Toast.makeText(GridActivity.this,name,Toast.LENGTH_SHORT).show();
            }
        });

        registerForContextMenu(this.gridView);
    }

    /**
     * Set add layout to menu
     * @param menu Menu
     * @return is success
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_bar_menu,menu);
        return true;
    }

    /**
     * Add item to name list
     * @param item Menu item
     * @return Is success
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.addItem:
                this.nameList.add("Added "+(++counter));

                //Notify to adapter that data source changed
                this.myAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Set remove layout to menu
     * @param menu Context menu
     * @param v View
     * @param menuInfo menu info
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v,menuInfo);

        //Set title
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo)menuInfo;

        menu.setHeaderTitle(this.nameList.get(info.position));

        //Set layout
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu,menu);
    }

    /**
     * Remove name from list
     * @param item Menu item
     * @return Is success
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        //Get item info
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.delete_item:
                this.nameList.remove(info.position);

                //Notify to adapter that data source changed
                this.myAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
