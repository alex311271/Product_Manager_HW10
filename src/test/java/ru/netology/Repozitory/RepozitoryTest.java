package ru.netology.Repozitory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Domain.Book;
import ru.netology.Repozitory.NotFoundException;
import ru.netology.Domain.Product;
import ru.netology.Domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RepozitoryTest {


    Product item1 = new Book(1, 100, "book", "Book1", "Author1");
    Product item2 = new Smartphone(2, 200, "smartphone", "phone1", "Fabricator1");
    Product item3 = new Smartphone(3, 500, "smartphone", "phone2", "Fabricator2");
    Product item4 = new Book(4, 300, "book", "Book2", "Author2");


    @Test

    public void findAll() {
        Repozitory repo = new Repozitory();

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);


        Product[] expected = {item1, item2, item3, item4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeId() {
        Repozitory repo = new Repozitory();

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        repo.removeId(2);
        Product[] expected = {item1, item3, item4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

   @Test
    void findIdFailed() {

        Repozitory repo = new Repozitory();

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        int id = 5;
        assertNull(repo.findId(id));
    }

    @Test
    void removeIdFailed() {
        Repozitory repo = new Repozitory();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        assertThrows(NotFoundException.class, () -> {
            repo.removeId(6);
        });
    }


    @Test
    void saveProductFailed() {
        Repozitory repo = new Repozitory();

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        assertThrows(AlreadyExistsException.class, () -> {
            repo.save(item2);
        });
    }
}


