package de.hbarr.aoc2020.day04;

import de.hbarr.aoc2020.Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Challenge01 implements Challenge {

    private final List<String> requiredFields = Arrays.asList("byr","iyr","eyr","hgt","hcl","ecl","pid");

    @Override
    public String run(List<String> data) {
        return String.valueOf(inlinePassportData(data)
                .stream()
                .filter(
                        d ->  Arrays.asList(d.split("[\\s|:]")).containsAll(requiredFields))
                .count()
        );
    }

    public static  List<String> inlinePassportData(List<String> input){
        List<String> inlined = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for(String line: input){
            if(!line.isEmpty()){
                builder.append(line).append(" ");
            }else{
                inlined.add(builder.toString());
                builder.setLength(0);
            }
        }
        inlined.add(builder.toString());
        return inlined;
    }
}
