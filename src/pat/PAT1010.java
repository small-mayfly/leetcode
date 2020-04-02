package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class PAT1010 {
	
	public void magic() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] datas = in.readLine().split(" ");
		String n1 = datas[0];
		String n2 = datas[1];
		long radix = Long.valueOf(datas[3]);
		
		if(n1.equals(n2)) {
			System.out.print(radix);
			return;
		}
		
		int t;
		if(datas[2]=="2") {
			String tstr = n1;
			n1 = n2;
			n2 = tstr;
		}
		// 获取输入值
		BigInteger data1 = BigInteger.ZERO;
		for(int i=0;i<n1.length();i++) {
//			data1 *= radix;
			
			if(n1.charAt(i)>='0' && n1.charAt(i)<='9') {
				t = n1.charAt(i) - '0';
			}else {
				t = n1.charAt(i) - 'a' + 10;
			}
			data1 = data1.multiply(BigInteger.valueOf(radix)).add(BigInteger.valueOf(t));
			
		}
		// 首先遍历一遍获取最大值
		int maxNum = 0;
		for(int i=0;i<n2.length();i++) {
			if(n2.charAt(i)>='0' && n2.charAt(i)<='9') {
				if(n2.charAt(i)-'0'>maxNum) {
					maxNum = n2.charAt(i)-'0';
				}
			}else {
				if(n2.charAt(i)-'a'+10>maxNum) {
					maxNum = n2.charAt(i)-'a'+10;
				}
			}
		}
		// n2的radix不小于maxNum+1
		maxNum++;
		// 从最小可能的进制开始向后遍历
		boolean flag = true;
		
		while(maxNum<=36) {
			if(maxNum==radix)
				continue;
			BigInteger nowBase = BigInteger.ONE;
			for(int i=0;i<n2.length()-1;i++) {
				nowBase = nowBase.multiply(BigInteger.valueOf(maxNum));
			}
			for(int i=0;i<n2.length();i++) {
				
			}
			
			
			
		}

		
		
		in.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new PAT1010().magic();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
