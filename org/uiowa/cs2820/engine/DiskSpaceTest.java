package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class DiskSpaceTest {
	
//Tests Write by initializing a new file and testing its existence.
@Test
public void Testfirst(){
	try {
		byte [] string1 = "Testing".getBytes();
		DiskSpace.writeArea(string1, 50);
	} catch (IOException e) {
		System.out.println("Error Writing in Test 1");
		e.printStackTrace();
		System.out.println(e);
	}
	String filepath = "diskspace.txt";
	File file = new File(filepath);
	
	assertEquals(file.exists(),true);
}
		
	
	
	//tests the write and read at the same time.
	//If there is an error in either portion, an error and message is displayed.
	@Test
	public void Testsecond() {
		byte[] test = null;
		try {
			byte [] string1 = "abcdef".getBytes();
			DiskSpace.writeArea(string1, 0);
		} catch (IOException e) {
			System.out.println("Write Error");
			e.printStackTrace();
			System.out.println(e);
		}
		
		try {
			test = DiskSpace.readArea(0,6);
		} catch (IOException e) {
			System.out.println("Read Error");
			e.printStackTrace();
			System.out.println(e);
		}
		
		System.out.println("Reached assert");
		assertEquals(test.length,6);
	}
}


