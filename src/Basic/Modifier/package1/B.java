package Basic.Modifier.package1;

public class B {
    public static void main(String[] args) {
        A a = new A();
        a.func1();
        a.func2(); //同一个包内, protected不需要继承也能通过实例访问
    }
}
