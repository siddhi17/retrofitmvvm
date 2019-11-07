package com.example.retrofitmvvm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.retrofitmvvm.Adapter.CommentsAdapter;
import com.example.retrofitmvvm.Adapter.VenueAdapter;
import com.example.retrofitmvvm.Model.Comments;
import com.example.retrofitmvvm.Model.Venue;
import com.example.retrofitmvvm.ViewModel.VenueViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VenueAdapter adapter;
    private CommentsAdapter commentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpView();
        ViewModelCalls();

    }

    public void setUpView()
    {
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void ViewModelCalls(){

        VenueViewModel model = ViewModelProviders.of(this).get(VenueViewModel.class);

   /*     model.getVenues().observe(this, new Observer<List<Venue>>() {
            @Override
            public void onChanged(@Nullable List<Venue> heroList) {
                adapter = new VenueAdapter(MainActivity.this, heroList);
                recyclerView.setAdapter(adapter);
            }
        });*/


        model.getComments().observe(this, new Observer<List<Comments>>() {
            @Override
            public void onChanged(@Nullable List<Comments> heroList) {
                commentsAdapter = new CommentsAdapter(MainActivity.this, heroList);
                recyclerView.setAdapter(commentsAdapter);
            }
        });

        model.getComments().observe(this, new Observer<List<Comments>>() {
            @Override
            public void onChanged(@Nullable List<Comments> heroList) {
                commentsAdapter = new CommentsAdapter(MainActivity.this, heroList);
                recyclerView.setAdapter(commentsAdapter);
            }
        });

    }

}
