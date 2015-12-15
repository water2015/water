package com.water.patterns;

public class FactoryMethod {

}

interface Creator {
	public Product create();
}

class ConcreteCreator implements Creator {

	@Override
	public Product create() {
		System.out.println("ConcreteProduct Creator");
		return new ConcreteProduct();
	}
}

interface Product {
}

class ConcreteProduct implements Product {

}