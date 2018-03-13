package com.example.pavin.movies;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements MovieAdapter.onMovieClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // if(findViewById(R.id.recycler_fragment) == null) {
            if (savedInstanceState == null) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                RecyclerFragment recyclerFragment = new RecyclerFragment();
                fragmentTransaction.add(R.id.main_content, recyclerFragment);
                fragmentTransaction.commit();
            }
      //  }
        initCollapsingToolbar();
        try{
            Glide.with(this).load(R.drawable.cover).into((ImageView)findViewById(R.id.backdrop));
        }
        catch (Exception e){
            e.printStackTrace();
        }
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

    public void onClickMovie(Movie movie) {
        Toast.makeText(this, movie.getName(), Toast.LENGTH_SHORT).show();
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
          /*  Intent intent = new Intent(this, class);
            intent.putExtra("movie", movie);
            startActivity(intent);*/
        }
        else{

            DetailFragment detailFragment = (DetailFragment)getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
            if(detailFragment == null) {
                detailFragment = DetailFragment.newInstance(movie);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.linear_land, detailFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
            //else detailFragment.updateMovie(movie);
        }
    }
}
