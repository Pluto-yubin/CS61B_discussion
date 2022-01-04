package discussion04;

/**
 * @auther Zhang Yubin
 * @date 2022/1/4 23:43
 */
public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
        noise = "Woof!";
    }

    @Override
    public void greet() {
        System.out.println("Dog " + name + " says: " + makeNoise());
    }

    public void playFetch() {
        System.out.println("Fetch, " + name + "!");
    }


}
