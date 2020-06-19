package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

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


