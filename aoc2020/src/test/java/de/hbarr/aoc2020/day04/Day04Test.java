package de.hbarr.aoc2020.day04;

import de.hbarr.aoc2020.Loader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04Test {

    @Test
    void evalTestDataC01(){
        Challenge01 challenge = new Challenge01();
        var loader = new Loader();
        assertEquals("2",challenge.run(loader.dataContent("testdata04.txt")));
    }

    @Test
    void evalTestDataC02(){
        Challenge02 challenge = new Challenge02();
        var loader = new Loader();
        assertEquals("4",challenge.run(loader.dataContent("testdata04_2.txt")));
    }
}
