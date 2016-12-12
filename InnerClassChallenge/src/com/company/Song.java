package com.company;

/**
 * Created by Trebek on 12/5/16.
 */
public class Song {
    private String title;
    private String duration;

    Song(String title, String duration){
        this.title = title;
        this.duration = duration;
    }

    public String getTitle(){
        return title;
    }

    public String getDuration(){
        return duration;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDuration(String duration){
        this.duration = duration;
    }

    @Override
    public String toString(){
        return this.title + ": " + this.duration;
    }
}




