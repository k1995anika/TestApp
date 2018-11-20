package com.kanika.testapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TeacherDb extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "timeTable";
    private static final String TABLE_QUEST = "teacher";
    // tasks Table Columns names
    private static final String _ID = "_ID";
    private static final String EmpId = "EmpId";
    private static final String Name = "Name";
    private static final String Subjects = "Subjects";



    public TeacherDb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ("
                + _ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " + EmpId
                + " TEXT, " + Name + " TEXT, " + Subjects + " TEXT)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }

    // Adding new teacher
    public void addTeacher(Teacher teacher) {
         SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(EmpId,teacher.getEmpId().toString());
        values.put(Name,teacher.getName().toString());
        values.put(Subjects,teacher.getSubjects().toString());

        // Inserting Row
        db.insert(TABLE_QUEST, null, values);
    }

    public List<Teacher> getAllTeachers() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Teacher> teacherList = new ArrayList<Teacher>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        return teacherList;
    }



}
