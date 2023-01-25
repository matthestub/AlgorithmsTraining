public class MergeSort {

    public static void main(String[] args) {

        int[] array = {5, 7, 9, 1, 4, 2, 8, 6};

        printArray(array);
        mergeSort(array);
        printArray(array);

    }


    public static void mergeSort(int[] arrayToSort) {

        int length = arrayToSort.length;
        if (length <= 1) return;

        int middle = length/2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length-middle];

        int i = 0; //left array
        int j = 0; //right array

        for (; i < length; i++) {
            if (i < middle) {
                leftArray[i] = arrayToSort[i];
            } else {
                rightArray[j] = arrayToSort[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(arrayToSort, leftArray, rightArray);
    }

    private static void merge(int[] arrayToSort, int[] leftArray, int[] rightArray) {

        int leftSize = arrayToSort.length/2;
        int rightSize = arrayToSort.length - leftSize;

        int i = 0, l = 0, r = 0;

        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                arrayToSort[i] = leftArray[l];
                i++;
                l++;
            }
            else {
                arrayToSort[i] = rightArray[r];
                i++;
                r++;
            }
        }

        while (l < leftSize) {
            arrayToSort[i] = leftArray[l];
            i++;
            l++;
        }

        while (r < rightSize) {
            arrayToSort[i] = rightArray[r];
            i++;
            r++;
        }
    }


    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
