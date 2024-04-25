package org.example.homework;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    @Test
    void CoordinatesShouldThrowIAExceptionWhenXandYAbove100() {
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(0, 101));
    }

    @Test
    void CoordinatesShouldThrowIAExceptionWhenXandYBelow0() {
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(-1, 5));
    }

    @Test
    void copyShouldReturnNewObject () {
        //given
            Coordinates coordinates1 = new Coordinates(5,6);
        //when
        Coordinates coordinates2 = Coordinates.copy(coordinates1, 0,0);
        //then
        assertThat(coordinates2, equalTo(coordinates1));
        assertThat(coordinates2, not(sameInstance(coordinates1)));
    }

    @Test
    void copyShouldReturnAddedCoordinates () {
        //given
        Coordinates coordinatesOG = new Coordinates(10, 10);
        //when
        Coordinates coordinatesCopy = Coordinates.copy(coordinatesOG, -3, -3);
        //then
        assertThat(coordinatesCopy.getX(), equalTo(7));
        assertThat(coordinatesCopy.getY(), equalTo(7));
    }
}