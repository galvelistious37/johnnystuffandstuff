package com.johnny.pack.age.city;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {

    private City objectUnderTestEmpyConstructor;
    private City objectUnderPopulatedConstructor;

    @BeforeEach
    void setup(){
        objectUnderTestEmpyConstructor = new City();
        objectUnderPopulatedConstructor = new City("New York", "NY");
    }

    @Test
    @DisplayName("Empty Constructor")
    void empytConstructorTest(){
        objectUnderTestEmpyConstructor.setId(1);
        objectUnderTestEmpyConstructor.setName("Detroit");
        objectUnderTestEmpyConstructor.setState("MI");
        String expected = "City{id=1, name='Detroit', state='MI'}";
        assertEquals(expected, objectUnderTestEmpyConstructor.toString());
    }



    @Test
    @DisplayName("Empty Constructor")
    void populatedConstructorTest(){
        objectUnderPopulatedConstructor.setId(2);
        assertEquals(2, objectUnderPopulatedConstructor.getId());
        assertEquals("New York", objectUnderPopulatedConstructor.getName());
        assertEquals("NY", objectUnderPopulatedConstructor.getState());
    }

}