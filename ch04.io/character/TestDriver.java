package ch04.io.character;

import java.io.IOException;
import java.io.InputStreamReader;

public class TestDriver {
    public static void main(String[] args) {
        System.out.println("Type characters and <Enter> key:");
        InputStreamReader in = new InputStreamReader(System.in);
        while (true) {
            try {
                char c = (char)in.read();
                if (c == '\n') break; // if press <Enter> break!
                System.out.print(c);
            } catch (IOException e) { // IOException
                // TODO: handle exception
            }
        }
        System.out.println();
    }
}