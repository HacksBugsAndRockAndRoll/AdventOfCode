package de.hbarr.aoc2020.day07;

import de.hbarr.aoc2020.Challenge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Challenge02 implements Challenge {

    @Override
    public String run(List<String> data) {
        Map<String, Bag> possibleBags = new HashMap<>();
        data.stream()
                .map(Bag::new)
                .forEach(b ->possibleBags.put(b.classifier, b));
        return String.valueOf(contents(possibleBags.get("shiny gold"),possibleBags,0));
    }

    private int contents(Bag bag,Map<String, Bag> possibleBags, int current){
        int increase = 0;
        for(Map.Entry<String,Integer> containedBag : bag.canContain.entrySet()){
            increase += containedBag.getValue() * (contents(possibleBags.get(containedBag.getKey()),possibleBags,current) +1);
        }
        return current+increase;
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
