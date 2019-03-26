package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //private ImageButton showPro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //showPro.findViewById(R.id.avatar);

        List<Book> image_details = getListBook();
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, image_details));
//        showPro.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,ProfileActivity.class));
//            }
//        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Book book = (Book) o;
                Toast.makeText(MainActivity.this, "Selected :" + " " + book, Toast.LENGTH_LONG).show();
            }
        });
    }
    private List<Book> getListBook(){
        List<Book> list = new ArrayList<Book>();
        Book HopDongTinhNhan = new Book("Hợp đồng tình nhân",16,"hopdongtinhyeu");
        Book LanhLungSauCuoi = new Book("Lạnh lùng sau cưới",36,"lanhlungsaucuoi");
        Book ChuyenDiCuaThanhXuan = new Book("Chuyến đi của thanh xuân", 20,"chuyendicuathanhxuan");
        Book CoMan = new Book("Cố Mạn",40,"coman");
        Book CuaHangBachHoa = new Book("Cửa hàng bách hóa vương tử",15,"cuahangbachhoavuongtu");
        list.add(HopDongTinhNhan);
        list.add(LanhLungSauCuoi);
        list.add(ChuyenDiCuaThanhXuan);
        list.add(CoMan);
        list.add(CuaHangBachHoa);
        return list;
    }
}
