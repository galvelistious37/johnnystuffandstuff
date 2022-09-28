package com.johnny.pack.age.city;

public class City {
    private int id;
    private String name;
    private int stateId;

    public City(){}

    public City(String name, int stateId) {
        this.name = name;
        this.stateId = stateId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stateId='" + stateId + '\'' +
                '}';
    }
}
