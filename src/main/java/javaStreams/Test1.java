package javaStreams;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {

        //Count the number of names starting with alphabet A in list
        @Test
        public void regular() {
            ArrayList<String> names = new ArrayList<>();
            names.add("Anne");
            names.add("Dom");
            names.add("Aleka");
            names.add("Adam");
            names.add("Ram");
            int count = 0;

            for (int i = 0; i < names.size(); i++) {
                String actualName = names.get(i);
                if(actualName.startsWith("a") || actualName.startsWith("A")) {
                    count++;
                }
            }
            System.out.println(count);
        }

        @Test
        public void streamFilter() {
            List<String> names = new ArrayList<>();
            names.add("Anne");
            names.add("Dom");
            names.add("Aleka");
            names.add("Adam");
            names.add("Ram");

            //There is no life for intermediate op if there is no terminal op
            //terminal operation will execute only  if intermediary op (filter) returns true
            //We can create stream
            //how to use filter in Stream API

            Long total = names.stream().filter(s -> s.startsWith("A") || s.startsWith("a")).count();
            System.out.println(total);

            long d = Stream.of("Anne","Dom","Aleka","Adam","Ram").filter(t -> t.startsWith("A")).count();
            System.out.println(d);

            //print all the names of ArrayList
            //names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
            names.stream().filter(s -> s.length() > 4).forEach(System.out::println);
            names.stream().filter(s -> s.length() > 3).limit(1).forEach(System.out::println);
        }

        @Test
        public void streamMap() {
            ArrayList<String> names = new ArrayList<>();
            names.add("Dudu");
            names.add("Raquel");
            names.add("Ursus");

            //print names of last letter "a" with upercase
//            Stream.of("Anne","Dom","Aleka","Adam","Ram")
//                    .filter(s -> s.endsWith("a"))
//                    .map(String::toUpperCase)
//                    .forEach(System.out::println);

            //prints names which have first letter as a with uppercase and sorted

            List<String> names1 = Arrays.asList("Aznne","Dom","Aleka","Adam","Ram");
            names1.stream()
                    .filter(s -> s.startsWith("A"))
                    .sorted().map(String::toUpperCase)
                    .forEach(s -> System.out.println(s));

            Stream<String> newStrean = Stream.concat(names.stream(), names1.stream());
            newStrean.forEach(s -> System.out.println(s));

           boolean flag =  newStrean.anyMatch(s -> s.equalsIgnoreCase("Adam"));
            System.out.println(flag);
            Assert.assertTrue(flag);
        }

        @Test
    public void streamCollect() {
            //list -> new List

            List<String> list = Stream.of("Anne","Dom","Aleka","Adam","Ram")
                    .filter(s -> s.endsWith("a"))
                    .map(s -> s.toUpperCase())
                    .collect(Collectors.toList());
            System.out.println(list.get(0));

            List<Integer> numbers = Arrays.asList(3,2,2,7,5,1,9,7);
            //print unique numbers from this array
            //sort the array

            numbers.stream()
                    .distinct()
                    .sorted()
                    .forEach(s -> System.out.println(s));

            List<Integer> numbersOrdered = numbers.stream().distinct().sorted().collect(Collectors.toList());
            System.out.println(numbersOrdered.get(2));
        }
    }

