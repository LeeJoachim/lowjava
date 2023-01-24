package ch17.defineinterface.stack;

abstract class StackItem {
    StackItem next;

    void setNext(StackItem top) {
        next = top;
    }
    public StackItem getNext() {
        return next;
    }
}

class IntItem extends StackItem {
    int data;
    IntItem(int num) {
        data = num;
    }
    @Override
    public String toString() {
        return "IntItem [data=" + data + "]";
    }   
}
class StringItem extends StackItem {
    String data;
    StringItem(String str) {
        data = str;
    }
    @Override
    public String toString() {
        return "StringItem [data=" + data + "]";
    }
}

class Stack {
    StackItem top;

    void push(StackItem item) {
        if (top == null) top = item;
        else item.setNext(top); top = item;
    }
    StackItem pop() {
        if (top == null) {
            System.err.println("stack is empty"); System.exit(-1);
        }
        StackItem temp = top;
        top = top.getNext();
        return temp;
    }
    void print() {
        System.out.println("==== This stack has ====");
        StackItem temp = top;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}

class TestDriver {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(new IntItem(10));
        stack.push(new IntItem(20));
        stack.push(new IntItem(30));
        stack.push(new StringItem("a"));
        stack.push(new StringItem("b"));
        stack.push(new StringItem("c"));

        stack.print();
    }
}
