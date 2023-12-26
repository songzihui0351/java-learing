package basic.innerclass;

public class Test {
    public static void main(String[] args) {
        Outer.Inner inner1 = new Outer.Inner();
        Outer.Inner inner2 = new Outer.Inner();
        System.out.println(inner1.equals(inner2)); //false
    }
}
