package com.archibald.domain;

public class Table {
	private int x;
	private int y;
	
	public Table(int x, int y) {
		super();
		if(x < 0 || y < 0) {
			throw new IllegalStateException("Table can not have negative dimensions.");
		}
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
