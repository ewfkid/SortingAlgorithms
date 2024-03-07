package arrays;

import java.util.*;

public class OneDimensionalArray extends ArrayBase {
    private int[] array;
    private static final Random rnd = new Random();
    private static final Scanner in = new Scanner(System.in);

    public OneDimensionalArray(int capacity, boolean userFilled) {
        this.array = new int[capacity];

        if (userFilled) {
            fillArrayFromUserInput();
        } else {
            fillArrayWithRandomValues();
        }
    }

    @Override
    protected void fillArrayFromUserInput() {
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }
    }

    @Override
    protected void fillArrayWithRandomValues() {
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(1000);
        }
    }

    @Override
    public void bubbleSort() {
        boolean swapped = true;

        while (swapped) {
            swapped = false;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swapped = true;
                    swap(i, i + 1);
                }
            }
        }
    }

    @Override
    public void insertionSort() {
        int i, j, temp;
        for (i = 1; i < array.length; i++) {
            temp = array[i];
            j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    @Override
    public void quickSort(int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) {
            return;
        }
        int pivot = array[highIndex];

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(leftPointer, rightPointer);
        }
        swap(leftPointer, highIndex);

        quickSort(lowIndex, leftPointer - 1);
        quickSort(leftPointer + 1, highIndex);

    }

    @Override
    public void printArray() {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private void swap(int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public int getCapacity() {
        return array.length;
    }
}
