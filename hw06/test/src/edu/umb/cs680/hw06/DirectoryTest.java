package edu.umb.cs680.hw06;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

public class DirectoryTest {

    @BeforeAll
    public static void setupFS(){
        testFixtureInitializer TFS = new testFixtureInitializer();
        testFixtureInitializer.createFS();
    }

   
    
    @Test
    public void testCountChildren() {       
        FileSystem fs = testFixtureInitializer.createFS();       
        int count = fs.getRootDirs().get(0).countChildren();        
        Assertions.assertEquals(4, count);
    }

    @Test
    public void testGetChildren() {
        FileSystem fs = testFixtureInitializer.createFS();
        Directory rootDir = fs.getRootDirs().get(0);
        LinkedList<FSElement> children = rootDir.getChildren();
        
        Assertions.assertEquals(4, children.size()); 
        Assertions.assertFalse(children.get(0) instanceof Directory);
        Assertions.assertEquals("x", children.get(0).getName());
        Assertions.assertTrue(children.get(1) instanceof Directory);
        Assertions.assertEquals("src", children.get(1).getName());
        Assertions.assertTrue(children.get(2) instanceof Directory);
        Assertions.assertEquals("lib", children.get(2).getName());
    }

        @Test
    public void testGetTotalSize() {
       
        FileSystem fs = testFixtureInitializer.createFS();
        Directory rootDir = fs.getRootDirs().get(0);
        int totalSize = rootDir.getTotalSize();

       
        Assertions.assertEquals(500, totalSize); 
    }

    @Test
    public void testGetSubDirectories() {
        FileSystem fs = testFixtureInitializer.createFS();
        Directory rootDir = fs.getRootDirs().get(0);
        LinkedList<Directory> subDirectories = rootDir.getSubDirectories();

        Assertions.assertEquals(3, subDirectories.size()); 
        Assertions.assertEquals("src", subDirectories.get(0).getName());
        Assertions.assertEquals("lib", subDirectories.get(1).getName());
        Assertions.assertEquals("test", subDirectories.get(2).getName());
    }
    
}
