package com.example.testapp;

import android.util.Log;

import java.util.Date;

public class Run{

    private String title, metric, weatherCondition, mood, notes, distance, time, pace, goals;
    private Date runDate;
    //private
    private boolean makePublic;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPace() {
        return pace;
    }

    public void setPace(String pace) {
        this.pace = pace;
    }

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }

    public boolean isMakePublic() {
        return makePublic;
    }

    public void setMakePublic(boolean makePublic) {
        this.makePublic = makePublic;
    }

    public void setGoals(String goals){
        this.goals = goals;
    }

    public String getGoals(){
        return goals;
    }

    @Override
    public String toString() {
        return "Run{" +
                "title='" + title + '\'' +
                ", metric='" + metric + '\'' +
                ", weatherCondition='" + weatherCondition + '\'' +
                ", mood='" + mood + '\'' +
                ", notes='" + notes + '\'' +
                ", distance='" + distance + '\'' +
                ", time='" + time + '\'' +
                ", pace='" + pace + '\'' +
                ", runDate=" + runDate +
                ", makePublic=" + makePublic +
                '}';
    }
}
