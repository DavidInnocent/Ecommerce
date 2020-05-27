package com.davidinnocent.terrasoft.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.davidinnocent.terrasoft.R;
import com.davidinnocent.terrasoft.model.ViewItemsModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomAdapter extends RecyclerView.Adapter {

    private static final int TYPE_HEADER=0;
    private static final int TYPE_ITEM=1;

    private List<String> viewitemlists;
    private List<Drawable> drawables=new ArrayList<>();
    private Context context;


    public CustomAdapter(List<String> viewitemlists, Context context) {
        this.viewitemlists = viewitemlists;
        this.context = context;
        drawables.add(ContextCompat.getDrawable(context,R.drawable.pink));
        drawables.add(ContextCompat.getDrawable(context,R.drawable.blue));
        drawables.add(ContextCompat.getDrawable(context,R.drawable.green));

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.activity_listviewitem,parent,false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

       CategoryViewHolder categoryViewHolder=(CategoryViewHolder) holder;

       categoryViewHolder.categoryname.setText(viewitemlists.get(position));
    }

    @Override
    public int getItemCount() {
        return viewitemlists.size();
    }



    private class CategoryViewHolder extends RecyclerView.ViewHolder {
        Button categoryname;
        public CategoryViewHolder(View view) {
            super(view);

            Random random=new Random();
            int nextDrawable=random.nextInt(drawables.size());

            categoryname=view.findViewById(R.id.category_name);
            categoryname.setBackground(drawables.get(nextDrawable));
        }
    }
}
