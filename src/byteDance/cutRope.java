package byteDance;

import java.util.*;

/**
 * 有n根不同长的绳子，L(0)<L(1)<...<L(n-1)
 * 找出m根一样最长的绳子
 * 可以剪切，不可以拼接
 */
public class cutRope {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //准备工作
        int n = sc.nextInt();
        int m = sc.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextDouble();

        //从小到大排序
        Arrays.sort(arr);

        //夹逼锁值，求出上界，再寻值
        int poi = 0;//只需要找到有边界
        for (int i = 0; i < arr.length; i++) {
            int total = 1;
            for (int j = i + 1; j < arr.length; j++) {
                total += arr[j] / arr[i];
                if (total >= m)
                    break;
            }
            if (total < m) {
                poi = i;
                break;
            }
        }

        //开始寻值(这里可以确定上下界限，然后采用折半查找)
        //下界的最小值为0.01，最大是arr[poi-1],取决于poi>0? arr[poi-1]:0.01
        //上界是arr[poi]
        //折半查找的目的是找到一个值k，
        //使得k满足 以k为长度可以满足切割数大于等于m段，而以 k+0.01则不行
        double rt = arr[poi];
        double lf = poi > 0 ? arr[poi - 1] : 0.01;
        double len = BinaryFind(arr, poi, m, lf, rt);

        System.out.println(String.format("%.2f", len));

    }


    public static double BinaryFind(double[] arr, int poi, int m, double lf, double rt) {

        if (lf == rt)
            return lf;

        double mid = (lf + rt) / 2;
        mid = Double.parseDouble(String.format("%.2f", mid));//保留小数点后两位
        int m1 = 0;
        for (int i = poi; i < arr.length; i++) {
            m1 += arr[i] / mid;
            if (m1 > m) break;
        }

        int m2 = 0;
        for (int i = poi; i < arr.length; i++) {
            m2 += arr[i] / (mid + 0.01);
            if (m2 > m) break;
        }

        if (m1 >= m && m2 < m)
            return mid;//找到最优解

        if (m2 >= m) {
            lf = Double.parseDouble(String.format("%.2f", mid + 0.01));
            return BinaryFind(arr, poi, m, lf, rt);
        }
        return BinaryFind(arr, poi, m, lf, mid);

    }
}
