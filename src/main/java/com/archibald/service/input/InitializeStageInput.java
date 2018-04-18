package com.archibald.service.input;

import com.archibald.domain.Direction;

public class InitializeStageInput {
	private int dimensionX;
	private int dimensionY;
	private int posX;
	private int posY;
	private Direction direction;
	
	public int getDimensionX() {
		return dimensionX;
	}
	public void setDimensionX(int dimensionX) {
		this.dimensionX = dimensionX;
	}
	public int getDimensionY() {
		return dimensionY;
	}
	public void setDimensionY(int dimensionY) {
		this.dimensionY = dimensionY;
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
