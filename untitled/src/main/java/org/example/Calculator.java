package org.example;
//
//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello, World!");
//    }
//}

// from http://www.vogella.com/tutorials/JUnit/article.html

//package com.vogella.junit.first;

public class Calculator {
    public int multiply(int x, int y) {
        // the following is just an example
        if (x > 999) {
            throw new IllegalArgumentException("X should be less than 1000");
        }
        return x * y;
    }
}