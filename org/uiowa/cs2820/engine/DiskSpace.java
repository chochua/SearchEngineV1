package org.uiowa.cs2820.engine;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.IOException;
public class DiskSpace {
	// DiskSpace using Random Access File
	//has ability to throw exceptions if needed
	
	
	//ArrayList<byte[]> database1 = new ArrayList<byte[]>();
	public static void writeArea(byte[] info, int location)
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
		int N = info.length;
		// suppose N is 825
		// next encode N into 2 bytes
		byte [] E = new byte[2];
		E[0] = (byte) (N / 256);
		E[1] = (byte) N;
		RAfile.write(E);
		RAfile.write(info);
		RAfile.close();	
	}
	public static byte[] readArea(int location) 
			throws IOException{
		String filepath = "diskspace.txt";
		File file = new File(filepath);
		// creates a new RAF with String A being the file path		
		RandomAccessFile RAfile = new RandomAccessFile(file,"r"); 
		
		RAfile.seek(location);
		byte [] E = new byte[2];
		RAfile.read(E);
		int N = (int)E[0];
		if (N < 0) N += 256; // Java has no unsigned
		N = N * 256;
		int M = (int)E[1];
		if (M < 0) M += 256; // stupid Java
		N = N + M;
		byte [] Z = new byte[N];
		RAfile.read(Z);
		RAfile.close();

		return Z;
		
	}
	
	public static int Size(){
		String filepath = "diskspace.txt";
		File file = new File(filepath);
		RandomAccessFile RAfile;
		try {
			RAfile = new RandomAccessFile(file,"r");
			int size = (int)RAfile.length();
			RAfile.close();
			return size;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return -1;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		} 
		
	}
}
