package basic.innerinterface;

public class Test {
    public static void main(String[] args) {
        OuterImpl outer = new OuterImpl();
        InnerImpl inner = new InnerImpl();
        outer.outerMethod(); //都能正常运行, 类似于静态内部类, 是两个完全独立的接口
        inner.innerMethod();
    }
}
