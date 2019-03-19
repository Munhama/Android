package com.example.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();

        String[] names = {"Alex", "Vlad", "Artym", "Stas", "Nikita", "Arina"};
        int a, w, g;
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            a = random.nextInt(23 - 18) + 18;
            w = random.nextInt(100 - 50) + 50;
            g = random.nextInt(200 - 160) + 160;

            dbHelper.insertData(names[i], a, w, g);
        }

        Cursor query = db.rawQuery("SELECT * FROM students ORDER BY age", null);
        TableLayout tableLayout = findViewById(R.id.tebleLayout);
        TableRow tableRow = new TableRow(this);
        String[] head = {"NAME", "AGE", "WEIGHT", "GROWTH"};
        for(String c:head){
            TextView tv = new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(16);
            tv.setPadding(5, 5, 5, 5);
            tv.setText(c);
            tableRow.addView(tv);
        }
        tableLayout.addView(tableRow);

        if(query.moveToFirst()){

            do {
                String name = query.getString(0);
                int age = query.getInt(1);
                int weight = query.getInt(2);
                int growth = query.getInt(3);

                TableRow row = new TableRow(this);
                row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.WRAP_CONTENT));
                String[] colText = {name + "", age + "", weight + "", growth + ""};
                for (String text : colText) {
                    TextView tv = new TextView(this);
                    tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                            TableRow.LayoutParams.WRAP_CONTENT));
                    tv.setGravity(Gravity.CENTER);
                    tv.setTextSize(16);
                    tv.setPadding(5, 5, 5, 5);
                    tv.setText(text);
                    row.addView(tv);
                }
                tableLayout.addView(row);
            }while (query.moveToNext());
        }
        query.close();
        db.close();
    }

    class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            super(context, "myDB", null, 2);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE IF NOT EXISTS students (name TEXT, age INTEGER, weight INTEGER, growth INTEGER)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS studednts");
        }

        public void insertData(String name, int age, int weight, int growth) {
            String sql = "INSERT INTO students (name, age, weight, growth) VALUES (?, ?, ?, ?)";
            SQLiteStatement statement = db.compileStatement(sql);

            statement.bindString(1, name);
            statement.bindLong(2, age);
            statement.bindLong(3, weight);
            statement.bindLong(4, growth);

            statement.executeInsert();
        }
    }
}
