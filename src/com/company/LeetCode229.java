package com.company;

import java.util.ArrayList;
import java.util.List;

public class LeetCode229 {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        List<Integer> ans = majorityElement(nums);
        System.out.println(ans);
    }

    public static List<Integer> majorityElement(int[] nums){
        int element1 = 0;
        int element2 = 0;
        int vote1 = 0;
        int vote2 = 0;

        for(int num: nums){
            if (vote1 > 0 && num == element1)
                vote1++;
            else if(vote2 > 0 && num == element2)
                vote2++;
            else if(vote1 == 0){
                element1 = num;
                vote1++;
            }else if(vote2 == 0){
                element2 = num;
                vote2++;
            }else{
                vote1--;
                vote2--;
            }
        }

        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : nums){
            if(vote1 > 0 && num == element1)
                cnt1++;
            if(vote2 > 0 && num == element2)
                cnt2++;
        }


        List<Integer> ans = new ArrayList<>();
        if(vote1 > 0 && cnt1 > nums.length / 3)
            ans.add(element1);
        if(vote2 > 0 && cnt2 > nums.length / 3)
            ans.add(element2);

        return ans;


    }
}
