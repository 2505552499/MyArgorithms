package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeetCode260 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int[] ans = singLeNumber(nums);
        for (int i = 0; i < 2; i++) {
            System.out.println(ans[i]);
        }
    }

    public static int[] singLeNumber(int[] nums){
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            /*if(!map.containsKey(num)){
                map.put(num, 1);
            }
            else map.replace(num, map.get(num) + 1);*/
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            if(map.get(key) == 1){
                if(ans[0] == 0)
                ans[0] = key;
                else ans[1] = key;
            }
        }
        return ans;
    }
}
