package de.hbarr.aoc2020;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Runner {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = Runner.class.getClassLoader();
        Map<String, String> challenges = Map.of(
    //          "de.hbarr.aoc2020.day01.Challenge01",
    //          "data01.txt",

    //          "de.hbarr.aoc2020.day01.Challenge02",
    //          "data01.txt",

    //          "de.hbarr.aoc2020.day02.Challenge01",
    //          "data02.txt",

    //          "de.hbarr.aoc2020.day02.Challenge02",
    //          "data02.txt",

              //"de.hbarr.aoc2020.day03.Challenge01",
             //"data03.txt"

                "de.hbarr.aoc2020.day03.Challenge02",
                "data03.txt"

        );

        Loader loader = new Loader();
        challenges.forEach(
                (clazz, file) -> {
                    System.out.println("running " + clazz);
                    System.out.println(instantiate(clazz, Challenge.class).run(loader.dataContent(file)));
                }
        );
    }

    public static <T> T instantiate(final String className, final Class<T> type) {
        try {
            return type.cast(Class.forName(className).newInstance());
        } catch (InstantiationException
                | IllegalAccessException
                | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }
}
