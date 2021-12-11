package de.hbarr.aoc2020.day11;

import de.hbarr.aoc2020.Challenge;

import java.util.Arrays;
import java.util.List;

public class Challenge01 implements Challenge {
    @Override
    public String run(List<String> data) {

        //occupied = true
        //free = false
        //floor = null

        Boolean[][] nextSeats = new Boolean[data.size()][data.get(0).length()];
        Boolean[][] seats = new Boolean[data.size()][data.get(0).length()];

        //init
        for (int i = 0; i < data.size(); i++) {
            Boolean[] row = new Boolean[data.get(i).length()];
            for (int ii = 0; ii < data.get(i).length(); ii++) {
                if (data.get(i).charAt(ii) == 'L') {
                    row[ii] = false;
                } else if (data.get(i).charAt(ii) == '.') {
                    row[ii] = null;
                } else {
                    row[ii] = false;
                }
            }
            seats[i] = row;
        }

        //seating
        //i -> x axis
        // ii -> y axis
        boolean run = true;
        int runs = 0;
        while (run) {
            System.out.println("run "+runs);
            runs++;
            for (int i = 0; i < seats.length; i++) {
                checkRow:
                for (int ii = 0; ii < seats[i].length; ii++) {
                    if (seats[i][ii] == null) {
                        nextSeats[i][ii] = null;
                        break checkRow;
                    }
                    if (!seats[i][ii]) {
                        for (int x = -1; x < 2; x++) {
                            for (int y = -1; y < 2; y++) {
                                Boolean occupied = isOccupied(x + i, y + ii, seats);
                                if (occupied != null && occupied == true) {
                                    nextSeats[i][ii] = false;
                                    break checkRow;
                                }
                            }
                        }
                        nextSeats[i][ii] = true;
                    }
                    if (seats[i][ii]) {
                        int countOccupied = 0;
                        for (int x = -1; x < 2; x++) {
                            for (int y = -1; y < 2; y++) {
                                Boolean occupied = isOccupied(x + i, y + ii, seats);
                                if (occupied != null && occupied == true) {
                                    countOccupied++;
                                    if (countOccupied >= 4) {
                                        nextSeats[i][ii] = false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (seats == nextSeats) {
                run = false;
            } else {
                seats = nextSeats;
            }
        }

        int occupied = 0;
        for (int i = 0; i < seats.length; i++) {
            System.out.println(Arrays.toString(seats[i]));
            for (int ii = 0; ii < seats[i].length; ii++) {
                Boolean oc = seats[i][ii];
                if (oc != null && oc == true)
                    occupied++;
            }
        }
        return String.valueOf(occupied);
    }

    private Boolean isOccupied(int x, int y, Boolean[][] seats) {
        if (x < 0 || y < 0) {
            return null;
        }
        if (x >= seats.length || y >= seats[x].length) {
            return null;
        } else {
            return seats[x][y];
        }
    }
}
