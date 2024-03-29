package edu.umb.cs680.hw08.fs;

import java.util.LinkedList;

public abstract class FileSystem {
    protected String name;
    protected int capacity;
    protected int id;
    private LinkedList<FSElement> rootdirs = new LinkedList<>();
    private static FileSystem instance = null;

    protected FileSystem() {}

    public static FileSystem getFileSystem() {
        if(instance == null) {
            instance = new ConcreteFileSystem();
        }
        return instance;
    }

    public void appendRootDir(Directory root) {
        rootdirs.add(root);
    }

    public FSElement Init(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;

        FSElement root = createDefaultRoot();
        if(root.isDirectory() && capacity >= root.getSize()) {
            setRoot(root);
            this.id = root.hashCode();
            return root;
        }
        else {
            return null;
        }
    }

    protected abstract FSElement createDefaultRoot();

    protected void setRoot(FSElement root) {
        rootdirs.add(root);
    }

    protected int getId() {
        return id;
    }

    public LinkedList<FSElement> getRootDirs() {
        return rootdirs;
    }

    protected int capacity() {
        return capacity;
    }
}

class ConcreteFileSystem extends FileSystem {
    protected FSElement createDefaultRoot() {
        // Implement the method to create the default root
        return null;
    }
}
