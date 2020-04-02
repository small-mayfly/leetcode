package hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 总体思路较为简单，由于题目所说，如果有出现words那么words一定是按照一定的排列组成子串，所以只需要依次向后遍历即可
 * @author mayfly
 */
public class SubstringwithConcatenationofAllWords {
	/**
	 * @param s 要匹配的字符串
	 * @param words 单词列表
	 * @return 处理结果列表
	 */
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> results = new LinkedList<Integer>();   // 用于存储结果
		// 如果s为空，或words为空则一定匹配不出任何子串，直接返回即可
		if(s.length()==0)
			return results;
		if(words.length==0)
			return results;
		// 因为每个word长度一样，所以直接获取即可
        int wordLen = words[0].length();   // 获取单词的长度
        // 因为words中可能出现重复的单词，所以用map来记录个数(word, num)
        Map<String, Integer> newWords = new HashMap<String, Integer>();
        // 用于记录在遍历过程中的结果
        Map<String, Integer> nowRem = new HashMap<String, Integer>();
        // 初始化newWrods
        for(int i=0;i<words.length;i++) {
        	if(newWords.containsKey(words[i])) {
        		newWords.replace(words[i], newWords.get(words[i])+1);   // 出现多次
        	}else {
        		newWords.put(words[i], 1);   // 第一次出现
        	}
        }
        int availableNum = 0;   // 记录当前已经匹配成功的word个数
        int startIndex = 0;   // 记录当前开始位置
        for(int index=0; index<=s.length()-wordLen*words.length; index++) {   // 从头开始，每次后移一位，到最后可能匹配成功的位置为止
        	startIndex = index;   // 获取本轮匹配的头
			availableNum=0;   // 初始化已经匹配成功的word个数
			nowRem.clear();   // 初始化匹配成功记录
        	while(startIndex<=s.length()-wordLen) {   // 依次向后遍历
        		String str = s.substring(startIndex, startIndex+wordLen);   // 从字符串中获取一个词
        		if(newWords.containsKey(str)) {   // 如果成功匹配word，则记录
        			if(nowRem.containsKey(str)) {   // 已经出现过的word
        				nowRem.replace(str, nowRem.get(str)+1);   // 个数加1
        				if(nowRem.get(str)>newWords.get(str)) {   // 如果word出现次数超过words列表中出现的次数，则一定不会匹配成功，恢复环境，退出本轮循环，开始下一轮循环
        					break;
        				}else {   // 出现次数仍然合理则继续匹配
        					availableNum++;   // 匹配成功word个数+1
        					if(availableNum==words.length) {   // 如果全部匹配成功，则记录开始位置，并恢复环境，开始下一轮匹配
        						results.add(index);
            					break;
        					}
        				}
        			}else {   // 当前单词第一次出现
        				nowRem.put(str, 1);   // 设置出现次数为1
        				availableNum++;   // 匹配成功word次数+1
        				if(availableNum==words.length) {   // 如果单词在words列表中只出现一次，并且全部匹配成功，则记录开始位置，并恢复环境，开始下一轮匹配
    						results.add(index);
        					break;
    					}
        			}
        			startIndex += wordLen;   // 匹配成功一个词，开始查询下一个词
        		}else {   // 如果出现不匹配的情况，向下走一步
        			startIndex++;
        		}
        	}
        }
		return results;
    }

	public static void main(String[] args) {
		SubstringwithConcatenationofAllWords sca = new SubstringwithConcatenationofAllWords();
		String[] words = {"ab","ba","ba"};
		String s = "ababaab";
		System.out.println(sca.findSubstring(s, words));
	}
}
