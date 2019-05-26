package com.example.myapplication;

public class BookDetail {
    private int BookID;
    private int Chapter;
    private String Content;

    public BookDetail(int bookID, int chapter, String content) {
        BookID = bookID;
        Chapter = chapter;
        Content = content;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    public int getChapter() {
        return Chapter;
    }

    public void setChapter(int chapter) {
        Chapter = chapter;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
