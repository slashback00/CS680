package edu.umb.cs680.hw07;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class DirectoryTest {
    
    @Test
    public void testFileSystemIsNotNull() {
        FileSystem fs = testFixtureInitializer.createFS();
        assertNotNull(fs);
    }

    @Test
    public void testRootIsNotNull() {
        FileSystem fs = testFixtureInitializer.createFS();
        LinkedList<Directory> root = fs.getRootDirs();
        assertNotNull(root);
    }

    @Test
    public void testReturnsCorrectNumberOfChildrenForRootDirectory() {
        FileSystem fs = testFixtureInitializer.createFS();
        LinkedList<Directory> root = fs.getRootDirs();
        int expectedNumChildren = 4;
        int actualNumChildren = root.getFirst().getChildren().size();
        assertEquals(expectedNumChildren, actualNumChildren);
}


    @Test
    public void testReturnsEmptyListForRootsChildFiles() {
        FileSystem fs = testFixtureInitializer.createFS();
        LinkedList<Directory> root = fs.getRootDirs();
        assertFalse(root.getFirst().getFiles().isEmpty());
    }

    @Test
    public void testReturnsCorrectDirectoryName() {
        FileSystem fs = testFixtureInitializer.createFS();
        LinkedList<Directory> root = fs.getRootDirs();
        String expectedDirectoryName = "prjRoot";
        String actualDirectoryName = root.getFirst().getName(); // No casting needed
        assertEquals(expectedDirectoryName, actualDirectoryName);
    }

    @Test
    public void testReturnsCorrectDirectorySize() {
        FileSystem fs = testFixtureInitializer.createFS();
        LinkedList<Directory> root = fs.getRootDirs();
        int expectedDirectorySize = 4; 
        int actualDirectorySize = root.size();
        assertEquals(expectedDirectorySize, actualDirectorySize);
    }
}
