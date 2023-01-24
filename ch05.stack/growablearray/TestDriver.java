package ch05.stack.growablearray;


/**
 * Collection Object or Container Object
 * <ul>
 * <li> LIFO(Last In First Out) 
 * <li> Functions : push(), pop(), peek(), reset() 
 * <li> algorithm : growable array
 * </ul>
 */

class Stack {

    /* Attributes - data members */
    static int MAX = 2;
    int[] stacks;
    int top;
    int size;

    Stack() {
        this(MAX);
    }
    Stack(int n) {
        /* error handling call */
        if (n > MAX) overflowError();

        stacks = new int[n];
        size = n;
        top = -1;
    }
    
    void push(int item) {

        /* growable array algorithm */
        if (top >= size-1) { // 1. End of Array
            int[] temps;
            temps = new int[size + 2]; // 2. extends 2 spaces
            for (int i = 0; i < size; i++) {
                temps[i] = stacks[i]; // 3. be copying...
            }
            stacks = temps; // 4. be replaced
            size = size + 2;
        }
        /**/

        top++;
        stacks[top] = item;
    }
    int pop() {
        /* error handling call */
        if (top == -1) emptyError();

        int val = stacks[top];
        stacks[top] = 0;
        top--;
        return val;
    }
    int peek() {
        /* error handling call */
        if (top == -1) emptyError();

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

    /* error handling functions */
    private void overflowError() {
		System.err.println("Stack overflow error occurs.");
		System.exit(-1); // just sends -1, -2... to debugger
	}
	private void emptyError() {
		System.err.println("Stack empty error occurs.");
		System.exit(-1);
	}

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
        Stack a = new Stack();
        Stack b = new Stack(2);
        
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


        System.out.println("x = " + x); // 20
        System.out.println("y = " + y); // 400

        System.out.println("top of stack a = " + a.peek()); // 40
        System.out.println("top of stack b = " + b.peek()); // 300
        
        
        
        System.out.println("size of a = " + a.getTop()); // 3
        a.reset();
        System.out.println("size of a = " + a.getTop()); // 0
    }
}

