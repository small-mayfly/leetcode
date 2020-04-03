package niuke.jianzhioffer;

public class Tqid11196 {
    public String LeftRotateString(String str,int n) {
        if(str.length()==0)
            return str;
        else if(str.length()<n)
            n %= str.length();


        String lastStr = str.substring(n);
        String headStr = str.substring(0, n);



        return lastStr+headStr;
    }
}
