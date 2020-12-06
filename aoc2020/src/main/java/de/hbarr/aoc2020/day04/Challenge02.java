package de.hbarr.aoc2020.day04;

import de.hbarr.aoc2020.Challenge;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;

public class Challenge02 implements Challenge {

    private final Pattern hclPattern = Pattern.compile("#[0-9,a-f]{6}");
    private final Pattern pidPattern = Pattern.compile("\\d{9}");
    private final Collection<String> eyeColors = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
    private final Map<String, Function<String, Boolean>> requiredFields = Map.of(
            "byr", s -> isBetweenIncluding(s, 1920, 2002)
            , "iyr", s -> isBetweenIncluding(s, 2010, 2020)
            , "eyr", s -> isBetweenIncluding(s, 2020, 2030)
            , "hgt", s -> {
                if (s.endsWith("cm")) {
                    return isBetweenIncluding(s.replace("cm", ""), 150, 193);
                } else if (s.endsWith("in")) {
                    return isBetweenIncluding(s.replace("in", ""), 59, 76);
                } else {
                    return false;
                }

            }
            , "hcl", s -> hclPattern.matcher(s).matches()
            , "ecl", eyeColors::contains
            , "pid", s -> pidPattern.matcher(s).matches()
    );


    @Override
    public String run(List<String> data) {
        return String.valueOf(
                inlinePassportData(data).stream().filter(line -> {
                            List<String> checkedKeys = new ArrayList<>();
                            for (String pair : line.split(" ")) {
                                String key = pair.split(":")[0];
                                String value = pair.split(":")[1];
                                if (!requiredFields.getOrDefault(key, s -> true).apply(value)) {
                                    return false;
                                }
                                checkedKeys.add(key);
                            }
                            return checkedKeys.containsAll(requiredFields.keySet());
                        }
                )
                        .count());
    }

    public static List<String> inlinePassportData(List<String> input) {
        List<String> inlined = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (String line : input) {
            if (!line.isEmpty()) {
                builder.append(line).append(" ");
            } else {
                inlined.add(builder.toString());
                builder.setLength(0);
            }
        }
        inlined.add(builder.toString());
        return inlined;
    }

    private static Boolean isBetweenIncluding(String number, int min, int max) {
        return Integer.parseInt(number) >= min && Integer.parseInt(number) <= max;
    }
}
