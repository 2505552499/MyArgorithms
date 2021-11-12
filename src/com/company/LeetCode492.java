package com.company;

public class LeetCode492 {
    public static void main(String[] args){
        int[] result = Rectangel(99999999);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] constructRectangle(int area){
        int n =(int) Math.sqrt((float)area);
        int[] ans = new int[2];
        if (n * n == area) {
            ans[0] = n;
            ans[1] = n;
            return ans;
        }
        for (int i = n; i > 0; i--) {
            for(int j = n + 1; j <= area / i; j++){
                if (i * j == area){
                    ans[0] = j;
                    ans[1] = i;
                    return ans;
                }
            }
        }


        return ans;
    }

    public static int[] Rectangel(int area){
        int n = (int)Math.sqrt(area);
        while(area % n != 0){
            n--;
        }
        return new int[] {area / n, n};
    }
}
