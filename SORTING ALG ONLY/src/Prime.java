import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prime {

    public static void main(String[] args) {

        printPrimeNumbers(100);
        printPrimeNumbers2();
        printPrimeNumbers3();

    }

    public static void printNumber (List<Integer> numbers) {
        for (Integer i : numbers) {
            System.out.print(i+" ");
        }
    }


    public static void printPrimeNumbers(int numberPool) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int numberToCheck = 2; numberToCheck <= numberPool; numberToCheck++) {
            boolean isPrime = true;
            for (int factor = 2; factor <= numberToCheck / 2; factor++) {
                if (numberToCheck % factor == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                primeNumbers.add(numberToCheck);
            }
        }

        printNumber(primeNumbers);
    }
    public static void printPrimeNumbers2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIn what range would you like to search?");
        int limit = scanner.nextInt();
        List<Integer> primeNumbers = new ArrayList<>();
        for (int numberToCheck = 2; numberToCheck <= limit; numberToCheck++) {
            boolean isPrime = true;
            for (int factor = 2; factor <= numberToCheck / 2; factor++) {
                if (numberToCheck % factor == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                primeNumbers.add(numberToCheck);
            }
        }
        printNumber(primeNumbers);
    }
    public static void printPrimeNumbers3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nHow many prime numbers would you like to see?");
        int primeCount = scanner.nextInt();
        List<Integer> primeNumbers = new ArrayList<>();
        int actualCount = 0;
        int numberToCheck = 2;
        while(actualCount < primeCount) {
            boolean isPrime = true;
            for (int factor = 2; factor <= numberToCheck / 2; factor++) {
                if(numberToCheck%factor == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                primeNumbers.add(numberToCheck);
                actualCount++;
            }
            numberToCheck++;
        }
        printNumber(primeNumbers);
    }

}
