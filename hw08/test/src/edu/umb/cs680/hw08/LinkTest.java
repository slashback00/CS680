package edu.umb.cs680.hw08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.fs.Directory;
import edu.umb.cs680.hw08.fs.FSElement;
import edu.umb.cs680.hw08.fs.FileSystem;
import edu.umb.cs680.hw08.fs.Link;

import static org.junit.jupiter.api.Assertions.*;


public class LinkTest {
    private static FileSystem fs;
    private static Directory rootDir;
    
    @BeforeAll
    public static void setUpFileSystem() {
        fs = TestFixtureInitializer.createFS();
        rootDir = (Directory) fs.getRootDirs().getFirst();
    }

    private Link findLinkByName(Directory dir, String linkName) {
        for (FSElement element : dir.getChildren()) {
            if (element.isDirectory()) {
                Link link = findLinkByName((Directory) element, linkName);
                if (link != null) {
                    return link;
                }
            } else if (element.isLink() && element.getName().equals(linkName)) {
                return (Link) element;
            }
        }
        return null;
    }
    
    @Test
    public void verifyLinkY() {
        Link linkY = findLinkByName(rootDir, "y");
        assertNotNull(linkY);
        assertEquals("y", linkY.getName());
        assertEquals(4, linkY.getSize());
        assertFalse(linkY.isDirectory());
        assertFalse(linkY.isFile());
        assertTrue(linkY.isLink());
    }

    @Test
    public void verifyLinkYTarget() {
        Link linkY = findLinkByName(rootDir, "y");
        assertNotNull(linkY);
        FSElement target = linkY.getTarget();
        assertTrue(target.isDirectory());
        assertEquals("src", target.getName());
    }

    // more tests...
}
