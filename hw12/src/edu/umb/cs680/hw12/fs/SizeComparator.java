package edu.umb.cs680.hw12.fs;

import java.util.Comparator;

public class SizeComparator implements Comparator<FSElement>{

    
    public int compare(FSElement fse1, FSElement fse2) {
        return (int) (fse1.getSize() - fse2.getSize()); 
    }
    
}