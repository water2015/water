package com.water.car;


public interface Car {

	void move(String command);

	int getPositionX();

	int getPositionY();
	
	void setPostitionX(int x);
	
	void setPostionY(int y);

	Orientation getOrientation();

	enum Orientation {
		EAST("east") {
			@Override
			public String move(int movements, Car car,  int[][] dimension) {
				int fromX = car.getPositionX() - 1;
				int toX = fromX + movements;
				int toY = car.getPositionY() - 1;
				
				this.checkIllegal(movements, dimension, fromX, toX, toY, toY);
				dimension[toX][toY] = 1;
				car.setPostionY(toY);
				car.setPostitionX(toX);
				return new StringBuilder().append("[").append(toX).append(" , ").append(toY).append("]").toString();
			}
		}, SOUTH("south") {
			@Override
			public String move(int movements, Car car,  int[][] dimension) {
				int toX = car.getPositionX() - 1;
				int fromY = car.getPositionY() - 1;
				int toY = car.getPositionY() - 1 - movements;
				
				checkIllegal(movements, dimension, toX, toX, toY, fromY);
				
				dimension[toX][toY] = 1;
				car.setPostionY(toY);
				car.setPostitionX(toX);
				return new StringBuilder().append("[").append(toX).append(" , ").append(toY).append("]").toString();
			}
		}, WEST("west") {
			@Override
			public String move(int movements, Car car,  int[][] dimension) {
				int fromX = car.getPositionX() - 1;
				int toX = fromX - movements;
				int toY = car.getPositionY() - 1;
				
				checkIllegal(movements, dimension, toX, fromX, toY, toY);
				dimension[toX][toY] = 1;
				car.setPostionY(toY);
				car.setPostitionX(toX);
				return new StringBuilder().append("[").append(toX).append(" , ").append(toY).append("]").toString();
			}
		}, NORTH("north") {
			@Override
			public String move(int movements, Car car,  int[][] dimension) {
				int toX = car.getPositionX() - 1;
				int fromY = car.getPositionY() - 1;
				int toY = car.getPositionY() - 1 + movements;
				
				checkIllegal(movements, dimension, toX, toX, fromY, toY);
				
				dimension[toX][toY] = 1;
				car.setPostionY(toY);
				car.setPostitionX(toX);
				return new StringBuilder().append("[").append(toX).append(" , ").append(toY).append("]").toString();
			}
		};
		
		public abstract String move(int movements, Car car, int[][] dimension);
		private String orientation;
		
		Orientation(String orientation) {
			this.orientation = orientation;
		}
		
		static Orientation getOrientationByName(String name) {
			Orientation result = null;
			for(Orientation o : values()) {
				if(o.orientation.equalsIgnoreCase(name)) {
					result = o;
					break;
				}
			}
			
			if(result == null) {
				throw new IllegalArgumentException("The [" + name + "] is illegal.");
			}
			
			return result;
		}
		
		public void checkIllegal(int movements, int[][] dimension, int fromX, int toX,
				int fromY, int toY) {
			if(toY < 0 || toY >= dimension.length || toX < 0 || toX >= dimension.length) {
				throw new IllegalArgumentException("The "+orientation+" movements[" + movements + "] is illegal.");
			}
		}
	}
}
