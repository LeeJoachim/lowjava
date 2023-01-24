package ch06.exceptionhandling.simplequeue;

/* java generic conventions,         e.g. <?> : wildcard */
/* <T> is meant to be a Type */
/* <E> is meant to be an Element    e.g. List<E> : a list of Elements */
/* <K> is Key                       e.g. in a Map<K, V>*/
/* <T> is Value                     i.e. as a return val; mapped val */

/* <? super E>      means any object including E that is parent of E */
/* <? extends E>    means any object including E that is  child of E */

/* simple queue */
class Queue {
    int front;
    int rear;
    int[] queues;
    
    static final int MAX = 100;

    Queue() {
        front = 0;
        rear = 0;
        queues = new int[MAX];
    }

    void enqueue(int x) {
        queues[rear] = x;
        rear++;

    }
    int dequeue() {
        int temp = queues[front];
        front++;
        return temp;
    }
}

class TestDriver {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("queue.dequeue() : " + queue.dequeue());
        System.out.println("queue.dequeue() : " + queue.dequeue());
        System.out.println("queue.dequeue() : " + queue.dequeue());
    }    
}
