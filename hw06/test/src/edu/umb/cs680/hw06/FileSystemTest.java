package edu.umb.cs680.hw06;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileSystemTest {

    @Test
    void testGetFileSystem() {
        FileSystem fs1 = FileSystem.getFileSystem();
        FileSystem fs2 = FileSystem.getFileSystem();
        assertSame(fs1, fs2);
    }

    @Test
    void testAppendRootDir() {
        FileSystem fs = FileSystem.getFileSystem();
        Directory root = new Directory(null, "root", 0, null);
        fs.appendRootDir(root);
        assertTrue(fs.getRootDirs().contains(root));
    }


}

