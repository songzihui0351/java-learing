package Basic.InnerClass;

//static nested classes
//和外部类完全无关, 完全可以独立存在, 只是借用外部类的壳来隐藏自己
//所以new出来的两个对象不相同, 和static无关
public class Outer {
    public static class Inner {
    }
}
