package ch13.aggregation;

class Matrix {
    int[][] matrix;

    int rowNum;
    int colNum;
    
    /* init */
    public Matrix() {
        matrix = null;
    }
    public Matrix(int rowNum, int colNum) {
        this.rowNum = rowNum;
        this.colNum = colNum;
        matrix = new int[rowNum][colNum];

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                matrix[i][j] = 0;
            }
        }
    }
    /**/
}

class MatrixWithNames extends Matrix {
    StringArray rowNames;
    StringArray colNames;

    MatrixWithNames(int rowNum, int colNum, StringArray rowArr, StringArray colArr) {
        super(rowNum, colNum);
        this.rowNames = rowArr;
        this.colNames = colArr;
    }

    void readDataFromConsole() {

        for (int i = 0; i < colNum; i++) { 
            for (int j = 0; j < rowNum; j++) {
                System.out.print(rowNames.getIndex(j) + "\'s " 
                                    + colNames.getIndex(i) + "? = ");
                matrix[j][i] = Integer.parseInt(System.console().readLine());
            }
        }

    }
    @Override
    public String toString() {
        String temp = "";

        for (int i = 0; i < colNum; i++) {
            temp += "===" + colNames.getIndex(i) + " list===" +"\n";
            for (int j = 0; j < rowNum; j++) {
                temp += "[" + j + "]" + rowNames.getIndex(j) + " " + matrix[j][i] + "\n";
            }
        }

        return temp;
    }
}

class StringArray {
    String[] arr;

    StringArray(int n) {
        arr = new String[n];
    }
    String getIndex(int i) {
        return arr[i];
    }
    void setIndex(int i, String s) {
        arr[i] = s;
    }
    void readDataFromConsole() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("please input String [number " + (i+1) + "] = ");
            arr[i] = System.console().readLine();
        }
    }
}

class TestDriver {
    public static void main(String[] args) {

        int rowNum;
        int colNum;
        StringArray rowNames;
        StringArray colNames;

        MatrixWithNames matrix;

        /* set a row */
        System.out.print("what number of product? ");
        rowNum = Integer.parseInt(System.console().readLine());
        rowNames = new StringArray(rowNum);

        System.out.println("what name of product? ");
        rowNames.readDataFromConsole();

        /* set a col */
        System.out.print("what number of list? ");
        colNum = Integer.parseInt(System.console().readLine());
        colNames = new StringArray(colNum);

        System.out.println("what name of list? ");
        colNames.readDataFromConsole();

        /* set a matrix */
        System.out.println("input your value");
        matrix = new MatrixWithNames(rowNum, colNum, rowNames, colNames);
        matrix.readDataFromConsole();

        /* print */
        System.out.println(matrix.toString());
    }
}
