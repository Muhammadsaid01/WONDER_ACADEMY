package com.example.wonder_academy;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Set;

public class MyLearningFragment extends Fragment {

    ListView listView;

    public MyLearningFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mylearning, container, false);

        listView = view.findViewById(R.id.listMyCourses);

        SharedPreferences prefs = getContext().getSharedPreferences("MyLearning", getContext().MODE_PRIVATE);
        Set<String> saved = prefs.getStringSet("courses", null);

        ArrayList<String> list = new ArrayList<>();
        if (saved != null) list.addAll(saved);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1,
                list);

        listView.setAdapter(adapter);

        return view;
    }
}
