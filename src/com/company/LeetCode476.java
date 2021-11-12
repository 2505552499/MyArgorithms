package com.company;

public class LeetCode476 {
    public static void main(String[] args) {
        int num = 5;
        int ans = findComplement(num);
        System.out.println(ans);
    }

    public static int findComplement(int num) {
        int highbit = 0;
        for (int i = 1; i <= 30; ++i) {
            if (num >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
        return num ^ mask;
    }
}
