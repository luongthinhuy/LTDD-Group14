package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageButton showPro;
    private Database dataHelper = new Database(this);
    private Cursor cursor;
    private CustomListAdapter adapter;
    private final List<Book> list= new ArrayList<Book>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showPro =  (ImageButton) findViewById(R.id.avatar);
        dataHelper.createDefaultBooksIfNeed();
        LoadData();
        List<Book> list = dataHelper.getAllBooks();
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, list));

        profile();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Book book = (Book) o;
                Intent myIntent = new Intent(MainActivity.this, BookContent.class);
                myIntent.putExtra("bookID",book.getBookID()+" ");
                startActivity(myIntent);
            }
        });
    }

    private void profile(){
        showPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
    private void LoadData(){
        Book ChuyenDiCuaThanhXuan = new Book("Chuyến đi của thanh xuân","chuyendicuathanhxuan","SQLite AND & OR operators are used to compile multiple conditions to narrow down the selected data in an SQLite statement. These two operators are called conjunctive operators.The OR operator is also used to combine multiple conditions in a SQLite statement's WHERE clause. While using OR operator, complete condition will be assumed true when at least any of the conditions is true. For example, [condition1] OR [condition2] will be true if either condition1 or condition2 is true.");
        Book CoMan = new Book("Cố Mạn","coman","The OR operator is also used to combine multiple conditions in a SQLite statement's WHERE clause. While using OR operator, complete condition will be assumed true when at least any of the conditions is true. SQLite AND & OR operators are used to compile multiple conditions to narrow down the selected data in an SQLite statement. These two operators are called conjunctive operators For example, [condition1] OR [condition2] will be true if either condition1 or condition2 is true.");
        Book CuaHangBachHoa = new Book("Cửa hàng bách hóa vương tử","cuahangbachhoavuongtu","You can combine N number of conditions using OR operator. For an action to be taken by the SQLite statement,SQLite AND & OR operators are used to compile multiple conditions to narrow down the selected data in an SQLite statement. These two operators are called conjunctive operators whether it be a transaction or query, only any ONE of the conditions separated by the OR must be TRUE. SQLite AND & OR operators are used to compile multiple conditions to narrow down the selected data in an SQLite statement. These two operators are called conjunctive operators");
        dataHelper.INSERT_Book(ChuyenDiCuaThanhXuan);
        dataHelper.INSERT_Book(CoMan);
        dataHelper.INSERT_Book(CuaHangBachHoa);
    }
}
