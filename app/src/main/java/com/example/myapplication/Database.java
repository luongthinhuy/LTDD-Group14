package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final String TAG = "SQLite";

    private SQLiteDatabase database;
    private static final int DATABASE_VERSION = 1;


    public static final String DATABASE_NAME = "ComicForLife";


    public static final String TABLE_BOOK = "Books";
    public static final String COLUMN_BOOK_ID ="Book_Id";
    public static final String COLUMN_BOOK_TITLE ="Book_Title";
    public static final String COLUMN_BOOK_IMAGE = "Book_Image";
    public static final String COLUMN_BOOK_CONTENT = "Book_Content";

    public static final String TABLE_USER = "Users";
    public static final String COLUMN_USER_ID ="User_Id";
    public static final String COLUMN_USER_USERNAME ="UserName";
    public static final String COLUMN_USER_PASSWORD = "Password";
    public static final String COLUMN_USER_NAME = "Name";
    public static final String COLUMN_USER_PHONE = "Phone";
    public static final String COLUMN_USER_GENDER = "Gender";
    public static final String COLUMN_USER_EMAIL = "Email";

    public static final String TABLE_BOOK_DETAIL = "BookDetails";
    public static final String COLUMN_BOOKD_ID = "BookID";
    public static final String COLUMN_BOOK_CHAPTER = "Chapter";
    public static final String COLUMN_CHAPTER_CONTENT = "Content";

    public Database(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String script = "CREATE TABLE " + TABLE_BOOK + "(" + COLUMN_BOOK_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_BOOK_TITLE + " TEXT, "
                + COLUMN_BOOK_IMAGE +" TEXT,"+COLUMN_BOOK_CONTENT+" TEXT)";
        db.execSQL(script);
        String createUserTable = "CREATE TABLE " + TABLE_USER + "(" + COLUMN_USER_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_USERNAME + " TEXT, "
                + COLUMN_USER_NAME +" TEXT,"+COLUMN_USER_PASSWORD+" TEXT,"+COLUMN_USER_PHONE+" TEXT,"
                + COLUMN_USER_GENDER +" INTEGER,"+COLUMN_USER_EMAIL+" TEXT)";
        db.execSQL(createUserTable);
        String createBookDetailTable  = "CREATE TABLE "+ TABLE_BOOK_DETAIL + "(" + COLUMN_BOOKD_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ COLUMN_BOOK_CHAPTER + " INTEGER," + COLUMN_CHAPTER_CONTENT
                + " TEXT)";
        db.execSQL(createBookDetailTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOK);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOK_DETAIL);
        onCreate(db);
    }

    public void createDefaultBooksIfNeed()  {
        int count = this.getBooksCount();
        if(count ==0 ) {
            Book book1 = new Book("Hợp đồng tình nhân","hopdongtinhyeu","The AND operator allows the existence of multiple conditions in a SQLite statement's WHERE clause. While using AND operator, complete condition will be assumed true when all the conditions are true. For example, [condition1] AND [condition2] will be true only when both condition1 and condition2 are true. The AND operator allows the existence of multiple conditions in a SQLite statement's WHERE clause. While using AND operator, complete condition will be assumed true when all the conditions are true. For example, [condition1] AND [condition2] will be true only when both condition1 and condition2 are true. (Thats why i included how to get parameters in my answer look below");
            Book book2 = new Book("Lạnh lùng sau cưới","lanhlungsaucuoi","The AND operator allows the existence of multiple conditions in a SQLite statement's WHERE clause. While using AND operator, complete condition will be assumed true when all the conditions are true. For example, [condition1] AND [condition2] will be true only when both condition1 and condition2 are true. (Thats why i included how to get parameters in my answer look below While using AND operator, complete condition will be assumed true when all the conditions are true. For example, [condition1] AND [condition2] will be true only when both condition1 and condition2 are true.");
            this.addBook(book1);
            this.addBook(book2);
        }
    }

    public void createAdminUser() {
        User admin = new User("admin","admin","ADMIN","0981974393","nqat2003@gmail.com",1);
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_USERNAME, admin.getUsername());
        values.put(COLUMN_USER_PASSWORD, admin.getPassword());
        values.put(COLUMN_USER_NAME, admin.getName());
        values.put(COLUMN_USER_EMAIL, admin.getEmail());


        db.insert(TABLE_USER, null, values);

        db.close();
    }

    public int getBooksCount() {

        String countQuery = "SELECT  * FROM " + TABLE_BOOK;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }

    public void addBook(Book book) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_BOOK_TITLE, book.getBookName());
        values.put(COLUMN_BOOK_IMAGE, book.getBookImage());
        values.put(COLUMN_BOOK_CONTENT, book.getBookContent());

        db.insert(TABLE_BOOK, null, values);

        db.close();
    }

    public void INSERT_Book(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_BOOK_TITLE, book.getBookName());
        values.put(COLUMN_BOOK_IMAGE, book.getBookImage());
        values.put(COLUMN_BOOK_CONTENT,book.getBookContent());
        db.insert(TABLE_BOOK, null, values);
        db.close();
    }

    public void INSERT_User(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_USERNAME, user.getUsername());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        db.insert(TABLE_USER, null, values);
    }

    public void INSERT_BookDetails(BookDetail BD) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_BOOKD_ID, BD.getBookID());
        values.put(COLUMN_BOOK_CHAPTER, BD.getChapter());
        values.put(COLUMN_CHAPTER_CONTENT, BD.getContent());
        database.insertOrThrow(TABLE_BOOK_DETAIL, null, values);
    }

    public Book getBook(String BookId) {
        Book book = new Book();
        int bookID = Integer.parseInt(BookId.trim());
        String selectQuery = "SELECT * FROM " + TABLE_BOOK + " WHERE " + COLUMN_BOOK_ID + "=" + bookID;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (null != cursor){
            cursor.moveToFirst();
            book.setBookID(cursor.getInt(0));
            book.setBookName(cursor.getString(1));
            book.setBookImage(cursor.getString(2));
            book.setBookContent(cursor.getString(3));
        }
        db.close();
        return book;
    }

    public List<Book> getAllBooks() {

        List<Book> noteList = new ArrayList<Book>();

        String selectQuery = "SELECT  * FROM " + TABLE_BOOK;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);



        if (cursor.moveToFirst()) {
            do {
                Book book = new Book();
                book.setBookID(Integer.parseInt(cursor.getString(0)));
                book.setBookName(cursor.getString(1));
                book.setBookImage(cursor.getString(2));

                noteList.add(book);
            } while (cursor.moveToNext());
        }

        return noteList;
    }

    public boolean getUserLogin(String username,String password){
        String countQuery = "SELECT * FROM " + TABLE_USER + " WHERE "+COLUMN_USER_USERNAME+" = '"+username+"' AND "
                            + COLUMN_USER_PASSWORD + " = '" + password +"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();

        cursor.close();
        if (count != 1)
            return false;
        return true;
    }

    public Cursor SELECTSQL(String sql) {
        return database.rawQuery(sql, null);
    }

    public void CloseBD() {
        if (database != null && database.isOpen())
            database.close();
    }
}
