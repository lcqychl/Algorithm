package network;

import java.util.Stack;

public class BigSumTest {
    //把字符串以字符形式放进栈中
    public Stack stringToStack(String str) {
        Stack stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9')
                stack.push(Integer.valueOf(String.valueOf(c)));
            else
                continue;
        }
        return stack;
    }

    //大数相加
    public String add(String a, String b) {
        Stack stackA = stringToStack(a);   //存放第一个数
        Stack stackB = stringToStack(b);   //存放第二个数
        Stack stackSum = new Stack();     //存放结果和
        int tempSum;    //两位数求和
        boolean isCarry = false;    //进位标志

        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            tempSum = (Integer) stackA.pop() + (Integer) stackB.pop();
            //若有进位，加1
            if (isCarry) {
                tempSum++;
                isCarry = false;
            }
            //位数和大于10，个位数入栈，标志进位
            if (tempSum >= 10) {
                tempSum -= 10;
                stackSum.push(tempSum);
                isCarry = true;
            } else {
                stackSum.push(tempSum);
            }
        }
        //取不为空的栈
        Stack stackTemp = !stackA.isEmpty() ? stackA : stackB;
        while (!stackTemp.isEmpty()) {
            //若原先有进位
            if (isCarry) {
                int end = (Integer) stackTemp.pop(); //取出栈中的数
                ++end;
                if (end >= 10)     //大于10，进位
                {
                    end -= 10;
                    stackSum.push(end);
                } else    //小于10，直接入栈
                {
                    stackSum.push(end);
                    isCarry = false;
                }
            }
            //若原先无进位
            else {
                stackSum.push(stackTemp.pop());
            }
        }
        //最高位有进位时,直接最后一个数为1
        if (isCarry)
            stackSum.push(1);
        //把栈中结果转为字符串
        String result = new String();
        while (!stackSum.isEmpty()) {
            result = result.concat(stackSum.pop().toString());
        }
        return result;
    }

    public static void main(String[] args) {
        BigSumTest bst = new BigSumTest();
        String a = "6293379654943111722643403";
        String b = "1523502388432201489337789";
        System.out.println("和为: " + bst.add(a, b));
    }

}
