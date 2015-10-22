package com.water.car;

public class BMWCar implements Car {

	private int positionX;
	private int positionY;
	private Orientation orientation;
	
	public BMWCar() {
		this.positionX = 1;
		this.positionY = 1;
		this.orientation = Orientation.NORTH;
	}
	public BMWCar(int positionX, int positionY, Orientation orientation) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.orientation = orientation;
	}

	@Override
	public void move(String command) {
		Park.getInstance().park(this, command);
	}

	@Override
	public int getPositionX() {
		return positionX;
	}

	@Override
	public int getPositionY() {
		return positionY;
	}

	@Override
	public Orientation getOrientation() {
		return orientation;
	}
	@Override
	public void setPostitionX(int x) {
		this.positionX = x + 1;
	}
	@Override
	public void setPostionY(int y) {
		this.positionY = y + 1;
	}
	
}
