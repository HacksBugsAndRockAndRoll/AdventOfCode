package de.hbarr.aoc2020.day05;

import de.hbarr.aoc2020.Challenge;

import java.util.List;
import java.util.stream.Collectors;

public class Challenge02 implements Challenge {

    @Override
    public String run(List<String> data) {
        var seats = data
                .stream()
                .filter(nbr -> !nbr.startsWith("BBBBBB") && !nbr.startsWith("FFFFFFF"))
                .map(nbr -> {
                    var row = Integer.parseInt(nbr.substring(0, 7).replace("B", "1").replace("F", "0"), 2);
                    var col = Integer.parseInt(nbr.substring(7, 10).replace("R", "1").replace("L", "0"), 2);
                    return row * 8 + col;
                })
                .sorted()
                .collect(Collectors.toList());
        return String.valueOf(findSeat(seats));
    }

    private int findSeat(List<Integer> seats) {
        for (int i = 0; i < seats.size() - 1; i++) {
            if (seats.get(i + 1) - seats.get(i) == 2) {
                return seats.get(i) + 1;
            }
        }
        return -1;
    }
}
