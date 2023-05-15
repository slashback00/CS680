package edu.umb.cs680.hw12.fs.util;

import java.util.LinkedList;

import edu.umb.cs680.hw12.fs.*;

public class FileSearchVisitor implements FSVisitor{
   
    private String fileName;
	private LinkedList<File> foundFiles;
    
   
    public void visit(Link link) {
        return;
    }

   
    public void visit(Directory dir) {
        return;
    }

   
    public void visit(File file) {
		if(file.getName().equals(fileName)) {
			foundFiles.add(file);
		}
	}

	public LinkedList<File> getFoundFiles(){
        return foundFiles;
    }
    
}