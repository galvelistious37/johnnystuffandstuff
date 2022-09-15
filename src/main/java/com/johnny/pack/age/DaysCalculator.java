package com.johnny.pack.age;

public class DaysCalculator {

    private int totalDays;

    public DaysCalculator(int totalDays) {
        this.totalDays = totalDays;
    }

    private int years;
    private int weeks;
    private int days;



    public int determineYears(int totalDays){
        years = totalDays / 365;
        return years;
    }

    public int determineWeeks(int totalDays){
        weeks = (totalDays % 365) / 7;
        return weeks;
    }

    public int determineDays(int totalDays){
        days = (totalDays % 365) % 7;
        return days;
    }

    public void getOutput(){
        System.out.format("%d days is equals to: \n%d years \n%d weeks \n%d days",
                getTotalDays(), getYears(), getWeeks(), getDays());
    }

    public int getTotalDays(){
        return totalDays;
    }

    public int getYears() {
        return years;
    }

    public int getWeeks() {
        return weeks;
    }

    public int getDays() {
        return days;
    }
}
