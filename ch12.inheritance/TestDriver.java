package ch12.inheritance;

// abstract 
class Point2D {
    int x;
    int y;

    
    public Point2D() {
        this.x = 0;
        this.y = 0;
    }
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }


    @Override
    public String toString() {
        return "[x=" + x + "] [y=" + y + "]";
    }
    Point2D add(Point2D p) {
        Point2D temp = new Point2D(this.x + p.getX(), 
                                   this.y + p.getY());
        return temp;
    }
    void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    // abstract void move (int x, int y, int z);
}

class Point3D extends Point2D {

    int z;
    
    public Point3D() {
        super();
        this.z = 0;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    
    void move(int x, int y, int z) {
        super.move(x, y); this.z += z;
    }
    
    // @Override
    // public String toString() {
    //     return super.toString() + " [z=" + z + "]";
    // }

    @Override
    public String toString() {
        return x + " " + y + " " + z;
    }
}

class TestDriver {
    public static void main(String[] args) {
        
        Point2D a = new Point2D(10, 20);
        Point2D b = new Point2D();
        Point2D c;

        b.setX(20); b.setY(30);
        System.out.println(a.getX() + ", " + a.getY());
        System.out.println("b : " + b);

        c = a.add(b);
        System.out.println("c : " + c);
        
        c.move(100, 100);
        System.out.println("c : " + c);
        

        /**/

        Point3D d = new Point3D();
        // Point2D d = new Point3D(); // upcasting!
        System.out.println(d);

        d = new Point3D(10, 20, 30);
        d.move(10, 10, 10);
        System.out.println(d);
        System.out.println(d.x);
        
        /* [upcasting, interface-abstract] */
        /* [inheritance, super, non-casting] */

        /* override : same function name, function signature */

        /* The compiler does not go down, just go up!
         * that is a one-way street.
         */
    }
}
