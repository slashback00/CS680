package edu.umb.cs680.hw07;




	import static org.junit.jupiter.api.Assertions.*;

	import org.junit.jupiter.api.Test;
	
	public class FileSystemTest {
	
		@Test
		public void testFileSystemIsSingletonClass() {
			FileSystem fs1 = FileSystem.getFileSystem();
			FileSystem fs2 = FileSystem.getFileSystem();	
			assertSame(fs1, fs2);
		}
	
		@Test
    	public void testGetFileSystemReturnsNonNullObject() {
        FileSystem fs = FileSystem.getFileSystem();
        assertNotNull(fs);
    }
}
	

