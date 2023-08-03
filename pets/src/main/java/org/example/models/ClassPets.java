package org.example.models;

public class ClassPets implements IClassPet {
    private ITypes typePet;
    private String classPet;

    public ClassPets(ITypes typePet, String classPet) {
        this.typePet = typePet;
        this.classPet = classPet;
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
