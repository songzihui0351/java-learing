package Basic.InnerInterface;

public class InnerImpl implements Outer.Inner {
    @Override
    public void innerMethod() {
        System.out.println("Inner");
    }
}
