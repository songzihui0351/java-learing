package Basic.Clone;

import java.util.List;

//clone方法就是一个构造器, 你必须确保它不会伤害到原始的对象, 并确保正确地创建被克隆对象中的约束条件
//clone方法尽量不用, 而使用构造器或静态工厂来代替, 只有数组很适合clone
//Cloneable接口和Object接口一个包, Cloneable能使用protect方法, 而实现Cloneable也就继承了protect方法
//Object的clone方法不会clone属性, 只是添加引用,对于可变对象, 需要在super.clone后递归的对可变属性clone
public class Foo implements Cloneable {

    List<Integer> list;

    public Foo(Foo foo) {
        //构造器
    }

    public static Foo getInstance(Foo foo) {
        //静态工厂方法
        return null;
    }

    @Override
    public Foo clone() {
        try {
            return (Foo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Foo{" +
                "list=" + list +
                '}';
    }
}
