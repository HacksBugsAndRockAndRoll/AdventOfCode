package de.hbarr.aoc2020.day09;

import de.hbarr.aoc2020.Loader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day09Test {
    @Test
    void evalTestDataC01(){
        Challenge01 challenge = new Challenge01();
        challenge.preambleSize = 5;
        var loader = new Loader();
        assertEquals("127",challenge.run(loader.dataContent("testdata09.txt")));
    }

    @Test
    void evalTestDataC02(){
        Challenge02 challenge = new Challenge02();
        challenge.preambleSize = 5;
        var loader = new Loader();
        assertEquals("62",challenge.run(loader.dataContent("testdata09.txt")));
    }

}
