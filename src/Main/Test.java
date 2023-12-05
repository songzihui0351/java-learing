package Main;

interface A {
    int a = 1;
}

class Test<E> {
    public static void main(String[] args) throws Error {
        Class<?> subclass = Test.class.asSubclass(Object.class);
    }

    public static <T extends A> void test() {
        System.out.println(T.a);
    }
}