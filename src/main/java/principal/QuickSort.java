package principal;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class QuickSort {

    private int[] numbers;
    private AtomicInteger small = new AtomicInteger(-1);

    public QuickSort(int[] arr) {
        this.numbers = arr;
    }

    public void runSort() {
        System.out.println("starting array: " + Arrays.toString(numbers));
        int lastIndex = numbers.length -1;
        int middleIndex = travel(0,numbers[lastIndex], lastIndex+1);

        travel(0, numbers[middleIndex-1], middleIndex);

        small.set(middleIndex);
        travel(middleIndex+1,numbers[lastIndex],lastIndex+1);

        System.out.println("sorted array: " + Arrays.toString(numbers));
    }

    private Integer travel(int index, int pivote, int limit) {
        if(index >= limit) {
            int temp = numbers[small.incrementAndGet()];
            numbers[small.get()] = numbers[limit-1];
            numbers[limit-1] = temp;
            small.set(-1);
            return numbers[limit-1];
        }

        if(numbers[index] < pivote){
            int temp = numbers[small.get()+1];
            numbers[small.incrementAndGet()] = numbers[index];
            numbers[index] = temp;
            return travel(index+1, pivote,limit);
        }else{
            return travel(index+1, pivote,limit);
        }
    }
}
