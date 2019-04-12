package network;
/**
 青蛙跳，有n节台阶，每次可以跳不多于d次，最多可以有几种跳法
 */
public class FrogJump {
    public static int jumpFloor(int n,int d){
        if(n==1){
            return 1;
        }
        int sum=0;
        for(int i=1;i<=n&&i<=d;i++){
            sum+=jumpFloor(n-i,d);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(jumpFloor(5,5));
    }
}
