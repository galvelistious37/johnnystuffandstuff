package com.johnny.pack.age.state;

import com.johnny.pack.age.city.City;
import com.johnny.pack.age.utilsandprops.DBUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StateDAOTest {

    @Mock
    DBUtils dbUtilsMock;
    @Mock
    Connection conMock;
    @Mock
    PreparedStatement psMock;
    @Mock
    ResultSet rsMock;
    @Mock
    State stateMock;

    @InjectMocks
    StateDAO objectUnderTest;

    @Test
    @DisplayName("StateDAO insert States")
    void testInsertStates() throws SQLException, IOException {
        when(dbUtilsMock.getMysqlConnection()).thenReturn(conMock);
        when(conMock.prepareStatement(anyString())).thenReturn(psMock);
        when(psMock.executeUpdate()).thenReturn(1);
        String filename = "src\\test\\resources\\StatesTestFile.txt";
        assertEquals(2, objectUnderTest.insertStates(filename));
    }

    @Test
    @DisplayName("insertStates catches IOException")
    void insertStatesCatchesIOExceptionTest(){
        String filename = "src\\test\\resources\\fileDoesNotExist.txt";
        try{
            objectUnderTest.insertStates(filename);
        } catch (IOException | SQLException e){
            assertTrue(e instanceof IOException);
            String expected = "Problem reading from file";
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    @DisplayName("insertStateObject throws exception")
    void insertThrowsExceptionTest() throws SQLException {
        when(dbUtilsMock.getMysqlConnection()).thenReturn(conMock);
        when(conMock.prepareStatement(anyString())).thenReturn(psMock);
        when(psMock.executeUpdate()).thenThrow(new SQLException("SQLException and stuff"));
        SQLException exception = assertThrows(SQLException.class,
                () -> objectUnderTest.insertStateObject(stateMock), "Throws Exception test");
        String expected = "SQLException and stuff";
        assertEquals(expected, exception.getMessage());
    }

    @Test
    @DisplayName("insertStateByName returns int rows inserted")
    void testinsertStateByName() throws SQLException {
        when(dbUtilsMock.getMysqlConnection()).thenReturn(conMock);
        when(conMock.prepareStatement(anyString())).thenReturn(psMock);
        when(psMock.executeUpdate()).thenReturn(1);
        assertEquals(1, objectUnderTest.insertStateByName("punktown"));
    }

    @Test
    @DisplayName("insertStateByName throws SQLException")
    void insertStateByNameThrowsSQLExceptionTest() throws SQLException {
        when(dbUtilsMock.getMysqlConnection()).thenReturn(conMock);
        when(conMock.prepareStatement(anyString())).thenReturn(psMock);
        when(psMock.executeUpdate()).thenThrow(new SQLException("SQLException and stuff"));
        SQLException exception = assertThrows(SQLException.class,
                () -> objectUnderTest.insertStateByName("punktown"), "Throws Exception test");
        String expected = "SQLException and stuff";
        assertEquals(expected, exception.getMessage());
    }

    @Test
    @DisplayName("StateDAO Select All")
    void testSelectAll() throws SQLException {
        when(dbUtilsMock.getMysqlConnection()).thenReturn(conMock);
        when(conMock.prepareStatement(anyString())).thenReturn(psMock);
        when(psMock.executeQuery()).thenReturn(rsMock);
        when(rsMock.next()).thenReturn(true).thenReturn(false);
        when(rsMock.getInt("STATE_ID")).thenReturn(1);
        when(rsMock.getString("STATE_NAME")).thenReturn("Punkington");

        String expected = "1, Punkington";

        List<State> testList = objectUnderTest.getAllStates();
        assertEquals(expected, testList.get(0).toString());
    }

    @Test
    @DisplayName("Select all throws exception")
    void selectAllThrowsExceptionTest() throws SQLException {
        when(dbUtilsMock.getMysqlConnection()).thenReturn(conMock);
        when(conMock.prepareStatement(anyString())).thenReturn(psMock);
        when(psMock.executeQuery()).thenThrow(new SQLException("SQLException and stuff"));
        SQLException exception = assertThrows(SQLException.class,
                () -> objectUnderTest.getAllStates(), "Throws Exception test");
        String expected = "SQLException and stuff";
        assertEquals(expected, exception.getMessage());
    }
}