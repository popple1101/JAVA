package test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test01 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.stream() // List 를 Stream 타입으로 변경하기
                .filter(name -> name.length() > 3)
                .forEach(s -> System.out.println(s));
    }
}
