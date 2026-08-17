package com.krakedev.aliens.test;

import com.krakedev.aliens.Alien;

public class TestConstructores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Alien alien1 = new Alien(3, "Verde");
		Alien alien2 = new Alien(35, "Azul");
		
		System.out.println("---- ALIEN 1 ----");
		alien1.imprimir();
		
		System.out.println();
		
		System.out.println("---- ALIEN 2 ----");
		alien2.imprimir();

	}

}
