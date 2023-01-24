package ch08.generic.librarystack;
import java.util.Stack;

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
        Stack<Integer> a = new Stack<Integer>();
        Stack<Double> b = new Stack<Double>();
        
        a.push(new Integer(10)); // boxing 
        a.push(20);
        int x = a.pop();
        a.push(new Integer(30)); // logical meaning
        a.push(40);

        b.push(100.0);
        b.push(200.0);
        b.push(300.0);
        b.push(400.0);
        double y = b.pop();


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

