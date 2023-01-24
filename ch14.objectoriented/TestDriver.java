package ch14.objectoriented;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Animal {
    String name;

    /* abstract function for notify specification */
    abstract void eat();
    void sleep() {
        System.out.println("all animals sleep aren't they?");
    }
    abstract void urinate();
    abstract void talk();

    public void setName(String name) {
        this.name = name;
    }

}

class Lion extends Animal {

    void eat() {
        System.out.println("Lion: eat");
    }
    @Override
    void sleep() {
        System.out.println("Lion: sleep");
    }
    void urinate() {
        System.out.println("Lion: urinate");
    }
    void talk() {
        System.out.println("Lion: talk");
    }
    @Override
    public String toString() {
        return "Lion [name=" + name + "]";
    }    
}

class Rabbit extends Animal {

    void eat() {
        System.out.println("Rabbit: eat");
    }
    @Override
    void sleep() {
        System.out.println("Rabbit: sleep");
    }
    void urinate() {
        System.out.println("Rabbit: urinate");
    }
    void talk() {
        System.out.println("Rabbit: talk");
    }
    @Override
    public String toString() {
        return "Rabbit [name=" + name + "]";
    }    
}

class Monkey extends Animal {

    void eat() {
        System.out.println("Monkey: eat");
    }
    void urinate() {
        System.out.println("Monkey: urinate");
    }
    void talk() {
        System.out.println("Monkey: talk");
    }
    @Override
    public String toString() {
        return "Monkey [name=" + name + "]";
    }
    
}


class TestDriver {
    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);
        ArrayList<Animal> animals = new ArrayList<Animal>();

        for (int i = 0; i < 2; i++) {
            System.out.print("please input number : ");
            String s = scan.next();
            n = Integer.parseInt(s);
  
            Animal x = null;
            /* need to if syntax */
            if (n == 1) {
                x = new Lion();
                System.out.print("Lion name : ");
            } else if (n == 2) {
                x = new Rabbit();
                System.out.print("Rabbit name : ");
            } else if (n == 3) {
                x = new Monkey();
                System.out.print("Monkey name : ");
            }

            animals.add(x);
            s = scan.next();
            x.setName(s);
        }

        for (int day = 0; day < 10; day++) {

            // for (int i = 0; i < 2; i++) {
            // Animal x = animals.get(i);
            for (Animal x : animals) {
                
            /* dynamic binding */
            x.eat();
            x.sleep();
            x.urinate();
            x.talk();
            }
        }

    scan.close();

    }
}
