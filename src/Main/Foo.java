package Main;

import java.util.Comparator;

import static java.util.Comparator.comparingInt;

public class Foo {

    // Comparable with comparator construction methods
    private static final Comparator<Foo> COMPARATOR = comparingInt((Foo pn) -> pn.a)
            .thenComparingInt(pn -> pn.b)
            .thenComparingInt(pn -> pn.c);
    private int a;
    private int b;
    private int c;

    public static void main(String[] args) {
        Bar bar = null;
        System.out.println(bar.equals(""));
    }

    public int compareTo(Foo pn) {
        return COMPARATOR.compare(this, pn);
    }
}
