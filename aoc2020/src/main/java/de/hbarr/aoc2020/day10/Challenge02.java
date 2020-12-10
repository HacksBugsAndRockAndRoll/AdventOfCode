package de.hbarr.aoc2020.day10;

import de.hbarr.aoc2020.Challenge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Challenge02 implements Challenge {
    @Override
    public String run(List<String> data) {
        List<Integer> sortedJoltages =data.stream().map(Integer::parseInt).sorted(Integer::compare).collect(Collectors.toList());
        Integer deviceJoltage = sortedJoltages.get(sortedJoltages.size() - 1) + 3;
        sortedJoltages.add(deviceJoltage);
        long[] combos = LongStream.concat(LongStream.of(1),LongStream.generate(() -> 0).limit(deviceJoltage.longValue())).toArray();
        for (int joltage : sortedJoltages) {
            long n1 = 0;
            long n2 = 0;
            long n3 = 0;
            if (joltage - 1 >= 0) {
                n1 = combos[joltage - 1];
                if (joltage - 2 >= 0) {
                    n2 = combos[joltage - 2];
                    if (joltage - 3 >= 0) {
                        n3 = combos[joltage - 3];
                    }
                }
            }
            combos[joltage] = n1 + n2 + n3;
        }
        return String.valueOf(combos[deviceJoltage]);
    }
}
