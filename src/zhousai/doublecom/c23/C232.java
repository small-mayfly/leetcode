package zhousai.doublecom.c23;

import java.util.Collection;
import java.util.HashMap;

public class C232 {

    /**
     * 回文字符串最多能构建多少个，取决于字符串中，出现次数为奇数的字符的个数
     * 因为每个出现次数为奇数的字符，都要分到不同的回文字符串中
     * @param s
     * @param k
     * @return
     */
    public boolean canConstruct(String s, int k) {
        // 字符串为null，则不可能构成回文字符串
        if(s==null)
            return false;
        // 要求构成回文字符串个数为空，当s不为空时也不可能
        if(k==0)
            return false;
        // 如果字符串长度小于要构成的回文字符串个数，每个回文字符串分一个字符也不够分
        if(s.length()<k)
            return false;
        // 统计出现次数为奇数的字符的个数
        HashMap<Character, Integer> rem = new HashMap<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            rem.put(c, 1 - rem.getOrDefault(c, 0));
        }
        Collection<Integer> values = rem.values();
        int oddNum = 0;
        for (Integer value : values) {
            oddNum += value;
        }
        // 如果出现次数为奇数的字符的个数大于k，则返回失败
        if(oddNum>k){
            return false;
        }


        return true;
    }

    public static void main(String[] args) {
        C232 c232 = new C232();
        String str = "yzyzyzyzyzyzyzy";
        int k=2;
        System.out.println(c232.canConstruct(str, k));
    }


}
