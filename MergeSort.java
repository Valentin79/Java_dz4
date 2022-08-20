package DZ4;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = { 2, 4, 3, 1, 6, 8, 4, 3, 9, 3, 7 };
        System.out.println(Arrays.toString(array));
        MergeSort.mergeSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] arr, int len) {
        if (len < 2) {
            return;
        }
        int mid = len / 2; // делим массив на две части - левую и правую
        int[] left = new int[mid];
        int[] right = new int[len - mid];
        
        for (int i = 0; i < mid; i++) { // пишем левую часть
            left[i] = arr[i];
        }
        for (int i = mid; i < len; i++) { // пишем правую часть
            right[i - mid] = arr[i];
        }
        mergeSort(left, mid); // делим левую часть
        mergeSort(right, len - mid); // делим правую часть
    
        merge(arr, left, right, mid, len - mid); // сливаем массивы
    }

    public static void merge(
            int[] arr, int[] left, int[] right, int lenLeft, int lenRight) {

        int i = 0, j = 0, index = 0; // индексы для левого, правого и результирующего м-ва
        while (i < lenLeft && j < lenRight) {
            if (left[i] <= right[j]) { // сравниваем числа в индексах
                //arr[index++] = left[i++]; 
                arr[index] = left[i]; // записывем меньшее
                index++; i++;
            } else {
                arr[index] = right[j];
                index++; j++;
            }
        }
        while (i < lenLeft) { // как перестаёт выполняться условие выше
            arr[index] = left[i]; // дописываем оставшееся число.
            index++; i++;
        }
        while (j < lenRight) {
            arr[index] = right[j];
            index++; j++;
        }
    }
}
