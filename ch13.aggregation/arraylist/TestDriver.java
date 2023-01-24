package ch13.aggregation.arraylist;
import java.util.ArrayList;
import java.util.Iterator;

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
                System.out.print(rowNames.get(j) + "\'s " 
                                    + colNames.get(i) + "? = ");
                matrix[j][i] = Integer.parseInt(System.console().readLine());
            }
        }

    }
    @Override
    public String toString() {
        String temp = "";

        for (int i = 0; i < colNum; i++) {
            temp += "===" + colNames.get(i) + " list===" +"\n";
            for (int j = 0; j < rowNum; j++) {
                temp += "[" + j + "]" + rowNames.get(j) + " " + matrix[j][i] + "\n";
            }
        }

        return temp;
    }
}

class StringArray extends ArrayList<String> {
    // String[] arr;

    StringArray(int n) {
        super();
        for (int i = 0; i < n; i++) {
            add(null);
        }
        // arr = new String[n];
    }

    StringArray(StringArray sa) {
        Iterator<String> iterator = sa.iterator();
        while(iterator.hasNext()) {
            add(iterator.next());
        }
    }
    
    void readDataFromConsole() {
        for (int i = 0; i < size(); i++) {
            System.out.print("please input String [number " + (i+1) + "] = ");
            String buffer = System.console().readLine();
            set(i, buffer);
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
