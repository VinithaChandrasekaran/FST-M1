package activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args){
        HashSet<String> hs = new HashSet<>();
        hs.add("obj1");
        hs.add("obj2");
        hs.add("obj3");
        hs.add("obj4");
        hs.add("obj5");
        hs.add("obj6");
        System.out.println("HashSet is: " + hs);
        System.out.println("Size of hashset is:"+hs.size());
        System.out.println("Removing obj3");
        hs.remove("obj3");
        System.out.println("Removing object not present in Hashset");
        hs.remove("Vinitha");

        System.out.println("Checking if obj6 is present in Hashset:"+hs.contains("obj6"));
        //Print updated HashSet
        System.out.println("Updated HashSet: " + hs);




    }
}
