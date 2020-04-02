package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MaximumProductofWordLengths {
	
	public boolean isEqual(String str1, String str2) {
		int[] rem = new int[26];
		int temp;
		for(int i=0;i<str1.length();i++) {
			temp = str1.charAt(i)-'a';
			rem[temp]=1;
		}
		for(int i=0;i<str2.length();i++) {
			temp = str2.charAt(i)-'a';
			if(rem[temp]==1)
				return true;
		}
		
		return false;
	}
	
	public boolean isEqual2(String str1, String str2) {
		int rema = 0;
		int remb = 0;
		for(int i=0;i<str1.length();i++) {
			rema |= 1 << (str1.charAt(i)-'a');
		}
		for(int i=0;i<str2.length();i++) {
			remb |= 1 << (str2.charAt(i)-'a');
		}
		return (rema&remb)==0?false:true;
	}
	
	// 循环判断两个字符串是否相等
	public int maxProduct(String[] words) {
		int result = 0;
        int tresult;
		for(int i=0;i<words.length;i++) {
			for(int j=i+1;j<words.length;j++) {
				if(isEqual2(words[i], words[j])) {
					continue;
				}else {
					tresult = words[i].length()*words[j].length();
					if(tresult>result)
						result = tresult;
				}
			}
		}
		
		
		return result;
    }
	
	
	public int maxProduct2(String[] words) {
		if(words.length<2)
			return 0;
		int result = 0;
		int tresult;
		HashMap<Integer, String> rem = new HashMap<Integer, String>();
		for (String string : words) {
			tresult = 0;
			for(int i=0;i<string.length();i++) {
				tresult |= 1<<(string.charAt(i)-'a');
			}
			if(string.length()>rem.getOrDefault(tresult, "").length()) {
				rem.put(tresult, string);
			}
		}
		for (Integer integer : rem.keySet()) {
			for (Integer integer2 : rem.keySet()) {
				if(integer!=integer2 && !isEqual2(rem.get(integer),rem.get(integer2))) {
					tresult = rem.get(integer).length()*rem.get(integer2).length();
					result = tresult>result?tresult:result;
				}
			}
		}
		return result;
    }
	
	
	public int maxProduct3(String[] words) {
		if(words.length<2)
			return 0;
		int result = 0;
		int tresult;
		int ttresult;
		HashMap<Integer, String> rem = new HashMap<Integer, String>();
		for (String string : words) {
			tresult = 0;
			for(int i=0;i<string.length();i++) {
				tresult |= 1<<(string.charAt(i)-'a');
			}
			for (Integer integer : rem.keySet()) {
				if((integer & tresult)==0) {
					ttresult = string.length()*rem.get(integer).length();
					if(ttresult>result) {
						result = ttresult;
					}
				}
			}
			if(string.length()>rem.getOrDefault(tresult, "").length()) {
				rem.put(tresult, string);
			}
		}
//		for (Integer integer : rem.keySet()) {
//			for (Integer integer2 : rem.keySet()) {
//				if((integer & integer2) ==0) {
//					tresult = rem.get(integer).length()*rem.get(integer2).length();
//					result = tresult>result?tresult:result;
//				}
//			}
//		}
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"a","ab","abc","d","cd","bcd","abcd"};
		new MaximumProductofWordLengths().maxProduct3(words);

	}

}
