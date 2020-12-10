package de.hbarr.aoc2020.day10;

import de.hbarr.aoc2020.Loader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day10Test {
    @Test
    void evalTestDataC01(){
        Challenge01 challenge = new Challenge01();
        var loader = new Loader();
        assertEquals("220",challenge.run(loader.dataContent("testdata10.txt")));
    }

    @Test
    void evalTestDataC02(){
        Challenge02 challenge = new Challenge02();
        var loader = new Loader();
        assertEquals("19208",challenge.run(loader.dataContent("testdata10.txt")));
    }
}
