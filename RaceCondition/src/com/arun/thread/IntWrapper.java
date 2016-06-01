package com.arun.thread;

public class IntWrapper {

	private int val;
	
	public IntWrapper(int v) {
		this.val = v;
	}

	public int getVal() {
		return val;
	}

	public void incrementVal() {
		val = val + 1;
	}
	
	public void setVal(int v) {
		val = v;
	}
}
