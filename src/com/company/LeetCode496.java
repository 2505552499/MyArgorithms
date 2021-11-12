package com.company;

import java.util.*;

public class LeetCode496 {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
//        int[] result = nextGreaterElement(nums1, nums2);
        int[] result = solution2(nums1, nums2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2){
        int[] result = new int[nums1.length];
        int flag = 0;
//        Arrays.sort(nums2);

        for (int i = 0; i < nums1.length; i++) {
            flag = 0;
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    flag = 1;
                }
                if(nums1[i] < nums2[j] && flag == 1){
                    result[i] = nums2[j];
                    break;
                }else{
                    result[i] = -1;
                }
            }
        }
        return result;

    }

    public static int[] solution2(int[] nums1, int[] nums2){
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stak = new ArrayDeque<>();
        for(int i = nums2.length - 1; i >= 0; i--){
            int num = nums2[i];
            while (!stak.isEmpty() && num >= stak.peek()){
                stak.pop();
            }
            map.put(num, stak.isEmpty() ? -1 : stak.peek());
            stak.push(num);
        }
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
