package de.hbarr.aoc2020.day06;

import de.hbarr.aoc2020.Challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge01 implements Challenge {

    @Override
    public String run(List<String> data) {
        return String.valueOf(uniqueAnswersSplitByGroup(data)
                .stream()
                .mapToInt(Set::size)
                .sum());
    }

    private List<Set<String>> uniqueAnswersSplitByGroup(List<String> data){
        List<Set<String>> result = new ArrayList<>();
        Set<String> uniqueByLine = new HashSet<>();
        for(String line : data){
            if(!line.isEmpty()){
                uniqueByLine.addAll(split(line));
            }else{
                result.add(uniqueByLine);
                uniqueByLine= new HashSet<>();
            }
        }
        result.add(uniqueByLine);
        return result;
    }

    private List<String> split(String data){
        List<String> result = new ArrayList<>();
        Matcher matcher = Pattern.compile(".").matcher(data);
        while(matcher.find()){
            result.add(matcher.group());
        }
        return result;
    }


}
