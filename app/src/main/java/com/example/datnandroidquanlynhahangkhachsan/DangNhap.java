package com.example.datnandroidquanlynhahangkhachsan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

import kotlinx.coroutines.Job;

public class DangNhap {
    private int id;
    private String name;
    private boolean isActive;
    private Job job;
    private List<Favorite> favorites;

    public DangNhap(int id, String nam, boolean isActive, Job job, List<Favorite> favorites) {
        this.id = id;
        this.nam = nam;
        this.isActive = isActive;
        this.job = job;
        this.favorites = favorites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }
}