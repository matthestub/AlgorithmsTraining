import java.util.Arrays;

public class TheQueue {

    private String[] queueArray;

    private int queueSize;

    private int front = 0, rear = 0, numberOfItems = 0;

    TheQueue(int size) {
        this.queueSize = size;
        this.queueArray = new String[queueSize];
        Arrays.fill(queueArray, "-1");
    }


    public void insert(String input) {

        if (numberOfItems + 1 < queueSize) {
            queueArray[rear] = input;
            rear++;
            numberOfItems++;

            System.out.println("INSERT "+input+" - was added to the queue.");
        } else {
            System.out.println("Sorry but the queue is full");
        }

    }

        public void remove() {
           if (numberOfItems > 0) {
               System.out.println("REMOVE "+queueArray[front] + " - was removed from the queue.");
                queueArray[front] = "-1";
                front++;
                numberOfItems--;
           }
           else {
               System.out.println("Sorry but the queue is empty.");
           }
        }

        public void peek() {
            System.out.println("The first element is: "+queueArray[front]);
        }

        public void insertMany(String bigInput) {
            String[] strArray = bigInput.split(" ");

            for (int i = 0; i < strArray.length; i++) {
                priorityInsert(strArray[i]);
            }
        }


        public void priorityInsert(String input) {

        int i;
            if (numberOfItems == 0) {
                insert(input);
            }
            else {

                for (i = numberOfItems-1; i >= 0; i--) {

                    if (Integer.parseInt(input) > Integer.parseInt(queueArray[i])) {
                        queueArray[i+1] = queueArray[i];
                    } else break;
                }
                queueArray[i+1] = input;
                rear++;
                numberOfItems++;
            }
        }


    public void displayTheQueue() {

        for (int i = 0; i < 61; i++) System.out.print("-");
        System.out.println();

        for (int i = 0; i < queueSize; i++) {
            System.out.printf("| %2s "+ " ", i);
        }
        System.out.println("|");

        for (int i = 0; i < 61; i++) System.out.print("-");
        System.out.println();

        for (int i = 0; i < queueSize; i++) {
            if (queueArray[i].equals("-1")) System.out.print("|     ");
            else System.out.printf("| %2s "+" ", queueArray[i]);
        }
        System.out.println("|");

        for (int i = 0; i < 61; i++) System.out.print("-");
        System.out.println();

        int spacesBeforeFront = 3*(2*(front+1)-1);
        for(int k = 1; k < spacesBeforeFront; k++)System.out.print(" ");
        System.out.print("F");

        int spacesBeforeRear = (2*(3*rear)-1) - (spacesBeforeFront);
        for(int l = 0; l < spacesBeforeRear; l++)System.out.print(" ");

        System.out.print("R");

        System.out.println("\n");

    }


    public static void main(String[] args) {

        TheQueue theQueue = new TheQueue(10);

//        theQueue.insert("11");
//        theQueue.insert("15");
//        theQueue.insert("12");
//
//        theQueue.displayTheQueue();

//        theQueue.remove();
//
//        theQueue.displayTheQueue();

//        theQueue.peek();

        theQueue.insertMany("18 5 22 19 9");

        theQueue.displayTheQueue();
    }
}
