package com.example.pavin.movies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by pavin on 12.03.2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyHolder> {

    private List<Movie> mMovies;
    private Context mContext;

    public MovieAdapter(Context context, List<Movie> movies) {
        mContext = context;
        mMovies = movies;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, int position) {
        Movie movie = mMovies.get(position);
        holder.title.setText(movie.getName());
        String rating = mContext.getString(R.string.rate) + " " + movie.getRating();
        holder.rating.setText(rating);
        Glide.with(mContext).load(movie.getPicture()).into(holder.pic);
        holder.pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(holder.pic);
            }
        });
    }

    private void showPopupMenu(View v){
        PopupMenu popupMenu = new PopupMenu(mContext, v);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.menu_movie, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new MyOnMenuItemClickListener(v));
        popupMenu.show();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        ImageView pic;
        TextView title, rating;

        MyHolder(View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.picture);
            title = itemView.findViewById(R.id.title);
            rating = itemView.findViewById(R.id.rating);
        }
    }

    class MyOnMenuItemClickListener implements PopupMenu.OnMenuItemClickListener{
        View mView;

        MyOnMenuItemClickListener(View v){
            mView = v;
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.add_favourite:
                   // Snackbar.make(mView, "Favourites", Snackbar.LENGTH_SHORT).show();
                    return true;
                case R.id.watch_later:
                   // Snackbar.make(mView, "Watch Later", Snackbar.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }
}
