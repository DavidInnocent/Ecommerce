package com.davidinnocent.e_commerce.util;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.davidinnocent.e_commerce.R;
import com.davidinnocent.e_commerce.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter {

    Context context;
    List<Transaction> items_list;

    List<Drawable> image_backgrounds=new ArrayList<>();

    List<Integer> color_list=new ArrayList<Integer>();



    public TransactionAdapter(Context context, List<Transaction> items_list) {
        this.context = context;
        image_backgrounds.add(ContextCompat.getDrawable(context,R.drawable.transactions_button));
        image_backgrounds.add(ContextCompat.getDrawable(context,R.drawable.transactions_button_two));
        image_backgrounds.add(ContextCompat.getDrawable(context,R.drawable.transactions_button_three));

        color_list.add(R.color.transPurple);
        color_list.add(R.color.transPurpleLight);
        color_list.add(R.color.transGreen);
        color_list.add(R.color.transGreennLight);
        color_list.add(R.color.colorOrange);
        color_list.add(R.color.colorOrange);


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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        TransactionAdapterHolder transactionAdapterHolder=(TransactionAdapterHolder)holder;
        transactionAdapterHolder.amount.setText(items_list.get(position).getTransaction_amount());
        transactionAdapterHolder.imageView.setImageDrawable(items_list.get(position).getTransaction_image());
        transactionAdapterHolder.description.setText(items_list.get(position).getTransaction_description());
        transactionAdapterHolder.date.setText(items_list.get(position).getTransaction_date());
        transactionAdapterHolder.bank.setText(items_list.get(position).getTransaction_bank());




        ShapeDrawable.ShaderFactory sf=new ShapeDrawable.ShaderFactory() {
            @Override
            public Shader resize(int width, int height) {
                int color_finder=GetColor(position);
                int[] color_array=new int[]{context.getResources().getColor(color_list.get(position)),color_list.get(color_finder)};

                return new LinearGradient(0, 0, 0, 60,
                        color_array,
                        null, Shader.TileMode.CLAMP);
            }

            private int GetColor(int thisposition) {
                if(thisposition++>color_list.size()-1){
                    return 0;}
                else{
                    return position;
                }
            }
        };

        PaintDrawable p=new PaintDrawable();
        p.setShape(new OvalShape());
        p.setShaderFactory(sf);

        transactionAdapterHolder.amount.getPaint().setShader(sf.resize(0,0));
        transactionAdapterHolder.imageView.setBackground(p);




    }

    @Override
    public int getItemCount() {
        return items_list.size();
    }

    private class TransactionAdapterHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView bank,description,date,amount;
        public TransactionAdapterHolder(View view) {
            super(view);

            bank=view.findViewById(R.id.trans_bank);
            description=view.findViewById(R.id.trans_description);
            date=view.findViewById(R.id.trans_date);
            amount=view.findViewById(R.id.trans_amount);
            imageView=view.findViewById(R.id.trans_image);
        }
    }
}
