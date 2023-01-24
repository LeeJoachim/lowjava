package ch10.stringobj.labrary;

/* how to use String obj in library */

class TestDriver {
    public static void main(String[] args) {
        
        String xx = "anne";
        String xy = new String("joachim");
        String temp = "";

        xx += " " + xy; // Existing object 'x' becomes garbage


        System.out.println("xx = " + xx);
        System.out.println("xx.length() = " + xx.length());
        System.out.println("xx.charAt(1) = " + xx.charAt(1));


        temp += 123;
        System.out.println("temp = " + temp + "\n");

        
        /* do not == sign when compare two String obj */
        /* x and y what is bigger? */
        System.out.println("[start compare to]");
        System.out.println("what is bigger?");
        
        if (xy.compareTo("U anne") > 0) {
            System.out.println(xy);
        } else if (xy.compareTo("U anne") < 0) {
            System.out.println("U anne");
        } else { 
            System.out.println("same");
        }

        /* ignore uppercase lowercase */
        System.out.println("[start compare to]");
        System.out.println("what is bigger? - ignore case");

        if (xy.compareToIgnoreCase("U Anne") > 0) {
            System.out.println(xy);
        } else if (xy.compareToIgnoreCase("U Anne") < 0) {
            System.out.println("U Anne");
        } else { 
            System.out.println("same");
        }
        /**/

        
        /* [start contains] */
        System.out.println("");
        System.out.println("[start contians]");
        System.out.println("do you have joachim?");
        if (xx.contains("joachim")) {
            System.out.println("i love him");
        } else {
            System.out.println("no love");
        }
        /**/
        
        /* [start equals] */
        System.out.println("");
        System.out.println("is equal?");
        if (xy.equals("joachim")) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
        /**/

        /* [end with?] */
        System.out.println("");
        System.out.println("end with .java?");
        temp = "test.java";
        if (temp.endsWith(".java")) {
            System.out.println("Yes Jave");
        } else {
            System.out.println("No java");
        }
        /**/

        /* formatting */
        int num = 123;
        double b = 16.555;

        String result = String.format("%5d\n%7.2f", num, b);
        System.out.println(result);

        /* replace */
        /* original obj is not changed. be cut and goes to garbage */
        result = result.replace('1', '6');
        System.out.println(result);

        /* split */
        temp = "hello world!";
        String[] s = temp.split(" ");
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }

        /* substring */
        temp = temp.substring(3, 5);
        System.out.println(temp);

        /* trim */
        String x = new String("   h e l l o   ");
        x = x.trim();
        System.out.println(x);
    }
}