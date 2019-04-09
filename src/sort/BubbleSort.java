package sort;



public class BubbleSort {
    public static void bubble(int[] nums){
        int temp;
        for(int i=0;i<nums.length;i++)
            for(int j=0;j<nums.length-1-i;j++)
            if(nums[j+1]<nums[j]){
                temp=nums[j+1];
                nums[j+1]=nums[j];
                nums[j]=temp;
            }
    }

    public static void printNums(int[] nums){
        for(int x:nums){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums={9,6,75,35,73,46};
        System.out.println("排序前：");
        printNums(nums);
        System.out.println("排序后：");
        bubble(nums);
        printNums(nums);
    }
}
