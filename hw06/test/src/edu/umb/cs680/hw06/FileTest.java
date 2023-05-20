package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class FileTest {

    @Test
    void testIsFile() {
        Directory parent = new Directory(null, "parent", 0, null);
        File file = new File(parent, "file.txt", 100, LocalDateTime.now());
        assertTrue(file.isFile());
    }

    @Test
    void testIsDirectory() {
        Directory parent = new Directory(null, "parent", 0, null);
        File file = new File(parent, "file.txt", 100, LocalDateTime.now());
        assertFalse(file.isDirectory());
    }

    @Test
    void testParent() {
        Directory parent = new Directory(null, "parent", 0, null);
        File file = new File(parent, "file.txt", 100, LocalDateTime.now());
        assertEquals(parent, file.getParent());
    }

    @Test
    void testSize() {
        Directory parent = new Directory(null, "parent", 0, null);
        File file = new File(parent, "file.txt", 100, LocalDateTime.now());
        assertEquals(100, file.getSize());
    }

    @Test
    void testCreationTime() {
        Directory parent = new Directory(null, "parent", 0, null);
        LocalDateTime now = LocalDateTime.now();
        File file = new File(parent, "file.txt", 100, now);
        assertEquals(now, file.getCreationTime());
    }
}
