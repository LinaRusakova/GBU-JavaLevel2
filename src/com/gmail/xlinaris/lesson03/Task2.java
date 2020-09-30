package com.gmail.xlinaris.lesson03;


import java.util.*;

/*2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 *В этот телефонный справочник с помощью метода add() можно добавлять записи.
 *С помощью метода get() искать номер телефона по фамилии.
 * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 * тогда при запросе такой фамилии должны выводиться все телефоны.
 **/
class PhoneBook {

    private final HashMap<String, String> phoneBook4You = new HashMap<>();

    //Method for adding records to phone book.
    void add(String surname, String addPhone) {
        if (phoneBook4You.containsKey(addPhone)) {
            System.out.println("Sorry, but phone number: \"" + addPhone + "\" already exist in this phone book. Records \"" + surname + ": " + addPhone + "\" are not added.");
        } else {
            System.out.println("Your records \"" + surname + ": " + addPhone + "\" added successfully in this phone book.");
            phoneBook4You.put(addPhone, surname);
        }
    }

    //Method for getting records from phone book by surname.
    void get(String surname) {
        String infoByPhoneNumber = "";
        ArrayList<String> numbers = new ArrayList<>();
        boolean isRrecordExist = false; //For checking existed record.
        for (Map.Entry<String, String> o : phoneBook4You.entrySet()) {
            if (o.getValue().equals(surname)) {
                numbers.add(o.getKey());
                isRrecordExist=true;
            }
        }
        // If records are funded, then print records to console
        if (isRrecordExist) {
            for (int i = 0; i < numbers.size(); i++) {
                infoByPhoneNumber += numbers.get(i);
                infoByPhoneNumber += (i != numbers.size() - 1) ? ", " : ".";
            }
            infoByPhoneNumber = "By surname \"" + surname + "\" in this phone book funded " + numbers.size() + " records with numbers:" + infoByPhoneNumber;
        } else {
            infoByPhoneNumber="By surname \"" + surname + "\" in this phone book records not funded.";
        }
        System.out.println(infoByPhoneNumber);
    }

}


public class Task2 {
    public static void main(String[] args) {
        System.out.println("Creation and filling of the phone book...");
        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add("Rusakova", "+12345");
        myPhoneBook.add("Ivanov", "+67891011");
        myPhoneBook.add("Rusakova", "+1213141516");
        myPhoneBook.add("Sidorov", "+12345");
        myPhoneBook.add("Rusakova", "+212222324");
        System.out.println();
        //Test searching by surname with one phone number.
        System.out.println("Searching phone numbers by surname \"Ivanov\"...");
        myPhoneBook.get("Ivanov");
        System.out.println();
        //Test searching by surname more than one phone number.
        System.out.println("Searching phone numbers by surname \"Rusakova\"...");
        myPhoneBook.get("Rusakova");
        System.out.println();
        //Test searching by surname, when no records of this surname.
        System.out.println("Searching phone numbers by surname \"Sidorov\"...");
        myPhoneBook.get("Sidorov");
    }

}

