package com.davidinnocent.terrasoft.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.davidinnocent.terrasoft.R;
import com.davidinnocent.terrasoft.model.Product;
import com.davidinnocent.terrasoft.model.Transaction;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter {

    Context context;
    List<Transaction> items_list;

    public TransactionAdapter(Context context, List<Transaction> items_list) {
        this.context = context;
        this.items_list = items_list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.transaction_list_view,parent,false);
        return new TransactionAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class TransactionAdapterHolder extends RecyclerView.ViewHolder {
        public TransactionAdapterHolder(View view) {
            super(view);
        }
    }
}
