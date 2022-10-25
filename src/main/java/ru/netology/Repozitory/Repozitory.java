package ru.netology.Repozitory;

import ru.netology.Repozitory.NotFoundException;
import ru.netology.Domain.Product;

public class Repozitory {

    private Product[] items = new Product[0];

    public void save(Product item) {
        if (findId(item.getId()) != null){
            throw new AlreadyExistsException("ID" + item.getId() + "уже используется");
        }
        Product[] temp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        temp[temp.length - 1] = item;
        items = temp;
    }




    public void removeId(int id) {
        if (findId(id) == null) {
           throw new NotFoundException(
                    "Товар с Id" + id + "не найден"
            );
        }
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

    public Product[] findId(int id) {
        for (Product product : items) {
            if (product.getId() == id) {
                return items;
            }

        }
        return null;
    }

}
