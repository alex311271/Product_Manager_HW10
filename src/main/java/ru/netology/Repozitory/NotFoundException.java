package ru.netology.Repozitory;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String q) {
        super(q);
    }

}
