package com.company;

import java.util.ArrayList;
import java.util.List;

public class LeetCode282 {
    int n;
    String num;
    int target;
    List<String> ans;

    public static void main(String[] args) {
        String num = "1234567890";
        int target = 6;
        LeetCode282 lc = new LeetCode282();
        List<String> ans = new ArrayList<>();
        ans = lc.addOperators(num, target);
        System.out.println(ans);

    }

    public List<String> addOperators(String num, int target) {
        this.n = num.length();
        this.num = num;
        this.target = target;
        this.ans = new ArrayList<String>();
        StringBuffer expr = new StringBuffer();
        backtrack(expr, 0, 0, 0);
        return ans;
    }

    public void backtrack(StringBuffer expr, int i, long res, long mul) {
        if (i == n) {
            if(res == target){
                ans.add(expr.toString());
            }
            return;
        }
        int signIndex = expr.length();
        if(i > 0){
            expr.append(0);
        }
        long val = 0;
        for(int j = i; j < n && (j == i || num.charAt(i) != '0'); ++j){
            val = val * 10 + num.charAt(j) - '0';
            expr.append(num.charAt(j));
            if(i == 0){
                backtrack(expr, j + 1, val,val);
            }else{
                expr.setCharAt(signIndex, '+');
                backtrack(expr, j+ 1, res + val, val);
                expr.setCharAt(signIndex, '-');
                backtrack(expr, j + 1, res - val, -val);
                expr.setCharAt(signIndex, '*');
                backtrack(expr,j + 1, res - mul + mul * val, mul * val);
            }
        }
        expr.setLength(signIndex);
    }
}
