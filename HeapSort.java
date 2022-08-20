import java.util.Arrays;

public class HeapSort {
    public static void main(String args[])
    {
        int array[] = {5,2,6,7,3,5,9,1,4,7};
        System.out.println(Arrays.toString(array));
        HeapSort hs = new HeapSort();
        hs.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int array[]){
        int len = array.length;
 
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(array, len, i);
        }
 
        for (int i=len-1; i>=0; i--) // идем по элементам
        {
            int temp = array[0];  // переставляем текущий корень в конец
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0); // повторяем
        }
         
    }

    public static void heapify(int array[], int len, int i){
        int largest = i; // Инициализируем наибольший элемент как корень
        int left = 2*i + 1; 
        int right = 2*i + 2;  
 
        if (left < len && array[left] > array[largest]) // проверяем дочерние элементы
            largest = left;
 
        if (right < len && array[right] > array[largest])
            largest = right;
 
        if (largest != i) // если самый большой элемент не корень
        {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, len, largest);
        }
    }
}

