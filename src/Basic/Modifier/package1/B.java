package Basic.Modifier.package1;

public class B {
    public static void main(String[] args) {
        A a = new A();
        a.func1();
        a.func2(); //同一个包内, protected不需要继承也能通过实例访问
        A.publicFunc();
        //A.privateFunc(); static和private不冲突, 可以有静态私有方法, 调用范围也同样符合private的范围(类内部)
    }
}
