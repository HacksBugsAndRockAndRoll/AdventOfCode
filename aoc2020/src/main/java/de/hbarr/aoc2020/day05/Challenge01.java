package de.hbarr.aoc2020.day05;

import de.hbarr.aoc2020.Challenge;

import java.util.List;

public class Challenge01 implements Challenge {

    @Override
    public String run(List<String> data) {
        return String.valueOf(data
                .stream()
                .mapToInt(nbr -> {
                            var row = Integer.parseInt(nbr.substring(0, 7).replace("B", "1").replace("F", "0"), 2);
                            var col = Integer.parseInt(nbr.substring(7, 10).replace("R", "1").replace("L", "0"), 2);
                            return row * 8 + col;
                        })
                .max().orElse(-1));
    }
}
