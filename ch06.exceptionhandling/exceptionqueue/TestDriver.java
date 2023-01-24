package ch06.exceptionhandling.exceptionqueue;

/*
 * not just print when compiler meets if (SOMETHING_EXCEPTION) out.println("err!");
 * 
 * this is java syntax
 * if (HAPPEN) throw new Exception();
 * 
 * and then
 * you have to attach 'throws Exception' to function's signification 
 * 
 * and then : not essential if constructor is not in try{}
 * the constructors also have to added 'throws Exception'
 * Therefore, class is no need to throws Exception, because of constructor
 * 
 * and then
 * TestDriver have to talk try catch syntax
 * if exception is caught, you can print special messages.
 */

/* primitive handling */
/* exception class just show a message */
class QueueException extends Exception {
    String s;

    public QueueException(String s) {
        this.s = s;
    }
    public String getExceptionMessage() {
        return s;
    }
}

/* simple queue */
class Queue {
    static final int MAX = 4;
    
    int front;
    int rear;
    int[] queues;

    Queue() {
        front = 0;
        rear = 0;
        queues = new int[MAX];
    }

    void enqueue(int x) throws QueueException {
        if (rear >= MAX) throw new QueueException("-1");

        queues[rear] = x;
        rear++;

    }
    int dequeue() throws QueueException {
        if (rear <= front) throw new QueueException("-2");

        int temp = queues[front];
        front++;
        return temp;
    }
}

class TestDriver {
    public static void main(String[] args) {
        Queue queue = new Queue();

        try {
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);
            queue.enqueue(30);
            queue.enqueue(30);
            queue.enqueue(30);
            queue.enqueue(30);
            System.out.println("queue.dequeue() : " + queue.dequeue());
            System.out.println("queue.dequeue() : " + queue.dequeue());
            System.out.println("queue.dequeue() : " + queue.dequeue());
            
        } catch (QueueException e) { 
            System.out.println(e.getExceptionMessage());
        }
    }    
}
