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
        objectUnderTestPopulatedConstructor = new City("New York", "NY");
    }

    @Test
    @DisplayName("Empty Constructor")
    void empytConstructorTest(){
        objectUnderTestEmptyConstructor.setId(1);
        objectUnderTestEmptyConstructor.setName("Detroit");
        objectUnderTestEmptyConstructor.setState("MI");
        String expected = "City{id=1, name='Detroit', state='MI'}";
        assertEquals(expected, objectUnderTestEmptyConstructor.toString());
    }



    @Test
    @DisplayName("Empty Constructor")
    void populatedConstructorTest(){
        objectUnderTestPopulatedConstructor.setId(2);
        assertEquals(2, objectUnderTestPopulatedConstructor.getId());
        assertEquals("New York", objectUnderTestPopulatedConstructor.getName());
        assertEquals("NY", objectUnderTestPopulatedConstructor.getState());
    }

}