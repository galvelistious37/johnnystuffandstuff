package com.johnny.pack.age;

import com.johnny.pack.age.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PlayerTest {

    private Player objectUnderTest;

    @BeforeEach
    public void setup(){
        objectUnderTest = new Player("Jekk", "Baerr",
                32, 70, 185,
                "Center Field", 150_000.43);
    }


    @Test
    @DisplayName("Constructor with parameters")
    public void instantiateObjectFromConstructorWithParameters(){
        assertEquals("Jekk", objectUnderTest.getFirstName());
    }

    @Test
    @DisplayName("Player toString")
    void playerToStringTest(){
        String expected = "PlayerID: 0\n" +
                "Team ID: 0\n" +
                "First Name: Jekk\n" +
                "Last Name: Baerr\n" +
                "Age: 32\n" +
                "Height: 70\n" +
                "Weight: 185\n" +
                "Position: Center Field\n" +
                "Salary: $150,000.43";
        assertEquals(expected, objectUnderTest.toString());
    }

}