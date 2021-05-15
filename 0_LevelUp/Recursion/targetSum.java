import java.util.Scanner;

public class targetSum {
    public static int permutationsWithInfi(int[] arr, int target, String csf){
        if(target == 0){
            System.out.println(csf);
            return 1;
        }
        int count = 0;
        for(int ele : arr){
            if(target - ele >= 0){
                count += permutationsWithInfi(arr, target - ele, csf + ele);
            }
        }
        return count;
    }
    public static int combinationsWithInfi(int[] arr, int target, int idx, String csf){
        if(target == 0){
            System.out.println(csf);
            return 1;
        }
        int count = 0;
        for(int i=idx; i<arr.length; i++){
            if(target - arr[idx] >= 0){
                count += combinationsWithInfi(arr, target - arr[i], i, csf + arr[i]);
            }
        }
        return count;
    }
    public static int combinationsWithSingle(int[] arr, int target, int idx, String csf){
        if(target == 0){
            System.out.println(csf);
            return 1;
        }
        int count = 0;
        for(int i=idx; i<arr.length; i++){
            if(target - arr[i] >= 0){
                count += combinationsWithSingle(arr, target - arr[i], i+1, csf + arr[i]);
            }
        }
        return count;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = 4;
        int[] arr = {2,3, 5, 7};
        int target = 10;
        //System.out.println(combinationsWithInfi(arr, target, 0, ""));
        System.out.println(combinationsWithSingle(arr, target, 0, ""));
    }
}
