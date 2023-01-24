package ch06.exceptionhandling;

/* 
 * java syntax enforces 'throw exception'
 * case 1 : i/o programming
 * case 2 : network programming
 * case 3 : database programming
 */

/* exception handling class */
/* has String exceptionNumber */
class StackException extends Exception {
    String exceptionNumber;

    StackException(String s) {
        this.exceptionNumber = s;
    }
    public String getExceptionNumber() {
        return exceptionNumber;
    }
}

class Stack {
    /* Attributes - data members */
    static int MAX = 100;
    int[] stacks;
    int top;
    int size;

    Stack() throws StackException {
        this(MAX);
    }
    Stack(int n) throws StackException {
        /* exception handling */
        if (n > MAX) throw new StackException("-1");

        stacks = new int[n];
        size = n;
        top = -1;
    }

    void push(int item) throws StackException {

        top++; // "do it first!"

        /* exception handling */
        if (top >= size) throw new StackException("-2");
        stacks[top] = item;
    }
    int pop() throws StackException {
        /* exception handling */
        if (top == -1) throw new StackException("-3");

        int val = stacks[top];
        stacks[top] = 0;
        top--;
        return val;
    }
    int peek() throws StackException {
        /* exception handling */
        if (top == -1) throw new StackException("-4");

        return stacks[top];
    }
    void reset() {
        initialize();
        top = -1;
    }
    boolean isEmpty() {
        if (top == -1) return true;
        else return false;
    }

    /* getter function */
    int getTop() {
        return top;
    }

    /* error handling functions "are not useful in java" */
    /*
    private void overflowError() {
        System.err.println("Stack overflow error occurs.");
        System.exit(-1); // just sends -1, -2... to debugger
    }
    private void emptyError() {
        System.err.println("Stack empty error occurs.");
        System.exit(-1); // "kill process is most dangerous!"
    }
    */

    /* init */
    private void initialize() {
        // NOTE: We don't have to do this initialization with Java
        for(int i = 0; i < size; i++) {
            stacks[i] = 0;
        }
    }

}

class TestDriver {
    public static void main(String[] args) {
        
        try {
            Stack a = new Stack();
            Stack b = new Stack(3);

            a.push(10);
            a.push(20);
            int x = a.pop();
            a.push(30);
            a.push(40);

            b.push(100);
            b.push(200);
            b.push(300);
            b.push(400);
            int y = b.pop();

            /* printing */
            System.out.println("x = " + x); // 20
            System.out.println("y = " + y); // 400

            System.out.println("top of stack a = " + a.peek()); // 40
            System.out.println("top of stack b = " + b.peek()); // 300

            System.out.println("size of a = " + a.getTop()); // 3
            a.reset();
            System.out.println("size of a = " + a.getTop()); // 0
            /**/

        } catch (StackException e) {
            System.out.println("e.toString() : " + e.toString());
            System.out.println("e.getExceptionNumber() : " + e.getExceptionNumber());

            /* if this mechanism is in while(true) loop. */
            /* you can call 'reset()' and break one loop. */
        }
    }
}
