package discussion04;

/**
 * @auther Zhang Yubin
 * @date 2022/1/4 23:40
 */
public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
        this.noise = "Meow!";
    }

    @Override
    public void greet() {
        System.out.println("Cat " + name + " says: " + makeNoise());
    }
}
