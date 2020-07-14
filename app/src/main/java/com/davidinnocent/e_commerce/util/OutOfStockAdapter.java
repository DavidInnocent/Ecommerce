package com.davidinnocent.e_commerce.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.davidinnocent.e_commerce.R;
import com.davidinnocent.e_commerce.model.Product;

import java.util.List;

public class OutOfStockAdapter extends RecyclerView.Adapter {


    Context context;
    List<Product> productsList;

    public OutOfStockAdapter(Context context, List<Product> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);

        return new OutOfStockProductHolder(layoutInflater.inflate(R.layout.product_list_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        OutOfStockProductHolder outOfStockProductHolder=(OutOfStockProductHolder) holder;

        Product product=productsList.get(position);
        outOfStockProductHolder.imageDrawable.setImageDrawable(product.getDrawable());
        outOfStockProductHolder.description.setText(product.getDescription());

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    private class OutOfStockProductHolder extends RecyclerView.ViewHolder {

        TextView description;
        ImageView imageDrawable;
        public OutOfStockProductHolder(View view) {
            super(view);
            description=view.findViewById(R.id.description);
            imageDrawable=view.findViewById(R.id.stock_image);

        }
    }
}
