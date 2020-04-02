package niuke.jianzhioffer;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 题目
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * 思路
 * 使用hashmap记录当前char，如果第一次出现则记录位置，如果第二次出现则用原来的位置减去当前的位置，因为是从前向后遍历的，所以如果出现多次位置记录那里一定是负数
 * 最后遍历hashmap，找到所有非负的位置记录点，最小的则是最先出现且仅出现一次的字符
 */
public class NIUKE11187 {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> rems = new HashMap<>();
        int strLen = str.length();
        // 如果字符之前没有出现过则记录位置，如果之前出现过则记录一个负数
        // 负数的产生是之前出现的位置减去再次出现的位置依次相减，一定小于0
        for (int i=0;i<strLen;i++){
            rems.put(str.charAt(i), rems.getOrDefault(str.charAt(i), i*2)-i);
        }

        // 遍历找到最小位置
        int remIndex = Integer.MAX_VALUE;
        Iterator<Character> characterIterator = rems.keySet().iterator();
        while (characterIterator.hasNext()){
            Character next = characterIterator.next();
            if(rems.get(next)>=0){
                remIndex = remIndex > rems.get(next) ? rems.get(next) : remIndex;
            }

        }
        if(remIndex<strLen){
            return remIndex;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new NIUKE11187().FirstNotRepeatingChar("zuDClOWjkPNhb"));
    }
}
