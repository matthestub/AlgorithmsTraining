import java.util.Random;

public class SelectionSort {

    public static void main(String[] args) {

        int[] numbers = generateNumber(10, 1000);
        printNumbers(numbers);

        selectionSort(numbers);

        printNumbers(numbers);

    }

    public static void selectionSort(int[] arrayToSort) {

        for (int i = 0; i < arrayToSort.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrayToSort.length; j++) {

                if (arrayToSort[j] < arrayToSort[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arrayToSort[i];
            arrayToSort[i] = arrayToSort[minIndex];
            arrayToSort[minIndex] = temp;
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
