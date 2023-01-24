package ch11.twodimension;

class TestDriver {
    public static void main(String[] args) {

        /* x* in stack area --> x*[]'s length field in heap area */
        /* x*[0] --> int[0][0]'s length field */
        /* x*[1] --> int[1][0]'s length field */
        /* x*[2] --> int[2][0]'s length field */

        int[][] x = new int[3][4];
        
        int i, j, k; 
        k = 1;
        
        for (i = 0; i < x.length; i++) {
            for (j = 0; j < x[i].length; j++) {
                x[i][j] = k++;
            }
        }
        for (i = 0; i < x.length; i++) {
            for (j = 0; j < x[i].length; j++) {
                System.out.printf("%3d %c", x[i][j], ' ');
            }
            System.out.println();
        }

        /**/


        int[][] y = new int[3][]; // this is pointer's arr

        y[0] = new int[2];
        y[1] = new int[8];
        y[2] = new int[5];

        k = 1;
        
        for (i = 0; i < y.length; i++) {
            for (j = 0; j < y[i].length; j++) {
                y[i][j] = k++;
            }
        }
        for (i = 0; i < y.length; i++) {
            for (j = 0; j < y[i].length; j++) {
                System.out.printf("%3d %c", y[i][j], ' ');
            }
            System.out.println();
        }

        System.out.println("sum = " + getSum(y));
    }
    

    
    static int getSum(int[][] arr) {

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
    
}
