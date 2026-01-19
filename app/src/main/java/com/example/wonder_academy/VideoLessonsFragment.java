package com.example.wonder_academy;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VideoLessonsFragment extends Fragment {

    RecyclerView rvVideos;
    ArrayList<Video> videoList = new ArrayList<>();

    public VideoLessonsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_video_lessons, container, false);

        rvVideos = view.findViewById(R.id.rvVideos);
        rvVideos.setLayoutManager(new LinearLayoutManager(getContext()));

        // YouTube video link
        videoList.add(new Video(
                "Android Development",
                R.drawable.and,
                "https://www.youtube.com/watch?v=mXjZQX3UzOs"
        ));



        videoList.add(new Video(
                "Java Full Course",
                R.drawable.java,
                "https://www.youtube.com/watch?v=GoXwIVyNvX0"
        ));


        rvVideos.setAdapter(new VideoAdapter(getContext(), videoList));

        return view;
    }
}
