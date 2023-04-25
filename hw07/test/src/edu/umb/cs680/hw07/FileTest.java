package edu.umb.cs680.hw07;

   
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileTest {
    
    static LocalDateTime localTime = LocalDateTime.now();
  
    Directory root = new Directory(null, "Root", 0, localTime);
    Directory Apps = new Directory(root, "Apps", 0, localTime);
    Directory bin = new Directory(root, "bin", 0, localTime);
    Directory home = new Directory(root, "home", 0, localTime);
    File a = new File(home, "a", 10, localTime);
    File b = new File(home, "b", 20, localTime);
    File c = new File(bin, "c", 30, localTime);
    File x = new File(Apps, "x", 40, localTime);
    File y = new File(Apps, "y", 50, localTime);
    Link d = new Link(bin, "d", 0, localTime, Apps);
    Link e = new Link(home, "e", 0, localTime, x);
    
    
    Directory pictures = new Directory(home, "pictures", 0, localTime);

    private String[] fileToStringArray(Directory f) {
        String[] fileInfo = { String.valueOf(f.isDirectory()), f.getName(), String.valueOf(f.getSize()),
            String.valueOf(f.getCreationTime()) };
        return fileInfo;
    }
    
    @Test
    public void verifyDirectoryEqualityRoot() {
        String[] expected = { "true", "Root", "0", localTime.toString()};
        Directory actual = root;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyFileInequalityBySize() {
        File actual = b;
        File expected = a;
        assertNotEquals(expected, actual);
    }

    @Test
    public void verifyLinkPointsToCorrectFile() {
        assertEquals(x, e.getTarget());
    }

 


    @Test
     	public void verifyFileIsLink() 
         {
     		assertTrue(e.isLink());
    	}
    
        
        @Test
            public void verifyFileInequality() 
             {
                File actual = a;
                 File expected = c;
                assertNotEquals(expected, actual);
             }
}
