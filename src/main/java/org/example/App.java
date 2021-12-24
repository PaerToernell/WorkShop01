package org.example;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    private static final String[] theNames = {"Pär Törnell", "Anto Rebelo", "Simon Elbrink, Suzanne Cederholm"};
    private static final Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Please choose an option:");
        //String[] allNames;
        String[] setOfNames;
        String nameToFind;
        boolean imDone = false;
        int aSelect = 0;
        int size;

        while (!imDone) {
            // Load all names to allNames
            System.out.println("1 : Load All Names");
            // Print allNames and setOfNames
            System.out.println("2 : Show All Names");


            // Print size of allNames and size of setOfNames
            System.out.println("3 : Show size");
            //
            System.out.println("4 : Clear All Names");
            //
            System.out.println("5 : Find All");
            // Get as string, print and add to set
            System.out.println("6 : Add name (to allNames)");

            System.out.println("7 : Find name");
            //
            System.out.println("8 : Find First name");
            System.out.println("9 : Find Last name");
            System.out.println("10 : Remove a name");
            System.out.println();
            System.out.println("0 Quit");
            //


            Scanner input = new Scanner(System.in);

            aSelect = sc.nextInt();
            switch (aSelect) {
                case 1:
                    NameRepository.setNames(theNames);
                    System.out.println("All names added.");
                    break;
                case 2:
                    NameRepository.printAll();
                    break;
                case 3:
                    size = NameRepository.getSize();
                    //System.out.println("Size: " + size);
                    break;
                case 4:
                    NameRepository.clear();
                    size = NameRepository.getSize();
                    System.out.println("Size of array: " + size);
                    break;
                case 5:
                    String[] allNames = NameRepository.findAll();
                    System.out.println("All names: " + Arrays.toString(allNames));
                    break;
                case 6:
                    System.out.println("Name to add: ");
                    String nameToAdd = input.nextLine();
                    boolean added = NameRepository.add(nameToAdd);
                    if (!added)
                        System.out.println("No success adding name");
                    else
                        System.out.println("Name added");
                    break;
                case 7:
                    System.out.println("Name to find: ");
                    nameToFind = input.nextLine();
                    String nameCheck = NameRepository.find(nameToFind);
                    if (nameCheck == null)
                        System.out.println("Name not to be found.");
                    else System.out.println("Name found.");
                    break;
                case 8:
                    System.out.println("First name to find: ");
                    String firstNameToFind = input.next();
                    String[] namesFoundByFirstName = NameRepository.findByFirstName(firstNameToFind);
                    System.out.println("All names: " + Arrays.toString(namesFoundByFirstName));
                break;
                case 9:
                    System.out.println("Last name to find: ");
                    String lastNameToFind = input.next();
                    String[] namesFoundByLastName = NameRepository.findByLastName(lastNameToFind);
                    System.out.println("All names: " + Arrays.toString(namesFoundByLastName));
                    break;
                case 10:
                    System.out.println("Name to remove: ");
                    String nameToRemove = input.nextLine();
                    boolean removed = NameRepository.remove(nameToRemove);
                    if (!removed)
                        System.out.println("No success removing name");
                    else
                        System.out.println("Name removed");
                    break;
                case 0:
                    imDone = true;
                    break;
            }
        }
    }
}
