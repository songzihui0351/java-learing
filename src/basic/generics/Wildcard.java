package basic.generics;

import java.util.ArrayList;
import java.util.List;

public class Wildcard {
    @SuppressWarnings("ReassignedVariable")
    public static void wildcard() {
        List<?> list; //?的作用是可以接受任意类型的泛型
        list = new ArrayList<Integer>();
        list = new ArrayList<String>();
        list = new ArrayList<>();
    }

    @SuppressWarnings({"MismatchedQueryAndUpdateOfCollection", "DataFlowIssue"})
    public static void PECS() { //producer extends consumer super
        List<? extends Number> producer = new ArrayList<>(); //保证生产的元素一定是T(子类也是T)
        Number number = producer.get(0); //可以遍历获取元素
//        producer.add(1); //无法添加元素
        List<? super Integer> consumer = new ArrayList<>(); //保证元素一定可以添加到集合中(只有父类可以)
        consumer.add(1); //可以添加元素
        Object o = consumer.get(0); //获取的元素只能是Object
    }
}
