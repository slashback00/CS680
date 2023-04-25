package edu.umb.cs680.hw08.fs.util;

import java.util.LinkedList;

import edu.umb.cs680.hw08.fs.FSVisitor;
import edu.umb.cs680.hw08.fs.Directory;
import edu.umb.cs680.hw08.fs.File;
import edu.umb.cs680.hw08.fs.Link;



public class FileSearchVisitor implements FSVisitor
{
    private String fileName;
    private LinkedList<File> foundFiles;

    public FileSearchVisitor(String fileName)
    {
        foundFiles = new LinkedList<>();
        this.fileName = fileName;
    }

    
    public void visit(Link link) 
    {
        return;
    }

   
    public void visit(Directory dir) 
    {
       return;
    }

    
    public void visit(File file) 
    {
       if(file.getName().equals(fileName))
       {
            foundFiles.add(file);
       }
    }

    public LinkedList<File> getFoundFiles()
    {
        return foundFiles;
    }
    
}
