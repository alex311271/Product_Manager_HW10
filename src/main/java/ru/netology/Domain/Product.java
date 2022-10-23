package ru.netology.Domain;

public class Product {
    protected int id;
    protected int price;
    protected String name;
    protected String title;

    public Product(int id, int price, String name, String title) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.title = title;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
