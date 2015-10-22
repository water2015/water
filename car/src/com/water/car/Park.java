package com.water.car;

import com.water.car.Car.Orientation;

public class Park {
	
	static Park park = new Park();
	
	private Park() {}

	private int[][] dimension = new int[4][4];
	
	public void park(Car car, String command) {
		String[] commands = command.split(";");
		
		for(String one : commands) {
			String[] ops = one.split("\\|");
			int movements = Integer.parseInt(ops[0]);
			Orientation orientation = Orientation.getOrientationByName(ops[1]);
			
			String position = orientation.move(movements, car, dimension);
			System.out.println("Car is parking in the position " + position);
		}
	}
	
	public static Park getInstance() {
		return park;
	}
}
