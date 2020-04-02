package zhousai.doublecom.c21;

/**
 * 桶排序，暴力遍历
 * 首先遍历一边字符串，记录每个字符出现的次数，然后依次从小到大，从大到小添加到输出字符串的末尾
 */
public class TopicOne {

    public String sortString(String s) {
        // 因为只有小写字母，所以可以用数组记录每个字符出现的次数
        int[] rem = new int[26];
        for (int i=0;i<s.length();i++)
            rem[s.charAt(i)-'a'] ++;
        // 构建输出字符串
        StringBuilder result = new StringBuilder();
        // 循环遍历数组，直到所有字符全部添加到结果字符串中
        while (result.length()<s.length()){
            // 首先按照从小到大的顺序添加一遍
            for(int i=0;i<26;i++){
                if(rem[i]>0){
                    result.append((char)('a'+i));
                    rem[i]--;
                }
            }
            // 按照从大到小的顺序添加一遍
            for(int i=25;i>=0;i--){
                if(rem[i]>0){
                    result.append((char)('a'+i));
                    rem[i]--;
                }
            }
        }
        // 输出结果
        return result.toString();
    }

    public static void main(String[] args) {
        TopicOne topicOne = new TopicOne();
        String data = "spo";
        System.out.println(topicOne.sortString(data));
    }
}
