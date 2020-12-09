package de.hbarr.aoc2020.day09;

import de.hbarr.aoc2020.Challenge;

import java.util.List;
import java.util.stream.Collectors;

public class Challenge02 implements Challenge {

    int preambleSize = 25;

    @Override
    public String run(List<String> data) {

        Challenge01 c01 = new Challenge01();
        c01.preambleSize = preambleSize;
        Long lastResult = Long.parseLong(c01.run(data));

        for (int i = 0; i < data.size(); i++) {
            long sum = Long.parseLong(data.get(i));
            for (int ii = i + 1; ii < data.size(); ii++) {
                sum += Long.parseLong(data.get(ii));
                if (sum > lastResult)
                    break;
                if (sum == lastResult) {
                    List<Long> numbers = data.stream()
                            .skip(i).limit(ii - i)
                            .map(Long::parseLong)
                            .sorted(Long::compare)
                            .collect(Collectors.toList());
                    return String.valueOf(numbers.get(0) + numbers.get(numbers.size() - 1));
                }
            }
        }
        return null;
    }
}
