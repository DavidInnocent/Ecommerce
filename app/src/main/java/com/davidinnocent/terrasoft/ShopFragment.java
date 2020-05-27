package com.davidinnocent.terrasoft;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.davidinnocent.terrasoft.model.Product;
import com.davidinnocent.terrasoft.util.CustomAdapter;
import com.davidinnocent.terrasoft.util.OutOfStockAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ShopFragment extends Fragment {


    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayout,linearLayout2;
    private RecyclerView out_of_stock_recycler_view;

    public ShopFragment() {

        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        getContext().getTheme().applyStyle(R.style.Theme_AppCompat_Light_NoActionBar_FullScreen,true);
        return inflater.inflate(R.layout.fragment_shop, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.my_recycler_view);
        out_of_stock_recycler_view=view.findViewById(R.id.out_of_stock);


        linearLayout= new LinearLayoutManager(getContext());
        linearLayout.setOrientation(RecyclerView.HORIZONTAL);
        linearLayout2= new LinearLayoutManager(getContext());
        linearLayout2.setOrientation(RecyclerView.HORIZONTAL);


        List<String> categoryList=new ArrayList<>();
        categoryList.add("Woman");
        categoryList.add("Man");
        categoryList.add("Kids");
        categoryList.add("Woman");
        categoryList.add("Man");
        categoryList.add("Kids");
        categoryList.add("Woman");
        categoryList.add("Man");
        categoryList.add("Kids");
        categoryList.add("Woman");
        categoryList.add("Man");
        categoryList.add("Kids");

        List<Product> items_list=new ArrayList<>();


        Product product1=new Product();
        product1.setDescription("Woman T-Shirt");
        product1.setDrawable(ContextCompat.getDrawable(getContext(),R.drawable.low_women));

        Product product2=new Product();
        product2.setDescription("Man T-Shirt");
        product2.setDrawable(ContextCompat.getDrawable(getContext(),R.drawable.man_woman));

        Product product3=new Product();
        product3.setDescription("Kids T-Shirt");
        product3.setDrawable(ContextCompat.getDrawable(getContext(),R.drawable.two_woman));


        Product product4=new Product();
        product4.setDescription("Man T-Shirt");
        product4.setDrawable(ContextCompat.getDrawable(getContext(),R.drawable.man_woman_man));

        Product product5=new Product();
        product5.setDescription("Kids T-Shirt");
        product5.setDrawable(ContextCompat.getDrawable(getContext(),R.drawable.women_cover));


        items_list.add(product1);
        items_list.add(product2);
        items_list.add(product3);
        items_list.add(product4);
        items_list.add(product5);


        OutOfStockAdapter outOfStockAdapter=new OutOfStockAdapter(getContext(),items_list);
        CustomAdapter adapter=new CustomAdapter(categoryList,getContext());


        out_of_stock_recycler_view.setLayoutManager(linearLayout2);
        recyclerView.setLayoutManager(linearLayout);

        out_of_stock_recycler_view.setAdapter(outOfStockAdapter);
        recyclerView.setAdapter(adapter);

    }


}