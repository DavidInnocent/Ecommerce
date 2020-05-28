package com.davidinnocent.terrasoft;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;

import com.davidinnocent.terrasoft.Viewmodel.MainViewModel;
import com.davidinnocent.terrasoft.model.Product;
import com.davidinnocent.terrasoft.util.CustomAdapter;
import com.davidinnocent.terrasoft.util.OutOfStockAdapter;
import com.labo.kaji.fragmentanimations.MoveAnimation;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ShopFragment extends Fragment {


    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayout,linearLayout2;
    private RecyclerView out_of_stock_recycler_view;
    private MainViewModel mainViewModel;

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
        mainViewModel=new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        return inflater.inflate(R.layout.fragment_shop, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Window window=getActivity().getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.colorDullWhite));
        }
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


        OutOfStockAdapter outOfStockAdapter=new OutOfStockAdapter(getContext(),mainViewModel.GetAllProducts().getValue());
        CustomAdapter adapter=new CustomAdapter(categoryList,getContext());


        out_of_stock_recycler_view.setLayoutManager(linearLayout2);
        recyclerView.setLayoutManager(linearLayout);

        out_of_stock_recycler_view.setAdapter(outOfStockAdapter);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter) {
            return MoveAnimation.create(MoveAnimation.RIGHT, enter, 700);
        } else {
//            return CubeAnimation.create(CubeAnimation.UP, enter, 500);
            return MoveAnimation.create(MoveAnimation.UP, enter, 700);
        }
    }

}