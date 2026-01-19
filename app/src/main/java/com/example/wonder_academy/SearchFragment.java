package com.example.wonder_academy;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    EditText edtSearch;
    RecyclerView rvSearch;
    ArrayList<Course> allCourses = new ArrayList<>();
    ArrayList<Course> filteredList = new ArrayList<>();
    CourseAdapter adapter;

    public SearchFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);

        edtSearch = view.findViewById(R.id.edtSearch);
        rvSearch = view.findViewById(R.id.rvSearchResults);

        rvSearch.setLayoutManager(new LinearLayoutManager(getContext()));


        allCourses.add(new Course("Android Development Basic", "Learn Android step by step"));
        allCourses.add(new Course("Java Programming", "Full Java course for beginners"));
        allCourses.add(new Course("Python Masterclass", "Zero to hero Python"));
        allCourses.add(new Course("UI/UX Design", "Design modern mobile apps"));
        allCourses.add(new Course("Web Development", "HTML, CSS, JS complete course"));

        filteredList.addAll(allCourses);


        adapter = new CourseAdapter(getContext(), filteredList);
        rvSearch.setAdapter(adapter);


        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                filteredList.clear();

                for (Course c : allCourses) {
                    if (c.title.toLowerCase().contains(s.toString().toLowerCase())) {
                        filteredList.add(c);
                    }
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        return view;
    }
}
