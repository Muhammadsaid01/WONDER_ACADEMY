package com.example.wonder_academy;

public class Video {
    String title;
    String videoUrl;

    // URL Thumbnail
    String thumbnailUrl;

    // Drawable Thumbnail
    int thumbnailRes = 0;

    // URL constructor
    public Video(String title, String thumbnailUrl, String videoUrl) {
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.videoUrl = videoUrl;
    }

    // Drawable constructor
    public Video(String title, int thumbnailRes, String videoUrl) {
        this.title = title;
        this.thumbnailRes = thumbnailRes;
        this.videoUrl = videoUrl;
    }
}
