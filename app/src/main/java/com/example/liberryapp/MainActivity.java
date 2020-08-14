package com.example.liberryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.liberryapp.adapters.RecycerViewAdapter;
import com.example.liberryapp.data.BooksName;

import java.util.ArrayList;

import static com.example.liberryapp.data.BooksName.mBooksNames;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mBooksName = new ArrayList<>();
    private BooksName booksName = new BooksName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        booksName.initbooks();
        initRecyclerView();

    }



    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerView.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecycerViewAdapter adapter = new RecycerViewAdapter(this,mBooksNames);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}