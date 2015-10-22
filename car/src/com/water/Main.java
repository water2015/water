package com.water;

import com.water.car.BMWCar;
import com.water.car.Car;

public class Main {

	public static void main(String[] args) {
		Car car = new BMWCar();
		
		// command: movements|orientation;movements|orientation
		car.move("3|east;2|north;1|south;2|west");
	}
}