package edu.umb.cs680.hw12.fs.util;

import java.util.LinkedList;

import edu.umb.cs680.hw12.fs.*;

public class FileCrawlingVisitor implements FSVisitor{
    // Index files in a file system

    private LinkedList<File> files = new LinkedList<>();
    String fileName;

    
    public void visit(Link link) {
        return;
    }

    
    public void visit(Directory dir) {
        return;
    }

    
    public void visit(File file) {
        files.add(file);

    }
    public LinkedList<File> getFiles() {
        return files;
    }
}