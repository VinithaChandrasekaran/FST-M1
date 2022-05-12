package activities;

public class Activity2 {
    public static void main(String[] args){
        int[] a= {10, 77, 10, 54, -11, 10};
        int sum= 30;

        int searchNum = 10;
        int fixedSum = 30;


        System.out.println("Result:" + resultOfArray(a, searchNum, fixedSum));

    }

    public static boolean resultOfArray( int[] a, int searchable, int sum){
    int temp_sum= 0;
        for (int i = 0; i < a.length; i++) {
            //System.out.println(a[i]);
            if ((a[i] % searchable) == 0) {
                temp_sum = temp_sum + a[i];
            }
            if (temp_sum > sum) {
                break;
            }
        }

        return temp_sum == sum;
    }
}
