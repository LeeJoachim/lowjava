package ch05.stack.linkedlist;


/**
 * Collection Object or Container Object
 * <ul>
 * <li> LIFO(Last In First Out) 
 * <li> Functions : push(), pop(), peek(), reset() 
 * <li> algorithm : linked list
 * </ul>
 */

class Stack {
    /* inner class - list node */
    static class StackItem {
        private int value;
        private StackItem next;

        /* init */
        StackItem(int v) {
            value = v;    
            next = null;
        }

        /* getter functions or read access function */
        public int getValue() {
            return value;
        }
        public StackItem getNext() {
            return next;
        }

        /* setter functions or write access function */
        public void setNext(StackItem next) {
            this.next = next;
        }
    
    }

    /* Attributes - data members */
    StackItem top; // if top is null, stack is empty
    /**/

    Stack() {
        initialize();
    }
    
    void push(int i) {
        /* linked list algorithm */
        if (isEmpty()) top = new StackItem(i);
        else {
            StackItem item = new StackItem(i);

            /* CAUTION! : important to understand!
             * 
             * setNext() function call sent only heap area's object address to item instance.
             * in other words, it delivered the contents. NOT stack area's variable address.
             * therefore, if *top's contents is changed to another address val. 
             * It does not affect the previous process.
             * 
             * e.g. see 2 lines below
             */
            item.setNext(top);
            top = item; // this is a preparatory move for the next function call.
            /**/
        }
        
    }
    int pop() {
        /* error handling call */
        if (isEmpty()) emptyError();

        StackItem temp = top;
        top = top.getNext();
        return temp.getValue();
    }
    int peek() {
        /* error handling call */
        if (isEmpty()) emptyError();

        return top.value;
    }
    void reset() {
        initialize();
    }
    boolean isEmpty() {
        if (top == null) return true;
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

    /* init top to null*/
    private void initialize() {
        top = null;
	}

}

/* Client or User */
/* Client must not talk InnerClass */
class TestDriver {
    public static void main(String[] args) {
        Stack a = new Stack();
        Stack b = new Stack();
        
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
        
        a.reset();
    }
}

