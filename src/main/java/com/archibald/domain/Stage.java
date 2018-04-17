package com.archibald.domain;

public class Stage {
	private Robot robot;
	private Table table;
	
	public Stage(Robot robot, Table table) {
		super();
		if(table.getX() < robot.getPosX() ||
		   table.getY() < robot.getPosY()) {
			throw new IllegalStateException("Archibald can not be located outside of the table.");
		}
		this.robot = robot;
		this.table = table;
	}
	public Robot getRobot() {
		return robot;
	}
	public void setRobot(Robot robot) {
		this.robot = robot;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	
}
