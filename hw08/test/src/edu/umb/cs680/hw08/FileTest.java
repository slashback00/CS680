package edu.umb.cs680.hw08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.fs.Directory;
import edu.umb.cs680.hw08.fs.FSElement;
import edu.umb.cs680.hw08.fs.File;
import edu.umb.cs680.hw08.fs.FileSystem;

import static org.junit.jupiter.api.Assertions.*;



public class FileTest {
    private static FileSystem fs;
    private static Directory rootDir;
    
    @BeforeAll
    public static void setUpFileSystem() {
        fs = TestFixtureInitializer.createFS();
        rootDir = (Directory) fs.getRootDirs().getFirst();
    }

    private File findFileByName(Directory dir, String fileName) {
        for (FSElement element : dir.getChildren()) {
            if (element.isDirectory()) {
                File file = findFileByName((Directory) element, fileName);
                if (file != null) {
                    return file;
                }
            } else if (element.getName().equals(fileName)) {
                return (File) element;
            }
        }
        return null;
    }
    
    @Test
    public void verifyFileX() {
        File fileX = findFileByName(rootDir, "x");
        assertNotNull(fileX);
        assertEquals("x", fileX.getName());
        assertEquals(100, fileX.getSize());
        assertFalse(fileX.isDirectory());
        assertTrue(fileX.isFile());
    }

    @Test
    public void verifyFileA() {
        File fileA = findFileByName(rootDir, "a");
        assertNotNull(fileA);
        assertEquals("a", fileA.getName());
        assertEquals(50, fileA.getSize());
        assertFalse(fileA.isDirectory());
        assertTrue(fileA.isFile());
    }

    @Test
    public void verifyFileB() {
        File fileB = findFileByName(rootDir, "b");
        assertNotNull(fileB);
        assertEquals("b", fileB.getName());
        assertEquals(50, fileB.getSize());
        assertFalse(fileB.isDirectory());
        assertTrue(fileB.isFile());
    }

}
