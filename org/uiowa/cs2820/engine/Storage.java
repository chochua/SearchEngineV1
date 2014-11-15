package org.uiowa.cs2820.engine;

import java.io.IOException;

public class Storage{

	
	Allocate A = new Allocate();		
		
	private Node get(int location){
		Node returndata = null;
		try {
			returndata = (Node)Converter.revert(DiskSpace.readArea(location));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returndata;
		}
	
	
	
	private void put(int location, Node node){
		byte[] writedata;
		writedata = Converter.convert(node);
		try {
			DiskSpace.writeArea(writedata, location);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void add(Node node){
				
		int newlocation = A.allocateArea();		
		if (DiskSpace.Size()>0){
			
			//adjust the previous last node in the array.
			int i = 0;
			while (i >= 0){
				i = get(i).next;
			}
			Node end = get(i);
			int originalsize = Converter.convert(end).length;
			end.next = newlocation;
			int newsize = Converter.convert(end).length;
			
			//ensure no overlapping of bytearrays in the file.
			if (newsize>originalsize){
				removekey(end.Key);
				add(end);
			}
			else{
				put(end.location, end);
			}
			node.prev = end.location;
		}
		node.location = newlocation;
		put(newlocation, node);
	}
	
	
	public void del(byte[] key, String id){
		if (DiskSpace.Size()>0){
			int i = 0;
			//remove the node from the database, add the identifier, then re-add the node to prevent bytearray overlap.
			while (i >= 0){
				if (get(i).Key == key){
					get(get(i).prev).next = get(get(i).next).location;
					get(get(i).next).prev = get(get(i).prev).location;
				}
				i = get(i).next;
			}
			get(i).Identifiers.remove(id);
			add(get(i));
		}
	}
	
	public void removekey(byte[] key){
		if (DiskSpace.Size()>0){
			int i = 0;
			//remove the node from the database, add the identifier, then re-add the node to prevent bytearray overlap.
			while (i >= 0){
				if (get(i).Key == key){
					get(get(i).prev).next = get(get(i).next).location;
					get(get(i).next).prev = get(get(i).prev).location;
				}
				i = get(i).next;
			}
		}
	}
	
	public Node find(byte[] key){
		if (DiskSpace.Size()>0){
			int i = 0;
			while (i >= 0){
				if (get(i).Key == key){
					return get(i);
				}
				i = get(i).next;
			}
		}
		return null;
	}
}
