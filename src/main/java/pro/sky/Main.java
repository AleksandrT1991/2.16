package pro.sky;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IntegerList Integer = new IntegerListImpl();
        Integer.add(1);
        Integer.add(2);
        Integer.add(3);
        Integer.add(4);
        Integer.add(1, 6);
        System.out.println(Arrays.toString(Integer.toArray()));
        Integer.clear();
        System.out.println(Integer.size());


    }
}
