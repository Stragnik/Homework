package ru.geekbrains.homework.lesson_1;

public class RunRoad implements Blockage {
    private int length;

    public RunRoad(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Champions champions) {
        champions.run(length);
    }
}