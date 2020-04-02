package pat;

import java.util.Scanner;
/**
 * 题目：https://pintia.cn/problem-sets/994805342720868352/problems/994805528788582400
 * 因为两个输入的大小无论是相加或相减都不会越界，所以这道题的关键在于输出的格式
 * @author mayfly
 * 
 * format转换关键字
 * d	整数型(10进制 )	
c	Unicode字符	
b	Boolean值	
s	String	
f	浮点数(10进制)
e	浮点数(科学计数)
x	整数(16进制)
h	散列码(16进制)
%	字符"%"
 *
 */
public class PAT1001 {
	
	public void method(int a, int b) {
		int c = a + b;
		if(Math.abs(c)<1000) {
			System.out.println(c);
		}else {
			System.out.format("%,d%n", c);
		}
	}
	
	public void method2(int a, int b) {
		int c = a + b;
		if(Math.abs(c)<1000) {
			System.out.println(c);
		}else {
			if(c<0) {
				System.out.print('-');
				c *= -1;
			}
			String data = String.valueOf(c);
			int rem = data.length();
			for(int i=0;i<data.length();i++) {
				if(i>0 && rem%3==0)
					System.out.print(',');
				rem--;
				System.out.print(data.charAt(i));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		PAT1001 p = new PAT1001();
		
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int a = in.nextInt();
			int b = in.nextInt();
			p.method(a, b);
			p.method2(a, b);
			
		}

	}

}
