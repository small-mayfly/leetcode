package hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * ����˼·��Ϊ�򵥣�������Ŀ��˵������г���words��ôwordsһ���ǰ���һ������������Ӵ�������ֻ��Ҫ��������������
 * @author mayfly
 */
public class SubstringwithConcatenationofAllWords {
	/**
	 * @param s Ҫƥ����ַ���
	 * @param words �����б�
	 * @return �������б�
	 */
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> results = new LinkedList<Integer>();   // ���ڴ洢���
		// ���sΪ�գ���wordsΪ����һ��ƥ�䲻���κ��Ӵ���ֱ�ӷ��ؼ���
		if(s.length()==0)
			return results;
		if(words.length==0)
			return results;
		// ��Ϊÿ��word����һ��������ֱ�ӻ�ȡ����
        int wordLen = words[0].length();   // ��ȡ���ʵĳ���
        // ��Ϊwords�п��ܳ����ظ��ĵ��ʣ�������map����¼����(word, num)
        Map<String, Integer> newWords = new HashMap<String, Integer>();
        // ���ڼ�¼�ڱ��������еĽ��
        Map<String, Integer> nowRem = new HashMap<String, Integer>();
        // ��ʼ��newWrods
        for(int i=0;i<words.length;i++) {
        	if(newWords.containsKey(words[i])) {
        		newWords.replace(words[i], newWords.get(words[i])+1);   // ���ֶ��
        	}else {
        		newWords.put(words[i], 1);   // ��һ�γ���
        	}
        }
        int availableNum = 0;   // ��¼��ǰ�Ѿ�ƥ��ɹ���word����
        int startIndex = 0;   // ��¼��ǰ��ʼλ��
        for(int index=0; index<=s.length()-wordLen*words.length; index++) {   // ��ͷ��ʼ��ÿ�κ���һλ����������ƥ��ɹ���λ��Ϊֹ
        	startIndex = index;   // ��ȡ����ƥ���ͷ
			availableNum=0;   // ��ʼ���Ѿ�ƥ��ɹ���word����
			nowRem.clear();   // ��ʼ��ƥ��ɹ���¼
        	while(startIndex<=s.length()-wordLen) {   // ����������
        		String str = s.substring(startIndex, startIndex+wordLen);   // ���ַ����л�ȡһ����
        		if(newWords.containsKey(str)) {   // ����ɹ�ƥ��word�����¼
        			if(nowRem.containsKey(str)) {   // �Ѿ����ֹ���word
        				nowRem.replace(str, nowRem.get(str)+1);   // ������1
        				if(nowRem.get(str)>newWords.get(str)) {   // ���word���ִ�������words�б��г��ֵĴ�������һ������ƥ��ɹ����ָ��������˳�����ѭ������ʼ��һ��ѭ��
        					break;
        				}else {   // ���ִ�����Ȼ���������ƥ��
        					availableNum++;   // ƥ��ɹ�word����+1
        					if(availableNum==words.length) {   // ���ȫ��ƥ��ɹ������¼��ʼλ�ã����ָ���������ʼ��һ��ƥ��
        						results.add(index);
            					break;
        					}
        				}
        			}else {   // ��ǰ���ʵ�һ�γ���
        				nowRem.put(str, 1);   // ���ó��ִ���Ϊ1
        				availableNum++;   // ƥ��ɹ�word����+1
        				if(availableNum==words.length) {   // ���������words�б���ֻ����һ�Σ�����ȫ��ƥ��ɹ������¼��ʼλ�ã����ָ���������ʼ��һ��ƥ��
    						results.add(index);
        					break;
    					}
        			}
        			startIndex += wordLen;   // ƥ��ɹ�һ���ʣ���ʼ��ѯ��һ����
        		}else {   // ������ֲ�ƥ��������������һ��
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
