package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private List<Book> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext, List<Book> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_view_item, null);
            holder = new ViewHolder();
            holder.bookImage = (ImageView) convertView.findViewById(R.id.imageView_bookImage);
            holder.bookName = (TextView) convertView.findViewById(R.id.textView_bookName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Book book = this.listData.get(position);
        holder.bookName.setText(book.getBookName());
        //holder.bookImage.setImageResource(R.drawable.chuyendicuathanhxuan);

//        int imageId = this.getMipmapResIdByName(book.getBookImage());
//
//        holder.bookImage.setImageResource(imageId);

        int imageId = getIdImageByName(book.getBookImage());
        holder.bookImage.setImageResource(imageId);
        return convertView;
    }

    public int getIdImageByName(String resName)  {
        String pkgName = context.getPackageName();

        int resID = context.getResources().getIdentifier(resName , "drawable", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder {
        ImageView bookImage;
        TextView bookName;
    }

}