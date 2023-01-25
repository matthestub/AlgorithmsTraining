import java.util.Arrays;

public class TheStack {

    private String[] stackArray;

    private int stackSize;

    private int topOfStack = -1;

    TheStack(int size) {
        stackSize = size;
        stackArray = new String[size];

        Arrays.fill(stackArray, "-1");
    }


    public void push(String input) {

        if (topOfStack + 1 < stackSize) {

            topOfStack++;
            stackArray[topOfStack] = input;

        } else {
            System.out.println("Sorry, the stack is full");
        }

        displayTheStack();
        System.out.println("PUSH "+input+", added to the stack.");
    }

    public String pop() {

        if (topOfStack >= 0) {
            displayTheStack();
            System.out.println("POP "+stackArray[topOfStack]+" - was removed from the Stack.\n");
            stackArray[topOfStack] = "-1";
            return stackArray[topOfStack--];
        } else {
            displayTheStack();
            System.out.println("Sorry but the stack is empty");
            return "-1";
        }
    }


    public String peek() {
        displayTheStack();

        System.out.println("PEEK "+stackArray[topOfStack]+" - is at the top of the Stack.\n");
        return stackArray[topOfStack];
    }

    public void pushMany(String multipleValues) {
        String[] tempString = multipleValues.split(" ");

        for (int i = 0; i < tempString.length; i++) {
            push(tempString[i]);
        }
    }

    public void popAll() {
        for (int i = stackSize; i >= 0; i--) {
            pop();
        }
    }


    public void displayTheStack() {

        for (int i = 0; i < 61; i++) System.out.print("-");
        System.out.println();

        for (int i = 0; i < stackSize; i++) {
            System.out.printf("| %2s "+ " ", i);
        }
        System.out.println("|");

        for (int i = 0; i < 61; i++) System.out.print("-");
        System.out.println();

        for (int i = 0; i < stackSize; i++) {
            if (stackArray[i].equals("-1")) System.out.print("|     ");
            else System.out.printf("| %2s "+" ", stackArray[i]);
        }
        System.out.println("|");

        for (int i = 0; i < 61; i++) System.out.print("-");
        System.out.println();


    }

    public static void main(String[] args) {

        TheStack theStack = new TheStack(10);
        theStack.push("10");
        theStack.push("15");
        theStack.peek();
        theStack.pop();

        theStack.displayTheStack();

        theStack.pushMany("12 9 15 91 52");

    }

}
