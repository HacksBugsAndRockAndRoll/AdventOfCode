package de.hbarr.aoc2020.day08;

import de.hbarr.aoc2020.Challenge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Challenge01 implements Challenge {
    @Override
    public String run(List<String> data) {

        int acc = 0;
        Result start = new Result(0,0);

        Set<Integer> executionLog = new HashSet<>();
        while(start != null){
            acc+= start.accChange;
            if(start.nextIndex >= data.size())
                break;
            if(executionLog.contains(start.nextIndex))
                break;
            String instruction = data.get(start.nextIndex).split(" ")[0];
            int arg = Integer.parseInt(data.get(start.nextIndex).split(" ")[1]);
            executionLog.add(start.nextIndex);
            start = execute(instruction,arg,start.nextIndex);
        }
        return String.valueOf(acc);
    }

        Result execute(String instruction, int arg, int index) {
        int accChange = 0;
        switch (instruction) {
            case "nop":
                index++;
                break;
            case "acc":
                accChange = arg;
                index++;
                break;
            case "jmp":
                index += arg;
                break;
            default:
                break;
        }
        return new Result(accChange, index);
    }

    class Result {
        Result(int accChange, int next) {
            this.accChange = accChange;
            this.nextIndex = next;
        }
        int accChange;
        int nextIndex;
    }
}
