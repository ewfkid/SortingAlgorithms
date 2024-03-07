package domain;

import arrays.OneDimensionalArray;

public class Main {
    public static void main(String[] args) {
        OneDimensionalArray[] data = {
                new OneDimensionalArray(100, false),
                new OneDimensionalArray(1000, false),
                new OneDimensionalArray(10000, false)};

        for (int i = 0; i < data.length; i++) {
            data[i].printArray();
            System.out.println("Bubble sort: " + getTime(1, data[i]));
            System.out.println("Insertion sort: " + getTime(2, data[i]));
            System.out.println("Quick sort: " + getTime(3, data[i]));

        }
    }

    public static long getTime(int key, OneDimensionalArray array) {
        long time, currentTime;
        if (key == 1) {
            time = System.currentTimeMillis();
            array.bubbleSort();
            currentTime = System.currentTimeMillis();
            return currentTime - time;
        } else if (key == 2) {
            time = System.currentTimeMillis();
            array.insertionSort();
            currentTime = System.currentTimeMillis();
            return currentTime - time;
        } else if (key == 3) {
            time = System.currentTimeMillis();
            array.quickSort(0, array.getCapacity() - 1);
            currentTime = System.currentTimeMillis();
            return currentTime - time;
        }
        return 0;
    }
}