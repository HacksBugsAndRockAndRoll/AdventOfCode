package de.hbarr.aoc2020.day02;

import de.hbarr.aoc2020.Challenge;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge01 implements Challenge {
    @Override
    public String run(List<String> data) {
        return String.valueOf(data.stream().map(Policy::new).filter(Policy::isValid).count());
    }

    private class Policy {
        final Pattern pattern = Pattern.compile("(?<min>\\d+)-(?<max>\\d+)\\s(?<token>.):\\s(?<data>.*)");
        int min;
        int max;
        String token;
        String data;

        Policy(String input) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                min = Integer.parseInt(matcher.group("min"));
                max = Integer.parseInt(matcher.group("max"));
                token = matcher.group("token");
                data = matcher.group("data");
            }
        }

        boolean isValid() {
            Pattern check = Pattern.compile("[^" + token + "]*" + token);
            int count = 0;
            Matcher matcher = check.matcher(data);
            while (matcher.find()) {
                count++;
            }
            return count >= min && count <= max;
        }

    }
}
