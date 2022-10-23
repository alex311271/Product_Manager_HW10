package ru.netology.Repozitory;

import ru.netology.Domain.Book;
import ru.netology.Domain.Product;
import ru.netology.Domain.Smartphone;

public class Repozitory {

    private Product[] items = new Product[0];


    public void save(Book item) {
        Product[] temp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        temp[temp.length - 1] = item;
        items = temp;
    }

    public void save(Smartphone item) {
        Product[] temp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        temp[temp.length - 1] = item;
        items = temp;
    }



    public void removeId(int id) {
        Product[] temp = new Product[items.length - 1];
        int copyIndex = 0;
        for (Product item : items) {
            if (item.getId() != id){
                temp[copyIndex] = item;
                copyIndex++;
            }
        }
        items = temp;
    }

    public Product[] findAll() {
        return items;
    }

}
