package nowCoder;

import java.util.Scanner;

/**
 牛牛和羊羊非常无聊.他们有n + m个共同朋友,他们中有n个是无聊的,m个是不无聊的。每个小时牛牛和羊羊随机选择两个不同的朋友A和B.(如果存在多种可能的pair(A, B),任意一个被选到的概率相同。),然后牛牛会和朋友A进行交谈,羊羊会和朋友B进行交谈。在交谈之后,如果被选择的朋友之前不是无聊会变得无聊。现在你需要计算让所有朋友变得无聊所需要的时间的期望值。
 输入描述:
 输入包括两个整数n 和 m(1 ≤ n, m ≤ 50)
 输出描述:
 输出一个实数,表示需要时间的期望值,四舍五入保留一位小数。
 示例1
 输入
 复制
 2 1
 输出
 复制
 1.5
 */
public class Bored {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        sc.close();
        int total = n+m;
        double[] f = new double[m + 1];
        f[0] = 0;
        f[1] = total/2.0;
        double max = total * (total - 1);
        for (int i = 2; i <= m;i++) {
            double tmp = total - i;
            double p1 = tmp * (tmp - 1)/max;//两个无聊的人
            double p2 = 2*tmp*i/max;//一个无聊的人
            double p3 = i*(i-1)/max;//零个无聊的人
            f[i] = (1 + p2 * f[i - 1] + p3 * f[i - 2]) / (1 - p1);
    }
        System.out.println(String.format("%.1f", f[m]));
    }
}
