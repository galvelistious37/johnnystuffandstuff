package com.johnny.pack.age.city;

import com.johnny.pack.age.utilsandprops.DBUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
class CityDAOTest {

    @Mock
    DBUtils dbUtilsMock;
    @Mock
    Connection conMock;
    @Mock
    PreparedStatement psMock;
    @Mock
    ResultSet rsMock;
    @Mock
    City cityMock;

    @InjectMocks
    CityDAO objectUnderTest;

    @BeforeEach
    void setup() throws SQLException {
        when(dbUtilsMock.getMysqlConnection()).thenReturn(conMock);
        when(conMock.prepareStatement(anyString())).thenReturn(psMock);
    }

    @Test
    @DisplayName("CityDAO insert cities")
    void testInsertCities() throws SQLException {
        when(psMock.executeUpdate()).thenReturn(1);
        String filename = "src\\test\\resources\\CitiesTestFile.txt";
        assertEquals(2, objectUnderTest.insertCities(filename));
    }

    @Test
    @DisplayName("CityDAO Select All")
    void testSelectAll() throws SQLException {
        when(psMock.executeQuery()).thenReturn(rsMock);
        when(rsMock.next()).thenReturn(true).thenReturn(false);
        when(rsMock.getInt("CITY_ID")).thenReturn(1);
        when(rsMock.getInt("STATE_ID")).thenReturn(1);
        when(rsMock.getString("CITY_NAME")).thenReturn("Portland");

        String expected = "City{id=1, name='Portland', stateId='1'}";

        List<City> testList = objectUnderTest.getAllCities();
        assertEquals(expected, testList.get(0).toString());
    }

    @Test
    @DisplayName("Select all throws exception")
    void selectAllThrowsExceptionTest() throws SQLException {
        when(psMock.executeQuery()).thenThrow(new SQLException("The fuck?"));
        assertThrows(SQLException.class,
                () -> {objectUnderTest.getAllCities();},
                "Throws Exception test");
    }

    @Test
    @DisplayName("Insert throws exception")
    void insertThrowsExceptionTest() throws SQLException {
        when(psMock.executeUpdate()).thenThrow(new SQLException("The fuck?"));
        assertThrows(SQLException.class,
                () -> {objectUnderTest.insertCity(cityMock);},
                "Throws Exception test");
    }
}