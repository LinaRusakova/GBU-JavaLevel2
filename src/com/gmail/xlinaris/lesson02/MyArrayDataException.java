package com.gmail.xlinaris.lesson02;

public class MyArrayDataException extends Exception{
    public String error="Ошибка преобразование элемента массива ";
    private String idContent;
    public MyArrayDataException(String error) {
        super(error);
    }

    public MyArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyArrayDataException(Throwable cause) {
        super(cause);
    }

    protected MyArrayDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }




    private int errorElementX,errorElementY;
    MyArrayDataException(String elementContent, int elementX, int elementY) {
       idContent=elementContent;
        errorElementX=elementX;
        errorElementY=elementY;
    }

    public MyArrayDataException() {

    }

    @Override
    public String toString() {

        return "---MyArrayDataException{" +
                "error='" + error +
                ": [" + errorElementX+","+errorElementY+"] = "+idContent+"}---\n";
    }
}
