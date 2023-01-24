package ch07.integer.array;

class TestDriver {
    public static void main(String[] args) {
        
        /* STACK AREA's *x ->
         * HEAP AREA's arr's first field, that is length field
         * and then index 0, 1, 2 ... 8
         */
        // int[] x = new int[8];      // reference's arr that points int     arr's length field 
        Integer[] x = new Integer[8]; // reference's arr that points Integer obj's length field
                                      // length field is assiened 8

        /* so what is different? */
        /* in HEAP AREA
         * "is that int arr?" OR "is that obj arr?"
         * 
         * i.e. 'obj arr' is also reference's arr in heap area
         * that points each 'class Integer';
         */

        x[0] = 10;
        x[1] = 20;
        x[2] = 30;
        x[3] = 40;
        x[4] = 50;
        x[5] = 60;

        x[3] = 90; // previously x[3] mallocated structure becomes free and go to garbage

        /* conclusion :
         * not just calculation or save purpose but for mechanism consistence about collection obj, especially generic class
         */

        for (int i = 0; i < 6; i++) {
            System.out.println(x[i]);
        }
    }    
}
