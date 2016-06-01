package com.arun.thread;

public class IntWrapperSafe {

	private int val;
	
	public IntWrapperSafe(int v) {
		this.val = v;
	}

	public int getVal() {
		return val;
	}

	public synchronized void incrementVal() {
		val = val + 1;
	}
	
	public void setVal(int v) {
		val = v;
	}
}
