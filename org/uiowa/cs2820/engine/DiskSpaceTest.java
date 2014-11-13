package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class DiskSpaceTest {

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
			test = DiskSpace.readArea(0,8);
		} catch (IOException e) {
			System.out.println("Read Error");
			e.printStackTrace();
			System.out.println(e);
		}
		assertEquals(test,"abcdef");
	}



	


@Test
public void readTest() {
	fail("Not yet implemented");
}

}
