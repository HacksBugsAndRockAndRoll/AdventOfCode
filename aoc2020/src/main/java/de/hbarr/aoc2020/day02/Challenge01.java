package de.hbarr.aoc2020.day02;

import de.hbarr.aoc2020.Challenge;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge01 implements Challenge {
    @Override
    public String run(List<String> data) {
        /**
         * Each line gives the password policy and then the password.
         * The password policy indicates the lowest and highest number
         * of times a given letter must appear for the password to be valid.
         * For example, 1-3 a means that the password must contain a at least 1 time and at most 3 times.
         */
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
                min = Integer.valueOf(matcher.group("min"));
                max = Integer.valueOf(matcher.group("max"));
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
