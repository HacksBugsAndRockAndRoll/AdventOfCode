package de.hbarr.aoc2020.day05;

import de.hbarr.aoc2020.Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Challenge01 implements Challenge {

    @Override
    public String run(List<String> data) {
        return String.valueOf(data
                .stream()
                .mapToInt(nbr -> {
                            var row = Integer.parseInt(nbr.substring(0, 7).replaceAll("B", "1").replaceAll("F", "0"), 2);
                            var col = Integer.parseInt(nbr.substring(7, 10).replaceAll("R", "1").replaceAll("L", "0"), 2);
                            return row * 8 + col;
                        })
                .max().orElse(-1));
    }
}
