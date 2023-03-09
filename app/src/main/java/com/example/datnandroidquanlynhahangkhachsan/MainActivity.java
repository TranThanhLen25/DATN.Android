package com.example.datnandroidquanlynhahangkhachsan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectClause0;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Job job = new Job(id:1, job:Coder)
        List<Favorite> favorites = new ArrayList<>();
        favorites.add(new Favorite(id:1, favorites:"foodball"));
        favorites.add(new Favorite(id:2, favorites "go fishing"));
        DangNhap dangnhap = new DangNhap(id:1, name:"ThanhLEN", isActive:true, job, favorites);
        Gson gson=new Gson();
        String AtrJson=gson.toJson(dangnhap);
        Log.e(tag:"String Json",AtrJson);
    }
}