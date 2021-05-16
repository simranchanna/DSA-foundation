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
    public static int permutationsWithSingle(int[] arr, boolean[] vis, int target, String ans) {
        if (target == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!vis[i] && target - arr[i] >= 0) {
                vis[i] = true;
                count += permutationsWithSingle(arr, vis, target - arr[i], ans + arr[i]);
                vis[i] = false;
            }
        }
        return count;
    }

    //SUBSEQUENCE METHOD ====================================================================================================

    public static int permutationWithInfi_subSeq(int[] arr, int tar, int idx, String ans) {
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if (tar - arr[idx] >= 0)
            count += permutationWithInfi_subSeq(arr, tar - arr[idx], 0, ans + arr[idx]);
        count += permutationWithInfi_subSeq(arr, tar, idx + 1, ans);
        return count;
    }
    public static int combinationWithInfi_subSeq(int[] arr, int tar, int idx, String ans) {
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }

            return 0;
        }

        int count = 0;
        if (tar - arr[idx] >= 0)
            count += combinationWithInfi_subSeq(arr, tar - arr[idx], idx, ans + arr[idx]);
        count += combinationWithInfi_subSeq(arr, tar, idx + 1, ans);

        return count;
    }

    public static int combinationWithSingle_subSeq(int[] arr, int tar, int idx, String ans) {
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if (tar - arr[idx] >= 0)
            count += combinationWithSingle_subSeq(arr, tar - arr[idx], idx + 1, ans + arr[idx]);
        count += combinationWithSingle_subSeq(arr, tar, idx + 1, ans);
        return count;
    }
    public static int permutationWithSingleCoin_subSeq(int[] arr, int tar, int idx, String ans) {
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (arr[idx] > 0 && tar - arr[idx] >= 0) {
            int val = arr[idx];
            arr[idx] = -arr[idx];
            count += permutationWithSingleCoin_subSeq(arr, tar - val, 0, ans + val);
            arr[idx] = -arr[idx];
        }
        count += permutationWithSingleCoin_subSeq(arr, tar, idx + 1, ans);
        return count;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = 4;
        int[] arr = {2,3, 5, 7};
        int target = 10;
        boolean[] vis = new boolean[4];
        //System.out.println(combinationsWithInfi(arr, target, 0, ""));
        //System.out.println(combinationsWithSingle(arr, target, 0, ""));
        System.out.println(permutationsWithSingle(arr, vis, target, ""));
    }
}
