package ch05.stack.point;

/* do not use library */
// import java.awt.Point;

/**
 * class Object
 * <p>
 * Every java class extends Object and that is not visible...
 * <ul>
 * <li> toString(), equals()
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

    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point pt = (Point)obj;
            return (x == pt.x) && (y == pt.y);
        }

        System.err.println("/* Your @param is not instanceof 'Point' */");
        return false;
    }


}

    class TestDriver {
    public static void main(String[] args) {
        Point pt1 = new Point(10, 20);
        Point pt2 = new Point(20, 30);

        int x = (int)pt1.getX();
        int y = (int)pt2.getY();

        System.out.println(x + " " + y);
        System.out.println(pt1);

        if (pt1.equals(pt2) == true) {
            System.out.println("same");
        } else {
            System.out.println("different");
        }
    }
}