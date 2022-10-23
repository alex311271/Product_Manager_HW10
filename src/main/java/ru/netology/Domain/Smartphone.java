package ru.netology.Domain;

public class Smartphone extends Product{

    private String fabricator;

    public Smartphone(int id, int price, String name, String title, String fabricator) {
        super(id, price, name, title);
        this.fabricator = fabricator;
    }

    public String getFabricator() {
        return fabricator;
    }

    public void setFabricator(String fabricator) {
        this.fabricator = fabricator;
    }
}
