package ch04.io.tokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * type is transformed
 * <p>
 * used StringTokenizer in java library. it tokenize String to Tokens
 */
public class TestDriver {
    public static void main(String[] args) {

        char c;
        int i;
        double f;
        String s;

        System.out.println("Four Tokens Types Transform to a char, an int, a double, and a string : ");

        String buffer = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            buffer = in.readLine();
        } catch (IOException e) {
            // TODO: handle exception
        }

        StringTokenizer st = new StringTokenizer(buffer); // Tokenizing
        String temp;

        /* first str token to char */
        temp = st.nextToken(); 
        c = temp.charAt(0);

        /* second str token to Integer */
        temp = st.nextToken(); 
        i = Integer.parseInt(temp);

        /* third str token to Double */
        temp = st.nextToken(); 
        f = Double.parseDouble(temp);

        /* forth str token to str */
        temp = st.nextToken(); 
        s = temp;

        System.out.println("c = " + c);
		System.out.println("i = " + i);
		System.out.println("f = " + f);
		System.out.println("s = " + s);

    }
}
