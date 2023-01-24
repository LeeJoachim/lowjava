package ch19.doublylinkedlist.russianroulette;

// import java.util.LinkedList;

class Node<E> {

    Node<E> prev;
    Node<E> next;
    E data;

    public Node(Node<E> next, E data) {
        this.prev = this;
        this.next = next;
        this.data = data;
    }
    public Node(E data) {
        this.prev = this;
        this.next = this;
        this.data = data;
    }
    /* prev node > this > @param node */
    /* need to change between-values A and B, B and C */
    void insert(Node<E> node) {
        this.prev = node.prev;
        this.next = node;

        node.prev.next = this;
        node.prev = this;
    }
    /* @param node > this > next node */
    void append(Node<E> node) {
        this.prev = node;
        this.next = node.next;

        node.next.prev = this;
        node.next = this;
    }
    /**/
    void remove() {
        this.next.prev = this.prev;
        this.prev.next = this.next;
    }
}

class LinkedList<E> {

    Node<E> head;
    int size;

    /** push() */
    void addFirst(E item) {
        addLast(item);
        head = head.prev; // change position
    }
    void addLast(E item) {
        Node<E> node = new Node<E>(item);
        if (head == null) {
            head = node; size++;
            return;
        }
        node.insert(head); size ++; // insert() is 'add-last'
    }
    void add(int index, E item) {
        
        // Node node = head;
        // Node temp;

        // if (index == 1) {
        //     temp = head;
        //     head = new Node<E>(temp, item); size++;
        //     return;
        // }
        // for (int i = 0; i < index-2; i++) {
        //     node = node.next;
        // }
        // temp = node.next;
        // node.next = new Node<E>(temp, item); size++;

        /* out of bounds */
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addFirst(item);
            return;
        }

        int count = 1;
        Node<E> node = head;
        Node<E> next = head.next;
        while (next != null) {
            if (count == index) break;
            count++;
            node = next;
            next = node.next;
        }
        Node<E> n = new Node<E>(item);
        n.append(node); size++;
    }
    void replace(int index, E item) {
        Node node = head;
        Node temp;

        if (index == 1) {
            temp = head.next;
            head = new Node<E>(temp, item);
            return;
        }
        for (int i = 0; i < index-2; i++) {
            node = node.next;
        }
        temp = node.next.next;
        node.next = new Node<E>(temp, item);
    }
    void remove(E item) {
        
        /* defence null point exception */
        if (head == null) return;
        Node<E> node = head.next;
        /**/

        if (head != null && head.data.equals(item)) {
            Node<E> temp = head.next;
            head.remove(); size--;

            /* checking : if (head is recursive) kill head */
            if (temp == head) {
                head = null; return;
            }
            /**/

            head = temp; return;
        }

        while (node != head) {
            if (node.data.equals(item)) {
                node.remove(); size--; return;
            }
            node = node.next;            
        }
    }
    void removeIndex(int index) {
        Node node = head;
        Node temp;

        if (index == 1) {
            temp = head.next;
            head = temp; size--;
            return;
        }
        for (int i = 0; i < index-2; i++) {
            node = node.next;
        }
        temp = node.next.next;
        node.next = temp; size--;
    }
    ListIterator<E> ListIterator() {
        return new ListIterator<E>(head);
    }
    @Override
    public String toString() {
        String str = "";
        Node<E> node = head;
        for (int i = 0; i < size; i++) {            
            str += "[" + node.data + "] ";
            node = node.next;
        }
        return str;
    }
}

class ListIterator<E> {
    Node<E> head;
    Node<E> node;

    public ListIterator(Node<E> head) {
        this.head = head;
    }
    boolean hasNext() {
        if (node == null) {
            if (head == null) {
                return false;
            }
            node = head;
            return true;
        }

        if (node == head)
            return false;
        else 
            return true;
    }
    E next() {
        E temp = node.data;
        node = node.next;
        return temp;
    }
}

class Revolver extends LinkedList<String> {

    static final boolean KILLED = false;
    static final boolean ALIVE = true;

    Node<String> node;
    int nHoles;
    int nBullets;

    public Revolver(boolean[] bullets, int max) {
        nHoles = max;
        nBullets = 0;

        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i] == true) {
                addLast("*"); nBullets++; nHoles--;
            } else {
                addLast("0");
            }
        }

        node = head;
    }

    boolean bang() {
        int num = (int) (Math.random()*10);
        
        if (num % 2 == 0) {
            for (int i = 0; i < num; i++) node = node.prev;
            System.out.println("Rotate right " + num + " times.");
        } else {
            for (int i = 0; i < num; i++) node = node.next;
            System.out.println("Rotate left " + num + " times.");
        }

        if (node.data.equals("*")) {
            System.out.println("BANG!"); nBullets--; nHoles++;
            return KILLED;
        } else {
            return ALIVE;
        }
    }

    void print(boolean hasStarted) {
        Node<String> temp = node;
        if (temp.data.equals("*")) {
            if (hasStarted == false) System.out.print("* ");
            else {
                System.out.print("X ");
				temp.data = "0";
            }
        } else {
            System.out.print("0 ");
        }
        temp = temp.next;

        /* print what is left of  */
        for (int i = 1; i < size; i++) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        /**/
    }
}

class TestDriver {
    public static void main(String[] args) {

        final int MAX = 8;
        System.out.println("--- Welcome a board (Russian Roulette) ---");
		System.out.println("Load Bullets : You can load up to " + MAX + " bullets.");
        boolean[] bullets = new boolean[MAX];

        for (int i = 0; i < bullets.length; i++) {
            String str;

            System.out.print("Do you want to load a bullet at hole[" + i + "] ? (y/n) ");
            str = System.console().readLine();
            if (str.equals("y")) bullets[i] = true;
            else bullets[i] = false;
        }

        System.out.print("Type the number of players: ");
		int nPlayers = Integer.parseInt(System.console().readLine());
        
        Revolver gun = new Revolver(bullets, MAX);
        System.out.print("Loaded bullets: ");
        gun.print(false);

        int i = 1;
        while(true) {
            String str;

            /* my turn, your turn */
            if (i > nPlayers) i = 1; // init i;
            System.out.print(i + "th man's turn : do you want to continue ? (y/n) ");

            str = System.console().readLine();
            if (!str.equals("y")) System.exit(0);
            gun.bang();
            gun.print(true);
            
            i++;
        }
    }
}
