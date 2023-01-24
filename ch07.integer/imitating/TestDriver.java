package ch07.integer.imitating;

/* 
 * boxing and unboxing
 * 
 * you do not make these functions
 * because they are implemented in compiler by java developers
 */

class MyInteger extends Object {
    // private final int val;
    private int val;

    MyInteger(int val) {
        this.val = val;
    }

    static void swap(MyInteger a, MyInteger b) {
        int temp = a.getValue();
        a.setValue(b.getValue());
        b.setValue(temp);
    }
    
    
    public int getValue() {
        return val;
    }
    public void setValue(int val) {
        this.val = val;
    }
    @Override
    public String toString() {
        return "" + val;
    }
}

class TestDriver {
    public static void main(String[] args) {
        MyInteger x = new MyInteger(10);
        MyInteger y = new MyInteger(20);

        /* syntax err */
        // x = 50;

        System.out.println("x = " + x + " y = " + y);
        
        /* call by address val */
        MyInteger.swap(x, y); // "this is not prefer in obj oriented mind."
        /**/

        System.out.println("call swap()");
        System.out.println("x = " + x + " y = " + y);
    }
}
