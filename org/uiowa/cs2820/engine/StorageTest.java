package org.uiowa.cs2820.engine;


import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Test;


public class StorageTest{
	Storage S = new Storage();

	@Test
	public void test() throws IOException, ClassNotFoundException{
		Node node1 = new Node(Converter.convert("key1"),"stringid1");
		Node node2 = new Node(Converter.convert("key2"),"stringid2");
		S.add(node1);
		S.add(node2);
		
		assertEquals(S.find(Converter.convert("key1")).Identifiers.get(0), "stringid1");
		assertEquals(S.find(Converter.convert("key2")).Identifiers.get(0), "stringid2");
		
		S.removekey(Converter.convert("key1"));
		
		assertEquals(S.find(Converter.convert("key2")).prev, -1);
	}
}
