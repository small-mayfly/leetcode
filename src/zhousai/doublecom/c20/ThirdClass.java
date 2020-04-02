package zhousai.doublecom.c20;

public class ThirdClass {
    /**
     * 只需遍历一遍字符串，即可找出所有子串
     * @param s
     * @return
     */
    public int numberOfSubstrings(String s) {
        // 如果长度不够一不存在包含abc的子串
        if(s.length()<3)
            return 0;
        // abc用于记录abc当前最后一次出现的位置
        int a = -1;
        int b = -1;
        int c = -1;
        // 用于记录所有子串个数
        int count = 0;
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'a':
                    a = i;
                    break;
                case 'b':
                    b = i;
                    break;
                default:
                    c = i;
            }
            // 找出abc中的最小值
            int minIndex = Math.min(a, Math.min(b, c));
            if(minIndex > -1){   // 全都大于1说明当前至少出现了一次包含了abc的子串
                // 对于当前包含abc的子串为min(a,b,c)~max(a,b,c)，这个子串前面有min(a,b,c)个字符，共有包含前面0，1，2，...，min(a,b,c)个字符共min(a,b,c)+1种情况
                // 所以总的情况数为min(a,b,c)+1
                count += (minIndex+1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String data = "aaacb";
        System.out.println(new ThirdClass().numberOfSubstrings(data));
    }


}
