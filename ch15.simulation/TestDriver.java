package ch15.simulation;

import java.util.ArrayList;
import java.util.Iterator;

/* the identity of customers */
abstract class Animal {

    String name;
    int weight;

    void drinksCoffee(int amount) {
        System.out.println(name + " drinks Coffee : " + amount);
        weight += 10*amount;
    }

    int howManyDoYouWant() { return (int)(Math.random()*10%3); }

    @Override
    public String toString() {
        String weight = Integer.toString(this.weight);
        return "[name : " + name + "] [weight : " + weight + "]";
    }
}
class Cat extends Animal {

    Cat(String name) {
        this.name = name;
        weight = 200;
    }

}
class Dog extends Animal {

    Dog(String name) {
        this.name = name;
        weight = 300;
    }
}
class Rabbit extends Animal {

    Rabbit(String name) {
        this.name = name;
        weight = 100;
    }
}
/**/

class CoffeeShop {
    Table table;
    Servant servant;

    CoffeeShop() {
        table = new Table();
        servant = new Servant(table);
    }
    void join(Animal a) {
        table.join(a);
    }
    void run() {
        for (int i = 0; i < 10; i++) {
            table.servedBy(servant);
        }
    }
    void print() {
        servant.print();
    }
}
class Table {
    ArrayList<Animal> animals;

    Table() {
        animals = new ArrayList<Animal>();
    }
    void join(Animal a) {
        animals.add(a);
    }
    int getSize() {
        return animals.size();
    }
    ArrayList<Animal> getAnimals() {
        return animals;
    }
    void servedBy(Servant servant) {
        /*
        Iterator<Animal> iter = animals.iterator();
        while (iter.hasNext()) {
            Animal e = iter.next();
            int amount = servant.askAmountToServe(e);
            e.drinksCoffee(amount);
        }
        */
        for (Animal e : animals) {
            int amount = servant.askAmountToServe(e);
            e.drinksCoffee(amount);
        }
    }
}
class Servant {
    ArrayList<Animal> animals;
    Table table;

    Servant(Table table) {
        this.table = table;
        animals = table.getAnimals();
    }
    int askAmountToServe(Animal e) {
        return e.howManyDoYouWant();
    }
    void print() {
        System.out.println("\n======[COFFEE SHOP'S]======");
        System.out.println("number of customers : " + table.getSize());
        System.out.println("\n====customers attributes====");
        /* for each vs iterator */
        for (Animal e : animals) {
            System.out.println(e);
        }
    }
}


class TestDriver {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop();
        Animal cat = new Cat("catty");
        Animal dog = new Dog("doggy");
        Animal rabbit = new Rabbit("rabbie");

        coffeeShop.join(cat);
        coffeeShop.join(dog);
        coffeeShop.join(rabbit);

        coffeeShop.run();
        coffeeShop.print();
    }
}