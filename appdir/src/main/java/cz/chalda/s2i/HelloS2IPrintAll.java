package cz.chalda.s2i;

/**
 * Hello world!
 */
public class HelloS2IPrintAll {
    public static void main(String[] args) {
        System.out.println("Hello S2I printing");
        System.out.println("Environmental Variables");
        System.getenv().forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));
    }
}
