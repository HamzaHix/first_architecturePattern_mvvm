package com.hixman.first_architecturepattern_mvvm.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.hixman.first_architecturepattern_mvvm.R;


public class MainActivity extends AppCompatActivity {

    // this var will help us listening to MovieViewModel
    MovieViewModel movieViewModel;

    TextView movieNameTV;
    Button  getMovieButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // define the views in the activity
        movieNameTV = findViewById(R.id.tv_movie_name);
        getMovieButton = findViewById(R.id.btn_get_movie_name);

        // here we setup the listener which is the main activity.
        // the main activity can listen to MovieViewModel by just using movieViewModel variable.
        // ViewModelProviders save the data in the movieViewModel , so even if you restart the main activity the data will not be stolen from you; i mean it will not disappear.
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        // here you decide what's gonna happen if  movieNameMutableLiveData changed
        movieViewModel.movieNameMutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                movieNameTV.setText(s);
            }
        });

        getMovieButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                movieViewModel.getMovie_name();
            }
        });



    }
}