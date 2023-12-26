package basic.generics;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class GenericClass {
    public static void array() {
        Class<? extends Number[]> clazz1 = new Number[1].getClass(); //数组必须用通配符是因为可以协变, Integer[]也是Number[]
        Class<? extends Number[]> clazz2 = new Number[2].getClass();
        Class<Number[]> clazz = Number[].class;
        System.out.println(clazz1 == clazz2); //ture, 具有相同元素类型和维数的数组都共享同一个Class对象, 和长度无关
    }

    public static void list() {
        Class<? extends ArrayList> clazz1 = new ArrayList<Integer>().getClass();
        Class<? extends ArrayList> clazz2 = new ArrayList<String>().getClass();
        Class<? extends ArrayList> clazz = ArrayList.class;
        System.out.println(clazz1 == clazz2); //true, 由于泛型擦除, 集合都共享一个Class对象
    }
}
