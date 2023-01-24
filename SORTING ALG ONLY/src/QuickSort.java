public class QuickSort {

    public static void main(String[] args) {

        int[] myArray = {8, 2, 4, 7, 1, 9, 3, 6, 5};

        printArray(myArray);
        quickSort(myArray, 0, myArray.length-1);
        printArray(myArray);

    }


    private static void quickSort(int[] array, int start, int end) {

        if (end <= start) return;

        int pivot = position(array, start, end);

        quickSort(array, start, pivot-1);
        quickSort(array, pivot+1, end);
    }


    private static int position(int[] array, int start, int end) {

        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j <= end - 1; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }



    private static void printArray(int[] arrayToPrint) {
        System.out.println();
        for (int i : arrayToPrint) {
            System.out.print(i+" ");
        }
    }

}
