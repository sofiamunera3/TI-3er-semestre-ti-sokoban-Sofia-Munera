package org.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class TargetTest {

    @Test
    void isOccupiedTest_debeRetornarFalseCuandoNoHayCajaSobreElObjetivo() {
        Target target = new Target(new Coordinates(2, 3));

        boolean resultado = target.isOccupied();

        assertFalse(resultado);
    }
}
