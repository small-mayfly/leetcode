package easy;

public class CountandSay {
	/**
	 * 从头开始算起，算到n截止
	 * @param n
	 * @return 计算出的字符串
	 */
	public String countAndSay(int n) {
		if(n==0)   // 第0个直接返回空即可
			return "";
		else if(n==1)
			return "1";   // 题目所给，第一个为1
		else if(n==2)
			return "11";   // 题目所给，第二个为11
		// 剩余的情况由计算得到
		// 生成stringbuffer，主要是由于不知道多长，所以使用它来处理变长
		StringBuilder t = new StringBuilder();
		// 初始化n==2的情况
		t.append('1');
		t.append('1');
		int remLen = t.length();   // 获取当前字符串长度
		int index = 0;   // 从头开始遍历
		char a='1';   // 旗帜词，用于记录
		int count;   // 用来计数，有多少个
		for(int i=2;i<n;i++) {   // 从2开始向后遍历
			a = t.charAt(0);   // 用来记录第一个值是什么
			index = 1;   // 从1开始遍历，因为0已经赋值给a
			count = 1;   // 当前已经有count个a出现
			while(index<remLen) {   // 遍历整个字符串，进行计数
				if(t.charAt(index)==a) {   // 如果当前词和上一个词一样，则继续计数
					count++;
				}else {   // 如果不一样，则需要更新当前记录词，也就是更改旗帜
					// 先将当前记录结果放入字符串的后面
					t.append((char)(count+'0'));   // 将当前计数值放入字符串的末尾
					t.append(a);   // 将当前旗帜放入字符串的末尾
					// 修改旗帜
					a = t.charAt(index);
					count = 1;   // 重新开始计数
				}
				index++;   // 遍历一个词，索引向后移动
			}
			// 最后一个字符的计数肯定没有放入字符串的末尾，所以放进去
			t.append((char)(count+'0'));
			t.append(a);
			// 将字符串中之前的字符清除掉
			t.delete(0, remLen);
			// 记录新生成的字符串的长度
			remLen = t.length();
//			System.out.println(t.toString());   // 输出当前新遍历的结果，不需要输出
		}
        return t.toString();   // 返回结果
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountandSay cts = new CountandSay();
		System.out.println(cts.countAndSay(6));
	}

}
