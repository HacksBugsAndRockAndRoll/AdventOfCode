package de.hbarr.aoc2020;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<String> daysToRun = Arrays.asList("08");

        Loader loader = new Loader();
        daysToRun.forEach(
                day -> {
                    for (int i = 1; i <= 2; i++) {
                        String clazz = "de.hbarr.aoc2020.day" + day + ".Challenge0" + i;
                        String file = "data" + day + ".txt";
                        System.out.println("running " + clazz);
                        System.out.println(instantiate(clazz, Challenge.class).run(loader.dataContent(file)));
                    }
                });
    }

    public static <T> T instantiate(final String className, final Class<T> type) {
        try {
            return type.cast(Class.forName(className).getDeclaredConstructor().newInstance());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }
}
