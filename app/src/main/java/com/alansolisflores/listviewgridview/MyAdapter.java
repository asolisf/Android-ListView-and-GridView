package com.alansolisflores.listviewgridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context acitivityContext;

    private int layoutId;

    private List<String> nameList;


    public MyAdapter(Context context,int layout, List<String> names)
    {
        this.acitivityContext = context;
        this.layoutId = layout;
        this.nameList = names;
    }

    @Override
    public int getCount() {
        return this.nameList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.nameList.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        //View holder pattern
        ViewHolder holder;

        //First time renderer is null
        if(convertView == null){
            //Fill view with item layout
            LayoutInflater layoutInflater = LayoutInflater.from(this.acitivityContext);
            convertView = layoutInflater.inflate(this.layoutId,null);
            holder = new ViewHolder();

            //Save reference in holder
            holder.nameTextView = convertView.findViewById(R.id.ItemTextView);
            convertView.setTag(holder);
        }else{
            //For example when scroll is up, recover reference
            holder = (ViewHolder) convertView.getTag();
        }

        //Set text by position to TextView
        String name = nameList.get(position);
        holder.nameTextView.setText(name);

        return convertView;
    }

    private static class ViewHolder {
        private TextView nameTextView;
    }
}
