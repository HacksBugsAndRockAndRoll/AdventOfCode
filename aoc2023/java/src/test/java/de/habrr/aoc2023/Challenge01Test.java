package de.habrr.aoc2023;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Challenge01Test {
    Challenge challenge = new Challenge01();

    @Test
    public void testExample() {
        assertEquals(142, challenge.solve(Loader.dataContent("Example01.txt")));
        System.out.println("challenge result:" + challenge.solve(Loader.dataContent("Challenge01.txt")));
    }

}
