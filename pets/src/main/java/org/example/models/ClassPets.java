package org.example.models;

public class ClassPets implements IClassPet {
    private int id;
    private ITypes typePet;

    @Override
    public String toString() {
        return  "id: " + id + " - " + classPet + " typePet=" + typePet.getTypePet() + "\n";
    }

    private String classPet;

    public ClassPets(int id, ITypes typePet, String classPet) {
        this.id = id;
        this.typePet = typePet;
        this.classPet = classPet;
    }

    @Override
    public int getIdClassPet() {
        return id;
    }

    @Override
    public ITypes getTypePet() {
        return typePet;
    }

    @Override
    public String getClassPet() {
        return classPet;
    }
}
