package com.gmail.xlinaris.lesson03;


import java.util.*;

public class Task1 {
    public static void main(String[] args) {

        /*Task1
         * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
         * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
         * Посчитать сколько раз встречается каждое слово.
         * */

        // Creating String array "words" of not unique words.
        String[] words = new String[]{"Russia", "England", "France", "Russia", "China", "Berlin", "Germany", "Germany", "Russia", "Moscow", "France", "Paris", "Tokyo", "Japan", "China", "Beijing"};

        // Creating String ArrayList "wordsList" based on array "words".
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(words));

        // Print to console "wordsList".
        String baseWordList = "List of words: ";
//        for (String str : words) {
//            baseWordList += "\""+str + "\" ";
//        }
        System.out.println(baseWordList+ wordsList.toString());
        System.out.println();

        // Creating String HashSet "uniqueWords", based on wordsList.
        HashSet uniqueWords = new LinkedHashSet(Arrays.asList(words));

        //Print to console "uniqueWords"
        String uniqueWordList = "List of unique words: ";
        System.out.println(uniqueWordList+uniqueWords.toString());
        System.out.println();

        //Print to console amount of all words of ArrayList "wordsList".
        String amountInfo = "List of all words with they amount: \n";
        for (Object str : uniqueWords) {
            int amount = 0;
            for (Object str1 : wordsList) {
                if (str1.equals(str)) amount++;
            }
            amountInfo += str + "\t=\t" + amount + "\n";
        }
        System.out.println(amountInfo);
    }
}
