package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("name1");
        myList.add("name2");
        myList.add("name3");
        myList.add(3, "Grapes");
        myList.add(1, "Papaya");

        System.out.println("Printing all the Objects:");
        for (String s : myList) {
            System.out.println(s);
        }
        System.out.println("3rd element in the list is: "+myList.get(2));
        System.out.println("Is name1 is in list: " + myList.contains("name1"));
        System.out.println("Size of ArrayList: " + myList.size());

        myList.remove("name2");

        System.out.println("New Size of ArrayList: " + myList.size());

        System.out.println("Printing Objects after removing object:");
        for (String s : myList) {
            System.out.println(s);
        }
    }

}

