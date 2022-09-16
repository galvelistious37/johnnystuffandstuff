package com.johnny.pack.age.player;

import com.johnny.pack.age.utilsandprops.DBUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayerDAOTest {

    @Mock
    DBUtils dbUtilsMock;
    @Mock
    Connection conMock;
    @Mock
    PreparedStatement psMock;
    @Mock
    ResultSet rsMock;
    @Mock
    Player playerMock;

    @InjectMocks
    PlayerDAO objectUnderTest;

    @BeforeEach
    void setup() throws SQLException {
        when(dbUtilsMock.getMysqlConnection()).thenReturn(conMock);
        when(conMock.prepareStatement(anyString())).thenReturn(psMock);
    }

    @Test
    @DisplayName("Test insert")
    void testInsert() throws SQLException {
        when(psMock.executeUpdate()).thenReturn(1);
        assertEquals(1, objectUnderTest.insertPlayer(playerMock));
    }

    @Test
    @DisplayName("Test Select All")
    void testSelectAll() throws SQLException {
        when(psMock.executeQuery()).thenReturn(rsMock);
        when(rsMock.next()).thenReturn(true).thenReturn(false);
        when(rsMock.getInt("PLAYER_ID")).thenReturn(1);
        when(rsMock.getInt("TEAM_ID")).thenReturn(1);
        when(rsMock.getString("FIRST_NAME")).thenReturn("Jekk");
        when(rsMock.getString("LAST_NAME")).thenReturn("Baerr");
        when(rsMock.getInt("AGE")).thenReturn(35);
        when(rsMock.getInt("HEIGHT")).thenReturn(69);
        when(rsMock.getInt("WEIGHT")).thenReturn(185);
        when(rsMock.getString("POSITION")).thenReturn("Left Field");
        when(rsMock.getDouble("SALARY")).thenReturn(456123.25);

        String expected = "PlayerID: 1\n" +
                "Team ID: 1\n" +
                "First Name: Jekk\n" +
                "Last Name: Baerr\n" +
                "Age: 35\n" +
                "Height: 69\n" +
                "Weight: 185\n" +
                "Position: Left Field\n" +
                "Salary: $456,123.25";

        List<Player> testList = objectUnderTest.getAllPlayers();
        assertEquals(expected, testList.get(0).toString());
    }

    @Test
    @DisplayName("Select all throws exception")
    void selectAllThrowsExceptionTest() throws SQLException {
        when(psMock.executeQuery()).thenThrow(new SQLException("The fuck?"));
        assertThrows(SQLException.class,
                () -> {objectUnderTest.getAllPlayers();},
                "Throws Exception test");
    }

    @Test
    @DisplayName("Insert throws exception")
    void insertThrowsExceptionTest() throws SQLException {
        when(psMock.executeUpdate()).thenThrow(new SQLException("The fuck?"));
        assertThrows(SQLException.class,
                () -> {objectUnderTest.insertPlayer(playerMock);},
                "Throws Exception test");
    }

}