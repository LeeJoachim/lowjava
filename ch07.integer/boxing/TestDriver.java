package ch07.integer.boxing;

/* pseudo && logical code : int *p = new int;
 * 
 * cf. real C code is 'mallocate'
 * 
 * in java you can't talk 'new int;' : syntax err
 * but want to use this mechanism
 */

class TestDriver {
    public static void main(String[] args) {

        /* boxing example */
        Integer x = 10; // 1024; -> new Integer(1024);
        x = 20; // new...
        x = 30; // mallocate...
        /**/

        /* unboxing */
        /* this syntax err is changed to 'not err' */
        int a = x; // heap area's int val assign to int a, not address val
        /**/
        
        System.out.println(a);   
    }
}