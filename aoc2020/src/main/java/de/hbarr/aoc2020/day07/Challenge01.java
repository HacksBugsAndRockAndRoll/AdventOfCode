package de.hbarr.aoc2020.day07;

import de.hbarr.aoc2020.Challenge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Challenge01 implements Challenge {

    @Override
    public String run(List<String> data) {
        Map<String, Bag> possibleBags = new HashMap<>();
        data.stream()
                .filter(s -> !s.startsWith("shiny gold"))
                .map(Bag::new)
                .forEach(b -> possibleBags.put(b.classifier, b));
        return String.valueOf(
                possibleBags.values().stream()
                        .filter(b -> canContain(b,"shiny gold",possibleBags))
                        .count());
    }

    private boolean canContain(Bag toBeChecked, String shouldBeContained, Map<String,Bag> possibleBags){
        if(toBeChecked.canContain.containsKey(shouldBeContained)){
            return true;
        }
        for(Map.Entry<String,Integer> entry : toBeChecked.canContain.entrySet()){
            if(canContain(possibleBags.get(entry.getKey()),shouldBeContained,possibleBags)){
                return true;
            }
        }
        return false;
    }

    private class Bag {
        String classifier;
        Map<String, Integer> canContain;
        public Bag(String descriptor) {
            this.classifier = descriptor.split(" ")[0] + " " + descriptor.split(" ")[1];
            if (descriptor.contains("no other bags.")) {
                this.canContain = Map.of();
            } else {
                String contain = descriptor.split("contain")[1].trim();
                this.canContain = new HashMap<>();
                for (String content : contain.split(", ")) {
                    this.canContain.put(content.split(" ")[1] + " " + content.split(" ")[2], Integer.parseInt(content.split(" ")[0]));
                }
            }
        }
    }
}