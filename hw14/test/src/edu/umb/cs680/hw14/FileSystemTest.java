package edu.umb.cs680.hw14; 


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


import edu.umb.cs680.hw14.fs.Directory;
import edu.umb.cs680.hw14.fs.FSElement;
import edu.umb.cs680.hw14.fs.File;
import edu.umb.cs680.hw14.fs.FileSystem;

public class FileSystemTest {
    TestFixtureInitializer TFS = new TestFixtureInitializer();
    FileSystem fs = TestFixtureInitializer.createFS();

    @Test
    public void testAlphabeticalComparatorTest(){
        LinkedList<FSElement> output = new LinkedList<FSElement>();
        output= fs.getRootDirs().getChildren(); // no parameter -> alphabetical sorting

        LinkedList<String> actual = new LinkedList<String>();
        for(FSElement fse : output){
            actual.add(fse.getName());
        }
        LinkedList<String> expected = new LinkedList<String>();
        expected.add("lib");
        expected.add("src");
        expected.add("test");
        expected.add("y");
        //A followed by "h" followed by "l" 
        assertEquals(expected, actual);
    }

    @Test
    public void testSizeComparatorTest(){
        LinkedList<FSElement> output = new LinkedList<FSElement>();
        output= fs.getRootDirs().getChildren((FSElement fse1, FSElement fse2)-> (int)(fse1.getSize() - fse2.getSize()));

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
    public void testTimeStampComparatorTest(){
        LinkedList<FSElement> output = new LinkedList<FSElement>();
        output= fs.getRootDirs().getChildren((FSElement fse1, FSElement fse2) -> (int)((fse1.getCreationtime()).compareTo(fse2.getCreationtime())));

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
    public void testReverseAlphabeticalComparatorTest(){
        LinkedList<FSElement> output = new LinkedList<FSElement>();
        output= fs.getRootDirs().getChildren((FSElement fse1, FSElement fse2)->fse2.getName().compareTo(fse1.getName()));

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
public void testGetFilesTest() {
    Directory directory = new Directory(null, "test", 0, null);
    File file1 = new File(directory, "file1", 100, null);
    File file2 = new File(directory, "file2", 200, null);
    Directory subdirectory = new Directory(directory, "subdirectory", 0, null);
    File file3 = new File(subdirectory, "file3", 150, null);
    directory.appendChild(file1);
    directory.appendChild(file2);
    directory.appendChild(subdirectory);
    subdirectory.appendChild(file3);

    List<File> actual = directory.getFiles(null);
    List<File> expected = Arrays.asList(file1, file2);

    assertEquals(expected, actual);
}






     @Test
    public void testGetSubdirectoriesTest() {
        Directory directory = new Directory(null, "test", 0, null);
        Directory subdirectory1 = new Directory(directory, "subdirectory1", 0, null);
        Directory subdirectory2 = new Directory(directory, "subdirectory2", 0, null);
        File file = new File(directory, "file", 100, null);
        directory.appendChild(subdirectory1);
        directory.appendChild(subdirectory2);
        directory.appendChild(file);

        List<Directory> actual = directory.getSubDirectories((d1, d2) -> d1.getName().compareTo(d2.getName()));
        List<Directory> expected = Arrays.asList(subdirectory1, subdirectory2);

        assertEquals(expected, actual);
    }



    
}
