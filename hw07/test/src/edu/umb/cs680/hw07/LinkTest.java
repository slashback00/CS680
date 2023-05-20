package edu.umb.cs680.hw07;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

public class LinkTest {
    private static FileSystem fs ;
    @BeforeAll
    public static void setupFS(){
        
        fs= testFixtureInitializer.createFS();
    }

    @Test
    public void ReturnsFalseForIsDirectory() {
        fs= testFixtureInitializer.createFS();
        assertTrue(fs.getRootDirs().getLast().isDirectory());
    }

    @Test
    public void ReturnsNameCorrectly() {
        fs= testFixtureInitializer.createFS();
        assertEquals(fs.getRootDirs().getLast().getName(),"prjRoot");
    }

    @Test
    public void ReturnsTargetCorrectly() {
        fs= testFixtureInitializer.createFS();
        assertEquals(fs.getRootDirs().getFirst().getName(),"prjRoot");
    }
      
    
}

