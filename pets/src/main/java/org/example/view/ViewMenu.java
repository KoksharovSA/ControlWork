package org.example.view;

import org.example.controller.WorkDataPets;
import org.example.models.ClassPets;
import org.example.models.IAnimals;
import org.example.models.IClassPet;
import org.example.models.ITypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ViewMenu implements IViewMenu {
    @Override
    public void start() {
        Scanner in = new Scanner(System.in);
        while (true) {
            String menu = "\nВыберите пункт меню:\n" +
                    "1.Показать всех животных\n" +
                    "2.Добавить животное\n" +
                    "3.Список команд, которое выполняет животное\n" +
                    "4.Обучить животное новой команде\n" +
                    "5.Выход";
            System.out.println(menu);
            int answer = in.nextInt();
            if (answer == 1) {
                System.out.println(WorkDataPets.getPets());
            } else if (answer == 2) {
                menuAddAnimal();
            } else if (answer == 3) {
                menuListCommandPet();
            } else if (answer == 4) {
                menuAddCommandPet();
            } else if (answer == 5) {
                break;
            } else {
                System.out.println("Неправильный ввод, повторите.");
            }
        }
    }

    private void menuAddAnimal() {
        Scanner in = new Scanner(System.in);

        System.out.println("\nВведите имя животного:");
        String name = in.nextLine();
        ITypes typePet = null;
        while (true) {
            System.out.println("\nВыберите id типа животного:");
            List<ITypes> types = WorkDataPets.getTypesPet();
            System.out.println(types);
            int inType = in.nextInt();
            if (WorkDataPets.getTypePet(inType) != null) {
                typePet = WorkDataPets.getTypePet(inType);
                break;
            } else {
                System.out.println("Не верный тип животного.");
            }
        }

        IClassPet classPet = null;
        while (true) {
            System.out.println("\nВыберите id класса животного:");
            List<IClassPet> listClass = WorkDataPets.getListClassPetForType(typePet.getId());
            List<Integer> idClasses = new ArrayList<>();
            for (IClassPet item : listClass) {
                idClasses.add(item.getIdClassPet());
            }
            System.out.println(listClass);
            int inClass = in.nextInt();
            if (idClasses.contains(inClass)) {
                classPet = WorkDataPets.getClassPet(inClass);
                break;
            } else {
                System.out.println("Не верный класс животного.");
            }
        }


        in.nextLine();
        System.out.println("Введите день рождения животного в формате ГГГГ-ММ-ДД:");
        String birthday = in.nextLine();

        System.out.println("Введите что говорит животное:");
        String whatSay = in.nextLine();

        System.out.println("Введите команды животного:");
        String commands = in.nextLine();

        WorkDataPets.addPet(name, classPet, birthday, commands, whatSay);
    }

    private void menuListCommandPet() {
        Scanner in = new Scanner(System.in);

        while (true) {

            List<IAnimals> listPets = WorkDataPets.getPets();
            List<Integer> idPets = new ArrayList<>();
            for (IAnimals item : listPets) {
                idPets.add(item.getId());
            }
            System.out.println("Введите id животного у которого хотире увидеть команды:");
            int idPet = in.nextInt();
            if (idPets.contains(idPet)) {
                for (IAnimals item : listPets) {
                    if (item.getId() == idPet) {
                        System.out.println("Команды животного: " + item.getCommands());
                    }
                }
                break;
            } else {
                System.out.println("Не верный id животного.");
            }
        }
    }

    private void menuAddCommandPet() {
        Scanner in = new Scanner(System.in);

        while (true) {

            List<IAnimals> listPets = WorkDataPets.getPets();
            List<Integer> idPets = new ArrayList<>();
            for (IAnimals item : listPets) {
                idPets.add(item.getId());
            }
            System.out.println("Введите id животного которому хотите добавить команду:");
            int idPet = in.nextInt();
            if (idPets.contains(idPet)) {
                in.nextLine();
                System.out.println("Введите новую команду:");
                String newCommand = in.nextLine();
                WorkDataPets.updatePetCommand(idPet, WorkDataPets.getPetsOnId(idPet).getCommands() + ", " + newCommand);
                break;
            } else {
                System.out.println("Не верный id животного.");
            }
        }
    }
}
