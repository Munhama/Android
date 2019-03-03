package com.example.tab;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class ThreeFragment extends Fragment{

    public ThreeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_three, container, false);
        Context context = getActivity().getApplicationContext();
        LinearLayout layout = new LinearLayout(context);

        TableLayout tableLayout = new TableLayout(context);
        tableLayout.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tableLayout.setStretchAllColumns(true);

        ImageView imageView1 = new ImageView(context);
        imageView1.setImageResource(R.drawable.alex);
        TextView textView2 = new TextView(context);
        textView2.setText("Alex");
        textView2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView textView3 = new TextView(context);
        textView3.setText("Programmer");
        textView3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageResource(R.drawable.artyem);
        TextView textView5 = new TextView(context);
        textView5.setText("Artyem");
        textView5.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView textView6 = new TextView(context);
        textView6.setText("English man");
        textView6.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        ImageView imageView3 = new ImageView(context);
        imageView3.setImageResource(R.drawable.vlad);
        TextView textView8 = new TextView(context);
        textView8.setText("Vlad");
        textView8.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView textView9 = new TextView(context);
        textView9.setText("I don't know");
        textView9.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);

        TableRow tableRow1 = new TableRow(context);
        tableRow1.addView(imageView1);
        tableRow1.addView(textView2);
        tableRow1.addView(textView3);
        TableRow tableRow2 = new TableRow(context);
        tableRow2.addView(imageView2);
        tableRow2.addView(textView5);
        tableRow2.addView(textView6);
        TableRow tableRow3 = new TableRow(context);
        tableRow3.addView(imageView3);
        tableRow3.addView(textView8);
        tableRow3.addView(textView9);

        tableLayout.addView(tableRow1);
        tableLayout.addView(tableRow2);
        tableLayout.addView(tableRow3);

        layout.addView(tableLayout);
        return layout;
    }

}