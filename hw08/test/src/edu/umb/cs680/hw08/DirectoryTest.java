package edu.umb.cs680.hw08;

import edu.umb.cs680.hw08.fs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest {
    
    private static Directory rootDir;

    @BeforeAll
    public static void setUpFileSystem() {
        FileSystem fileSystem = TestFixtureInitializer.createFS();
        rootDir = (Directory) fileSystem.getRootDirs().getFirst();
    }

    @Test
    public void verifyDirectoryEqualityWithFsElement() {
        assertTrue(rootDir.isDirectory());
        assertFalse(rootDir.isFile());
        assertFalse(rootDir.isLink());
    }

    @Test
    public void verifyDirectoryName() {
        assertEquals("prjRoot", rootDir.getName());
    }

    @Test
    public void verifyFileInsertion() {
        File x = new File(rootDir, "x", 100, rootDir.getCreationTime());
        rootDir.appendChild(x);
        assertTrue(rootDir.getChildren().contains(x));
    }
 
    
}
