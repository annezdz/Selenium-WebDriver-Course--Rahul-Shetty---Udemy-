package CoreJava;

public class MethodsDemo {
    public static void main(String[] args) {

        MethodsDemo d = new MethodsDemo();
        System.out.println(d.getData());
        System.out.println("Static");
        System.out.println(getData1());
        getData1();
    }

    public String getData() {
        System.out.println("Hello world!");
        return "Anne";
    }

    public static String getData1() {
        System.out.println("Hello static!");
        return "Anne static";
    }
}
