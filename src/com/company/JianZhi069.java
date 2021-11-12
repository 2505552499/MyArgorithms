package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class JianZhi069 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Scanner sc2 = new Scanner(line);

        ArrayList<Integer> arr2 = new ArrayList<>();
        while(sc2.hasNext()){
            arr2.add(sc2.nextInt());
        }

        int[] arr = {24,69,100,99,79,67,78,36,26,19};
        int[] arr1 = {1,3,4,4,2};


        int ans = peakIndexMountainArray(arr);
        int ans1 = peakIndexMountainArray(arr1);

//        System.out.println(ans + "\n" + ans1);
//        System.out.println(binarySearch(arr1));
        System.out.println(binarySearch(arr2));
    }

    public static int peakIndexMountainArray(int[] arr){
        int n = arr.length;
        int ans = -1;
        for (int i = 1; i < n - 1; ++i){
            if(arr[i] > arr[i+1]){
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static int binarySearch(ArrayList<Integer> arr){
        int n = arr.size();
        int l = 1, r = n - 2, ans = 0;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(arr.get(mid) > arr.get(mid + 1)){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
}
