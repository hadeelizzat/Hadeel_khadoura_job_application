package com.example.myapplication.models;

public class Worker {
    private  int image;
    private String name;
    private int id;

    public Worker(int id, int image, String name) {
        this.id = id;
        this.image = image;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

}
