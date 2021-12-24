package org.example;

import java.util.Arrays;

public class NameRepository {
    private static int size;
    //private static String[] names = new String[0];
    static String[] allNames;
    static String[] foundNames;
    static String[] allFirstNames;
    static String[] allLastNames;

    // public static splitAll() {


    //  }


    public static int getSize() {
        System.out.println("AllNAmes "+allNames.length);
        System.out.println("Found Names "+foundNames.length);
        return allNames.length;
    }

    public static void setNames(String[] names) {
        size = names.length;
        NameRepository.allNames = names.clone();
        allNames = names.clone();
    }

    public static void clear() {
        allNames = new String[0];
    }

    public static String[] findAll() {
        foundNames = allNames.clone();
        return foundNames;
    }

    public static void printAll() {
        System.out.println("All names: " + Arrays.toString(allNames));
        System.out.println("Found names: " + Arrays.toString(foundNames));

    }

    public static String find(final String fullName) {
        for (String name : allNames) {
            if (name.equals(fullName)) {
                return name;
            }
        }
        return null;
    }

    public static boolean add(final String fullName) {
        String nameCheck = find(fullName);
        boolean added = false;

        if (nameCheck == null) {
            nameCheck = "";
        }

        if (!nameCheck.equals(fullName)) {
            String[] newArray = new String[++size];

            for (int i = 0; i < size - 1; i++) {
                newArray[i] = allNames[i];
            }

            newArray[size - 1] = fullName;
            allNames = newArray;
            added = true;
        }


        return added;
    }

    public static String[] findByFirstName(final String firstName) {
        String[] names = new String[size];

        for (int i = 0; i < size; i++) {
            String[] splitName = NameRepository.allNames[i].split(" ");

            if (splitName[0].equals(firstName)) {
                names[i] = NameRepository.allNames[i];
                foundNames[i] = NameRepository.allNames[i];
            }
        }

        return names;
    }

    public static String[] findByLastName(final String lastName) {
        String[] names = new String[size];

        for (int i = 0; i < size; i++) {
            String[] splitName = NameRepository.allNames[i].split(" ");

            if (splitName[1].equals(lastName)) {
                names[i] = NameRepository.allNames[i];
                foundNames[i] = NameRepository.allNames[i];
            }
        }

        return names;
    }

    public static boolean update(final String original, final String updatedName) {
        boolean updated = false;

        for (int i = 0; i < size; i++) {
            if (NameRepository.allNames[i].equals(original)) {
                NameRepository.allNames[i] = updatedName;
                updated = true;
            }
        }

        return updated;
    }

    public static boolean remove(final String fullName) {
        boolean removed = false;
        for (String name : NameRepository.allNames) {
            if (name.equals(fullName)) {
                name = null;
                removed = true;
            }
        }

        return removed;
    }
}
