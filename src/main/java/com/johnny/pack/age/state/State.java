package com.johnny.pack.age.state;

public class State {
    private int stateId;
    private String name;

    /**
     * Insert a new state to the database
     * @param name - String state name
     */
    void insertState(String name){

    }

    /**
     * Insert a new state to the database
     * @param id - int state id
     * @param name - String state name
     */
    void insertState(int id, String name){

    }

    public int getStateId(){
        return stateId;
    }

    public void setStateId(int stateId){
        this.stateId = stateId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("%d, %s", getStateId(), getName());
    }
}
