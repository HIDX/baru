package com.example.eventm.Item;

public class ItemProduct {

    private String title;
    private int Thumbnail;

    public ItemProduct(){

    }

    public ItemProduct(String title, int thumbnail) {
        this.title = title;
        Thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
