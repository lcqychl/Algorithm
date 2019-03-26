package network;

import java.util.Scanner;

//判断一个整数是否是奇数
public class IsOddTest {
    //错误一,要求返回Boolean型，却打印输出
    /*public boolean isOdd(int i) {
        if (i % 2 == 1) {
            System.out.println("是奇数");
        } else {
            System.out.println("是偶数");
        }
    }*/

    //解决一，返回多余
    /*public boolean isOdd(int i) {
        if (i % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }*/

    //解决二，返回简练，但没有考虑负值
    /*public boolean isOdd(int i) {
        return i % 2 == 1;
    }*/

    //传入的i为负数，运算复杂
    /*public boolean isOdd(int i) {
        return i % 2 == 1 || i % 2 == -1;
    }*/

    //优化
    /*public boolean isOdd(int i) {
        return i % 2 != 0;
    }*/

    //优化 移位操作
    /*public boolean isOdd(int i) {
        return i >> 1 << 1 != i;
    }*/

    private static boolean isOdd(int i) {
        return (i & 1) == 1;
    }

    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        int a=scanner.nextInt();
        System.out.println(isOdd(a));
    }
}
