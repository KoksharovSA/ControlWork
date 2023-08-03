package org.example.models;

public class Pets implements IAnimals{
    private String myName;
    private String myCommands;

    private String myBirthday;

    private String whatSay;
    private IClassPet myClass;
    private ITypes myType;
    public Pets(String myName, String myCommands, String myBirthday, String whatSay, IClassPet myClass) {
        this.myName = myName;
        this.myCommands = myCommands;
        this.myBirthday = myBirthday;
        this.whatSay = whatSay;
        this.myClass = myClass;
    }

    public Pets() {
    }

    @Override
    public void move(String way) {
        System.out.println("Я иду " + way);
    }

    @Override
    public void say() {
        System.out.println(whatSay);
    }

    @Override
    public ITypes getType() {
        return myClass.getTypePet();
    }

    @Override
    public IClassPet getClassPet() {
        return myClass;
    }

    @Override
    public String getName() {
        return myName;
    }

    @Override
    public String getCommands() {
        return myCommands;
    }

    @Override
    public String getBirthday() {
        return myBirthday;
    }
}
