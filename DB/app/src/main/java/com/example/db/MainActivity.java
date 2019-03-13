package com.example.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("ap.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS students (name TEXT, age INTEGER, weight INTEGER, growth INTEGER)");
        db.execSQL("INSERT INTO students VALUES ('Tom Smith', 23, 90, 190);");
        db.execSQL("INSERT INTO students VALUES ('John Dow', 31, 75, 180);");

        Cursor query = db.rawQuery("SELECT * FROM students;", null);
        TextView textView = (TextView) findViewById(R.id.textView);

        if(query.moveToFirst()){
            do{
                String name = query.getString(0);
                int age = query.getInt(1);
                int weight = query.getInt(2);
                int growth = query.getInt(3);
                textView.append("Name: " + name + " Age: " + age + " Weight: "+ weight + " Growth: " + growth + "\n");
            }
            while(query.moveToNext());
        }
        query.close();
        db.close();
    }
}
