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

    public void add(Product product) {
        repozitory.save(product);
    }

    public Product[] findAll() {
        Product[] all = repozitory.findAll();
        return all;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];// тут будем хранить подошедшие запросу продукты
        for (Product product: repozitory.findAll()) { // перебираем значения ячеек массива по адресу findAll в Rpozitory
            if (matches(product, text)) { // если запрос matches true то "добавляем в конец" массива result продукт product
                Product[] tmp = new Product[result.length + 1]; // создаем временный массив длинно на 1 ячейку больше чем массив result
                for (int i = 0; i < result.length; i++) { //
                    tmp[i] = result[i];
                    i++;
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
