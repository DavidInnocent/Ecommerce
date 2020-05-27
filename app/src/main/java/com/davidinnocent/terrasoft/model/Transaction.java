package com.davidinnocent.terrasoft.model;

import android.graphics.drawable.Drawable;

public class Transaction {

    Drawable transaction_image;
    String transaction_bank,transaction_description,transaction_amount,transaction_date;

    public Drawable getTransaction_image() {
        return transaction_image;
    }

    public void setTransaction_image(Drawable transaction_image) {
        this.transaction_image = transaction_image;
    }

    public String getTransaction_bank() {
        return transaction_bank;
    }

    public void setTransaction_bank(String transaction_bank) {
        this.transaction_bank = transaction_bank;
    }

    public String getTransaction_description() {
        return transaction_description;
    }

    public void setTransaction_description(String transaction_description) {
        this.transaction_description = transaction_description;
    }

    public String getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(String transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }
}
