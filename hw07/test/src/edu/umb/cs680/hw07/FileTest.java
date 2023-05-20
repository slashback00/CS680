package edu.umb.cs680.hw07;
  


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileTest {
    
   
    
    @Test
    public void testGetFileSystemReturnsNonNullObject() {
        FileSystem fs = FileSystem.getFileSystem();
        assertNotNull(fs);
    }

    @Test
    public void FilesystemIsNotnull(){
        FileSystem fs= testFixtureInitializer.createFS();
        assertNotNull(fs);
    }

    @Test
    public void isDirectoryReturnsFalse(){
        FileSystem fs= testFixtureInitializer.createFS();
        assertFalse(fs.getRootDirs().getFirst().getFiles().getFirst().isDirectory());
    }



 


 

}

