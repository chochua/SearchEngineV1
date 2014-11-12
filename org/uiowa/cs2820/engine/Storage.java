package org.uiowa.cs2820.engine;

import java.util.ArrayList;

public class Storage{

	
	DiskSpaceMock D = new DiskSpaceMock();
	
	//loads the disk into memory
	public ArrayList<Node> loadRAM(){
		ArrayList<Node> RAM = new ArrayList<Node>();
		try{
			RAM.add(get(0)); //sets the first Node
			int next = RAM.get(0).next;
			while (next>=0){
				Node newnode = get(next);
				next = newnode.next;
				RAM.add(newnode);
			}
		}
		catch (IndexOutOfBoundsException e){
			Node nullnode = new Node(Converter.convert(null), "null");
			nullnode.location = 0;
			put(0, nullnode);
		}
		
		return RAM;
	}
	
	private Node get(int location){
		byte[] readdata = D.read(location);
		return (Node)Converter.revert(readdata);
	}
	
	private void put(int location, Node node){
		byte[] writedata = Converter.convert(node);
		D.write(location, writedata);
	}
	
	public void add(Node node){
		ArrayList<Node> RAM = loadRAM();
		node.location = allocateMock();
		Node oldlast = RAM.get(RAM.size());
		oldlast.next = node.location;
		node.prev = oldlast.location;
		put(node.location, node);
	}
	
	public void del(Node node){
		ArrayList<Node> RAM = loadRAM();
		for (Node i : RAM){
			if ((i.Key == node.Key)&&(i.Identifiers == node.Identifiers)){
				get(i.next).prev = get(i.prev).location;
				get(i.prev).next = get(i.next).location;
			}
		}		
	}
	
	
	public int allocateMock(){
		return D.tempdatabase.size()-1;
	}
}