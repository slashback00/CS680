package edu.umb.cs680.hw08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.fs.Directory;
import edu.umb.cs680.hw08.fs.FSElement;
import edu.umb.cs680.hw08.fs.FileSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

public class FileSystemTest {
    private static FileSystem fs;
    private static Directory rootDir;

    @BeforeAll
    public static void setUpFileSystem() {
        fs = TestFixtureInitializer.createFS();
        rootDir = (Directory) fs.getRootDirs().getFirst();
    }

    @Test
    public void verifyFileSystemSingleton() {
        FileSystem fs1 = FileSystem.getFileSystem();
        FileSystem fs2 = FileSystem.getFileSystem();
        assertSame(fs1, fs2);
    }

    @Test
    public void verifyFileSystemRoots() {
        LinkedList<FSElement> roots = fs.getRootDirs();
        assertTrue(roots.contains(rootDir));
        // You can also add assertions here for any other root directories you expect to exist
    }

    @Test
    public void verifyRootDir() {
        assertEquals("prjRoot", rootDir.getName());
        assertTrue(rootDir.isDirectory());
    }

}
