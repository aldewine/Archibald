package com.archibald.domain;

public class Stage {
	private Archibald archibald;
	private Table table;
	
	public Stage(Archibald archibald, Table table) {
		super();
		if(table.getX() < archibald.getPosX() ||
		   table.getY() < archibald.getPosY()) {
			throw new IllegalStateException("Archibald can not be located outside of the table.");
		}
		this.archibald = archibald;
		this.table = table;
	}
	public Archibald getArchibald() {
		return archibald;
	}
	public void setArchibald(Archibald archibald) {
		this.archibald = archibald;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	
}
