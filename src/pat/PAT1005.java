package pat;

import java.util.Scanner;
/**
 * 这道题应该是送分题，要注意输入的大小，因为输入最长是100位，所以必须按照字符串来获取
 * @author mayfly
 *
 */
public class PAT1005 {
	
	public void magic() {
		Scanner in = new Scanner(System.in);
		
		String data = in.nextLine();
		int sum = 0;
		for(int i=0;i<data.length();i++) {
			sum += (data.charAt(i)-'0');
			
		}
		data = String.valueOf(sum);
		String[] iter = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		System.out.print(iter[data.charAt(0)-'0']);
		for(int i=1;i<data.length();i++) {
			System.out.print(" " + iter[data.charAt(i)-'0']);
		}
		in.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PAT1005().magic();
	}

}
