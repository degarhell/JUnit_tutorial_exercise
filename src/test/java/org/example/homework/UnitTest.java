package org.example.homework;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UnitTest {

    @Test
    void moveThrowsExceptionWhenFuelBelow0() {
        //given
        Coordinates coordinates1 = new Coordinates(6, 4);
        Unit unit1 = new Unit(coordinates1, 9, 5);
        //when
        //then
        assertThrows(IllegalStateException.class, () -> unit1.move(4,6));
    }

    @Test
    void moveReturnsLoweredAmountOfFuel() {
//        given
        Unit unit1 = new Unit(new Coordinates(4, 4), 12, 2);
//        when
        unit1.move(1,0);
//        then
        assertThat(unit1.getFuel(), is(11));
    }
    @Test
    void movedUnitShouldReturnNewCoordinates() {
//        given
        Unit unit1 = new Unit(new Coordinates(4, 4), 12, 2);
//        when
        Coordinates coordinatesAfterMove = unit1.move(1,0);
//        then
        assertThat(coordinatesAfterMove, equalTo(new Coordinates(5,4)));

    }

    @Test
    void fillingUpTheTankShouldNotExceedMaxFuelLimit() {
//        given
        Unit unit1 = new Unit(new Coordinates(3,3), 10, 2);
//        when
        unit1.tankUp();
//        then
        assertThat(unit1.getFuel(), is(lessThan(11)));
    }

    @Test
    void loadingToMuchCargoThrowsIllegalStateException() {
//        given
        Unit unit1 = new Unit(new Coordinates(3,3), 10, 2);
//        when
//        then
        assertThrows(IllegalStateException.class, () -> unit1.loadCargo(new Cargo("Zupa", 3)));
    }



    @Test
    void unloadCargo() {
//        given
        Unit unit1 = new Unit(new Coordinates(3,3), 10, 10);
        Cargo c1 = new Cargo("Zupa", 3);
        Cargo c2 = new Cargo("Kurczak", 4);
        Cargo c3 = new Cargo("Jabłka",2);
//        when
        unit1.loadCargo(c1);
        unit1.loadCargo(c2);
        unit1.loadCargo(c3);
        unit1.unloadCargo(c2);
//        then
        assertThat(unit1.getCargo(), not(hasItem(c2)));
    }

    @Test
    void unloadAllCargo() {
//        given
        Unit unit1 = new Unit(new Coordinates(3,3), 10, 10);
        Cargo c1 = new Cargo("Zupa", 3);
        Cargo c2 = new Cargo("Kurczak", 4);
        Cargo c3 = new Cargo("Jabłka",2);
//        when
        unit1.unloadAllCargo();
//        then
        assertThat(unit1.getLoad(), is(0));
    }
}