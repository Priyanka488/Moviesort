package com.example.android.newmoves;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context context;
    private LayoutInflater inflater;
    List<DataMovies> data= Collections.emptyList();
    DataMovies current;
    int currentPos=0;

    // create constructor to initialize context and data sent from MainActivity
    public MoviesAdapter(Context context, List<DataMovies> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }


    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.movies_list, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder = (MyHolder) holder;
        DataMovies current = data.get(position);
        myHolder.moviesTitle.setText("Title: " + current.title);
        myHolder.moviesOverview.setText("Overview: " + current.overview);
        myHolder.moviesDate.setText("Release Date: " + current.releaseDate);

    }

    // return total item from List
    @Override
    public int getItemCount()
    {
        return data.size();
    }



class MyHolder extends RecyclerView.ViewHolder{

    TextView moviesTitle;
    TextView moviesOverview;
    TextView moviesDate;

    // create constructor to get widget reference
    public MyHolder(View itemView) {
        super(itemView);
        moviesTitle= (TextView) itemView.findViewById(R.id.movie_title);
        moviesOverview= (TextView) itemView.findViewById(R.id.movie_overview);
        moviesDate = (TextView) itemView.findViewById(R.id.movie_releaseDate);
    }

}

}