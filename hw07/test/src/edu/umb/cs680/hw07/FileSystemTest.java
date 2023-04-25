package edu.umb.cs680.hw07;

	// import org.junit.jupiter.api.Test;
	// import static org.junit.jupiter.api.Assertions.*;

	// public class FileSystemTest 
	// {
	// 	@Test
	// 	void test_getFilesystem() {
	// 		FileSystem fs = FileSystem.getFileSystem();
	// 		assertEquals(fs, FileSystem.getFileSystem());
			
	// 	}

	// 	@Test
	// 	public void getFileSystemisNotNull() {
	// 		assertNotNull(FileSystem.getFileSystem());
	// 	}
		
	// }



	import static org.junit.jupiter.api.Assertions.*;

	import org.junit.jupiter.api.DisplayName;
	import org.junit.jupiter.api.Test;
	
	class FileSystemTest {
	
		@Test
		@DisplayName("Test if getFileSystem returns the same object")
		void testGetFileSystemReturnsSameObject() {
			FileSystem fs = FileSystem.getFileSystem();
			assertSame(fs, FileSystem.getFileSystem());
		}
	
		@Test
		@DisplayName("Test if getFileSystem returns a non-null object")
		void testGetFileSystemReturnsNonNullObject() {
			assertNotNull(FileSystem.getFileSystem());
		}
	}
	
