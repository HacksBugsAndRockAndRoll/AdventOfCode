package de.hbarr.aoc2020.day01;

import de.hbarr.aoc2020.Loader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01Test {
    @Test
    void evalTestDataC01(){
        Challenge01 challenge = new Challenge01();
        var loader = new Loader();
        assertEquals("514579",challenge.run(loader.dataContent("testdata01.txt")));
    }

    @Test
    void evalTestDataC02(){
        Challenge02 challenge = new Challenge02();
        var loader = new Loader();
        assertEquals("241861950",challenge.run(loader.dataContent("testdata01.txt")));
    }
}
