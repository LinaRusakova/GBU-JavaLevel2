package com.gmail.xlinaris.lesson02;

import java.util.ArrayList;
import java.util.List;


public class Task {
    //создаем дефолтный размер строкового массива 4х4
    private static final int DEFAULT = 4;
    static String[][] arrayDefault = new String[DEFAULT][DEFAULT];

    // создаем два тестовых строковых массивов 3х3, 5х5
    private static final int NUM3 = 3;
    private static final int NUM5 = 5;
    static String[][] array3 = new String[NUM3][NUM3];
    static String[][] array5 = new String[NUM5][NUM5];

    public static void main(String[] args) {
        //создаем список всех массивов
        List list = new ArrayList();
        list.add(arrayDefault);
        list.add(array3);
        list.add(array5);
        arrInit(list); //инициализируем каждый из созданных массивов
        arrChanger(list);
        arrChanger2(list);
    }

    private static void arrInit(List list) {
        for (Object arrays : list) {
            String[][] tempArr = ((String[][]) arrays);
            for (int x = 0; x < tempArr.length; x++) {
                for (int y = 0; y < tempArr.length; y++) {
                    if (y % 2 != 0) tempArr[x][y] = String.valueOf(y);
                    else tempArr[x][y] = "\"ThisElementIsString\"";
                }
            }
        }
    }


    private static void arrChanger(List list) {
        //применяем в цикле foreach ко всем элементам списка метод, принимающий элементы списка (массивы)
        for (Object arrays : list) {
            try {
                task1ToString(((String[][]) arrays));//делаем приведение типа объекта к String[][]
                System.out.println();
            } catch (MyArraySizeException e) {
                System.out.println(e.toString());
            }
        }
    }

    /*
     * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     * */
    private static void task1ToString(String[][] array) throws MyArraySizeException {
        System.out.println("Пытаем вывести в консоль массив размером " + array.length + "...");
        if (array.length != 4)
            throw new MyArraySizeException(array.length); //пробрасываем исключение, если размер не равен 4.
        String info = "";
        for (int x = 0; x < DEFAULT; x++) {
            info += "[";
            for (int y = 0; y < DEFAULT; y++) {
                info += array[x][y];
                info += (y < DEFAULT - 1) ? "," : "";
            }
            info += "]\n";
        }
        System.out.println(info); //если всё хорошо, выводим элементы массива
    }


    /*
     * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
     *  Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
     * должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
     * */

    private static void arrChanger2(List list) {
        //применяем в цикле foreach ко всем элементам списка метод, принимающий элементы списка (массивы)
        for (Object arrays : list) {
            task2ToInt(((String[][]) arrays));//делаем приведение типа объекта к String[][]
            System.out.println();
        }
    }

    private static void task2ToInt(String[][] array)  {
        System.out.println("Пытаемся преобразовать элементы массива размером " + array.length + " в тип 'Int' и получить сумму элементов и вывести её в консоль...");
        int sum = 0;
        String info = "";
        int[][] arrInt = new int[array.length][array.length];
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                try {
                    sum = getSum(array[x][y], sum, x, y);
                } catch (MyArrayDataException e) {
                    System.out.println(e.toString());
                }

            }
        }
        System.out.println("Сумма всех элементов массива размером " + array.length + " = "+sum + "."); //если всё хорошо, выводим сумму элементов массива
    }

    private static int getSum(String s, int sum, int x, int y) throws MyArrayDataException{
        try {
            int value=Integer.parseInt(s);
        sum += value;
        } catch (NumberFormatException e) {
            throw new MyArrayDataException(s,x,y);
        } finally {
            int value=0;
            sum += value;
        }
        return sum;
    }
}

