//Jake Sellers 00595842
package org.uiowa.cs2820.engine;
import java.io.File.*;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
public class DiskSpace {
	// DiskSpace using Random Access File
	//has ability to throw exceptions if needed
	
	//ArrayList<byte[]> database1 = new ArrayList<byte[]>();
	public static void writeArea(String info, int location)
		throws IOException{
		//Creates the file path
		String filepath = "diskspace.txt";
		File file = new File(filepath);
		
	
			// first time, file doesn't exist
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("file created");
			}
		
		
		
		RandomAccessFile RAfile = new RandomAccessFile(file,"rw");
		//looks for files location
		RAfile.seek(location);
		//writes to file with data given by info
		RAfile.write(info.getBytes());
		RAfile.close();

		
		
	}
	public static byte[] readArea(int location, int size) 
			throws IOException{
		String filepath = "diskspace.txt";
		File file = new File(filepath);
		// creates a new RAF with String A being the file path		
		RandomAccessFile RAfile = new RandomAccessFile(file,"r"); 
		//locates position of file given by int location
		RAfile.seek(location); 										
		//creates a new byte array of size of file
		byte[] data = new byte[size];	
		//reads data after starting point of given size
		RAfile.read(data);
		RAfile.close();

		//returns searched for data
		return data;
		
	}
	}

	
