package com.johnny.pack.age.city;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {

    private City objectUnderTestEmptyConstructor;
    private City objectUnderTestPopulatedConstructor;

    @BeforeEach
    void setup(){
        objectUnderTestEmptyConstructor = new City();
        objectUnderTestPopulatedConstructor = new City("Portland", 1);
    }

    @Test
    @DisplayName("Empty Constructor")
    void emptyConstructorTest(){
        objectUnderTestEmptyConstructor.setId(1);
        objectUnderTestEmptyConstructor.setName("Denver");
        objectUnderTestEmptyConstructor.setStateId(5);
        String expected = "City{id=1, name='Denver', stateId='5'}";
        assertEquals(expected, objectUnderTestEmptyConstructor.toString());
    }



    @Test
    @DisplayName("Populated Constructor")
    void populatedConstructorTest(){
        objectUnderTestPopulatedConstructor.setId(2);
        assertEquals(2, objectUnderTestPopulatedConstructor.getId());
        assertEquals("Portland", objectUnderTestPopulatedConstructor.getName());
        assertEquals(1, objectUnderTestPopulatedConstructor.getStateId());
    }

}