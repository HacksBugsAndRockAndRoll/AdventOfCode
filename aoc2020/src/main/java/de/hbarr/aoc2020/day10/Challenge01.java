package de.hbarr.aoc2020.day10;

import de.hbarr.aoc2020.Challenge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Challenge01 implements Challenge {
    @Override
    public String run(List<String> data) {
        Integer outletJoltage = 0;
        List<Integer> sortedJoltages = Stream.concat(Stream.of(outletJoltage), data.stream().map(Integer::parseInt).sorted(Integer::compare)).collect(Collectors.toList());
        Integer deviceJoltage = sortedJoltages.get(sortedJoltages.size() - 1) + 3;
        sortedJoltages.add(deviceJoltage);
        int[] diffs = new int[]{0, 0, 0, 0};
        for (int i = 1; i < sortedJoltages.size(); i++) {
            diffs[sortedJoltages.get(i) - sortedJoltages.get(i - 1)]++;
        }
        return String.valueOf(diffs[1] * diffs[3]);
    }
}
