package com.example.myapplication;


public class Book {
    private String bookName;
    private int bookChapter;
    private String bookImage;

    public Book(String bookName, int bookChapter, String bookImage){
        this.bookName = bookName;
        this.bookChapter = bookChapter;
        this.bookImage = bookImage;
    }

    public int getBookChapter() {
        return bookChapter;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public void setBookChapter(int bookChapter) {
        this.bookChapter = bookChapter;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return this.bookName;
    }
}
