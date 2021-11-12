package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode078 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> t = new ArrayList<>();
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] nums = {1,2,3};
        LeetCode078 lc = new LeetCode078();
        ans = lc.subsets(nums);
        System.out.println(ans);
    }

    public List<List<Integer>> subsets(int[] nums){
        dfs(0, nums);
        return ans;

    }

    public void dfs(int cur, int[] nums){
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }
}
