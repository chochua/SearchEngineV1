// Author: Nick Evans

package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import org.junit.Before;

public class AllocateTest {
	
	private Allocate testAllocate;

	public void remove_file() {
	File file = new File("checkpoint.txt");
	if (file.exists()) {
		file.delete();
	}
	}
	
	
	@Test
	public void empty_allocate_test() {
		remove_file();
		testAllocate = new Allocate();
		int area = testAllocate.allocateArea();
		assertEquals(area, 0);
	}
	
	@Test
	public void allocate_area_test() {
		remove_file();
		testAllocate = new Allocate();
		int area = 0;
		for (int i=0; i <= 10; i++) {
			area = testAllocate.allocateArea();
		}
		assertEquals(area, 10);
	}
	
	@Test
	public void free_area_test() {
		remove_file();
		testAllocate = new Allocate();
		int area = 0;
		for (int i=0; i < 10; i++) {
			area = testAllocate.allocateArea();
		}
		testAllocate.freeArea(4);
		testAllocate.freeArea(9);
		assertEquals(testAllocate.size(), 8);
	}

	
	@Test
	public void restore_file_test() {
		remove_file();
		testAllocate = new Allocate();
		int area = 0;
		for (int i=0; i < 10; i++) {
			area = testAllocate.allocateArea();
		}
		// Reinstantiate testAllocate to test restore()
		testAllocate = new Allocate();
		assertEquals(testAllocate.size(), 10);
	}
}
