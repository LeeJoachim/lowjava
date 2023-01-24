package ch04.io.buffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * unix command echo
 * <p>
 * problems : type is String
 */

public class TestDriver {
    public static void main(String[] args) {
        String buffer;

        System.out.println("Type String in a line <Enter> key:");
        System.out.println("An empty line stops this program");

        BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                            System.in));

        while(true) {
            try {
                buffer = in.readLine();
                if (buffer.length() == 0) break; // if meet emptyline
                System.out.println(buffer);
            } catch (IOException e) {
                // TODO: handle exception
            }
        }
        System.out.println("End!");
    }
}
