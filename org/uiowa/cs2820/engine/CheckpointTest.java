package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.BitSet;

import org.junit.Test;

public class CheckpointTest {

	/*
	 * Use Checkpoint.save() and Checkpoint.restore() to 
	 * ensure that the object given to Checkpoint.save()
	 * is equivalent to the object returned after
	 * using Checkpoint.restore()
	 */
	
	@Test
	public void test() throws IOException {
		BitSet bits = new BitSet();
		bits.set(1000001);
		Checkpoint.save(bits);
		assertEquals(Checkpoint.restore("checkpoint.txt"),bits);
	}

}
