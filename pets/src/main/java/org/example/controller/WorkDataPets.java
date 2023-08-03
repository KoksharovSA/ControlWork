package org.example.controller;

import org.example.models.IClassPet;
import org.example.models.ITypes;

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
    public static void addTypePets(String nameTypePets){
        String SQL = "INSERT INTO type_pets (id, name) VALUES (" + getNextId("type_pets") + ", '" + nameTypePets + "');";
        WorkWithDB.uploadData(SQL);
    }

    public static void addClassPets(String nameClassPets, ITypes type){
        String SQL = "INSERT INTO pets (id, name, type_pet) VALUES (" + getNextId("pets") + ", '" + nameClassPets + "', " + type.getId() + ");";
        WorkWithDB.uploadData(SQL);
    }

    public static void addPet(String name, IClassPet classPet, String birthday, String commands){
        String SQL = "INSERT INTO zoo_residents (name, pet, birthday, command) VALUES (" + name + ", '" + classPet + "', " + birthday + ", " + commands + ");";
        WorkWithDB.uploadData(SQL);
    }

    public static void updatePet(int id, String newCommand){
        String SQL = "UPDATE zoo_residents SET command = " + newCommand + " WHERE id = " + id + ";";
        WorkWithDB.uploadData(SQL);
    }
}
