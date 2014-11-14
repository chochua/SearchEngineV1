package org.uiowa.cs2820.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Storage{

	
	Allocate A = new Allocate();
	ArrayList<Node> RAM = new ArrayList<Node>();
	
	
	//loads the disk into memory
	public void loadRAM(){
		String filepath = "arraysave.txt";
		File file = new File(filepath);
		
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		byte[] ba = new byte[(int) file.length()];

		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			fis.read(ba);
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RAM = (ArrayList<Node>)Converter.revert(ba); 
	}
	
	
	public ArrayList<Node> getRAM(){
		loadRAM();
		return RAM;
	}
	
	
	private Node get(int location){
		loadRAM();
		int size = -1;
		
		for (Node node : RAM){
			if (node.location == location){
				size = node.size;
				break;
			}
		}	
		
		byte[] readdata = new byte[size];
		try {
			readdata = DiskSpace.readArea(location, size);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (Node)Converter.revert(readdata);
	}
	
	
	
	private void put(int location, Node node){
		byte[] writedata = new byte[node.size];
		writedata = Converter.convert(node);
		try {
			DiskSpace.writeArea(writedata, location);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void add(Node node){
		loadRAM();
		node.location = A.allocateArea();
		
		if (RAM.size()>0){
			Node oldlast = RAM.get(RAM.size()-1);
			oldlast.next = node.location;
			node.prev = oldlast.location;
			put(oldlast.location, oldlast);
		}
		put(node.location, node);
		saveRAM();
		
	}
	
	
	public void saveRAM() {
		String filepath = "arraysave.txt";
		File file = new File(filepath);		
		try {		
			// first time, file doesn't exist
			if (file.createNewFile()) {
				System.out.println("file created");
			}
		}
		catch (Exception ex) {
			System.out.println("Error");
		}	
		// byte array to write to file
		byte[] ba = new byte[(int) file.length()];
		ba = Converter.convert(RAM);  
		try {
			// write to file
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(ba);
			fos.close();
		}
		catch (Exception ex) {
			System.out.println("Error");
		}	
	}
	
	public void del(Node node){
		loadRAM();
		for (Node i : RAM){
			if ((i.Key == node.Key)&&(i.Identifiers == node.Identifiers)){
				get(i.next).prev = get(i.prev).location;
				get(i.prev).next = get(i.next).location;
			}
		}		
	}
}
