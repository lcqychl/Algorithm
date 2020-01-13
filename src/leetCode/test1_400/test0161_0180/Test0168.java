package leetCode.test1_400.test0161_0180;

/**
 * @author nimingxiong
 * Created at 2020/1/13 11:01
 */
public class Test0168 {
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            n--;
            sb.insert(0,(char) (n % 26 + 65));
            n = n / 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int a = 28;
        System.out.println(convertToTitle(a));
    }
}
