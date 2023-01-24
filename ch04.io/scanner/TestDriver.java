package ch04.io.scanner;

import java.util.Scanner; // SYNTAX C : include, C# : using

/**
 * String separated four tokens : lexical analysis(tokenizer)
 */
public class TestDriver {
    public static void main(String[] args) {
        char c;
        int i;
        double f;
        String s;

        System.out.println("Four tokens Type Transform to a char, an int, a double, and a string : ");

        Scanner scanner = new Scanner(System.in);

        /* character transformation */
        String temp;
        temp = scanner.next(); 
        c = temp.charAt(0); 

        /* int transformation */
        i = scanner.nextInt();

        /* double transformation */
        f = scanner.nextDouble();

        /* next */
        s = scanner.next();

        System.out.println("c = " + c);
		System.out.println("i = " + i);
		System.out.println("f = " + f);
		System.out.println("s = " + s);
    }
}
