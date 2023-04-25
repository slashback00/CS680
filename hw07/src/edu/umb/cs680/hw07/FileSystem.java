package edu.umb.cs680.hw07;

import java.util.LinkedList;

public class FileSystem
{
    private static FileSystem Instance = null;
    private LinkedList<Directory> rootDirs;    

    private FileSystem()
    {
        Instance = null;
        this.rootDirs = new LinkedList<>();
    }

    public static FileSystem getFileSystem()
    {
        if(Instance == null)
        {
            Instance = new FileSystem();
        }
        return Instance;
    }

    public void appendRootDir(Directory Root)
    {
        rootDirs.add(Root);
    }

    public LinkedList<Directory> getRootDirs()
    {
        return rootDirs;
    }

    public static void main(String[] args) 
    {
        System.out.println("Class FileSystem Runs");
    }

  
}
