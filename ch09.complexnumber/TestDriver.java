package ch09.complexnumber;

class ComplexNumber {

    double real;
    double imaginary;

    ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /* member function style */
    /* is recommended it! that obj oriented style */
    ComplexNumber add(ComplexNumber num) {
        /* "this algorithm return void"

        this.real += num.getReal();
        this.imaginary += num.getImaginary();
        */

        return new ComplexNumber(this.real + num.getReal(), this.imaginary + num.getImaginary());
    }

    /* static member function style : C style */
    /* this is C language style and You had better not use this */
    /* It is not bound to a specific object */
    /* It is global function and not have 'this' reserved word */
    /* you can't use reserved word 'this' */
    static ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.real + b.real, a.imaginary + b.imaginary);
    }
    /**/

    public double getReal() {
        return real;
    }
    public double getImaginary() {
        return imaginary;
    }

    @Override
    public String toString() {
        return "ComplexNumber [real=" + real + ", imaginary=" + imaginary + "i]";
    }
    
    
}

public class TestDriver {
    public static void main(String[] args) {
        
        ComplexNumber a = new ComplexNumber(1.2, 1.5);
        ComplexNumber b = new ComplexNumber(2.1, 3.2);
        ComplexNumber c;
        ComplexNumber d;

        /* function calls equals message sending */
        /* Syntax similar to natural language is recommended */

        /* call virtual machine or compiler or OS */
        c = ComplexNumber.add(a, b); // is not recommended it!
        /**/

        /* call object a's function add */
        d = a.add(b); // more meaningful and tell this 'message sending'
        /**/

        /**/

        System.out.println(c);
        System.out.println(d);
    }    
}
