package pro.sky;

import java.util.Random;

public class Sorting {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        double timeBubbleSort = timeBubbleSort(5);
        System.out.println("Среднее время сортировки пузырьком: " + timeBubbleSort + " мс.");
        double timeSelectionSort = timeSelectionSort(5);
        System.out.println("Среднее время сортировки выбором: " + timeSelectionSort + " мс.");
        double timeInsertionSort = timeInsertionSort(5);
        System.out.println("Среднее время сортировки вставкой: " + timeInsertionSort + " мс.");

    }

    private static double timeBubbleSort(int iteration ) {
        double sum = 0;
        for (int i = 0; i < iteration; i++) {
            int[] array = generateArray(100000);
            long start = System.currentTimeMillis();
            sortBubble(array);
            long end = System.currentTimeMillis() - start;
            sum += end;
        }
        return sum / iteration;
    }
    private static double timeSelectionSort(int iteration ) {
        double sum = 0;
        for (int i = 0; i < iteration; i++) {
            int[] array = generateArray(100000);
            long start = System.currentTimeMillis();
            sortSelection(array);
            long end = System.currentTimeMillis() - start;
            sum += end;
        }
        return sum / iteration;
    }
    private static double timeInsertionSort(int iteration ) {
        double sum = 0;
        for (int i = 0; i < iteration; i++) {
            int[] array = generateArray(100000);
            long start = System.currentTimeMillis();
            sortInsertion(array);
            long end = System.currentTimeMillis() - start;
            sum += end;
        }
        return sum / iteration;
    }

    private static int[] generateArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
         array[i] = RANDOM.nextInt(-50,50);
        }
        return array;
    }
    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }
    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }
    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}