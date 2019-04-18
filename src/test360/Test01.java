package test360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 假设对一行的数据只需要修改零或一次，使数据数据为非递减数列
 * 结果正确则输出Yes，错误输出No（结果区分大小写）
 * 输入未知行数据，输出对应结果
 * eg:
 * 输入：
 * 2 1
 * 2 3 4 3 4 5
 * 2 3 4 3 5 4 6
 * 输出：
 * Yes
 * Yes
 * No
 */
public class Test01 {
    public static boolean check(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i - 1] > nums[i]) {
                nums[i]=nums[i-1];
                j += 1;
                //对修改次数进行判断，大于一次跳出循环，略微降低时间复杂度
                if(j>1)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        //输入数据存储
        //判断是否有下一行
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            //判断下一行是否存在，在输入完结果enter为换行，需在按一次enter结束输入
            if(s==null||s.equals("")){
                break;
            }
            list.add(s);
        }
        //处理数据并调用方法判断
        int n=list.size();
        boolean[] r=new boolean[n];
        for(int i = 0; i < n; i++) {
            String s=list.get(i);
            //对行字符串去空格成String数组
            String[] s_nums = s.split(" ");
            //String数组转成int数组
            int[] nums = new int[s_nums.length];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = Integer.valueOf(s_nums[j]);
            }
            //调用check方法对数组结果进行判断
            r[i] = check(nums);
        }

        for (int i = 0; i < n; i++) {
            if (r[i]) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}

