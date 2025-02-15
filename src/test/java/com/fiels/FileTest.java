package com.fiels;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileTest {

    @Test
    void givenDir_whenMkdir_thenDirIsDeleted() {
        // given
        File directory = new File("dir");
        // then
        assertTrue(directory.mkdir());
        assertTrue(directory.delete());
    }

    @Test
    void givenFile_whenCreateNewFile_thenFileIsDeleted() {
        // given
        File file = new File("file.txt");
        // then
        try {
            assertTrue(file.createNewFile());
        } catch (IOException exception) {
            fail("Could not create " + "file.txt");
        }
        assertTrue(file.delete());
    }
}
