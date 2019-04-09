package sort;


public class QuickSort {
    public static void quick(int[] arr,int l,int r) {
        if(l<r){
            int i = AdjustArray(arr, l, r);//先成挖坑填数法调整s[]
            quick(arr, l, i - 1); // 递归调用
            quick(arr, i + 1, r);
        }
    }

    public static int AdjustArray(int[] arr,int l ,int r){
        int i = l, j = r;
        int x = arr[l]; //s[l]即s[i]就是第一个坑
        while (i < j)
        {
            // 从右向左找小于x的数来填s[i]
            while(i < j && arr[j] >= x)
                j--;
            if(i < j)
            {
                arr[i] = arr[j]; //将s[j]填到s[i]中，s[j]就形成了一个新的坑
                i++;
            }
            // 从左向右找大于或等于x的数来填s[j]
            while(i < j && arr[i] < x)
                i++;
            if(i < j)
            {
                arr[j] = arr[i]; //将s[i]填到s[j]中，s[i]就形成了一个新的坑
                j--;
            }
        }
        //退出时，i等于j。将x填到这个坑中。
        arr[i] = x;
        return i;
    }

    public static void printNums(int[] arr){
        for(int x:arr){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr={9,6,75,35,73,46};
        System.out.println("排序前：");
        printNums(arr);
        System.out.println("排序后：");
        quick(arr,0,arr.length-1);
        printNums(arr);
    }
}
