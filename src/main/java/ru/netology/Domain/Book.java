package ru.netology.Domain;

public class Book extends Product{

    private String author;

    public Book(int id, int price, String name, String title, String author) {
        super(id, price, name, title);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
