import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {

        int[] numbers = generateNumber(10, 1000);
        printNumbers(numbers);

        bubbleSort(numbers);

        printNumbers(numbers);

    }



    public static void bubbleSort(int[] arrayToSort) {

        for (int i = arrayToSort.length-1; i > 1; i--) {

            for (int j = 0; j < i; j++) {
                if (arrayToSort[j] > arrayToSort[j+1]) {
                    int temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j+1];
                    arrayToSort[j+1] = temp;
                }
            }
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
