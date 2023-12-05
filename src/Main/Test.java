package Main;

import java.util.ArrayList;
import java.util.List;

interface A {
    int a = 1;
}

class Test<E> {
    public static void main(String[] args) throws Error {
        Class<?> subclass = Test.class.asSubclass(Object.class);
        List<?> list;
        ArrayList<Integer> list1 = new ArrayList<>();
        list = list1;
        list1.add(1);
        Object o = list.get(0);
    }

    public static <T extends A> void test() {
        System.out.println(T.a);
    }
}