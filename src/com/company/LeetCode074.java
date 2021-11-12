package com.company;

public class LeetCode074 {
    public static void main(String[] args) {
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        int target = 3;
        int[][] matrix = {{1,1},{2,2}};
        int target = 2;
        System.out.println(searchMatrix(matrix,target));
    }

    public static boolean searchMatrix(int[][] matrix, int target){
        int row = matrix.length, col = matrix[0].length;

        if(col == 1){
            for(int i = 0; i < row; i++){
                if(matrix[i][0] == target)
                    return true;
            }
        }
        for(int i = 0; i < row; i++){
            if(matrix[i][0] <= target){
                int l = 0, r = col - 1;
                while(l <= r){
                    int mid = l + (r - l) / 2;
                    if(matrix[i][mid] == target)
                        return true;
                    else if(matrix[i][mid] > target){
                        r = mid - 1;
                    }
                    else
                        l = mid + 1;
                }
            }
        }
        return false;
    }

}
