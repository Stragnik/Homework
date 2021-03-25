package ru.geekbrains.homework.lesson_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] words = {"apple", "leak", "orange", "pear", "lemon", "grape", "banana", "apricot", "avocado", "broccoli",
                "nut", "garlic", "mango", "carrot", "banana", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "pear", "mushroom", "cherry", "broccoli", "apple", "melon", "banana", "orange"};

        ArrayList<String> currentList = new ArrayList<>(Arrays.asList(words));
        ArrayList<String> mainList = new ArrayList<>(Arrays.asList(words));

        HashMap hashMap = new HashMap();

        for (String s : currentList) {
            int counter = 0;
            for (String s1 : mainList) {
                if (s.equals(s1)) {
                    counter++;
                }
            }
            hashMap.put(s, counter);
        }
        System.out.println(hashMap);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addElement("Вася", 78906781231L, 78906781232L);
        phoneBook.addElement("Гена", 78906781232L, 78906781231L);
        phoneBook.addElement("Жора", 78906781233L, 78906781234L);
        phoneBook.addElement("Игнат", 78906781234L, 78906781132L, 78906781232L);
        phoneBook.addElement("Степан", 78906781235L);

        for (Map.Entry<String, Set<Long>> o : phoneBook.getPhoneBook().entrySet()) {
            System.out.println(phoneBook.getPhones(o.getKey()));
        }
    }

}

