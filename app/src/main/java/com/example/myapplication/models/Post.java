package com.example.myapplication.models;

public class Post {
    private String Workmanship;
    private String city;
    private int id;
    private int image;
    private String worker_name;
    private String post_description;
    public Post(int id,String workmanship, String city, int image, String worker_name, String post_description) {
        this.id = id;
        Workmanship = workmanship;
        this.city = city;
        this.image = image;
        this.worker_name = worker_name;
        this.post_description = post_description;
    }
    public int getId() {
        return id;
    }
    public String getWorkmanship() {
        return Workmanship;
    }

    public String getCity() {
        return city;
    }

    public int getImage() {
        return image;
    }

    public String getWorker_name() {
        return worker_name;
    }

    public String getPost_description() {
        return post_description;
    }
}
