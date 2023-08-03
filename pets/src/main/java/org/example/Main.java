package org.example;

import org.example.controller.WorkDataPets;
import org.example.controller.WorkWithDB;
import org.example.models.ITypes;
import org.example.models.Pets;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(WorkDataPets.getNextId("type_pets"));
    }
}