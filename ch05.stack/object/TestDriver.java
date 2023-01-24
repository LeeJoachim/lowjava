package ch05.stack.object;

/* do not use library */
// import java.awt.Point;


/**
 * class Object
 * <p>
 * Every java class extends Object and that is not visible...
 * <ul>
 * <li> toString() : return String info
 * <li> equals(Object obj) : "are they same reference?"
 * </ul>
 */

/* make Point class, do not use java library */
class Point {

    /* data members */
    int x;
    int y;
    /**/

    /* constructor */
    /* init */
    Point() {
        this(0, 0);
    }
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**/

    /* getter functions */
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    /**/

    /* Object's equals() function override */
    /* "exactly needs same function signature" */
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point pt = (Point)obj;
            return (x == pt.x) && (y == pt.y);
        }

        System.err.println("/* Your @param is not instanceof 'Point' */");
        return false;
    }
    /**/

    /* override */
    public String toString() {
        return "hey"; // "please return meaningful line."
    }
    /**/


}

class TestDriver {
    public static void main(String[] args) {
        Point pt1 = new Point(10, 20);
        Point pt2 = new Point(20, 30);

        int x = (int)pt1.getX();
        int y = (int)pt2.getY();

        /* when it is runtime, return class name info */
        System.out.println("pt1.getClass().getName() : ");
        System.out.println(pt1.getClass().getName());
        /**/
        
        /* get hash code */
        /* is random number, that is bound in compile time */
        System.out.println("pt1.hashCode()");
        System.out.println(pt1.hashCode());
        /**/

        System.out.println(x + " " + y);

        /* toString() */
        System.out.println(pt1); // is same 'pt1.toString()'
        /**/

        if (pt1.equals(pt2) == true) {
            System.out.println("same");
        } else {
            System.out.println("different");
        }
    }
}