package ch11.twodimension.objoriented;

class Matrix {

    int[][] matrix;
    
    int row;
    int col;

    Matrix(int row, int col) {

        this.row = row;
        this.col = col;
        matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    // void add(Matrix m) {

    //     int[][] temp = m.matrix;

    //     for (int i = 0; i < row; i++) {
    //         for (int j = 0; j < col; j++) {
    //             matrix[i][j] += temp[i][j];
    //         }
    //     }
    // }

    Matrix add(Matrix m) {

        /* defensive */
        if (m.row != this.row || m.col != this.col) {
            System.err.println("err");
            System.exit(-1);
        }
        /**/

        Matrix temp = new Matrix(m.row, m.col);

        for (int i = 0; i < m.row; i++) {
            for (int j = 0; j < m.col; j++) {
                temp.matrix[i][j] = this.matrix[i][j] + m.matrix[i][j];
            }
        }

        return temp;
    }

    void readDataFromConsole() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                System.out.println("row : [" + i + "] col : [" + j + "]");
                this.matrix[i][j] = Integer.parseInt(System.console().readLine());
            }
        }
    }

    void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
    }
    
}

class TestDriver {
    public static void main(String[] args) {
        
        Matrix a = new Matrix(2, 2);
        Matrix b = new Matrix(2, 2);
        Matrix c = new Matrix(2, 2);

        a.readDataFromConsole();
        b.readDataFromConsole();

        // a.add(b);
        c = a.add(b);

        c.print();


    }    
}
