package org.uiowa.cs2820.engine;

import java.util.LinkedList;

public class Node {
  // Node is a basic unit in the database
  byte[] Key;  // Key of this node for lookup
  public LinkedList<String> Identifiers; 
  int size;    // for byte List
  
  int next = -1; //for Storage class
  int prev = -1; //for Storage class
  int location; //for Storage class
  
  Node(byte[] f, String id) {
	this.Key = f;
	this.Identifiers = new LinkedList<String>();
	this.Identifiers.add(id);
    }
  
  public void add(String id) { 
	Identifiers.remove(id);
	Identifiers.add(id);
    }
  
  public void del(String id) {
	Identifiers.remove(id);
    }
  

  public int getSize() {
	return Identifiers.size(); 
    }
  
  
  public LinkedList getIdentifiers() {
	  // have to call value storage
	  LinkedList getid = new LinkedList();
	  for (int i = 0; i < Identifiers.size(); i ++) { 
		  getid.add(Identifiers.get(i));
	  }
	  return getid; 
  }
  
  
  }
