package ru.geekbrains.homework.lesson_1;

public class Main {

    public static void main(String[] args) {
        Champions[] champions = {
                new Cat("Murzik", 400, 20),
                new Robot("C3PO", 500, 50),
                new Human("Sergei", 300, 2)};

        Blockage[] blockages = {
                new RunDistance(400),
                new Wall(30)};

        for (int i = 0; i < champions.length; i++) {
            for (int j = 0; j < blockages.length; j++) {
                blockages[j].doIt(champions[i]);
                if (!champions[i].isOnDistance()) {
                    break;
                }
            }
        }

    }
}

