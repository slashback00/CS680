package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.Test;

import edu.umb.cs680.hw12.fs.AlphabeticalComparator;
import edu.umb.cs680.hw12.fs.FSElement;
import edu.umb.cs680.hw12.fs.FileSystem;
import edu.umb.cs680.hw12.fs.ReverseAlphabeticalComparator;
import edu.umb.cs680.hw12.fs.SizeComparator;
import edu.umb.cs680.hw12.fs.TimeStampComparator;

public class FileSystemTest {
    FileSystem fs = TestFixtureInitializer.createFS();

    @Test
    public void checkAlphabeticalComparator(){
        LinkedList<FSElement> output = new LinkedList<FSElement>();
        output= fs.getRootDirs().getChildren(new AlphabeticalComparator());

        LinkedList<String> actual = new LinkedList<String>();
        for(FSElement fse : output){
            actual.add(fse.getName());
        }
        LinkedList<String> expected = new LinkedList<String>();
        expected.add("lib");
        expected.add("src");
        expected.add("test");
        expected.add("y");
        assertEquals(expected, actual);
    }

    @Test
    public void verifyDirectory() {
        assertTrue(fs.getRootDirs().isDirectory());
    }

 

    @Test
    public void checkSizeComparator(){
        LinkedList<FSElement> output = new LinkedList<FSElement>();
        output= fs.getRootDirs().getChildren(new SizeComparator());

        LinkedList<String> actual = new LinkedList<String>();
        for(FSElement fse : output){
            actual.add(fse.getName());
        }
        LinkedList<String> expected = new LinkedList<String>();
        expected.add("lib");
        expected.add("src");
        expected.add("test");
        expected.add("y");
        assertEquals(expected, actual);
    }

    @Test
    public void checkTimeStampComparator(){
        LinkedList<FSElement> output = new LinkedList<FSElement>();
        output= fs.getRootDirs().getChildren(new TimeStampComparator());

        LinkedList<String> actual = new LinkedList<String>();
        for(FSElement fse : output){
            actual.add(fse.getName());
        }
        LinkedList<String> expected = new LinkedList<String>();
        expected.add("lib");
        expected.add("src");
        expected.add("test");        
        expected.add("y");
        assertEquals(expected, actual);
    }
     
    @Test
    public void checkReverseAlphabeticalComparator(){
        LinkedList<FSElement> output = new LinkedList<FSElement>();
        output= fs.getRootDirs().getChildren(new ReverseAlphabeticalComparator());

        LinkedList<String> actual = new LinkedList<String>();
        for(FSElement fse : output){
            actual.add(fse.getName());
        }
        LinkedList<String> expected = new LinkedList<String>();
        expected.add("y");
        expected.add("test");
        expected.add("src");
        expected.add("lib");
        assertEquals(expected, actual);
    }

    @Test
    
    public void testGetTotalSize(){
        long actual = fs.getRootDirs().getTotalSize();
        long expected = 200;
        assertEquals(expected, actual);
    }
}