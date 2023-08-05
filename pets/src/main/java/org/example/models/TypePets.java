package org.example.models;

public class TypePets implements ITypes{
    private int id;
    private String type;

    @Override
    public String toString() {
        return "id=" + id +
                ", type='" + type + "\n";
    }

    public TypePets(int id, String type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getTypePet() {
        return type;
    }
}
