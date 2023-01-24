package ch02.recursive.fibo;

class TestDriver {
    public static void main(String[] args) {
        
        for (int i = 0; i < 10; i++) {
            System.out.println("fibo(" + i + ") = " + fibo(i));
        }
    }
    
    static int fibo(int n) {
        
        if (n == 0) return 1;
        else if (n == 1) return 1;
        else if (n > 1) return fibo(n-2) + fibo(n-1);
        else {
            System.err.println("Unexpected minus argument.");
            System.exit(-1);
            return -1;
        }

    }
}