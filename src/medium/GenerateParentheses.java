package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 这个题目可以看为，从坐标(0, 0)出发到(n, n)，每次沿x轴或y轴走一个单位长度，且不经过y=x线下方的所有可能路线的个数
 * 利用递归函数来进行深搜即可
 * @author 小蜉蝣
 *
 */

public class GenerateParentheses {
	/**
	 * 
	 * @param steps 每一步沿x轴走或y轴走，分别设steps为1或-1，用以记录每一步的情况
	 * @param now_value 记录当前1和-1相加和，如果小于0则一定处于y=x线的下方，不符合
	 * @param now_x 记录当前走了多少步1，防止1走多
	 * @param now_step 记录当前走了几步
	 * @param all_num 记录n的大小
	 * @param results 用以记录结果列表
	 */
	public void nextStep(int[] steps, int now_value, int now_x, int now_step, int all_num, List<String> results) {
		if(now_x>all_num)
			return;
		if(now_value<0)
			return;
		if(now_step==all_num*2) {
			if(now_value==0) {
				StringBuilder tresult = new StringBuilder();
				for(int i=0;i<2*all_num;i++) {
					tresult.append(steps[i]==1?"(":")");
				}
				results.add(tresult.toString());
				System.out.println(tresult.toString());
			}
			return;
		}
		// x步
		steps[now_step] = 1;
		nextStep(steps, now_value+1, now_x+1, now_step+1, all_num, results);
		// y步
		steps[now_step] = -1;
		nextStep(steps, now_value-1, now_x, now_step+1, all_num, results);

	}
	
	public void test(int n) {
		int xnum = 0;
		int value = 0;
		int[] steps = new int[2*n];
		for(int i=0; i<2*n; i++)
			steps[i]=0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				
			}
		}
	}
	
	public List<String> generateParenthesis(int n) {
		List<String> results = new LinkedList<String>();   // 因为不需要查，只需要添加即可，所以使用linkedlist
		int[] steps = new int[2*n];
		for(int i=0; i<2*n; i++)
			steps[i]=0;
		nextStep(steps, 0, 0, 0, n, results);
		System.out.println(results);
        return results;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParentheses gp = new GenerateParentheses();
		gp.generateParenthesis(3);

	}

}
