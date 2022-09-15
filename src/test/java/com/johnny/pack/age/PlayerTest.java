package com.johnny.pack.age;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayerTest {

    private Player objectUnderTest;

    @BeforeEach
    public void setup(){
        objectUnderTest = new Player("Jekk", "Baerr",
                32, 70, 185,
                "Center Field", 150_000.43);
    }


//    @Test
//    @DisplayName("All players from DB")
//    public void selectAllPlayersFromDatabase(){
//        when(pq.getAllPlayers()).thenReturn(playerList);
//        List<Player> newList = player.getAllPlayers();
//        assertEquals(3, newList.size());
//        assertEquals("Jack", newList.get(2).getFirstName());
//
//    }

}