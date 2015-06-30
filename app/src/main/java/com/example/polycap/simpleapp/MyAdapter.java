package com.example.polycap.simpleapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Polycap on 6/27/2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<MyProjects> projects;
    private String imgUrl= "http://2.bp.blogspot.com/-Z6YZ4W0VIs4/UVnzzHZtnWI/AAAAAAAAAC0/ZUrXI2QoFnM/s640/3D-android-with-backpack.jpg.1024x768_q85_crop-smart_upscale-True.jpg";
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View view;

        public ViewHolder(View v) {
            super(v);
            view = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<MyProjects> projects)
    {
        this.projects = projects;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row , parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        TextView title = (TextView)holder.view.findViewById(R.id.title);
        TextView desc = (TextView)holder.view.findViewById(R.id.desc);
        final ImageView imageView = (ImageView)holder.view.findViewById(R.id.imageView);

        title.setText(projects.get(position).getTitle());
        desc.setText(projects.get(position).getDesc());
//        imageView.setImageResource(projects.get(position).getImage());

        Picasso.with(holder.view.getContext()).load(imgUrl).into(imageView);

        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View view){
                imageView.setImageResource(R.drawable.fes);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return projects.size();
    }
}