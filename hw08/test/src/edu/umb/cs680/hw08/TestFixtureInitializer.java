package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

import edu.umb.cs680.hw08 .fs.*;


public class TestFixtureInitializer {
    public static FileSystem createFS(){
        LocalDateTime time = LocalDateTime.now();
        Directory prjRoot = new Directory(null, "prjRoot", 0, time);

        File x = new File(prjRoot, "x", 100, time);

        Directory src = new Directory(prjRoot, "src", 0, time);
        Directory lib = new Directory(prjRoot, "lib", 0, time);
        Directory test = new Directory(prjRoot, "test", 0, time);

        File a = new File(src, "a", 50, time);
        File b = new File(src, "b", 50, time);
        File c = new File(lib, "c", 50, time);

        Directory test_src= new Directory(test, "src", 0, time);
        File d = new File(test_src, "d", 50, time);

        Link y = new Link(prjRoot,"y",4, LocalDateTime.now(),test_src);

        prjRoot.appendChild(src);
        prjRoot.appendChild(lib);
        prjRoot.appendChild(test);
        prjRoot.appendChild(y);


        src.appendChild(a);
        src.appendChild(b);

        lib.appendChild(c);

        test.appendChild(test_src);
        test_src.appendChild(d);

        FileSystem fs = FileSystem.getFileSystem();
        fs.appendRootDir(prjRoot);
        return fs; 
    }
}
