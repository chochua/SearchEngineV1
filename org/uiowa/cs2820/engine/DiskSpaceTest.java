package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class DiskSpaceTest {
	//tests the write and read at the same time.
	//If there is an error in either portion, an error and message is displayed.
	@Test
	public void Test() {
		byte[] test = null;
		try {
			DiskSpace.writeArea("abcdef", 0);
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
		System.out.println(test);
		System.out.println("Reached assert");
		assertEquals(test,"abcdef");
		
	}



	



}
