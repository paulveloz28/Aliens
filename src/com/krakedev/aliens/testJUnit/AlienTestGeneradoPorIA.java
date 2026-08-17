package com.krakedev.aliens.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.aliens.Alien;

public class AlienTestGeneradoPorIA {
	
	@Test
    void debeAjustarTamanioMenorAlMinimo() {

        Alien alien = new Alien(0, "Verde");

        assertEquals(5, alien.getTamanio());
    }

    @Test
    void debeAjustarTamanioMayorAlMaximo() {

        Alien alien = new Alien(100, "Azul");

        assertEquals(30, alien.getTamanio());
    }

    @Test
    void debeMantenerTamanioDentroDelRango() {

        Alien alien = new Alien(18, "Rojo");

        assertEquals(18, alien.getTamanio());
        assertEquals("Rojo", alien.getColor());
    }

    @Test
    void debeCalcularPreciosConElTamanioAjustado() {

        Alien alien = new Alien(40, "Verde");

        assertEquals(6.0, alien.getPrecioCuerpo(), 0.0001);
        assertEquals(3.0, alien.getPrecioExtremidad(), 0.0001);
        assertEquals(1.5, alien.getPrecioOjo(), 0.0001);
    }

    @Test
    void debeAceptarDiezExtremidades() {

        Alien alien = new Alien(20, "Verde");

        assertTrue(alien.agregarBrazos(5));
        assertTrue(alien.agregarPiernas(5));

        assertEquals(5, alien.getNumeroBrazos());
        assertEquals(5, alien.getNumeroPies());
    }

    @Test
    void noDebePermitirMasDeDiezExtremidades() {

        Alien alien = new Alien(20, "Azul");

        assertTrue(alien.agregarBrazos(5));

        assertFalse(alien.agregarPiernas(6));

        assertEquals(5, alien.getNumeroBrazos());
        assertEquals(0, alien.getNumeroPies());
    }

    @Test
    void debeAplicarLimiteDeOjosSegunElTamanio() {

        Alien alienPequeno = new Alien(10, "Verde");
        Alien alienMediano = new Alien(11, "Azul");
        Alien alienGrande = new Alien(21, "Rojo");

        assertTrue(alienPequeno.agregarOjos(3));
        assertTrue(alienMediano.agregarOjos(5));
        assertTrue(alienGrande.agregarOjos(7));

        assertFalse(alienPequeno.agregarOjos(1));
        assertFalse(alienMediano.agregarOjos(1));
        assertFalse(alienGrande.agregarOjos(1));
    }

    @Test
    void unIntentoFallidoNoDebeModificarLaCantidad() {

        Alien alien = new Alien(10, "Verde");

        assertTrue(alien.agregarBrazos(10));

        assertFalse(alien.agregarPiernas(1));

        assertEquals(10, alien.getNumeroBrazos());
        assertEquals(0, alien.getNumeroPies());
    }

    @Test
    void debeCalcularCorrectamenteElPrecioTotal() {

        Alien alien = new Alien(20, "Verde");

        assertTrue(alien.agregarBrazos(2));
        assertTrue(alien.agregarPiernas(2));
        assertTrue(alien.agregarOjos(3));

        // Precio cuerpo = 20 * 0.20 = 4
        // 4 extremidades = 4 * 2 = 8
        // 3 ojos = 3 * 1 = 3
        // Precio total = 15

        assertEquals(15.0, alien.getPrecioTotal(), 0.0001);
    }

    @Test
    void debeActualizarAutomaticamenteElPrecioTotal() {

        Alien alien = new Alien(10, "Verde");

        // Cuerpo = 2
        // 2 brazos = 2
        assertTrue(alien.agregarBrazos(2));
        assertEquals(4.0, alien.getPrecioTotal(), 0.0001);

        // 1 pierna adicional
        assertTrue(alien.agregarPiernas(1));
        assertEquals(5.0, alien.getPrecioTotal(), 0.0001);

        // 2 ojos adicionales
        assertTrue(alien.agregarOjos(2));
        assertEquals(6.0, alien.getPrecioTotal(), 0.0001);
    }

    @Test
    void debeProbarUnCasoCombinado() {

        Alien alien = new Alien(25, "Morado");

        assertTrue(alien.agregarBrazos(3));
        assertTrue(alien.agregarPiernas(4));
        assertTrue(alien.agregarOjos(6));

        assertEquals(3, alien.getNumeroBrazos());
        assertEquals(4, alien.getNumeroPies());
        assertEquals(6, alien.getNumeroOjos());

        // Cuerpo = 25 * 0.20 = 5
        // 7 extremidades * 2.5 = 17.5
        // 6 ojos * 1.25 = 7.5
        // Total = 30

        assertEquals(30.0, alien.getPrecioTotal(), 0.0001);
    }
}
