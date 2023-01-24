package ch07.integer.object;

class TestDriver {
    public static void main(String[] args) {
        
        /* polymorphic container */
        Object[] x = new Object[8];
        
        x[0] = 10;    // boxing
        x[1] = new Integer(10);      // original
        x[2] = 30.5;  // boxing
        x[3] = new Double(30.5);     // original
        x[4] = "lee"; // boxing
        x[5] = new String("lee"); // original

        /* read only */
        /* private final [datatype] [fieldname] */

        x[5] = "i love you"; // possible any index num

        for (int i = 0; i < 6; i++) {
            System.out.println(x[i]);
        }
    }    
}
