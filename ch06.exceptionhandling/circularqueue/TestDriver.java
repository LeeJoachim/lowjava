package ch06.exceptionhandling.circularqueue;

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
    
    static final int SIZE = 4;

    Queue() {
        front = 0;
        rear = 0;
        queues = new int[SIZE];
    }

    /* do not enQueue over and equals SIZE */
    void enQueue(int x) {
        /* defensive programming */
        /* this algorithm just moves whole Queues if arr meets 'end of arr' */
        if (rear >= SIZE-1) {

            int[] temps = new int[SIZE];
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
        System.out.println("q.dequeue() : " + q.deQueue());
        System.out.println("q.dequeue() : " + q.deQueue());
        System.out.println("q.dequeue() : " + q.deQueue());
        q.enQueue(40);
        q.enQueue(50);
        q.enQueue(60);
        System.out.println("q.dequeue() : " + q.deQueue());
        System.out.println("q.dequeue() : " + q.deQueue());
        System.out.println("q.dequeue() : " + q.deQueue());

        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);
        System.out.println("q.dequeue() : " + q.deQueue());
        System.out.println("q.dequeue() : " + q.deQueue());
        System.out.println("q.dequeue() : " + q.deQueue());
        q.enQueue(40);
        q.enQueue(50);
        q.enQueue(60);
        System.out.println("q.dequeue() : " + q.deQueue());
        System.out.println("q.dequeue() : " + q.deQueue());
        System.out.println("q.dequeue() : " + q.deQueue());
    }    
}
