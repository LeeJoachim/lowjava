package ch08.generic.libraryqueue;
import java.util.ArrayDeque; // using growable arr
// import java.util.AbstractQueue; // abstract class can not instantiation

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

class TestDriver {
    public static void main(String[] args) {

        ArrayDeque<Integer> a = new ArrayDeque<Integer>();
        ArrayDeque<Double> b = new ArrayDeque<Double>();
        
        a.add(new Integer(10)); // boxing 
        a.add(20);
        int x = a.remove();
        a.add(new Integer(30)); // logical meaning
        a.add(40);

        b.add(100.0);
        b.add(200.0);
        b.add(300.0);
        b.add(400.0);
        double y = b.remove();


        System.out.println("x = " + x); // 20
        System.out.println("y = " + y); // 400

        System.out.println("top of stack a = " + a.peek()); // 40
        System.out.println("top of stack b = " + b.peek()); // 300
        
        
        
        System.out.println("size of a = " + a.size()); // 3
        System.out.println("size of a = " + a.size()); // 3

        System.out.println(a.toString());
        System.out.println(a);
    }
}

