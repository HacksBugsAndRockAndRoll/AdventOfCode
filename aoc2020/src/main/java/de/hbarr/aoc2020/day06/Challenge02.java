package de.hbarr.aoc2020.day06;

import de.hbarr.aoc2020.Challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Challenge02 implements Challenge {

    @Override
    public String run(List<String> data) {
        Integer result = 0;
        for(List<List<String>> answersInGroup : allAnswersSplitByGroup(data)){
            Set<String> allYes = null;
            for(List<String> answerByPerson : answersInGroup){
                if(allYes == null){
                    allYes = new HashSet<>(answerByPerson);
                }else{
                    allYes = allYes.stream()
                            .distinct()
                            .filter(answerByPerson::contains)
                            .collect(Collectors.toSet());
                }
            }
            result += allYes.size();
        }
        return String.valueOf(result);
    }


    private List<List<List<String>>> allAnswersSplitByGroup(List<String> data){
        List<List<List<String>>> result = new ArrayList<>();
        List<List<String>> answersInGroup = new ArrayList<>();
        for(String line : data){
            if(!line.isEmpty()){
                answersInGroup.add(split(line));
            }else{
                result.add(answersInGroup);
                answersInGroup= new ArrayList<>();
            }
        }
        result.add(answersInGroup);
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
