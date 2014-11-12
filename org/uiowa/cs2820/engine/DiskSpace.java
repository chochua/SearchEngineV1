//Jake Sellers 00595842
package org.uiowa.cs2820.engine;
import java.io.RandomAccessFile;
import java.io.IOException;
public class DiskSpace {
	// DiskSpace using Random Access File
	//has ability to throw exceptions if needed
	
	//ArrayList<byte[]> database1 = new ArrayList<byte[]>();
	public static void writeArea(String A, String info, int location)
		throws IOException{
		//A is the file path
		RandomAccessFile file = new RandomAccessFile(A,"rw");
		//looks for files location
		file.seek(location);
		//writes to file with info
		file.write(info.getBytes());
		file.close();
		
		
	}
	public static byte[] readArea(String A, int i, int size) 
			throws IOException{
		// creates a new RAF with String A being the file path
		RandomAccessFile file = new RandomAccessFile(A,"r"); 
		//locates position of file given by int i
		file.seek(i); 										
		//creates a new byte array of size of file
		byte[] data = new byte[size];	
		//reads data after starting point of given size
		file.read(data);
		file.close();
		//returns searched for data
		return data;
		
	}
	}

	
