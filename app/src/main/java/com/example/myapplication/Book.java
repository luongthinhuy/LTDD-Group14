package com.example.myapplication;


import java.io.Serializable;

public class Book implements Serializable {
    private int bookID;
    private String bookName;
    private String bookImage;
    private String bookContent;

    public Book() {
    }

    public Book(int bookID, String bookName, String bookImage, String bookContent) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookImage = bookImage;
        this.bookContent = bookContent;
    }

    public Book(String bookName, String bookImage, String bookContent) {
        this.bookName = bookName;
        this.bookImage = bookImage;
        this.bookContent = bookContent;
    }

    public String getBookContent() {
        return bookContent;
    }

    public void setBookContent(String bookContent) {
        this.bookContent = bookContent;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    @Override
    public String toString() {
        return this.bookName;
    }
}
