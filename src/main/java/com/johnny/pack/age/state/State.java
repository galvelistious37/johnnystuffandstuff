package com.johnny.pack.age.state;

public class State {
    private int stateId;
    private String name;

    public State(){

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
