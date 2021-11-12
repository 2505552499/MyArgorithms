package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class LeetCode033 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Scanner sc2 = new Scanner(line);
        while(sc2.hasNextInt()){
            arr.add(sc2.nextInt());
        }
        int target = sc.nextInt();
        System.out.println(search(arr, target));


    }

    public static int search(ArrayList<Integer> nums, int target) {
        int len = nums.size();
        int l = 0, r = len - 1;

        if (len == 1)
            return nums.get(0) == target ? 0 : -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums.get(mid) == target) {
                return mid;
            }
            if (nums.get(0) <= nums.get(mid)) {
                if (nums.get(0) <= target && target < nums.get(mid)) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }


            } else {
                if (nums.get(mid) < target && target <= nums.get(len - 1)) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}

