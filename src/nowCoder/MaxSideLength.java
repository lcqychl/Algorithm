package nowCoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 题目描述
 牛牛手中有三根木棍,长度分别是a,b,c。牛牛可以把任一一根木棍长度削短,牛牛的目标是让这三根木棍构成一个三角形,并且牛牛还希望这个三角形的周长越大越好。
 输入描述:
 输入包括一行,一行中有正整数a, b, c(1 ≤ a, b, c ≤ 100), 以空格分割
 输出描述:
 输出一个整数,表示能拼凑出的周长最大的三角形。
 示例1
 输入
 1 2 3
 输出
 5
 */
public class MaxSideLength {

    public static int sum(int a,int b,int c){
        if(c-b-a>=0){
            return 2*(b+a)-1;
        }
        else{
            return a+b+c;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] num=new int[3];
        for(int i=0;i<3;i++){
            num[i]=sc.nextInt();
        }
        Arrays.sort(num);
        int a=num[0];
        int b=num[1];
        int c=num[2];
        System.out.println(sum(a,b,c));
    }
}
