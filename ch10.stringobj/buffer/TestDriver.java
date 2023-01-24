package ch10.stringobj.buffer;

/* String's mechanism : byte[], read only */
/* if String obj is a lot of change, this is a burden */

/* StringBuffer's mechanism : not read only */
/* allocate enough byte[] like C language */

public class TestDriver {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("Hello World!");

        /* this is his mechanism!, not assignment but original obj is changed */
        sb.reverse();
        /**/

        System.out.println(sb);
        
        sb.setCharAt(3, 'x');
        System.out.println(sb);
    }
}