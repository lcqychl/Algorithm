package nowCoder;

import java.util.Scanner;

/**
输入描述:
第一行一个整数n，表示超市中面包的总类型数，1≤n≤100;
第二行n个整数，第i个数表示第i种面包的价格ai，1≤ai≤100
第三行一个整数m，1≤m≤100
接下来m行每一行有两个整数x,y，表示第x种面包购买了y个，保证1≤x≤n，1≤y≤100
输出描述:
输出一个整数，表示购买面包总价格。
示例1
输入
复制
52
73 41 72 19 94 18 45 94 75 98 44 69 21 22 68 16 20 82 71 16 89 59 80 62 70 79 36 33 62 27 22 53 83 85 66 50 7 51 72 53 87 92 58 57 6 78 43 60 41 40 56 13
61
24 70
13 45
39 10
41 30
52 70
31 21
50 41
14 35
30 12
47 79
1 18
38 15
10 77
49 28
38 22
35 56
19 83
28 96
22 50
8 7
17 69
33 40
41 32
25 39
16 47
12 79
25 24
10 46
42 75
39 5
6 93
35 30
9 74
21 76
21 93
47 65
18 17
8 38
4 48
52 34
31 39
11 27
36 50
45 54
46 30
9 45
27 60
9 4
4 18
45 75
14 48
1 45
35 64
24 26
45 1
30 40
8 10
49 8
30 35
52 24
38 15
输出
复制
135993
 */
public class BuyBread {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] ni=new int[n];
        for(int i=0;i<n;i++){
            ni[i]=sc.nextInt();
        }
        int m=sc.nextInt();
        int[] xi=new int[m];
        int[] yi=new int[m];
        for(int j=0;j<m;j++){
            xi[j]=sc.nextInt();
            yi[j]=sc.nextInt();
        }
        sc.close();
        int sum=0;
        for(int k=0 ;k<m;k++){
            if(xi[k]<=n)
                sum+=ni[xi[k]-1]*yi[k];
        }
        System.out.println(sum);
    }
}
