package org.example.models;

public class Pets implements IAnimals{
    private int id;
    private String myName;
    private String myCommands;

    private String myBirthday;

    private String whatSay;
    private IClassPet myClass;

    @Override
    public String toString() {
        return "\n\n" +
                "id=" + id + '\n' +
                "myName=" + myName + '\n' +
                "myCommands=" + myCommands + '\n' +
                "myBirthday=" + myBirthday + '\n' +
                "whatSay=" + whatSay + '\n' +
                "myClass=" + myClass;
    }

    private ITypes myType;
    public Pets(int id, String myName, String myCommands, String myBirthday, String whatSay, IClassPet myClass) {
        this.id = id;
        this.myName = myName;
        this.myCommands = myCommands;
        this.myBirthday = myBirthday;
        this.whatSay = whatSay;
        this.myClass = myClass;
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
    public int getId() {
        return id;
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
