package com.company;

public class LeetCode038 {
    public static void main(String[] args) {
        int n = 300;
        long start = System.currentTimeMillis();

        String s = countAndSay(n);
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
        System.out.println(s);
    }

    public static String countAndSay(int n){
        String str = "1";
        for(int i = 2; i <= n; ++i){
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;
            while (pos < str.length()){
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)){
                    pos++;
                }
                sb.append(Integer.toString(pos - start)).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();

        }
        return str;
    }
}
