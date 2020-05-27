package com.davidinnocent.terrasoft.model;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

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
