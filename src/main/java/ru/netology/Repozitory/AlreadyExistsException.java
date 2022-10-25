package ru.netology.Repozitory;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String a) {
        super(a);
    }
}
