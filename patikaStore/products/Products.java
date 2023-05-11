package patikaStore.products;

import patikaStore.tradeMark.TradeMark;

import java.util.Scanner;

public abstract class Products {
    private int id;
    private String name;
    private int price;
    private int disCount;
    private int stock;
    private TradeMark tradeMark;

    public Products(int id, String name,int price ,int disCount, int stock, TradeMark tradeMark) {
        this.id = id;
        this.name = name;
        this.price=price;
        this.disCount = disCount;
        this.stock = stock;
        this.tradeMark = tradeMark;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDisCount() {
        return disCount;
    }

    public void setDisCount(int disCount) {
        this.disCount = disCount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public TradeMark getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(TradeMark tradeMark) {
        this.tradeMark = tradeMark;
    }
}
