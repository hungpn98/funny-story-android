package com.hungpn.funnystories;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.hungpn.funnystories.story.Story;
import com.hungpn.funnystories.title.Title;
import com.hungpn.funnystories.topic.Topic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ManagerSql {
    private static final String DB_NAME = "truyencuoi";
    private Context context;
    private SQLiteDatabase sqLiteDatabase;

    public ManagerSql(Context context) {
        this.context = context;
        copyEXApp();
    }

    private void copyEXApp() {
        String path = Environment.getDataDirectory().getPath() + "/data/" +
                context.getPackageName() + "/db";
        if (new File(path + "/" + DB_NAME).exists()) {
            return;
        }
        try {
            InputStream in = context.getAssets().open(DB_NAME);

            new File(path).mkdir();
            OutputStream out = new FileOutputStream(path + "/" + DB_NAME);

            byte[] b = new byte[1024];
            int lengh = in.read(b);
            while (lengh > -1) {
                out.write(b, 0, lengh);
                lengh = in.read(b);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openDB() {
        if (sqLiteDatabase == null || sqLiteDatabase.isOpen() == false) {
            String path = Environment.getDataDirectory().getPath() + "/data/" +
                    context.getPackageName() + "/db";
            sqLiteDatabase = SQLiteDatabase.openDatabase(path + "/" + DB_NAME, null,
                    SQLiteDatabase.OPEN_READWRITE);
        }
    }

    private void closeDB() {
        if (sqLiteDatabase == null || sqLiteDatabase.isOpen() == false) {
            return;
        }
        sqLiteDatabase.close();
        sqLiteDatabase = null;
    }

    public List<Topic> getAllTopic() {
        List<Topic> list = new ArrayList<>();
        openDB();
        Cursor c = sqLiteDatabase.rawQuery("select * from categories", null);
        c.moveToFirst();
        int indexID = c.getColumnIndex("id");
        int indextName = c.getColumnIndex("name");

        while (!c.isAfterLast()) {
            int id = c.getInt(indexID);
            String name = c.getString(indextName);
            list.add(new Topic(id, name));
            c.moveToNext();
        }
        closeDB();

        return list;
    }

    public List<Title> getAllTitle(int idCat) {
        List<Title> titleList = new ArrayList<>();
        openDB();
        Cursor c = sqLiteDatabase.rawQuery(
                "select * from stories where cat_id = " +idCat, null);
        c.moveToFirst();
        int indexId = c.getColumnIndex("cat_id");
        int indexIdStory = c.getColumnIndex("id");
        int indexName = c.getColumnIndex("name");

        while (!c.isAfterLast()) {
            int id = c.getInt(indexId);
            int idStory = c.getInt(indexIdStory);
            String name = c.getString(indexName);
            titleList.add(new Title(name, id, idStory));
            c.moveToNext();

        }
        c.close();
        closeDB();
        return titleList;
    }
    public Story getStory(int id ){
        Story story;
        String name;
        String detail;

        openDB();
        Cursor c = sqLiteDatabase.rawQuery(
                "select * from stories where id = " +id, null);
        c.moveToFirst();
        int indexName = c. getColumnIndex("name");
        int indexStory = c.getColumnIndex("content");
        detail = c.getString(indexStory);
        name = c.getString(indexName);
        story =new Story(name,detail);
        closeDB();
        return story;
    }
}
