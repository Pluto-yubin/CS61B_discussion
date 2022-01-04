package discussion04;

/**
 * @auther Zhang Yubin
 * @date 2022/1/4 23:45
 */
public class TestAnimals {
    /**
     * 2.1 Assume that Animal and Cat are defined as above. What would Java print on each
     * of the indicated lines?
     * @param args
     */
    public static void main(String[] args) {
        Animal a = new Animal("Pluto", 10);
        Cat c = new Cat("Garfield", 6);
        Dog d = new Dog("Fido", 4);
        a.greet(); // (A) Animal Pluto says: Huh?
        c.greet(); // (B) Cat Garfield says: Meow!
        d.greet(); // (C) Dog Fido says: WOOF!
        a = c;
        ((Cat) a).greet(); // (D) Cat Garfield says: Meow!
        a.greet(); // (E) Cat Garfield says: Meow!
        /**
         * Consider what would happen if we added the following to the bottom of main under
         * line 12:
         * 1 a = new Dog("Spot", 10);
         * 2 d = a;
         * Why would this code produce a compiler error? How could we fix this error?
         */
        a = new Dog("Spot", 10);
        // d = a;
        /**
         * Compile Error happened in line 31 because the static type of a is Animal, if you evaluate a to d, you are trying
         * to make the pointer of dog point to its super class, and in Java it's not allowed.
         */
    }


}
