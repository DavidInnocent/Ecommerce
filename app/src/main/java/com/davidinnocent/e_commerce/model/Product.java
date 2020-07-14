package com.davidinnocent.e_commerce.model;

import android.graphics.drawable.Drawable;

public class Product {


    String description;
    Drawable drawable;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
}
