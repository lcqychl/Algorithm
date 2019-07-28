package skill;


public class Test {

    public static void main(String[] args) {
        //不需要辅助空间交换值
        int x=1;
        int y=2;
        x=x^y;
        y=x^y;
        x=x^y;
        System.out.println(x+","+y);
    }
}
