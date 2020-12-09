package de.hbarr.aoc2020.day09;

import de.hbarr.aoc2020.Challenge;

import java.util.List;
import java.util.stream.Collectors;

public class Challenge01 implements Challenge {

    int preambleSize = 25;

    @Override
    public String run(List<String> data) {
        for (int i = 0; i < data.size() - preambleSize; i++) {
            int checkThis = Integer.parseInt(data.get(i + preambleSize));
            List<Integer> window = data.stream().skip(i).limit(preambleSize).map(Integer::parseInt).collect(Collectors.toList());
            if (!numberValid(checkThis, window)) {
                return String.valueOf(checkThis);
            }
        }
        return null;
    }

    private boolean numberValid(int checkThis, List<Integer> window) {
        for (int i = 0; i < window.size(); i++) {
            for (int ii = i; ii < window.size(); ii++) {
                if (window.get(i) + window.get(ii) == checkThis) {
                    return true;
                }
            }
        }
        return false;
    }
}
