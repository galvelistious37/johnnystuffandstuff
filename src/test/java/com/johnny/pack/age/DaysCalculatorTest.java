package com.johnny.pack.age;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DaysCalculatorTest {
    private DaysCalculator daysCalc365;
    private DaysCalculator daysCalc375;
    private DaysCalculator daysCalc355;

    @BeforeEach
    public void setup(){
        daysCalc365 = new DaysCalculator(365);
        daysCalc375 = new DaysCalculator(375);
        daysCalc355 = new DaysCalculator(355);
    }

    @AfterEach
    public void tearDown(){
        daysCalc365 = null;
        daysCalc375 = null;
        daysCalc355 = null;
    }

    @Test
    @DisplayName("Years from days")
    public void getYearsFromDays(){
        daysCalc365.determineYears(daysCalc365.getTotalDays());
        daysCalc375.determineYears(daysCalc375.getTotalDays());
        daysCalc355.determineYears(daysCalc355.getTotalDays());
        assertEquals(1, daysCalc365.getYears());
        assertEquals(1, daysCalc375.getYears());
        assertEquals(0, daysCalc355.getYears());
    }

    @Test
    @DisplayName("Weeks from days")
    public void getWeeksFromDays(){
        daysCalc365.determineWeeks(daysCalc365.getTotalDays());
        daysCalc375.determineWeeks(daysCalc375.getTotalDays());
        daysCalc355.determineWeeks(daysCalc355.getTotalDays());
        assertEquals(0, daysCalc365.getWeeks());
        assertEquals(1, daysCalc375.getWeeks());
        assertEquals(50, daysCalc355.getWeeks());
    }

    @Test
    @DisplayName("Days remaing")
    public void daysRemaining(){
        daysCalc365.determineDays(daysCalc365.getTotalDays());
        daysCalc375.determineDays(daysCalc375.getTotalDays());
        daysCalc355.determineDays(daysCalc355.getTotalDays());
        assertEquals(0, daysCalc365.getDays());
        assertEquals(3, daysCalc375.getDays());
        assertEquals(5, daysCalc355.getDays());
    }

    @Test
    @DisplayName("Show output")
    public void showOutput(){
        daysCalc365.determineYears(daysCalc365.getTotalDays());
        daysCalc365.determineWeeks(daysCalc365.getTotalDays());
        daysCalc365.determineDays(daysCalc365.getTotalDays());
        daysCalc365.getOutput();
        System.out.println();
        daysCalc375.determineYears(daysCalc375.getTotalDays());
        daysCalc375.determineWeeks(daysCalc375.getTotalDays());
        daysCalc375.determineDays(daysCalc375.getTotalDays());
        daysCalc375.getOutput();
        System.out.println();
        daysCalc355.determineYears(daysCalc355.getTotalDays());
        daysCalc355.determineWeeks(daysCalc355.getTotalDays());
        daysCalc355.determineDays(daysCalc355.getTotalDays());
        daysCalc355.getOutput();
        System.out.println();
        DaysCalculator dc = new DaysCalculator(798);
        dc.determineYears(dc.getTotalDays());
        dc.determineWeeks(dc.getTotalDays());
        dc.determineDays(dc.getTotalDays());
        dc.getOutput();
    }

}