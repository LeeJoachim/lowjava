package ch06.exceptionhandling.growablequeue;

/* java generic conventions         e.g. <?> : wildcard */
/* <T> is meant to be a Type */
/* <E> is meant to be an Element    e.g. List<E> : a list of Elements */
/* <K> is Key                       e.g. in a Map<K, V>*/
/* <T> is Value                     i.e. as a return val; mapped val */

/* <? super E>      means any object including E that is parent of E */
/* <? extends E>    means any object including E that is  child of E */

/* NOTION! : this is not circular queue */
/*           this is personal queue */

class Queue {
    int front;
    int rear;
    int[] queues;
    
    static final int SIZE = 2;

    Queue() {
        front = 0;
        rear = 0;
        queues = new int[SIZE];
    }

    /* do not enQueue over and equals SIZE */
    void enQueue(int x) {
        /* defensive programming */
        /* this algorithm just grows defined array if arr meets 'end of arr' */
        if (rear >= SIZE-1) {

            int[] temps = new int[SIZE+10]; // grows 10 spaces
            int pos = 0;

            for (int i = front; i <= rear; i++) {
                temps[pos] = queues[i]; // be copying...
                pos++;
            }
            /* init */
            rear = rear-front;
            front = 0;
 
            queues = temps;
        }

        queues[rear] = x;
        rear++;
    }
    int deQueue() {
        int temp = queues[front];
        front++;
        return temp;
    }
}

class TestDriver {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);
        q.enQueue(40);
        q.enQueue(50);
        q.enQueue(60);
        q.enQueue(70);
        q.enQueue(80);
        q.enQueue(90);
        q.enQueue(100);
        q.enQueue(110);
        q.enQueue(120);
        System.out.println("q.dequeue() : " + q.deQueue());
        System.out.println("q.dequeue() : " + q.deQueue());
        System.out.println("q.dequeue() : " + q.deQueue());
        System.out.println("q.dequeue() : " + q.deQueue());
        System.out.println("q.dequeue() : " + q.deQueue());
        System.out.println("q.dequeue() : " + q.deQueue());
        System.out.println("q.dequeue() : " + q.deQueue());
        System.out.println("q.dequeue() : " + q.deQueue());
        System.out.println("q.dequeue() : " + q.deQueue());
        System.out.println("q.dequeue() : " + q.deQueue());
        System.out.println("q.dequeue() : " + q.deQueue());
        System.out.println("q.dequeue() : " + q.deQueue());
    }    
}
