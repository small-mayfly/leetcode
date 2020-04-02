package hard;

public class LongestValidParentheses {
	/**
	 *	找出字符串中合法的()子串们的最大长度，比如())()合法子串长度为2，因为中间有个非法字符将两个子串隔开了
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
		// 如果长度不足2，一定不存在合法匹配
        if(s.length()<2)
        	return 0;
        // 首先去除最左边的非法子串，其实最右边的非法(((也可以用这种方法去除，不过是没有做
        int startIndex = 0;   // 从最左边开始遍历
        for(startIndex=0;startIndex<s.length();startIndex++) {
        	if(s.charAt(startIndex) != ')')
        		break;
        }
        s = s.substring(startIndex);   // 截取掉最左边的)))非法子串
        // 记录字符串中某个字符是否合法
        int[] cul = new int[s.length()];
        for(startIndex=0;startIndex<s.length();startIndex++) {   // 首先置为0，假设为不合法
        	cul[startIndex]=0;
        }
        int rem = 0;   // 使用rem来模拟入栈出栈操作，因为()的特殊性，入出结束后栈中没有剩余一定是合法的
        for(startIndex=0;startIndex<s.length();startIndex++) {
        	if(s.charAt(startIndex)=='(') {   // 首先如果是(则入栈，rem--
        		rem--;
        		cul[startIndex]++;   // 假设当前是合法的，所以+1
        	}else {   // )出栈
        		rem++;   // 模拟出栈操作
        		if(rem<=0) {   // 如果rem>0说明)过多，则)一定是非法的，所以当rem<=0时，可以假设合法
        			cul[startIndex]++;   // 合法的，所以+1
        		}else {   // 不合法
        			rem=0;   // 不合法直接将栈置空，从新开始入栈
        			cul[startIndex]--;   // 当前位置一定非法，所以，可以-1
        		}
        	}
        }
        // 如果只是从左向右一遍，因为有很多地方只能是假设合法，比如(()则最左边的非法字符也被假设为合法，但是对于())最右边的)一定能识别出非法
        // 所以使用相同的思路从右向左遍历一边，可以排除一些之前从左向右遍历无法确定的情况
        rem = 0;   // 情况栈
        for(startIndex=0;startIndex<s.length();startIndex++) {
        	if(s.charAt(s.length()-startIndex-1)==')') {   // 首先如果是)则入栈，rem--
        		rem--;
        		cul[s.length()-startIndex-1]++;   // 假设当前是合法的，所以+1
        	}else {   // )出栈
        		rem++;   // 模拟出栈操作
        		if(rem<=0) {   // 如果rem>0说明)过多，则)一定是非法的，所以当rem<=0时，可以假设合法
        			cul[s.length()-startIndex-1]++;   // 合法的，所以+1
        		}else {   // 不合法
        			rem=0;   // 不合法直接将栈置空，从新开始入栈
        			cul[s.length()-startIndex-1]--;   // 当前位置一定非法，所以，可以-1
        		}
        	}
        }
        // 经过两次遍历过后，合法的字符对应cul数组中的数字一定为2，所以只需要找出cul中最长的连续2的个数就是最长合法匹配子串长度
        rem = 0;   // 使用rem当做标识位，为0表示上一个字符是非法字符，需要从当前位置开始计数
        int tresult = 0;   // 记录当前查找的子串的合法长度
        int result = 0;   // 记录最长合法子串长度
        for(startIndex=0;startIndex<s.length();startIndex++) {
        	if(rem==0) {   // rem==0从当前位置开始计数，上一个遍历的位置不在合法子串中
        		if(tresult>result)   // 如果上一个合法子串长度大于目前已知合法子串长度则进行赋值
        			result=tresult;
        		tresult = 0;   // 开始准备对下一个合法子串长度计数
        	}
        	if(cul[startIndex]==2) {   // 当前位置合法
        		tresult++;   // 计数长度+1
        		rem++;   // 修改标识位，告诉下一次遍历当前字符合法
        	}else {
        		rem=0;   // 不合法，则标志当前位置非法
        	}
        }
        if(tresult>result)   // 处理最后的合法子串没有赋值的情况
			result=tresult;
        return result;   // 返回结果
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestValidParentheses lvp = new LongestValidParentheses();
		String s = "()(()";
		System.out.println(lvp.longestValidParentheses(s));
	}
}
