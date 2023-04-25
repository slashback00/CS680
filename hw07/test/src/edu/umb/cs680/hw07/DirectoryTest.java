package edu.umb.cs680.hw07;



import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for Directory class")
public class DirectoryTest {

    private Directory root;
    private Directory dir;
    private File file;

    @BeforeEach
    void setUp() {
        root = new Directory(null, "root", 0, LocalDateTime.now());
        dir = new Directory(root, "dir", 0, LocalDateTime.now());
        file = new File(dir, "file.txt", 100, LocalDateTime.now());
    }

    @Nested
    @DisplayName("Tests for isDirectory method")
    class IsDirectoryTests {
        @Test
        @DisplayName("Root is a directory")
        void rootIsDirectory() {
            assertTrue(root.isDirectory());
        }

        @Test
        @DisplayName("Directory is a directory")
        void directoryIsDirectory() {
            assertTrue(dir.isDirectory());
        }

        @Test
        @DisplayName("File is not a directory")
        void fileIsNotDirectory() {
            assertFalse(file.isDirectory());
        }
    }

    @Test
    @DisplayName("Test for getTotalSize method")
    void getTotalSize() {
        assertEquals(100, dir.getTotalSize());
    }

    @Test
    @DisplayName("Test for countChildren method")
    void countChildren() {
        assertEquals(0, root.countChildren());
        assertEquals(1, dir.countChildren());
    }

    @Test
    @DisplayName("Test for getName method")
    void getName() {
        assertEquals("dir", dir.getName());
    }

    @Test
    @DisplayName("Test for getCreationTime method")
    void getCreationTime() {
        assertNotNull(dir.getCreationTime());
    }

}