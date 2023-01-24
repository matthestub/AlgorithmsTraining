import java.util.Random;

public class InsertionSort {

    public static void main(String[] args) {

        int[] numbers = generateNumber(10, 1000);
        printNumbers(numbers);

        insertionSort(numbers);

        printNumbers(numbers);

    }

    public static void insertionSort(int[] arrayToSort) {

        for (int i = 1; i < arrayToSort.length; i++) {

            int currentValue = arrayToSort[i];
            int j = i - 1;

            while (j >= 0 && arrayToSort[j] > currentValue) {
                arrayToSort[j+1] = arrayToSort[j];
                j--;
            }
            arrayToSort[j+1] = currentValue;
        }
    }


    public static int[] generateNumber(int howMany, int bound) {
        Random random = new Random();
        int[] numbers = new int[howMany];

        for (int i = 0; i < howMany; i++) {
            numbers[i] = random.nextInt(bound);
        }
        return numbers;
    }

    public static void printNumbers(int[] array) {
        for (int i : array) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
