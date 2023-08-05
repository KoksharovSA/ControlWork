package org.example;

import org.example.controller.WorkDataPets;
import org.example.controller.WorkWithDB;
import org.example.models.ITypes;
import org.example.models.Pets;
import org.example.view.IViewMenu;
import org.example.view.ViewMenu;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        System.out.println(WorkDataPets.getTypePet(1));
//        System.out.println(WorkDataPets.getClassPet(1));
//        System.out.println(WorkDataPets.getPets());
        IViewMenu menu = new ViewMenu();
        menu.start();
    }
}