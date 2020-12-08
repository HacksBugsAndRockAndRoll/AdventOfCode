package de.hbarr.aoc2020.day07;

import de.hbarr.aoc2020.Loader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day07Test {

    @Test
    void evalTestDataC01(){
        Challenge01 challenge = new Challenge01();
        var loader = new Loader();
        assertEquals("4",challenge.run(loader.dataContent("testdata07.txt")));
    }

    @Test
    void evalTestDataC02(){
        Challenge02 challenge = new Challenge02();
        var loader = new Loader();
        assertEquals("126",challenge.run(loader.dataContent("testdata07_2.txt")));
    }
}
