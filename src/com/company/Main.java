package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] params) {
        int[] array = new int[] {58, 41, 33, 44, 35, 59, 11, 22, 55, 31, 41, 83, 36, 74, 15, 20};
        bubbleSort(array);
        System.out.println(arrayToString(array));
    }
    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    isSorted = false;
                }
            }
        }
    }
    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите длину массива: ");
        int length = Integer.parseInt(reader.readLine());
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("Отсортированный массив " + Arrays.toString(array));

        System.out.println("Искомое число: ");
        int number = Integer.parseInt(reader.readLine());
        for (int i = 0; i < array.length - 1 / 2; i++) {
            if (array[i] == number) {
                System.out.println("Индекс елемента: " + i);
                break;
            }
            if (array[array.length - 1 - i] == number) {
                System.out.println("Индекс елемента: " + i);
                break;
            }
        }

        System.out.println("Искомое число: ");
        int number2 = Integer.parseInt(reader.readLine());
        int first = 0;
        int last = array.length - 1;
        binarySearch(array, first, last, number2);


        System.out.println("Введите длину массива со строк: ");
        String[] strings = new String[Integer.parseInt(reader.readLine())];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = reader.readLine();
        }
        Arrays.sort(strings, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        System.out.println("Отсортированный массив " + Arrays.toString(strings));
    }

    // бинарный поиск
    public static void binarySearch(int[] array, int first, int last, int item) {
        int position;
        int comparisonCount = 1;    // для подсчета количества сравнений

        // для начала найдем индекс среднего элемента массива
        position = (first + last) / 2;

        while ((array[position] != item) && (first <= last)) {
            comparisonCount++;
            if (array[position] > item) {  // если число заданного для поиска
                last = position - 1; // уменьшаем позицию на 1.
            } else {
                first = position + 1;    // иначе увеличиваем на 1
            }
            position = (first + last) / 2;
        }
        if (first <= last) {
            System.out.println(item + " является " + ++position + " элементом в массиве");
            System.out.println("Метод бинарного поиска нашел число после " + comparisonCount +
                    " сравнений");
        } else {
            System.out.println("Элемент не найден в массиве. Метод бинарного поиска закончил работу после "
                    + comparisonCount + " сравнений");
        }
    }

}


