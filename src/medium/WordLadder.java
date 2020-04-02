package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WordLadder {
	// 计算两个word之间的距离
	public int culLen(String source, String target) {
		int lens = source.length();
		int lent = target.length();
		int result = 0;
		if(lens==lent) {
			for(int i=0;i<lens;i++) {
				if(source.charAt(i)!=target.charAt(i)) {
					result++;
				}
			}
		}else {
			result = Math.abs(lens-lent);
			for(int i=0;i<Math.min(lens,  lent);i++) {
				if(source.charAt(i)!=target.charAt(i)) {
					result++;
				}
			}
		}
		return result;
	}
	// 广度优先遍历
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int wordNum = wordList.size();
        if(wordNum==0)
        	return 0;
        else if(wordNum==1) {
        	if(wordList.get(0).equals(endWord))
        		return 2;
        	else
        		return 0;
        }else {
        	int rem=-1;
        	for(int i=0;i<wordNum;i++) {
        		if(wordList.get(i).equals(endWord))
        			rem = i;
        	}
        	if(rem==-1)
        		return 0;
        	else if(culLen(beginWord, endWord)==1)
        		return 2;
        	else {
        		wordList.remove(rem);
        		LinkedList<String> tl = new LinkedList<String>();
        		tl.add(beginWord);
        		rem = 1;
        		int newRem = 0;
        		int nowLen = 1;
        		int tLen;
        		while(wordList.size()>0) {
        			while(rem>0) {
        				tLen = wordList.size()-1;
        				while(tLen>=0) {
        					if(culLen(tl.getFirst(), wordList.get(tLen))==1) {
        						newRem++;
        						tl.addLast(wordList.remove(tLen));
        						if(culLen(tl.getLast(), endWord)==1) {
        							return nowLen+2;
        						}
        					}
        					tLen--;
        				}
        				rem--;
        				tl.removeFirst();
        			}
        			if(newRem==0)
        				return 0;
        			rem = newRem;
        			newRem=0;
        			nowLen++;
        		}
        	}
        }
        return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> datas = new ArrayList<String>();
		datas.add("lest");
		datas.add("leet");
		datas.add("lose");
		datas.add("code");
		datas.add("lode");
		datas.add("robe");
		datas.add("lost");
		System.out.println(new WordLadder().ladderLength("leet", "code", datas));
	}

}
