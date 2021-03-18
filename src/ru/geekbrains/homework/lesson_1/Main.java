package ru.geekbrains.homework.lesson_1;

public class Main {
    public static void main(String[] args) {
        Champions[] champions = {
                new Cat("Murzik", 200, 30),
                new Robot("R2D2", 500, 100),
                new Human("Sergei", 1000, 10)};

        Blockage[] blockages = {
                new RunRoad(500),
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

