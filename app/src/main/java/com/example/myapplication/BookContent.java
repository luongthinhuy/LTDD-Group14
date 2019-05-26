package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class BookContent extends AppCompatActivity {
    private Database dataHelper = new Database(this);
    private TextView BookName;
    private TextView BookContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_book);
        BookName = (TextView) findViewById(R.id.tv_BookName);
        BookContent = (TextView) findViewById(R.id.tv_BookContent);
        Intent myIntent = getIntent();
        String bookID = myIntent.getStringExtra("bookID");
        Book book = new Book();
        book = dataHelper.getBook(bookID);
        BookName.setText(book.getBookName());
        BookContent.setText(book.getBookContent());
    }
}
