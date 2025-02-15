package com.fiels;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

public class PathTest {

    @Test
    void givenPathString_whenCreatesPathObject_thenCorrect() {
        // given
        Path path = Paths.get("/articles/baeldung");
        // when then
        assertEquals("\\articles\\baeldung", path.toString());
    }

    @Test
    void givenPathParts_whenCreatesPathObject_thenCorrect() {
        // given
        Path path = Paths.get("/articles", "baeldung");
        // when then
        assertEquals("\\articles\\baeldung", path.toString());
    }

    @Test
    void givenPath_whenRetrievesFileName_thenCorrect() {
        // given
        Path path = Paths.get("/articles/baeldung/logs");
        // when
        Path fileName = path.getFileName();
        // then
        assertEquals("logs", fileName.toString());
    }

    @Test
    void givenPath_whenRetrievesNameByIndex_thenCorrect() {
        // given
        Path path = Paths.get("/articles/baeldung/logs");
        // when
        Path name0 = path.getName(0);
        Path name1 = path.getName(1);
        Path name2 = path.getName(2);
        // then
        assertEquals("articles", name0.toString());
        assertEquals("baeldung", name1.toString());
        assertEquals("logs", name2.toString());
    }
}
