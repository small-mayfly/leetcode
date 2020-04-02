package niuke.jianzhioffer;

import java.util.ArrayList;

/**
 * 因为是连续的数组，假设长度为sum，平均值为min，且都为正数，所以sum/num=avg,avg-num/2>0由此可以得出num<=Math.floor(Math.sqrt(sum*2));
 * @author mayfly
 *
 */
public class NIUKE11194 {
	
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		// 记录总的结果
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		// 计算出最长的序列为多长
		int maxLen = (int)Math.floor(Math.sqrt(sum*2));
		int min;
		while(maxLen>1) {
			// 判断平均值，如果平均值是整数则说明有奇数个序列，如果余0.5说明有偶数个序列，否则不可能有当前长度的连续序列
			float avg = 1.0f*sum/maxLen;
			if((avg-Math.floor(avg))==0) {
				// 当前长度应该为奇数，但实际上为偶数，所以存在矛盾，不可能组成和sum的连续序列
				if(maxLen%2==0) {
					maxLen--;
					continue;
				}
				min = (int)avg - (maxLen-1)/2;   // 计算出当前序列的最小值
				
			}else if((avg-Math.floor(avg))==0.5) {
				if(maxLen%2==1){
					maxLen--;
					continue;
				}
				min = (int)Math.floor(avg) - maxLen/2 + 1;
			}else {
				maxLen--;
				continue;
			}
			// 将序列写入结果中
			ArrayList<Integer> result = new ArrayList<Integer>();
			for(int i=0;i<maxLen;i++)
				if(min+i>0)
					result.add(min+i);
			if(result.size()>1)
				results.add(result);
			maxLen--;
		}
		
		
	    return results;   
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NIUKE11194().FindContinuousSequence(100);

	}

}
