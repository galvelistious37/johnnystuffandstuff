package com.johnny.pack.age.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {
    private State objectUnderTest;

    @BeforeEach
    void setup(){
        objectUnderTest = new State();
    }

    @Test
    @DisplayName("State Getter/Setter and toString")
    void stateGetterSetterAndToString_test(){
        objectUnderTest.setStateId(1);
        objectUnderTest.setName("OR");
        String expected = "1, OR";
        assertEquals(expected, objectUnderTest.toString());
    }

}