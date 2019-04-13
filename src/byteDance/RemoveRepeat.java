package byteDance;

import java.util.Scanner;

/**
 * 去除重复的AAA或者AABB类型去除
 */
public class RemoveRepeat {
    public static String remove(String s){
        StringBuffer sb=new StringBuffer();
        switch (s.length()){
            case 0:
                break;
            case 1:
                sb.append(s.charAt(0));
                break;
            case 2:
                sb.append(s.charAt(0));
                sb.append(s.charAt(1));
                break;
            default:
                sb.append(s.charAt(0));
                sb.append(s.charAt(1));
                int j=1;
                for (int i = 2; i < s.length(); i++) {
                    if (j>=2&&sb.charAt(j-2) == sb.charAt(j-1)&&sb.charAt(j)==s.charAt(i)) {
                        continue;
                    }
                    else if(j>=2&&sb.charAt(j-1)==sb.charAt(j)&&sb.charAt(j)==s.charAt(i)){
                        continue;
                    }
                    else if(j<2&&sb.charAt(j-1)==sb.charAt(j)&&sb.charAt(j)==s.charAt(i)){
                        continue;
                    }
                    else{
                            sb.append(s.charAt(i));
                            j+=1;
                        }
                }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(remove(s));
    }
}
