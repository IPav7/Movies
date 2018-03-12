package com.example.pavin.movies;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavin on 12.03.2018.
 */

public class RecyclerFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private MovieAdapter mMovieAdapter;
    private List<Movie> mMovies;
    private onMovieClickListener mMovieClickListener;

    public interface onMovieClickListener{
        void onClick(Movie movie);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovies = new ArrayList<>();
        prepareMovies();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof onMovieClickListener){
            mMovieClickListener = (onMovieClickListener)activity;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.content_main, container, false);
        mRecyclerView = root.findViewById(R.id.recycler_view);
        mMovieAdapter = new MovieAdapter(getActivity(), mMovies);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mMovieAdapter);
        return root;
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
        }

}
