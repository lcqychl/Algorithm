package byteDance;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**小a在玩一个很简单的游戏，游戏的内容是控制一个小人在一块矩形的空地内走，一旦小人走出矩阵范围，游戏就失败。
游戏机有上，下，左，右四个按键，每按一下小人就向相应的方向走一步。这个游戏过于简单，小a说：“这种游戏我闭着眼睛玩都输不了”。
于是他便闭上眼睛,进行一连串的操作。但若他中途输了的话就会停止。
那么问题来了:给定小a的操作，进行Q次询问，你能算出每次询问小人能走多少步吗？
输入描述:
第一行为长度L的字符串S，每个字符依次代表小a的一次操作。’u’代表向上，’d’代表向下，’l’代表向左，’r’代表向右。字符串S不会包含其他字符。
第二行是整数Q，代表Q次询问
接下来Q行，每行有四个整数，N，M，X，Y，保证1<=X<=N，1<=Y<=M，矩阵大小为N*M，小人初始位置为(X, Y)。
*/
public class MatrixGame {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String c=sc.next();

        /*int[][] q=null;
        for(int j=0;j<4;j++)
        { int i=0;
            q[i][j]=sc.nextInt();
            i++;
            D:\workspace\apache-maven-3.6.0\bin;
            C:\ProgramData\Oracle\Java\javapath;
            %MYSQL_HOME%\bin;
            %GO_HOME%\bin;
            C:\Windows\system32;
            C:\Windows;
            C:\Windows\System32\Wbem;
            C:\Windows\System32\WindowsPowerShell\v1.0\;
            D:\MATLAB\runtime\win64;
            D:\MATLAB\bin;
            D:\MATLAB\polyspace\bin;
            D:\Git\cmd;
            D:\nodejs\;
            C:\Program Files (x86)\NVIDIA Corporation\PhysX\Common
        }*/
        System.out.println(count(c,8,10,6,5));
    }

    public static int count(String c,int N,int M,int X,int Y) {
        char a[] = c.toCharArray();
        int count = 0;
        for (int k = 0; k < a.length; k++) {
            switch (a[k]) {
                case 'u':
                    Y++;
                    if (Y > M) {
                        return count;
                    }
                    count++;
                    break;
                case 'd':
                    Y--;
                    if (Y < 1) if (Y > M) {
                        return count;
                    }
                    count++;
                    break;
                case 'r':
                    X++;
                    if (X > N) {
                        return count;
                    }
                    count++;
                    break;
                case 'l':
                    X--;
                    if (X <1) {
                        return count;
                    }
                    count++;
                    break;
            }
        }
        return 0;
    }
}
