package com.example.eventm.Item;

public class ItemProduct {

    private String title;
    private int ImageM;

    public ItemProduct(){

    }

    public ItemProduct(String title, int imageM) {
        this.title = title;
        ImageM = imageM;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageM() {
        return ImageM;
    }

    public void setImageM(int imageM) {
        ImageM = imageM;
    }
}
