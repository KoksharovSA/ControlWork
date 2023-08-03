package org.example.models;

public interface IAnimals {
    public void move(String way);
    public void say();
    public ITypes getType();
    public IClassPet getClassPet();
    public String getName();
    public String getCommands();
    public String getBirthday();
}
