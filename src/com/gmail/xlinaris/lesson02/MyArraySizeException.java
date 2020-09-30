package com.gmail.xlinaris.lesson02;

public class MyArraySizeException extends RuntimeException {

    String error = "Задан неверный размер массива";
    private int errorLength;

    MyArraySizeException(int length) {
        errorLength = length;
    }

    @Override
    public String toString() {
        return "---MyArraySizeException{" +
                "error='" + error +
                ": " + errorLength + "'}---\n";
    }
}
