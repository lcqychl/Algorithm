package leetCode.test1_400.test0061_0080;

public class Test0065 {
    public boolean isNumber(String s) {
        String end = s.substring(s.length()-1);
        if (end.matches("[fFdD]")){
            return false;
        }
        try{
            float a=new Float(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
