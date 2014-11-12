package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class CheckpointTest {

	/*
	 * Use Checkpoint.save() and Checkpoint.restore() to 
	 * ensure that the object given to Checkpoint.save()
	 * is equivalent to the object returned after
	 * using Checkpoint.restore()
	 */
	
	@Test
	public void test() {
		ArrayList<String> x = new ArrayList<>(Arrays.asList("hello", "world"));
		Checkpoint.save(x);
		assertEquals(Checkpoint.restore("checkpoint.txt"),x);
	}

}
