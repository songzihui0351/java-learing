package Basic.Enum;

import java.lang.reflect.Field;

public enum Gender {
    MALE, FEMALE; //public static final

    public static void main(String[] args) {
        Class<? extends Gender> genderClass = Gender.class;
        for (Field field : genderClass.getFields()) {
            System.out.println(field);
        }
    }
}

