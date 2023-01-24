package ch17.defineinterface;

/* Mind's Identity : just Mind */
interface Mind {

    void hate();
    void love();
}

/* Brain's Identity : Brain && Mind */
interface brain extends Mind {

    void understand();
    void calmdown();
}

class IAm implements brain {

    // @Override
    public void hate() {
        System.out.println("I hate you... but I love you forever and ever");
    }

    // @Override
    public void love() {
        System.out.println("I love you... but I always love you.");
    }

    // @Override
    public void understand() {
        System.out.println("i understand you");
    }    
}

abstract class Cosmos {

    void kineticEnergy() {

    }
}

class Earth extends Cosmos {

    void human() {

    }
}


class TestDriver {
    public static void main(String[] args) {
        /* if some obj is finds functions,
         * return type is blue-print at compiler
         * i.e. compiler will finds func for statement return type
         */
        brain i = new IAm(); // brain && mind
        i.hate();
        i.love();
        i.understand();

        System.out.println();

        Earth earth = new Earth();
        earth.kineticEnergy();
        earth.human();
    }
}
