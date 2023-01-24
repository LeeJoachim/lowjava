package ch06.exceptionhandling.linkedlistqueue;

/* java generic conventions,         e.g. <?> : wildcard */
/* <T> is meant to be a Type */
/* <E> is meant to be an Element    e.g. List<E> : a list of Elements */
/* <K> is Key                       e.g. in a Map<K, V>*/
/* <T> is Value                     i.e. as a return val; mapped val */

/* <? super E>      means any object including E that is parent of E */
/* <? extends E>    means any object including E that is  child of E */

/* simple queue */
class Queue {

    /* inner class - list node */
    static class QueueItem {
        int val;
        QueueItem next;

        /* init */
        QueueItem(int v) {
            val = v;
            next = null;
        }
        /**/

        /* getter function */
        public int getValue() {
            return val;
        }
        public QueueItem getNext() {
            return next;
        }

        /* setter functions */
        public void setValue(int val) {
            this.val = val;
        }
        public void setNext(QueueItem next) {
            this.next = next;
        }
        /**/
    }
    QueueItem front;
    QueueItem rear;
    
    Queue() {
        initialize();
    }

    void enqueue(int x) {
        if (isEmpty()) {
            rear = new QueueItem(x); // run only first time
            front = rear;
        }
        else {
            QueueItem temp = new QueueItem(x);
            rear.setNext(temp);
            rear = temp;
        }
    }
    int dequeue() {

        QueueItem temp = front;
        front = front.getNext();
        return temp.getValue();

    }

    /** init rear to null */
    void initialize() {
        rear = null;
    }
    /** if rear is empty */
    boolean isEmpty() {
        if (rear == null) return true;
        else return false;
    }
}

class TestDriver {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        System.out.println("queue.dequeue() : " + queue.dequeue());
        System.out.println("queue.dequeue() : " + queue.dequeue());
        System.out.println("queue.dequeue() : " + queue.dequeue());
        System.out.println("queue.dequeue() : " + queue.dequeue());
        System.out.println("queue.dequeue() : " + queue.dequeue());
        System.out.println("queue.dequeue() : " + queue.dequeue());
    }    
}
