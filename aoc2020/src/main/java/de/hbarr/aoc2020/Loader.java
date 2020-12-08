package de.hbarr.aoc2020;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Loader {
    public List<String> dataContent(String fileName) {
        try {
            return Files.readAllLines(Paths.get(Loader.class.getClassLoader().getResource(fileName).toURI()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
