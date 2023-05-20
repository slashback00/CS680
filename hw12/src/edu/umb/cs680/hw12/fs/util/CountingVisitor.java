package edu.umb.cs680.hw12.fs.util;

import edu.umb.cs680.hw12.fs.*;

public class CountingVisitor implements FSVisitor{
    

    private int dirNum = 0;
	private int fileNum = 0;
	private int linkNum = 0;
    
    public void visit(Link link) {
        linkNum++;
    }

    
    public void visit(Directory dir) {
        fileNum++;
    }

    
    public void visit(File file) {
        dirNum++;
    }

    public int totalElementsVisited(){
        return (linkNum + fileNum + dirNum);
    }

    public int getdirNum(){
        return dirNum;
    }

    public int getfileNum(){
        return fileNum;
    }

    public int getlinkNum(){
        return linkNum;
    }
    
}
