package org.uiowa.cs2820.engine;


import static org.junit.Assert.*;


import java.util.ArrayList;





import org.junit.Test;


public class StorageTest{
	Storage S = new Storage();



	@Test
	public void test(){
		Node node1 = new Node(Converter.convert("key1"),"stringid1");
		Node node2 = new Node(Converter.convert("key2"),"stringid2");
		S.add(node1);
		S.add(node2);
		ArrayList<Node> RAM = S.getRAM();
		assertEquals(Converter.revert(node1.Key),RAM.get(1).Key);
		assertEquals(node1.Identifiers,RAM.get(1).Identifiers);
		assertEquals(Converter.revert(node2.Key),RAM.get(2).Key);
		assertEquals(node2.Identifiers,RAM.get(2).Identifiers);
		
		
	}
	
}