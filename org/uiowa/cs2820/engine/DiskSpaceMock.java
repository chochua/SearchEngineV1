package org.uiowa.cs2820.engine;

import java.util.ArrayList;

//Mock class for diskspace.

public final class DiskSpaceMock{
	
	ArrayList<byte[]> tempdatabase = new ArrayList<byte[]>();
	
	public void write(int location, byte[] data){
		tempdatabase.set(location, data);
	}
	
	public byte[] read(int location){
		return tempdatabase.get(location);
	}
}
