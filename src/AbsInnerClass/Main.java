package AbsInnerClass;

import static AbsInnerClass.NyPizza.Size.SMALL;
import static AbsInnerClass.Pizza.Topping.*;

public class Main {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();

        int[] ints = new int[5];

    }
}