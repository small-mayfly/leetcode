package niuke.jianzhioffer;

public class Tqid11205 {

    public boolean magic(char[] str, char[] pattern, int start1, int start2){

        if(str.length<=start1){   // str为空
            if(pattern.length<=start2){
                return true;
            }else{
                if(start2+1<pattern.length){
                    if(pattern[start2+1]=='*'){
                        return magic(str, pattern, start1, start2+2);
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }else{ // str不为空
            if(pattern.length<=start2){   // pattern为空，直接返回false
                return false;
            }else if(start2+1<pattern.length){   // pattern还有较多值
                if(pattern[start2+1]=='*'){
                    if(pattern[start2]=='.' || pattern[start2]==str[start1]){   // 如果可以匹配当前字符
                        return (magic(str, pattern, start1+1, start2+2) || magic(str, pattern, start1+1, start2)) || magic(str, pattern, start1, start2+2);
                    }else{   // 如果不能匹配当前字符
                        return magic(str, pattern, start1, start2+2);
                    }
                }else{
                    if(pattern[start2]=='.' || pattern[start2]==str[start1]){
                        return magic(str, pattern, start1+1, start2+1);
                    }else{
                        return false;
                    }
                }
            }else{   // 如果pattern只有一个值了
                if(pattern[start2]=='.' || pattern[start2]==str[start1]){
                    start1++;
                    if(start1>=str.length)
                        return true;
                    else
                        return false;
                }else{
                    return false;
                }
            }
        }
    }

    public boolean match(char[] str, char[] pattern)
    {
        if(str.length==0 && pattern.length==0){
            return true;
        }

        if(str.length>0 && pattern.length==0)
            return false;
        return magic(str, pattern, 0, 0);

    }

    public boolean match2(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        Tqid11205 tqid11205 = new Tqid11205();
        String str = "";
        String pattern = ".";
        System.out.println(tqid11205.match(str.toCharArray(), pattern.toCharArray()));
        System.out.println(tqid11205.match2(str.toCharArray(), pattern.toCharArray()));
    }
}
