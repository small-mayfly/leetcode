package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PAT1015 {
	
	public boolean isPrime(int data) {
		if(data==1)
			return false;
		if(data==2)
			return true;
		int mid = (int)Math.sqrt(data);
		for(int i=2;i<=mid;i++) {
			if(data%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public int reverseWithRadix(int data, int radix) {
		return Integer.parseInt(new StringBuilder(Integer.toString(data, radix)).reverse().toString(), radix);
	}
	
	public void magic() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String [] datas;
		while(true) {
			// 取得值并转化为10进制数
			datas = in.readLine().split(" ");
			int num = Integer.parseInt(datas[0]);
			if(num<0)
				break;
			int radix = Integer.parseInt(datas[1]);
			if(isPrime(num) && isPrime(reverseWithRadix(num, radix))) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
		}
		
		in.close();
	}

	public static void main(String[] args) throws IOException {
		new PAT1015().magic();
	}

}
