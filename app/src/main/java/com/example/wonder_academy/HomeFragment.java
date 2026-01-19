package com.example.wonder_academy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    CourseAdapter adapter;
    ArrayList<Course> courseList;

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerCourses);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        courseList = new ArrayList<>();
        courseList.add(new Course("Java Beginner", "Start learning Java from scratch"));
        courseList.add(new Course("Android Development", "Create Android apps (Java)"));
        courseList.add(new Course("AI Basics", "Learn fundamentals of AI"));
        courseList.add(new Course("Python Full Course", "Complete Python training"));

        adapter = new CourseAdapter(getContext(), courseList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
