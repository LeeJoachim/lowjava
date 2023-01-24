package ch19.doublylinkedlist;

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
    ListIterator<E> listIterator() {
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

class TestDriver {
	public static void main(String[] args) 
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
        int selector;
        int item;
		
        while (true) {
			
			System.out.print("What do you want ? <1>addFront, <2>addTail, <3>remove, <4>quit : ");
			selector = readConsoleAndParseInt();
			if (selector < 1 || selector > 3) break;

			System.out.print("input int data : ");
			item = readConsoleAndParseInt();

			switch (selector) {
			case 1 :
				list.addFirst(item);
				System.out.println(list);
				break;
			case 2 :
				list.addLast(item);
				System.out.println(list);
				break;
			case 3 :
                list.remove(item);
                System.out.println(list);
				break;
            default :
                System.out.println(list);
				break;
			}
		}

		System.out.println("size of the list = " + list.size);
		ListIterator<Integer> iter = list.listIterator();
		while(iter.hasNext()) {
			int data = iter.next();
			System.out.println(data);
		}
	}

    static int readConsoleAndParseInt() {
		String str = System.console().readLine();
		return Integer.parseInt(str);
	}
}
