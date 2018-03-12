package com.example.pavin.movies;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements RecyclerFragment.onMovieClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(savedInstanceState == null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            RecyclerFragment recyclerFragment = new RecyclerFragment();
            fragmentTransaction.add(R.id.main_content, recyclerFragment);
            fragmentTransaction.commit();
        }
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

    @Override
    public void onClick(Movie movie) {

    }
}
