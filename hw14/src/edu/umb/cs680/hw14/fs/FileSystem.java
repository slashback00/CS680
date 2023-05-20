package edu.umb.cs680.hw14.fs;


public class FileSystem {
	private static FileSystem instance = null;
	private Directory rootDir;
     
	
    public FileSystem(){}
	public static FileSystem getFileSystem() {
		if (instance == null) {
			instance = new FileSystem();
		}
        
		return instance;
	}
	
	public Directory getRootDirs(){
		return rootDir;
	}
	
	public void appendRootDir(Directory root) {
		this.rootDir = root;
	}


}
