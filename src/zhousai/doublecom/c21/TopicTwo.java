package zhousai.doublecom.c21;

import java.util.HashMap;


/**
 * https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/discuss/531840/JavaPython-One-Pass
 * 每个元音字母出现有偶数次和奇数次两种情况，五个元音字母共有32种出现次数情况组合
 */
public class TopicTwo {

    public int findTheLongestSubstring(String s) {
        // 记录当前计算出的结果
        int result = 0;
        // 用来标志所有元音字母出现的情况
        int cur = 0;
        // 用来记录每种元音字母出现情况所对应的的最大字符串长度
        HashMap<Integer, Integer> seen = new HashMap<>();
        // 只有最终cur==0的才是我们要的结果，所以首先进行一次初始化，这样当所有原因字符都出现偶数次的时候，只要用index+1就是最大长度，因为全都没出现就是全都出现偶数次
        seen.put(0, -1);
        int temp;
        for (int i = 0; i < s.length(); ++i) {
            temp = 1<<("aeiou".indexOf(s.charAt(i)) + 1 )>>1;   // 查找当前字符在元音字母中的位置，如果不存在则设为0，否则设为2^index
            cur ^= temp;   // 用当前状态与当前字符做异或操作
            seen.putIfAbsent(cur, i);   // 如果是第一次出现这种状态则记录下来
            // 判断出当前已经遍历的子串的最长串。如果当前状态对应的字符串长于已知的子字符串长度，则替换
            // 关于i - seen.get(cur)的说明，两次出现同一个cur，说明两次同一状况出现两次，但是由于是异或操作，所以我们可以举个例子，第一次是只有一个e，则第二次是有三个e，所以两次长度相减就是中间包含两次e的最大长度
            result = Math.max(result, i - seen.get(cur));
        }
        return result;
    }
    public static void main(String[] args) {
        TopicTwo topicTwo = new TopicTwo();
        String data = "leetcodeisgreat";
        System.out.println(topicTwo.findTheLongestSubstring(data));
    }
}
