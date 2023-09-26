package AbsInnerClass;

import java.io.IOException;

import static AbsInnerClass.NyPizza.Size.SMALL;
import static AbsInnerClass.Pizza.Topping.*;

public class Main {

    public String name;

    public static void main(String[] args) throws IOException {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();
        Object o = new Object();

    }
}

