package ch18.datastructure.linkedlist.library;

import java.util.Iterator;
import java.util.LinkedList;

// class Node<E> {

//     Node<E> next;
//     E data;

//     public Node(Node<E> next, E data) {
//         this.next = next;
//         this.data = data;
//     }
//     public Node(E data) {
//         this.next = null;
//         this.data = data;
//     }
// }

// class LinkedList<E> {

//     Node<E> head;
//     int size;

//     /** push() */
//     void addFirst(E item) {
//         head = new Node(head, item); size++;
//     }
//     void addLast(E item) {
//         if (head == null) {
//             head = new Node<E>(item); size++; return;
//         }

//         Node<E> node = head;
//         while (node.next != null) {
//             node = node.next;
//         }
//         node.next = new Node<E>(item); size++;
//     }
//     void add(int index, E item) {
        
//         Node node = head;
//         Node temp;

//         if (index == 1) {
//             temp = head;
//             head = new Node<E>(temp, item); size++;
//             return;
//         }
//         for (int i = 0; i < index-2; i++) {
//             node = node.next;
//         }
//         temp = node.next;
//         node.next = new Node<E>(temp, item); size++;
//     }
//     void replace(int index, E item) {
//         Node node = head;
//         Node temp;

//         if (index == 1) {
//             temp = head.next;
//             head = new Node<E>(temp, item);
//             return;
//         }
//         for (int i = 0; i < index-2; i++) {
//             node = node.next;
//         }
//         temp = node.next.next;
//         node.next = new Node<E>(temp, item);
//     }
//     void remove(E item) {
//         Node<E> node = head;
//         while (head != null && node.next != null) {
//             if (node.next.data.equals(item)) {
//                 node.next = node.next.next; size--;
//             }
//             node = node.next;
//         }
//     }
//     void removeIndex(int index) {
//         Node node = head;
//         Node temp;

//         if (index == 1) {
//             temp = head.next;
//             head = temp; size--;
//             return;
//         }
//         for (int i = 0; i < index-2; i++) {
//             node = node.next;
//         }
//         temp = node.next.next;
//         node.next = temp; size--;
//     }
//     ListIterator<E> ListIterator() {
//         return new ListIterator<E>(head);
//     }
//     @Override
//     public String toString() {
//         String str = "";
//         Node<E> node = head;
//         while (node != null) {
//             str += "[" + node.data + "] ";
//             node = node.next;
//         }
//         return str;
//     }
// }

// class ListIterator<E> {
//     Node<E> node;

//     public ListIterator(Node<E> node) {
//         this.node = node;
//     }
//     boolean hasNext() {
//         if (node == null)
//             return false;
//         else 
//             return true;
//     }
//     E next() {
//         E temp = node.data;
//         node = node.next;
//         return temp;
//     }
// }


class TestDriver {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();

        /*
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        System.out.println(list);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        System.out.println(list);
        list.add(7, 1000);
        System.out.println(list);
        list.replace(5, 999);
        System.out.println(list);
        System.out.println(list.size);
        list.remove(999);
        System.out.println(list);
        System.out.println(list.size);
        list.removeIndex(2);
        System.out.println(list);
        System.out.println(list.size);
        */

        while (true) {
            int inputNum;
            String inputData;

			System.out.print("What do you want ? <1>addFront, <2>addTail, <3>remove, <4>quit : ");
            inputNum = readAndParseInt();
            
            /* out of bounds */
            if (inputNum < 1 || inputNum > 4) {
                System.out.println("wrong number");
                break;
            }
            /* quit mode */
            if (inputNum == 4) {
                System.out.println("good bye!");
                break;
            }

            /* and then... */
            System.out.print("Input String data : ");
            inputData = System.console().readLine();

            switch (inputNum) {
                case 1:
                    list.addFirst(inputData);
                    System.out.println(list);
                    break;
                case 2:
                    list.addLast(inputData);
                    System.out.println(list);
                    break;
                case 3:
                    list.remove(inputData);
                    System.out.println(list);
                    break;

                /* dead code */
                default:
                    System.out.println(list);
                    break;
            }
        }

        /* test other operations */
        System.out.println("size of the list = " + list.size());

        Iterator<String> iter = list.iterator();
        while(iter.hasNext()) {
            String data = iter.next();
            System.out.println(data);
        }
    }
    
    static int readAndParseInt() {
        String s = System.console().readLine();
        return Integer.parseInt(s);
    }
}
