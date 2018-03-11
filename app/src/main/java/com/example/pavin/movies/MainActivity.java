package com.example.pavin.movies;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MovieAdapter mMovieAdapter;
    private List<Movie> mMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initCollapsingToolbar();
        mRecyclerView = findViewById(R.id.recycler_view);
        mMovies = new ArrayList<>();
        mMovieAdapter = new MovieAdapter(this, mMovies);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mMovieAdapter);
        prepareMovies();
        try{
            Glide.with(this).load(R.drawable.cover).into((ImageView)findViewById(R.id.backdrop));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void prepareMovies(){
        mMovies.add(new Movie("The Shawshank Redemption", 9, R.drawable.album1));
        mMovies.add(new Movie("The Green Mile", 9, R.drawable.album2));
        mMovies.add(new Movie("Forrest Gump", 9, R.drawable.album3));
        mMovies.add(new Movie("Schindler's List", 8, R.drawable.album4));
        mMovies.add(new Movie("Intouchables", 8, R.drawable.album5));
        mMovies.add(new Movie("Leon", 8, R.drawable.album6));
        mMovies.add(new Movie("Inception", 8, R.drawable.album7));
        mMovies.add(new Movie("The Lion King", 8, R.drawable.album8));
        mMovies.add(new Movie("Fight Club", 8, R.drawable.album9));
        mMovies.add(new Movie("Knockin' on Heaven's Door", 8, R.drawable.album10));
        mMovies.add(new Movie("The Godfather", 8, R.drawable.album11));
        mMovieAdapter.notifyDataSetChanged();
    }

    private void initCollapsingToolbar(){
        final CollapsingToolbarLayout toolbarLayout = findViewById(R.id.collapsing_toolbar);
        toolbarLayout.setTitle(" ");
        AppBarLayout appBarLayout = findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShown = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1)
                    scrollRange = appBarLayout.getTotalScrollRange();
                if(scrollRange + verticalOffset == 0){
                    toolbarLayout.setTitle(getString(R.string.app_name));
                    isShown = true;
                }
                else if(isShown){
                    toolbarLayout.setTitle("");
                    isShown = false;
                }
            }
        });
    }

}
