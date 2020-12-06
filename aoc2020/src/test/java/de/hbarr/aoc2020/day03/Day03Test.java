package de.hbarr.aoc2020.day03;

import de.hbarr.aoc2020.Loader;
import de.hbarr.aoc2020.day03.Challenge01;
import de.hbarr.aoc2020.day03.Challenge02;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day03Test {
    @Test
    void evalTestDataC01(){
        Challenge01 challenge = new Challenge01();
        var loader = new Loader();
        assertEquals("7",challenge.run(loader.dataContent("testdata03.txt")));
    }

    @Test
    void evalTestDataC02(){
        Challenge02 challenge = new Challenge02();
        var loader = new Loader();
        assertEquals("336",challenge.run(loader.dataContent("testdata03.txt")));
    }
}
