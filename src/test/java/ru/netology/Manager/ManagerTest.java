package ru.netology.Manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.Domain.Book;
import ru.netology.Domain.Product;
import ru.netology.Domain.Smartphone;
import ru.netology.Repozitory.Repozitory;

import static org.mockito.Mockito.*;

public class ManagerTest {


    Repozitory repozitory = new Repozitory();
    Manager manager = new Manager(repozitory);

    Product item1 = new Book(11, 150, "book", "Book1", "Author1");
    Product item2 = new Smartphone(5, 500, "smartphone", "Smartphone1", "Fabric1");
    Product item3 = new Book(12, 100, "book", "Book2", "Author2");
    Product item4 = new Smartphone(10, 700, "smartphone", "Smartphone3", "Fabric2");

    @BeforeEach
    public void setup(){

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
    }



  

    @Test
    public void findAll() {

        Product[] expected = {item1, item2, item3, item4};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByAllBook(){

        Product[] expected = {item1, item3};
        Product[] actual = manager.searchBy("book");
    }

    @Test
    public void noSearchByBook(){

        Product[] expected = {item3};
        Product[] actual = manager.searchBy("book8");
    }

    @Test
    public void searchByAuthor(){

        Product[] expected = {item1};
        Product[] actual = manager.searchBy("Author1");
    }

    @Test
    public void searchByFabricator(){

        Product[] expected = {item4};
        Product[] actual = manager.searchBy("Fabric2");
    }


}
