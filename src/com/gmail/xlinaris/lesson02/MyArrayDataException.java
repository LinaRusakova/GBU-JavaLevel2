package com.gmail.xlinaris.lesson02;

public class MyArrayDataException extends Exception {
    public String error = "Ошибка преобразования в Int элемента массива ";
    private String idContent;
    private int errorElementX, errorElementY;

    MyArrayDataException(String elementContent, int elementX, int elementY) {
        idContent = elementContent;
        errorElementX = elementX;
        errorElementY = elementY;
    }

    @Override
    public String toString() {

        return "---MyArrayDataException{" +
                "error='" + error +
                ": [" + errorElementX + "," + errorElementY + "] = " + idContent + "}---\n";
    }
}
