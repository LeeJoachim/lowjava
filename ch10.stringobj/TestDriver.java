package ch10.stringobj;

/* String object */

/* c language syntax */
/* char x[10];
 * strcpy(x, "lee");
 * 'l','e','e','\0'
 * '\0' end of String (null caracter) don't use
 */

/* in java */
/* dynamic allocation
 * not over flow
 * can assignment e.g. a = "hello"; , "hello" + "world"; // strcat()
 * read only i.e. mallocate and garbage
 * structure form
 */              
class TestDriver {
    public static void main(String[] args) {

        String a; // String 객체를 가리키는 reference
        String b; // Pointer is pointing String object in heap area

        /* String object has data members 
         * e.g. [byte[] value][byte coder][int hash][boolean hashZero] 
         */
        /* byte[] value is pointer variable == reference */
        a = new String("hello"); // origin form
        // a = "hello"; // boxing // a -> String's *value -> [length : 5][h][e][l][l][o]
        b = "lee";
        System.out.println(a + b);

        System.out.println("Hello World!"); // string constant
    }
}