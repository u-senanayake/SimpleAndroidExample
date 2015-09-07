package com.alumaworks.udayanga.databasetestapp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Udayanga on 8/18/2015.
 */
public class FriendHelper extends ContentProvider {
    static final String PROVIDER_NAME = "com.alumaworks.udayanga.databasetestapp";
    static final String URL = "content://" + PROVIDER_NAME + "/friends1";
    static final Uri CONTENT_URI = Uri.parse(URL);

    static final int FRIENDS = 1;

    static final UriMatcher uriMatcher;
    static{
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "friends1", FRIENDS);
    }
    FriendsDB friendsDB;
    public FriendHelper(Context context){
        friendsDB = new FriendsDB(context);
    }

    public void addFriend(String friendName1,String friendName2){
        SQLiteDatabase db = friendsDB.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("friend_name_1", friendName1);
        values.put("friend_name2",friendName2);
        db.insert("friends1", null, values);
        //db.insert("friend2",null,values);
        db.close();
        db.close();
    }

    public List<String> getFriends(){
        List<String> friends = new ArrayList<String>();

        SQLiteDatabase db = friendsDB.getReadableDatabase();
        Cursor cursor = db.query("friends1", new String[] {"friend_name_1"}, null, null, null, null, null);
        while (cursor.moveToNext()){
            friends.add(cursor.getString(0));
        }
        cursor.close();
        db.close();

        return friends;
    }
    @Override
    public boolean onCreate() {
        friendsDB = new FriendsDB(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings2, String s2) {
        SQLiteDatabase db = friendsDB.getReadableDatabase();
        Cursor cursor = db.query("friends1", new String[] {"friend_name_1"},null,null,null, null, null);
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case FRIENDS:
                return "vnd.android.cursor.dir/vnd.me.dilan.friends";
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
    static class FriendsDB extends SQLiteOpenHelper {
        private final static String DB_NAME = "friends_db";
        private final static int DB_VERSION = 1;

        public FriendsDB(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table friends (_id integer primary key autoincrement," +
                    "friend_name varchar(255) not null);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table friends;");
            onCreate(db);
        }
    }
}
