package test360;

import java.util.Scanner;

public class test02 {
        public static String in = new String();
        public static int count(String in){
            return "3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER ".indexOf(in);
        }
        public static void main(String args[]) {
            Scanner s = new Scanner(System.in);
            in = s.nextLine();
            String [] line = in.split("-");
            String [] line1 = line[0].split(" ");
            String [] line2 = line[1].split(" ");
            if(in.contains("joker JOKER")){
                System.out.println("joker JOKER");
            }else if(line1.length!=line2.length){
                if (line1.length==4 && line1[0].compareTo(line1[1])==0 && line1[1].compareTo(line1[2])==0 && line1[2].compareTo(line1[3])==0){
                    System.out.println(line[0]);
                }else if(line2.length==4 && line2[0].compareTo(line2[1])==0 && line2[1].compareTo(line2[2])==0 && line2[2].compareTo(line2[3])==0){
                    System.out.println(line[1]);
                }else{
                    System.out.print("ERROR");
                }
            }
            else{
                if(count(line1[0])>count(line2[0])){
                    System.out.println(line[0]);
                }else{
                    System.out.println(line[1]);
                }
            }
        }
    }
