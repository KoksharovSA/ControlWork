package org.example.controller;

import org.example.models.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkDataPets {
    public static int getNextId(String nameTable){
        ResultSet resultSet = WorkWithDB.downloadData("SELECT * FROM " + nameTable);
        List<Integer> result = new ArrayList<>();
        while (true){
            try {
                if (!resultSet.next()) break;
                result.add(resultSet.getInt("id"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return Collections.max(result) + 1;
    }

    public static List<ITypes> getTypesPet (){
        String query = "SELECT * FROM type_pets";
        ResultSet resultSet = WorkWithDB.downloadData(query);
        List<ITypes> listTypesPet = new ArrayList<>();
        while (true){
            try {
                if (!resultSet.next()) break;
                listTypesPet.add(new TypePets(resultSet.getInt("id"), resultSet.getString("name")));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return listTypesPet;
    }

    public static ITypes getTypePet (int id){
        String query = "SELECT * FROM type_pets WHERE id = " + id;
        ResultSet resultSet = WorkWithDB.downloadData(query);
        ITypes typePet = null;
        while (true){
            try {
                if (!resultSet.next()) break;
                typePet = new TypePets(resultSet.getInt("id"), resultSet.getString("name"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return typePet;
    }

    public static IClassPet getClassPet (int id){
        String query = "SELECT * FROM pets WHERE id = " + id;
        ResultSet resultSet = WorkWithDB.downloadData(query);
        IClassPet classPet = null;
        while (true){
            try {
                if (!resultSet.next()) break;
                classPet = new ClassPets(resultSet.getInt("id"),
                                        getTypePet(resultSet.getInt("type_pet")),
                                        resultSet.getString("name"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return classPet;
    }

    public static List<IClassPet> getListClassPetForType (int idType){
        String query = "SELECT * FROM pets WHERE type_pet = " + idType;
        ResultSet resultSet = WorkWithDB.downloadData(query);
        List<IClassPet> listClassPet = new ArrayList<>();
        while (true){
            try {
                if (!resultSet.next()) break;
                listClassPet.add(new ClassPets(resultSet.getInt("id"),
                        getTypePet(resultSet.getInt("type_pet")),
                        resultSet.getString("name")));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return listClassPet;
    }

    public static List<IAnimals> getPets(){
        List<IAnimals> result = new ArrayList<>();
        String query = "SELECT * FROM zoo_residents";
        ResultSet resultSet = WorkWithDB.downloadData(query);
        while (true){
            try {
                if (!resultSet.next()) break;
                IAnimals pet = new Pets(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("command"),
                        resultSet.getString("birthday"),
                        resultSet.getString("whatSay"),
                        getClassPet(resultSet.getInt("pet")));
                result.add(pet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public static IAnimals getPetsOnId(int idPet){
        IAnimals result = null;
        String query = "SELECT * FROM zoo_residents WHERE id = " + idPet;
        ResultSet resultSet = WorkWithDB.downloadData(query);
        while (true){
            try {
                if (!resultSet.next()) break;
                result = new Pets(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("command"),
                        resultSet.getString("birthday"),
                        resultSet.getString("whatSay"),
                        getClassPet(resultSet.getInt("pet")));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public static void addTypePets(String nameTypePets){
        String SQL = "INSERT INTO type_pets (id, name) VALUES (" + getNextId("type_pets") + ", '" + nameTypePets + "');";
        WorkWithDB.uploadData(SQL);
    }

    public static void addClassPets(String nameClassPets, ITypes type){
        String SQL = "INSERT INTO pets (id, name, type_pet) VALUES (" + getNextId("pets") + ", '" + nameClassPets + "', " + type.getId() + ");";
        WorkWithDB.uploadData(SQL);
    }

    public static void addPet(String name, IClassPet classPet, String birthday, String commands, String whatSay){
        String SQL = "INSERT INTO zoo_residents (name, pet, birthday, command, whatSay) VALUES ('" + name + "', " + classPet.getIdClassPet() + ", '" + birthday + "', '" + commands + "', '" + whatSay + "');";
        WorkWithDB.uploadData(SQL);
    }

    public static void updatePetCommand(int id, String newCommand){
        String SQL = "UPDATE zoo_residents SET command = '" + newCommand + "' WHERE id = " + id + ";";
        WorkWithDB.uploadData(SQL);
    }
}
