package com.archibald.domain;

public class Robot {
	private int posX;
	private int posY;
	private Direction direction;
	
	public Robot(int posX, int posY, Direction direction) {
		super();
		if(posX < 0 || posY < 0) {
			throw new IllegalStateException("Archibald can not be placed in negative dimensions.");
		}
		this.posX = posX;
		this.posY = posY;
		this.direction = direction;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
