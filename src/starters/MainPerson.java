package starters;

import entity.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainPerson {
    public static void main(String[] args) {

            Person person = new Person();
            person.setFamily("Ушаков");
            person.setName("Виталий");

            int[] myInt = new int[]{2,5,6,77,11223,34,8768,3463,345,3,54,45,3,2,65,4};
            List<Integer> collect = Arrays.stream(myInt)
                    .filter(elem -> elem > 10)
                    .sorted()
                    .collect(
                            ArrayList::new,
                            ArrayList::add,
                            ArrayList::addAll
                    );
            System.out.println(collect);
            System.out.println(person);

    }

}
