package com.krakedev.aliens.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.aliens.Alien;

public class AlienTestJUnit {

	@Test
	void debeAsignarCorrectamenteLosAtributos() {

		Alien alien = new Alien(15, "Rojo");

		assertEquals(15, alien.getTamanio());
		assertEquals("Rojo", alien.getColor());
		assertEquals(0, alien.getNumeroOjos());
		assertEquals(0, alien.getNumeroBrazos());
		assertEquals(0, alien.getNumeroPies());
	}

	@Test
	void debeAjustarTamanioMinimo() {

		Alien alien = new Alien(2, "Verde");

		assertEquals(5, alien.getTamanio());
	}

	@Test
	void debeAjustarTamanioMaximo() {

		Alien alien = new Alien(40, "Azul");

		assertEquals(30, alien.getTamanio());
	}

	@Test
	void debeCalcularLosPreciosSegunElTamanio() {

		Alien alien = new Alien(20, "Rojo");

		assertEquals(4.0, alien.getPrecioCuerpo(), 0.0001);
		assertEquals(2.0, alien.getPrecioExtremidad(), 0.0001);
		assertEquals(1.0, alien.getPrecioOjo(), 0.0001);
	}

	@Test
	void debeAceptarLosLimitesDelTamanio() {

		Alien alienMinimo = new Alien(5, "Verde");
		Alien alienMaximo = new Alien(30, "Azul");

		assertEquals(5, alienMinimo.getTamanio());
		assertEquals(30, alienMaximo.getTamanio());
	}

}
