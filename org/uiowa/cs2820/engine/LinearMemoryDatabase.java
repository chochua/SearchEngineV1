package org.uiowa.cs2820.engine;

public class LinearMemoryDatabase implements Database {
  
  Storage store = new Storage();
  
  public Node fetch(byte[] key) {
	  return store.find(key);
    }
  
  public void store(byte[] key, String id) {
	  Node addNode = new Node(key, id);
	  store.add(addNode);
    }
  
  public void delete(byte[] key, String id) {
	  store.del(key);
    }
  }
	  
