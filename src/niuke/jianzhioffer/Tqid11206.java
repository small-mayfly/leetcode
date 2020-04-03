package niuke.jianzhioffer;

public class Tqid11206 {

    public boolean isNumeric(char[] str) {

        if(str.length==0)
            return false;
        int index = 0;
        int numPoint = 0;
        boolean num1Point = false;  // 记录当前数字是否已经有过小数点
//        boolean num2Point = false;  // 科学技术法指数一定为整数
        // 首先判断第一个字符，将第一个字符去除后，再次出现-+号一定为指数部分出现的
        if(str[0]=='-' || str[0]=='+'){
            index++;
        }else if(str[0]<='9' && str[0]>='0'){
            index++;
        }else{   // 异常情况，直接返回false
            return false;
        }

        // 依次判断
        while (index<str.length){
            if(str[index]=='-' || str[index]=='+'){
                if(str[index-1]=='e' || str[index-1]=='E'){
                    index++;
                }else{
                    return false;
                }
            }else if(str[index]<='9' && str[index]>='0'){
                index++;
            }else if(str[index]=='.'){
                if(numPoint==0){
                    if(num1Point == true){
                        return false;
                    }else{
                        index++;
                        num1Point = true;
                    }
                }else{
                    return false;
                }
            }else if(str[index]=='e' || str[index]=='E'){
                numPoint++;
                index++;
            }else{   // 异常情况，直接返回false
                return false;
            }
        }
        // 防止出现最后一位不是数字的情况
        if(str[index-1]>='0' && str[index-1]<='9')
            return true;
        else
            return false;
    }


    public static void main(String[] args) {
        Tqid11206 tqid11206 = new Tqid11206();
        String data = "-1E-16";
        System.out.println(tqid11206.isNumeric(data.toCharArray()));
    }
}
