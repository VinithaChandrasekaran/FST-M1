package activities;

import java.util.*;

public class Activity13 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random indexGen = new Random();

        System.out.print("Enter Numbers");
        System.out.println("(EOF or non-integer to terminate): ");

        while(scan.hasNextInt()) {
            list.add(scan.nextInt());
        }

        Integer nums[] = list.toArray(new Integer[0]);
        int ran = indexGen.nextInt(nums.length);
        System.out.println("Index value generated randomly is : " + ran);
        System.out.println("Value in array at generated index: " + nums[ran]);

        scan.close();
    }
}