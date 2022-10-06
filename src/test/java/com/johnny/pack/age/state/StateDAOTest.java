package com.johnny.pack.age.state;

import com.johnny.pack.age.utilsandprops.DBUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}