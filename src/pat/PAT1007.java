package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 这道题时间限制比较强，所以不能使用常规的动态规划来计算。
 * 利用优化过后的动态规划来计算，使复杂度降低为O(n)
 * 同时获取控制台输入不能使用Scanner in = new Scanner(System.in);要使用BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));，不然依然会超时，在这里浪费了太长时间
 * 后者比前者时间上少30ms左右
 * @author mayfly
 *
 */
public class PAT1007 {

	public void magic() throws IOException {
//		Scanner in = new Scanner(System.in);
//		in.nextLine();
//		
//		String[] datas = in.nextLine().split(" ");
//		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    reader.readLine();
	    String[] datas = reader.readLine().split(" ");
		int num = datas.length;
		int[] numbers = new int[num];
		int realSum, realStart, realEnd;
		
		int nowSum, nowStart, nowEnd;
		for(int i=0;i<num;i++)
			numbers[i] = Integer.valueOf(datas[i]);
		// 首先找到第一个非负数
		int index = 0;
		while(index<num) {
			if(numbers[index]<0) {
				index++;
			}else {
				break;
			}
		}
		// 如果所有数都是负数
		if(index==num) {
			realSum = 0;
			realStart = numbers[0];
			realEnd = numbers[num-1];
		}else {   // 否则开始正常计算
			realSum = realStart = realEnd = nowSum = nowStart = nowEnd = numbers[index];
			for(int i=index+1;i<num;i++) {
				if(nowSum+numbers[i]>0) {
					nowSum += numbers[i];
					nowEnd = numbers[i];
				}else {   // 如果当前和小于0，则重新开始计数
					index = i+1;
					while(index<num) {
						if(numbers[index]<0) {
							index++;
						}else {
							break;
						}
					}
					if(index==num) {
						break;
					}else {
						i = index;
						nowSum = nowStart = nowEnd = numbers[index];
					}
				}
				if(nowSum>realSum) {
					realSum = nowSum;
					realStart = nowStart;
					realEnd = nowEnd;
				}
			}
			
		}
		
		System.out.print(realSum + " " + realStart + " " + realEnd);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new PAT1007().magic();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
