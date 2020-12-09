package de.hbarr.aoc2020.day03;

import de.hbarr.aoc2020.Challenge;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Challenge02 implements Challenge {

    @Override
    public String run(List<String> data) {

        List<Pair<Integer, Integer>> slopes = Arrays.asList(Pair.with(1, 1),
                Pair.with(3, 1),
                Pair.with(5, 1),
                Pair.with(7, 1),
                Pair.with(1, 2));
        List<Integer> allResults = new ArrayList<>();
        for (Pair<Integer, Integer> slope : slopes) {
            Position pos = new Position(0, 0, data.get(0).length());
            int trees = 0;
            for (int i = pos.getY(); i < data.size() - slope.getValue1(); i+=slope.getValue1()) {
                if (data.get(pos.incY(slope.getValue1())).charAt(pos.incX(slope.getValue0())) == '#') {
                    trees++;
                }
            }
            allResults.add(trees);
        }
        return String.valueOf(allResults.stream().reduce(1, Math::multiplyExact));
    }

    private class Position {
        int modX;
        int x;
        int y;

        Position(int x, int y, int modX) {
            this.x = x;
            this.y = y;
            this.modX = modX;
        }

        int getX() {
            return x % modX;
        }

        int getY() {
            return y;
        }

        int incX(int by) {
            x += by;
            return getX();
        }

        int incY(int by) {
            y += by;
            return getY();
        }
    }
}
