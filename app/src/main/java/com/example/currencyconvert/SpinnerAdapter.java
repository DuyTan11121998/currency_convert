package com.example.currencyconvert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SpinnerAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Spinner> spinnerList;

    public SpinnerAdapter(Context context, int layout, List<Spinner> spinnerList) {
        this.context = context;
        this.layout = layout;
        this.spinnerList = spinnerList;
    }

    @Override
    public int getCount() {
        return spinnerList.size();
    }

    @Override
    public Object getItem(int position) {
        //
        return null;
    }

    @Override
    public long getItemId(int position) {
        //
        return 0;
    }

    private class viewHolder{
        // giảm thiểu việc ánh xạ lại , tiết kiệm bộ nhớ và xử lý nhanh hơn.
        ImageView img;
        TextView name;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder;

        if (convertView == null ){
            // trả về mỗi dòng trên mỗi cái iterm
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // Lấy phần context nào để nhấn cái layout vào

            convertView = inflater.inflate(layout,null);
            holder = new viewHolder();
            //ánh xạ view

            holder.name =(TextView) convertView.findViewById(R.id.TextViiew_spinner);
            holder.img = (ImageView) convertView.findViewById(R.id.imageView_spinner);
            convertView.setTag(holder);//để truyền vào trạng thái ánh xạ của View
        }else{
            holder = (viewHolder) convertView.getTag();// lấy lại trạng thái của ánh xạ
        }

        Spinner spinner =spinnerList.get(position);
        holder.name.setText(spinner.getName());
        holder.img.setImageResource(spinner.getImage());
        return convertView;
    }
}
