import java.util.Random;

public class ArrayStructures {

    private int[] theArray = new int[50];
    private int arraySize = 10;

    public void generateRandomArray() {

//        for(int i = 0; i < arraySize; i++) {
//            theArray[i] = (int) (Math.random()*10)+10;
//        }

        Random random = new Random();

        for (int i = 0; i < arraySize; i++) {
            theArray[i] = random.nextInt(100);
        }

    }

    public void printArray() {
        System.out.println("----------");
        for (int i = 0; i < arraySize; i++) {
            System.out.print("| "+i+" | ");
            System.out.println(theArray[i]+" |");
        }
        System.out.println("----------");
    }

    public int getValueAtIndex(int index) {
        if (index < arraySize) return theArray[index];
        return 0;
    }

    public boolean doesArrayContainsThisValue(int searchValue) {

        boolean containsValue = false;
        for (int i = 0; i < arraySize; i++) {
            if (theArray[i] == searchValue) {
                containsValue = true;
            }
        }

        return containsValue;
    }

    public void deleteValueAtIndex(int deleteIndex) {

        if (deleteIndex < arraySize && deleteIndex >= 0) {

            for (int i = deleteIndex; i < (arraySize-1); i++) {

                theArray[i] = theArray[i+1];

            }
            arraySize--;
        } else {
            System.out.println("Incorrect index!");
        }
    }

    public void insertValue(int valueToInsert) {

        if (arraySize < 50) {
            theArray[arraySize] = valueToInsert;
            arraySize++;
        }
    }

    //Linear search - if I want to find ALL matches in the Array
    //Binary Search - if I want to find ONE EXACT match in the Array. Values need to be sorted, duplicates are allowed.


    public String linearSearchForValue(int value) {

        boolean valueInArray = false;

        StringBuilder indexesWithValue = new StringBuilder();
        indexesWithValue.append("Value found on index: ");

        for (int i = 0; i < arraySize; i++) {
            if (theArray[i] == value) {
                valueInArray = true;
                indexesWithValue.append(i).append(" ");
            }

            printHorizontalArray(i, -1);
        }

        if (!valueInArray) indexesWithValue.append("none");

        return indexesWithValue.toString();
    }


    public void binarySearchForValue(int value) {

        System.out.println();
        System.out.println("Binary search: ");

        int lowIndex = 0;
        int highIndex = arraySize - 1;

        while (lowIndex <= highIndex) {

            int middleIndex = (lowIndex+highIndex) / 2;

            printHorizontalArray(middleIndex, -1);

            if (value < theArray[middleIndex]) {

                highIndex = middleIndex - 1;
            }
            else if (value > theArray[middleIndex]) {
                lowIndex = middleIndex + 1;
            }
            else {
                System.out.println("Found value "+value+" on index: "+middleIndex);
                break;
            }
        }
    }


    public void bubbleSort() {

//        for (int i = 0; i < arraySize-1; i++) {
//            for (int j = 0; j < arraySize - i - 1; j++) {
//
//                if (theArray[j] > theArray[j+1]) {
//                    int temp = theArray[j];
//                    theArray[j] = theArray[j+1];
//                    theArray[j+1] = temp;
//                }
//            }
//        }

        for (int i = arraySize - 1; i > 1; i--) {

            for (int j = 0; j < i; j++) {

                if (theArray[j] > theArray[j+1]) {
                    swapValues(j, j + 1);
                    printHorizontalArray(i, j);
                }
                printHorizontalArray(i, j);
            }
        }
    }

    public void selectionSort() {

        for (int i = 0; i < arraySize - 1; i++) {

            int min = i;

            for (int j = i + 1; j < arraySize; j++) {

                if (theArray[min] > theArray[j]) {
                    min = j;
                }
            }

            swapValues(i, min);
            printHorizontalArray(i, -1);

        }

    }


    public void insertionSort() {

        for (int i = 1; i < arraySize; i++) {

            int currentValue = theArray[i];
            int j = i - 1;

            while (j >= 0 && theArray[j] > currentValue) {
                theArray[j+1] = theArray[j];
                j--;
            }

            theArray[j+1] = currentValue;
            printHorizontalArray(i, -1);
        }

    }

    public void printHorizontalArray(int i, int j) {

        for (int n = 0; n <= theArray.length; n++) System.out.print("-");
        System.out.println();

        for (int n = 0; n < arraySize; n++) {
            System.out.print("| "+n+"  ");
        }
        System.out.println("|");

        for (int n = 0; n <= theArray.length; n++) System.out.print("-");
        System.out.println();

        for (int n = 0; n < arraySize; n++) {
            System.out.print("| "+theArray[n]+" ");
        }
        System.out.println("|");

        for (int n = 0; n <= theArray.length; n++) System.out.print("-");
        System.out.println();

        //**********

        if (j != -1) {
            for (int k = 0; k < ((j*5)+2); k++) System.out.print(" ");
            System.out.print(j);
        }


        //fixing spacing while printing iteration number
        if (i != -1) {
            for (int l = 0; l < (5*(i - j)-1); l++) System.out.print(" ");
            System.out.print(i);
        }

        System.out.println();
    }


    public void swapValues(int valueOne, int valueTwo) {

        int temp = theArray[valueOne];
        theArray[valueOne] = theArray[valueTwo];
        theArray[valueTwo] = temp;
    }

    public static void main(String[] args) {

        ArrayStructures newArray = new ArrayStructures();
        newArray.generateRandomArray();
        newArray.printArray();
//
//        System.out.println(newArray.getValueAtIndex(3));
//        System.out.println(newArray.doesArrayContainsThisValue(15));
//
//        newArray.deleteValueAtIndex(7);
//        newArray.printArray();
//
//        newArray.insertValue(55);
//        newArray.printArray();
//
        newArray.insertionSort();
        newArray.printArray();
        //newArray.binarySearchForValue(13);

    }

}
