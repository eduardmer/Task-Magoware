package com.detyre_magoware_android.data_model;

public class Programe {

    private String name;
    private String duration;
    private long startTime;
    private long endTime;
    private boolean publicitet;

    public Programe(String name, String duration){
        this.name=name;
        this.duration=duration;
        this.publicitet=false;
    }

    public Programe(String name, String duration, boolean publicitet){
        this.name=name;
        this.duration=duration;
        this.publicitet=publicitet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public boolean isPublicitet() {
        return publicitet;
    }

    public void setPublicitet(boolean publicitet) {
        this.publicitet = publicitet;
    }
}
