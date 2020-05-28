package com.davidinnocent.terrasoft.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.davidinnocent.terrasoft.R;
import com.davidinnocent.terrasoft.model.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Product>> GetAllProducts()
    {
        Product product1=new Product();
        product1.setDescription("Woman T-Shirt");
        product1.setDrawable(ContextCompat.getDrawable(getApplication(), R.drawable.low_women_tn));

        Product product2=new Product();
        product2.setDescription("Man T-Shirt");
        product2.setDrawable(ContextCompat.getDrawable(getApplication(),R.drawable.man_woman_tn));

        Product product3=new Product();
        product3.setDescription("Kids T-Shirt");
        product3.setDrawable(ContextCompat.getDrawable(getApplication(),R.drawable.two_woman_tn));


        Product product4=new Product();
        product4.setDescription("Man T-Shirt");
        product4.setDrawable(ContextCompat.getDrawable(getApplication(),R.drawable.man_woman_man_tn));

        Product product5=new Product();
        product5.setDescription("Kids T-Shirt");
        product5.setDrawable(ContextCompat.getDrawable(getApplication(),R.drawable.women_cover_tn));

        List<Product> items_list=new ArrayList<>();
        items_list.add(product1);
        items_list.add(product2);
        items_list.add(product3);
        items_list.add(product4);
        items_list.add(product5);
        MutableLiveData<List<Product>> products=new MutableLiveData<>();
        products.setValue(items_list);

        return products;
    }
}
