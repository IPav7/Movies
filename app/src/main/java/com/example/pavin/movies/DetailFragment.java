package com.example.pavin.movies;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by pavin on 13.03.2018.
 */

public class DetailFragment extends Fragment {

    public static DetailFragment newInstance(Movie movie){
        DetailFragment detailFragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("movie", movie);
        detailFragment.setArguments(args);
        return detailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       /* Bundle args = getArguments();
        Movie movie = null;
        if(args != null)
        movie = (Movie)args.getSerializable("movie");*/
        View root = inflater.inflate(R.layout.detail_fragment, container, false);
        TextView textView = root.findViewById(R.id.textFrag);
        textView.setText("PIDORASINA");
        return root;
    }
}
