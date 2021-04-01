package ru.geekbrains.homework.lesson_5;

public class Main {
    static final int size = 10_000_000;
    static final int halfSize = size / 2;
    private static final Object mon = new Object();
    private static final Object mon1 = new Object();

    public static void main(String[] args) {
        System.out.println("1. Метод");
        firstMethod();
        System.out.println("2. Метод");
        secondMethod();
    }

    private static void firstMethod() {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения первого метода: " + (endTime - startTime));
    }

    private static void secondMethod() {

        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1.0f;
        }

        float[] arr1 = new float[halfSize];
        float[] arr2 = new float[halfSize];

        long startTime = System.currentTimeMillis();

        long dividingStartTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, halfSize);
        System.arraycopy(arr, halfSize, arr2, 0, halfSize);
        System.out.println("Время разбивки массива на два: " + (System.currentTimeMillis() - dividingStartTime));

        long startMath1ArrayTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            synchronized (mon) {
                for (int i = 0; i < halfSize; i++) {
                    arr1[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Время подсчета первого массива: " + (System.currentTimeMillis() - startMath1ArrayTime));
            }
        });


        long startMath2ArrayTime = System.currentTimeMillis();
        Thread t2 = new Thread(() -> {
            synchronized (mon1) {
                for (int i = 0; i < halfSize; i++) {
                    arr2[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Время подсчета второго массива: " + (System.currentTimeMillis() - startMath2ArrayTime));
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long joiningStartTime = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr, 0, halfSize);
        System.arraycopy(arr2, 0, arr, halfSize, halfSize);
        System.out.println("Время склейки массивов: " + (System.currentTimeMillis() - joiningStartTime));

        System.out.println("Общее время вычеслений второго метода: " + (System.currentTimeMillis() - startTime));
    }

}
