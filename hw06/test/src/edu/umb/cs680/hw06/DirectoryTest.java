package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;



public class DirectoryTest {
    
    private  Directory parentDir;
    private Directory childDir1;
    private Directory childDir2;
    private File file1;
    private File file2;
    
    @BeforeEach
    public void setUp() {
        LocalDateTime time = LocalDateTime.now();
        parentDir = new Directory(null, "parent", 0, time);
        childDir1 = new Directory(parentDir, "child1", 0, time);
        childDir2 = new Directory(parentDir, "child2", 0, time);
        file1 = new File(parentDir, "file1", 100, time);
        file2 = new File(childDir1, "file2", 50, time);
        parentDir.appendChild(childDir1);
        parentDir.appendChild(childDir2);
        parentDir.appendChild(file1);
        childDir1.appendChild(file2);
    }
    
    @Test
    public void testCountChildren() {
        assertEquals(4, parentDir.countChildren());
        assertEquals(2, childDir1.countChildren());
        assertEquals(0, childDir2.countChildren());
    }
    
    @Test
    public void testGetChildren() {
        assertEquals(parentDir.getChildren().size(), parentDir.countChildren());
        assertTrue(parentDir.getChildren().contains(childDir1));
        assertTrue(parentDir.getChildren().contains(childDir2));
        assertTrue(parentDir.getChildren().contains(file1));
        assertEquals(childDir1.getChildren().size(), childDir1.countChildren());
        assertTrue(childDir1.getChildren().contains(file2));
    }
    
    @Test
    public void testGetTotalSize() {
        assertEquals(300, parentDir.getTotalSize());
        assertEquals(100, childDir1.getTotalSize());
        assertEquals(0, childDir2.getTotalSize());
    }
    
    @Test
    public void testGetSubDirectories() {
        assertEquals(2, parentDir.getSubDirectories().size());
        assertTrue(parentDir.getSubDirectories().contains(childDir1));
        assertTrue(parentDir.getSubDirectories().contains(childDir2));
        assertEquals(0, childDir1.getSubDirectories().size());
        assertEquals(0, childDir2.getSubDirectories().size());
    }
    
   
    
    @Test
    public void testAddFile() {
        File file3 = new File(parentDir, "file3", 75, LocalDateTime.now());
        parentDir.addFile(file3);
        assertTrue(parentDir.getChildren().contains(file3));
        assertEquals(5, parentDir.countChildren());
    }
}
