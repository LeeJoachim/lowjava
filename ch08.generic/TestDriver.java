package ch08.generic;

/* java generic conventions         e.g. <?> : wildcard */
/* <T> is meant to be a Type */
/* <E> is meant to be an Element    e.g. List<E> : a list of Elements */
/* <K> is Key                       e.g. in a Map<K, V>*/
/* <T> is Value                     i.e. as a return val; mapped val */

/* <? super E>      means any object including E that is parent of E */
/* <? extends E>    means any object including E that is  child of E */

/*
 * Generic class 
 * i.e. template, parameterized class
 * 
 * ref level mechanism e.g. Integer, Double, ... extends Object
 */

/*
 * compiler finds functions at close distance preferentially  
 */

class Stack<E> {

    /* Attributes - data members */
    static int MAX = 100;
    E[] stacks;
    int top;
    int size;

    Stack() {
        this(MAX);
    }
    Stack(int n) {
        /* error handling call */
        if (n > MAX) overflowError();

        /* type cast to obj */
        stacks = (E[])new Object[n]; // Not E but Obj
        /**/
        size = n;
        top = -1;
    }
    

    void push(E item) {

        top++; // "do it first!"
        
        /* error handling call */
        if (top > size-1) overflowError();

        stacks[top] = item;
    }
    E pop() {
        /* error handling call */
        if (top == -1) emptyError();

        E val = stacks[top];
        stacks[top] = null; // notice : assign null
        top--;
        return val;
    }
    E peek() {
        /* error handling call */
        if (top == -1) emptyError();

        return stacks[top];
    }
    void reset() {
        initialize();
        top = -1;
    }
    int size() {
        return top+1;
    }
    @Override
    public String toString() {

        if (top == -1) emptyError();

        String s = "[";
        for (int i = 0; i < top; i++) {
            s = s + this.stacks[i] + " ";
        }
        s = s + this.stacks[top] + "]"; // last data
        return s;
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

    private void initialize() {
		// NOTE: We don't have to do this initialization with Java
		for(int i = 0; i < size; i++) {
			stacks[i] = null; // notice : init null
		}
	}

}

class TestDriver {
    public static void main(String[] args) {
        Stack<Integer> a = new Stack<Integer>();
        Stack<Double> b = new Stack<Double>(5);
        
        a.push(new Integer(10)); // boxing 
        a.push(20);
        int x = a.pop();
        a.push(new Integer(30)); // logical meaning
        a.push(40);

        b.push(100.0);
        b.push(200.0);
        b.push(300.0);
        b.push(400.0);
        double y = b.pop();


        System.out.println("x = " + x); // 20
        System.out.println("y = " + y); // 400

        System.out.println("top of stack a = " + a.peek()); // 40
        System.out.println("top of stack b = " + b.peek()); // 300
        
        
        
        System.out.println("size of a = " + a.size()); // 3
        a.reset();
        System.out.println("size of a = " + a.size()); // 0

        System.out.println(b.toString());
        System.out.println(b);
    }
}

