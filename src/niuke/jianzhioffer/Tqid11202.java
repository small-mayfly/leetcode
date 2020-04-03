package niuke.jianzhioffer;

public class Tqid11202 {
    public int StrToInt(String str) {
        int result = 0;
        str = str.trim();
        if(str.length()==0)
            return 0;
        int index = 0;
        int flag = 0;
        if(str.charAt(0)=='+'){

            index++;
        }
        if(str.charAt(0)=='-'){
            index++;
            flag = 1;
        }
        if(index+1>=str.length())
            return 0;
        int a = str.charAt(index) - '0';
        if(a>0 && a<10){
            result -= a;
        }else {
            return 0;
        }
        index++;
        while (index<str.length()){
            a = str.charAt(index) - '0';
            if(a>0 && a<10){
                result *= 10;
                result -= a;
                if(result>=0)
                    return 0;
            }else {
                return 0;
            }
            index++;
        }

        if(flag==0){
            result *= -1;
            if(result<0)
                return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        Tqid11202 tqid11202 = new Tqid11202();
        System.out.println(tqid11202.StrToInt("123"));
    }
}
