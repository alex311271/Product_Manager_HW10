package ru.netology.Manager;

import ru.netology.Domain.Book;
import ru.netology.Domain.Product;
import ru.netology.Domain.Smartphone;
import ru.netology.Repozitory.Repozitory;

public class Manager {

    private Repozitory repozitory;

    public Manager(Repozitory repozitory) {
        this.repozitory = repozitory;
    }

    public Product[] findAll() {
        Product[] all = repozitory.findAll();
        return all;
    }

    public void add(Product product) {
        repozitory.save((Book) product);
        repozitory.save((Smartphone) product);
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product: repozitory.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) { //
                    tmp[i] = result[i];
                }
                tmp[result.length] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    }
