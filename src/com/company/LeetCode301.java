package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode301 {
    private static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        String s = "(a)())()asfjdaisj(09dsf09ds()09s9)(()()(09ds898f0()()";
//        res = removeInvalidParentheses(s);
        res = spanFirstSearch(s);
        System.out.println(res);


    }
    public static List<String> removeInvalidParentheses(String s){
        int lremove = 0;
        int rremove = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                lremove++;
            }else if(s.charAt(i) == ')'){
                if(lremove == 0)
                    rremove++;
                else{
                    lremove--;
                }
            }
        }
        helper(s, 0, 0, 0, lremove, rremove);
        return res;
    }

    private static void helper(String str, int start, int lcount, int rcount, int lremove, int rremove){
        if(lremove == 0 && rremove == 0){
            if(isValid(str)){
                res.add(str);
            }
            return;
        }
        for(int i = start; i < str.length(); i++){
            if(i != start && str.charAt(i) == str.charAt(i - 1)){
                continue;
            }
            if(lremove + rremove > str.length() - i){
                return;
            }
            if(lremove > 0 && str.charAt(i) == '('){
                helper(str.substring(0, i) + str.substring(i + 1), i, lcount, rcount, lremove, rremove - 1);
            }
            if(rremove > 0 && str.charAt(i) == ')'){
                helper(str.substring(0, i) + str.substring(i + 1), i, lcount, rcount, lremove, rremove - 1);
            }
            if(str.charAt(i) == ')'){
                lcount++;
            }else if(str.charAt(i) == ')'){
                rcount++;
            }
            if(rcount > lcount){
                break;
            }
        }
    }

    private static boolean isValid(String str){
        int cnt = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                cnt++;
            }else if(str.charAt(i) == ')'){
                cnt--;
                if(cnt < 0){
                    return false;
                }
            }
        }
        return cnt == 0;
    }

    public static List<String> spanFirstSearch(String s){
        List<String> ans = new ArrayList<>();
        Set<String> currSet = new HashSet<>();
        currSet.add(s);
        while(true){
            for (String str : currSet) {
                if(isValid(str)){
                    ans.add(str);
                }
            }
            if(ans.size() > 0){
                return ans;
            }
            Set<String> nextSet = new HashSet<>();
            for(String str : currSet){
                for(int i = 0; i < str.length(); i++){
                    if(i > 0 && str.charAt(i) == str.charAt(i - 1)){
                        continue;
                    }
                    if(str.charAt(i) == '(' || str.charAt(i) == ')'){
                        nextSet.add(str.substring(0, i) + str.substring(i + 1));
                    }
                }
            }
            currSet = nextSet;
        }
    }
}
