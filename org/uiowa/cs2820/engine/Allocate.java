package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.BitSet;

public class Allocate {

	private BitSet allocationSet;

	
	public Allocate() {
		try {
			allocationSet = (BitSet) Checkpoint.restore("checkpoint.txt");
		} 
		catch (IOException ex) {
			allocationSet = new BitSet();
		}
			
	}
	
	// Returns a new area of the file in which to store an object
	public int allocateArea() {
		 
		int areaNumber;
		if (allocationSet.isEmpty()) {
			areaNumber = 0;
		} else {
			areaNumber = allocationSet.nextClearBit(0);
		}
		
		allocationSet.set(areaNumber);
		
		Checkpoint.save(allocationSet);	
		return areaNumber;
	}

	// Marks an area of the database as free
	// Takes as a parameter an area of the file to be freed
	public void freeArea(int areaNumber) {
		//To throw an exception if no areas are allocated or no?
		allocationSet.clear(areaNumber);
		Checkpoint.save(allocationSet);
	}
	
	public int size() {
		return allocationSet.cardinality();
	}
}
