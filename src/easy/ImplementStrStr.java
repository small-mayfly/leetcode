package easy;

public class ImplementStrStr {
	/**
	 * 获得needle子串在haystack中第一次出现的索引，如果没有出现过则返回-1
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr(String haystack, String needle) {
		if(needle.length()>haystack.length())   // 如果needle的长度大于haystack，则needle子串一定不会在haystack中出现
			return -1;
		if("".equals(needle) && "".equals(haystack))   // 如果二者都为空，返回0
			return 0;
		else if("".equals(haystack))   // 如果只有haystack为空，则一定是没出息
			return -1;
		else if("".equals(needle))   // 如果needle为空，haystack不为空，则返回0，因为空值可以在任意位置
			return 0;
		// 剩下的是无法直接判断的情况，只能遍历
		int result = -1;   // 首先假设needle不曾在haystack中出现
		int needleLen = needle.length();   // 获取needle的长度
		for(int i=0;i<=haystack.length()-needleLen;i++) {   // 从开始位置遍历到最后有可能的位置
			if(haystack.subSequence(i, i+needleLen).equals(needle)) {   // 如果找到则结束循环
				result = i;
				break;
			}
		}
		return result;   // 返回查找的结果
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementStrStr iss = new ImplementStrStr();
		String haystack = "hello";
		String needle = "hello";
		System.out.println(iss.strStr(haystack, needle));
	}

}
