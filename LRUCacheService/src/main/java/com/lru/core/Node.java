package com.lru.core;


public class Node {
	
    public int key; 
    public int value; 
    public Node pre; 
    public Node next; 
  
    public Node(int key, int value) 
    { 
        this.key = key; 
        this.value = value; 
    }
    
	public void setKey(int key) {
		this.key = key;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public int getValue() {
		return value;
	}


	
}
