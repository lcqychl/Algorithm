package network;

public class FibonacciSequence {
    //递推方式
    public static int testFibonacci1(int n) {
        int a = 1, b=1, c = 0;
        if (n <= 2) {
            return  a;
        }
        for (int i = 3; i <= n; i++) {
                c = a+b;
                a = b;
                b = c;
        }
        return c;
    }
    //递推方式－数组方式
    public static int testFibonacci2(int n) {
        int[] arrayList = new int[n];
        arrayList[0] = arrayList[1] =1;
        for (int i = 0; i < arrayList.length; i++) {
            if (i >1) {
                arrayList[i] = arrayList[i-1] +arrayList[i-2];
            }
        }return arrayList[n-1];
    }
    //递归方式
    public static int testFibonacci3(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }else {
            return testFibonacci3(n-1) + testFibonacci3(n-2);
        }
    }
    public static void main(String[] args) {
        System.out.println(testFibonacci1(5));
        System.out.println(testFibonacci2(6));
        System.out.println(testFibonacci3(7));
    }
}
