package com.luv2code.hibernate.demo;

public class Fruit implements Fruits, Company{
	public static void main(String[] args) {
		System.out.println(Fruits.APPLE);
		System.out.println(Company.APPLE);
		
		System.out.println(Fruits.APPLE == Company.APPLE);
	
	}

}