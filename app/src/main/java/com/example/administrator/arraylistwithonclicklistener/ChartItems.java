package com.example.administrator.arraylistwithonclicklistener;

/**
 * Created by Administrator on 9/11/2015.
 */
public class ChartItems {
    String itemName,price;
    int image;

    public ChartItems(int image, String itemName, String price) {
        this.image = image;
        this.itemName = itemName;
        this.price = price;
    }




    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setPrice(String price) {
        this.price = price;
    }





    public String getItemName() {
        return itemName;
    }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }


}
