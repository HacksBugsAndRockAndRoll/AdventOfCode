package de.hbarr.aoc2020.day02;

import de.hbarr.aoc2020.Loader;
import de.hbarr.aoc2020.day02.Challenge01;
import de.hbarr.aoc2020.day02.Challenge02;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day02Test {
    @Test
    void evalTestDataC01(){
        Challenge01 challenge = new Challenge01();
        var loader = new Loader();
        assertEquals("2",challenge.run(loader.dataContent("testdata02.txt")));
    }

    @Test
    void evalTestDataC02(){
        Challenge02 challenge = new Challenge02();
        var loader = new Loader();
        assertEquals("1",challenge.run(loader.dataContent("testdata02.txt")));
    }
}
