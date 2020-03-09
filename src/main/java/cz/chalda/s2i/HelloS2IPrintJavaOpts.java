package cz.chalda.s2i;

/**
 * Hello world!
 */
public class HelloS2IPrintJavaOpts {
    public static void main(String[] args) {
        System.out.println("Hello S2I printing JAVA_OPTS!");
        System.out.println("JAVA_OPTS are : " + System.getenv("JAVA_OPTS"));
    }
}
