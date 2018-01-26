package com.example.tapos.magitionapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.tapos.magitionapplication.models.Magic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tapos on 1/26/18.
 */

public class MagicOperations {

    public static final String LOGTAG = "EMP_MNGMNT_SYS";

    SQLiteOpenHelper dbhandler;
    SQLiteDatabase database;

    private static final String[] allColumns = {
            MagicDBHandler.COLUMN_ID,
            MagicDBHandler.COLUMN_TITLE,
            MagicDBHandler.COLUMN_DESCRIPTION,
            MagicDBHandler.COLUMN_THUMBNAIL
    };

    public MagicOperations(Context context){
        dbhandler = new MagicDBHandler(context);
    }

    public void open(){
        Log.i(LOGTAG,"Database Opened");
        database = dbhandler.getWritableDatabase();


    }
    public void close(){
        Log.i(LOGTAG, "Database Closed");
        dbhandler.close();

    }
    public Magic addMagic(Magic magic){
        ContentValues values  = new ContentValues();
        values.put(MagicDBHandler.COLUMN_TITLE,magic.getTitle());
        values.put(MagicDBHandler.COLUMN_DESCRIPTION,magic.getDescription());
        values.put(MagicDBHandler.COLUMN_THUMBNAIL, magic.getThumbnail());
        long insertid = database.insert(MagicDBHandler.TABLE_MAGIC,null,values);
        magic.setId(insertid);
        return magic;

    }

    // Getting single Employee
    public Magic getAMagic(long id) {

        Cursor cursor = database.query(MagicDBHandler.TABLE_MAGIC,allColumns,MagicDBHandler.COLUMN_ID + "=?",new String[]{String.valueOf(id)},null,null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Magic e = new Magic(Long.parseLong(cursor.getString(0)),cursor.getString(1),cursor.getString(2),Integer.parseInt(cursor.getString(3)));
        // return Employee
        return e;
    }

    public List<Magic> getAllMagic() {

        Cursor cursor = database.query(MagicDBHandler.TABLE_MAGIC,allColumns,null,null,null, null, null);

        List<Magic> magics = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                Magic magic = new Magic();
                magic.setId(cursor.getLong(cursor.getColumnIndex(MagicDBHandler.COLUMN_ID)));
                magic.setTitle(cursor.getString(cursor.getColumnIndex(MagicDBHandler.COLUMN_TITLE)));
                magic.setDescription(cursor.getString(cursor.getColumnIndex(MagicDBHandler.COLUMN_DESCRIPTION)));
                magic.setThumbnail(cursor.getInt(cursor.getColumnIndex(MagicDBHandler.COLUMN_THUMBNAIL)));
                magics.add(magic);
            }
        }
        // return All Employees
        return magics;
    }




    // Updating Magic
    public int updateEmployee(Magic magic) {

        ContentValues values = new ContentValues();
        values.put(MagicDBHandler.COLUMN_TITLE,magic.getTitle());
        values.put(MagicDBHandler.COLUMN_DESCRIPTION,magic.getDescription());
        values.put(MagicDBHandler.COLUMN_THUMBNAIL, magic.getThumbnail());
        // updating row
        return database.update(MagicDBHandler.TABLE_MAGIC, values,
                MagicDBHandler.COLUMN_ID + "=?",new String[] { String.valueOf(magic.getId())});
    }

    // Deleting Employee
    public void removeEmployee(Magic magic) {

        database.delete(MagicDBHandler.TABLE_MAGIC, MagicDBHandler.COLUMN_ID + "=" + magic.getId(), null);
    }
}
