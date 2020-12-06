package de.hbarr.aoc2020.day01;

import de.hbarr.aoc2020.Challenge;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge02 implements Challenge {
    /**
     * Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.
     */
    public String run(List<String> data) {
        try {
            List<Integer> numbers = data.stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
            for (int i = 0; i < numbers.size(); i++) {
                for (int ii = i + 1; ii < numbers.size(); ii++) {
                    for (int iii = ii + 1; iii < numbers.size(); iii++) {
                        if (numbers.get(i) + numbers.get(ii) + numbers.get(iii) == 2020) {
                            return String.valueOf(numbers.get(i) * numbers.get(ii) * numbers.get(iii));
                        }
                    }
                }
            }
        } catch (Exception ex) {

        }
        return null;
    }
}