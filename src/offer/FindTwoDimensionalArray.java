package offer;

import java.util.Scanner;

public class FindTwoDimensionalArray {
    /**题目描述
    *在一个二维数组中(每个一维数组的长度相同)，每一行都按照从左到右递增的顺序排序，
    *每一列都按照从_上到下递增的顺序排序。请完成一个函数，输入这样的一-个二维数组
    *和一个整数* ，判断数组中是否含有该整数。
    */

    public boolean Find(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1;//从右上角开始
        while (r <= rows - 1 && c >= 0) {
            if (target == matrix[r][c])
                return true;
            else if (target > matrix[r][c])
                r++;
            else
                c--;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
    }
}
