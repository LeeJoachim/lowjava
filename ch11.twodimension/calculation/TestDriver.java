package ch11.twodimension.calculation;

/* C language style code */

class CalMatrix {

    static int[][] add(int[][] x, int[][] y) {

        int[][] z = new int[x.length][x[0].length];
        boolean flag = true;

        /* defensive */
        for (int i = 0; i < x.length; i++) {
            if ((x[i].length != y[i].length) && flag) {
                System.err.println("not match row and col");
                flag = false;
            }
        }
        if ((x.length != y.length) && flag) {
            System.err.println("not match row and col");
            flag = false;
        /**/

        /* algorithm */
        } else if (flag) {
            for (int i = 0; i < x.length; i++) {
                for (int j = 0; j < x[0].length; j++) {
                    z[i][j] = x[i][j] + y[i][j];
                }
            }
        }
        /**/


        return z;
   }

   static int[][] multiply(int[][] x, int[][] y) {

        int[][] z = new int[x.length][y[0].length];
        boolean flag = true;

        /* defensive */
        if ((x[0].length != y.length) && flag) { // x[0] is not enough defensive 
            System.err.println("not match row and col");
            flag = false;
        /**/

        /* algorithm */
        } else if (flag) {
            for (int i = 0; i < x.length; i++) {

                for (int k = 0; k < y[0].length; k++) {
                    
                    for (int j = 0; j < x[0].length; j++) {
                        z[i][k] += x[i][j] * y[j][k];
                    }
                }
            }
        }
        /**/


        return z;
    }

}

class TestDriver {

    public static void main(String[] args) {

        int[][] x = { { 1, 2, 3, 4 }, 
                      { 5, 6, 7, 8 }, 
                      { 9, 10, 11, 12 }, };
        int[][] y = { { 1, 2, 3, 4 }, 
                      { 5, 6, 7, 8 }, 
                      { 9, 10, 11, 12 }, };
        int[][] z;

        int[][] temp = { { 2, 2 }, 
                         { 2, 2 }, 
                         { 2, 2 }, 
                         { 2, 2 }, };


        z = CalMatrix.multiply(x, temp);
        print(z); 

    }

    static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%3d", arr[i][j]);
            }
            System.out.println();
        }
    }
}
