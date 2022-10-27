package ru.netology.Manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.Domain.Book;
import ru.netology.Domain.Product;
import ru.netology.Domain.Smartphone;
import ru.netology.Repozitory.Repozitory;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

public class ManagerTest {

    Repozitory repozitory = Mockito.mock(Repozitory.class);
    Manager manager = new Manager(repozitory);

    Product item1 = new Book(11, 150, "book1", "Book1", "Author1");
    Product item2 = new Smartphone(5, 500, "smartphone1", "Smartphone1", "Fabric1");
    Product item3 = new Book(12, 100, "book2", "Book2", "Author2");
    Product item4 = new Smartphone( 10, 700, "smartphone2", "Smartphone3", "Fabricator2");
    Product item5 = new Book(13, 200, "book3", "Book3", "Author2");
    Product item6 = new Smartphone(6, 550, "smartphone3", "Smartphone3", "Fabric1");


    @Test
    public void  findAllBook(){
        Product[] products = {item1, item2, item3, item4, item5, item6};
        doReturn(products).when(repozitory).findAll();

        Product[] expected = {item1, item3, item5};
        Product[] actual = manager.searchBy("book");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllSmartphone(){
        Product[] products = {item1, item2, item3, item4, item5, item6};
        doReturn(products).when(repozitory).findAll();

        Product[] expected = {item2, item4, item6};
        Product[] actual = manager.searchBy("smartphone");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void findAll(){
        Product[] products = {item1, item2, item3, item4, item5, item6};
        doReturn(products).when(repozitory).findAll();

        Product[] expected = {item1, item2, item3, item4, item5, item6};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void  finNoProduct(){
        Product[] products = {item1, item2, item3, item4, item5, item6};
        doReturn(products).when(repozitory).findAll();

        Product[] expected = {};
        Product[] actual = manager.searchBy("smartphone4");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void  findOneProduct(){
        Product[] products = {item1, item2, item3, item4, item5, item6};
        doReturn(products).when(repozitory).findAll();

        Product[] expected = {item3};
        Product[] actual = manager.searchBy("book2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void  findTwoProduct(){
        Product[] products = {item1, item2, item3, item4, item5, item6};
        doReturn(products).when(repozitory).findAll();

        Product[] expected = {item3, item4};
        Product[] actual = manager.searchBy("2");

        Assertions.assertArrayEquals(expected, actual);
    }

}
