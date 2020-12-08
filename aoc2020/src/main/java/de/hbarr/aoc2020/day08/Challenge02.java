package de.hbarr.aoc2020.day08;

import de.hbarr.aoc2020.Challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Challenge02 implements Challenge {
    @Override
    public String run(List<String> data) {
        List<Integer> mutationLog = new ArrayList<>();
        for (int i = 0; i < data.stream().filter(s -> s.startsWith("jmp") || s.startsWith("nop")).count(); i++) {
            boolean mutated = false;
            int acc = 0;
            Result start = new Result(0, 0);
            Set<Integer> executionLog = new HashSet<>();
            while (start != null) {
                acc += start.accChange;
                if (start.nextIndex >= data.size()) {
                    return String.valueOf(acc);
                }
                if (executionLog.contains(start.nextIndex))
                    break;
                String instruction = data.get(start.nextIndex).split(" ")[0];
                int arg = Integer.parseInt(data.get(start.nextIndex).split(" ")[1]);
                executionLog.add(start.nextIndex);
                if(!mutated && (instruction.equals("jmp")||instruction.equals("nop")) && !mutationLog.contains(start.nextIndex)){
                    instruction = flip(instruction);
                    mutated=true;
                    mutationLog.add(start.nextIndex);
                }
                start = execute(instruction, arg, start.nextIndex);
            }
        }
        return null;
    }

    private String flip(String instruction){
        if(instruction.equals("nop")){
            return "jmp";
        }
        if(instruction.equals("jmp")){
            return "nop";
        }
        return instruction;
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
