package com.example.tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class TwoFragment extends Fragment{

    public TwoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two, container, false);

        ListView listView = view.findViewById(R.id.listView);
        final String[] names = getResources().getStringArray(R.array.spis);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.list_item, R.id.name, names);
        listView.setAdapter(adapter);
        return view;
    }

}