package ru.geekbrains.homework.lesson_1;

public class Wall implements Blockage {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Champions champions) {
        champions.jump(height);
    }
}
