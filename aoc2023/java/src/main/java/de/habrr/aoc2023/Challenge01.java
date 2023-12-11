package de.habrr.aoc2023;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Challenge01 implements Challenge {
    Pattern p = Pattern.compile("(\\d)", Pattern.DOTALL);
    @Override
    public int solve(List<String> data) {
        AtomicInteger sum = new AtomicInteger();
        data.forEach(d -> {
            Matcher m = p.matcher(d);
            List<String> l = m.results().map(MatchResult::group).collect(Collectors.toList());
            if (!l.isEmpty()) {
                sum.addAndGet(Integer.parseInt(l.getFirst() + l.getLast()));
            }
        });
        return sum.get();
    }
}
