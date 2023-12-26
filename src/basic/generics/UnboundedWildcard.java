package basic.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressWarnings({"unchecked", "rawtypes"})
public class UnboundedWildcard<E> {
    List raw = new ArrayList(); //不要使用raw类型
    List<?> unbounded = new ArrayList<>(); //因为泛型擦除, 不知道具体类型, 所以不能添加, 但是可以指向任何类型的引用
    List<Object> objectList = new ArrayList<>(); //集合没有协变
    List<E> list = new ArrayList<>();


    private void covariant(Collection<E> collection) {
    }

    private void rawTest() {
        raw.add(1);
        raw.add("1");
        Object o = raw.get(0);
        raw = unbounded;
        raw = objectList;
        covariant(raw);
    }

    private void unboundedTest() {
//        unbounded.add(1); 无法添加, 因为无法确定类型
        Object o = unbounded.get(0);
        unbounded = raw;
        unbounded = objectList;
//        covariant(unbounded); 无界通配符实参只能传递给参数为无界通配符的方法 - Collection<?> collection
    }

    private void objectListTest() {
        objectList.add(1);
        objectList.add("1");
        objectList = raw;
        //objectList = list; 集合没有协变
//        covariant(objectList); 集合没有协变
    }

    private void listTest() {
        list = raw;
//        list = unbounded;
//        list = objectList;
        covariant(list);
    }
}
