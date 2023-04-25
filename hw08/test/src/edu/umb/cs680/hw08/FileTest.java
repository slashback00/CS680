package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import edu.umb.cs680.hw08.fs.Directory;
import edu.umb.cs680.hw08.fs.FSElement;
import edu.umb.cs680.hw08.fs.File;
import edu.umb.cs680.hw08.fs.Link;


public class FileTest
{
    private static Directory root;
    private static Directory Apps;
    private static Directory bin;
    private static Directory home;
    private static Directory pictures;
    private static File x;
    private static File y;
    private static File a; 
    private static File b;
    private static File c;
    private static Link d;
    private static Link e;
    
    @BeforeAll
    static void setUpBeforeClass() throws Exception
    {
        LocalDateTime creationTime = LocalDateTime.now();
        
        root = new Directory(null, "root", 0, creationTime);
        Apps = new Directory(root, "Apps", 0, creationTime);
        bin = new Directory(root, "bin", 0, creationTime);
        home = new Directory(root, "home", 0, creationTime);
        pictures = new Directory(home, "pictures", 0, creationTime);
        x = new File(Apps, "x", 1, creationTime);
        y = new File(pictures, "y", 2, creationTime);
        a = new File(pictures, "a", 3, creationTime);
        b = new File(pictures, "b", 4, creationTime);
        c = new File(pictures, "c", 5, creationTime);
        d = new Link(home, "d", 0, creationTime, Apps);
        e = new Link(bin, "e", 0, creationTime, x);

        root.appendChild(Apps);
        root.appendChild(bin);
        root.appendChild(home);
        root.appendChild(d);
        root.appendChild(e);
        Apps.appendChild(x);
        Apps.appendChild(e);
        bin.appendChild(y);
        home.appendChild(c);
        home.appendChild(pictures);
        pictures.appendChild(a);
        pictures.appendChild(b);
        pictures.appendChild(d);

    }

    private String[] fileToStringArray(File f) 
    {
		String[] fileInfo = { String.valueOf(f.isDirectory()), f.getName(), String.valueOf(f.getSize()),
				String.valueOf(f.getCreationTime()), f.getParent().getName() };
		return fileInfo;
	}




    @Test
    public void verifyFileEqualityX() 
    {
        String[] expected = { "false", "x", "1", String.valueOf(x.getCreationTime()), "Apps" };
        File actual = this.x;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyFileEqualityB() 
    {
        String[] expected = { "false", "b", "4", String.valueOf(b.getCreationTime()), "pictures" };
        File actual = b;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    

    
    @Test
    public void verifyFileEqualityA() 
    {
        String[] expected = { "false", "a", "3", String.valueOf(a.getCreationTime()), "pictures" };
        File actual = this.a;
        assertArrayEquals(expected, fileToStringArray(actual));
    }


    @Test
    public void isTestDirectoryWithX()
    {
        assertFalse(x.isDirectory());
    }

    @Test
    public void isTestLinkWithX()
    {
        assertFalse(x.isLink());
    }

    



}