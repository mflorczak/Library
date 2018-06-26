package com.library.controller;

public class BookTitleNotFoundException extends Exception {
    public BookTitleNotFoundException(String message) {
        super(message);
    }
}
