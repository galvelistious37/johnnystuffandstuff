package com.johnny.pack.age;

import java.text.NumberFormat;
import java.util.Locale;

public class Player {

    private int playerId;
    private int teamId;
    private String firstName;
    private String lastName;
    private int age;
    private int height;
    private int weight;
    private String position;
    private double salary;

    public Player(String firstName, String lastName, int age, int height, int weight, String position, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.salary = salary;
    }

    public Player(){}

    public Player(int teamId, String firstName,
                  String lastName, int age, int height, int weight,
                  String position, double salary) {
        this.teamId = teamId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.salary = salary;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        String salaryString = nf.format(getSalary());
        return String.format("" +
                "PlayerID: %d\n" +
                "Team ID: %d\n" +
                "First Name: %s\n" +
                "Last Name: %s\n" +
                "Age: %d\n" +
                "Height: %d\n" +
                "Weight: %d\n" +
                "Position: %s\n" +
                "Salary: %s",
                getPlayerId(), getTeamId(), getFirstName(), getLastName(),
                getAge(), getHeight(), getWeight(), getPosition(), salaryString);
    }
}
