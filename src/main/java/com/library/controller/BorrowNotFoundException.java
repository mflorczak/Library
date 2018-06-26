package com.library.controller;

public class BorrowNotFoundException extends Exception {
    public BorrowNotFoundException(String message) {
        super(message);
    }
}
