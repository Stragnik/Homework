package ru.geekbrains.homework.lesson_1;

public class RunDistance implements Blockage {
    private int length;

    public RunDistance(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Champions champions) {
        champions.run(length);
    }
}
