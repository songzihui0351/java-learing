package Basic.Generics;

public class HeapPollution {
    public static void main(String[] args) {
        Integer[] array1 = toArray1(1, 2); //ClassCastException
        Integer[] array2 = toArray2(1, 2);
    }

    @SuppressWarnings("unchecked")
    static <T> T[] toArray1(T... array) {
        return (T[]) new Object[array.length]; //新建Object[]再强转为T[], 结果还是Object[]
    }

    @SafeVarargs
    static <T> T[] toArray2(T... array) {
        System.out.println(array instanceof Integer[]); //true
        return array; //直接返回参数就是T[]
    }
}
