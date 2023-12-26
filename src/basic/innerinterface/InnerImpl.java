package basic.innerinterface;

public class InnerImpl implements Outer.Inner {
    @Override
    public void innerMethod() {
        System.out.println("Inner");
    }
}
