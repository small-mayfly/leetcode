package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * �����Ŀ���Կ�Ϊ��������(0, 0)������(n, n)��ÿ����x���y����һ����λ���ȣ��Ҳ�����y=x���·������п���·�ߵĸ���
 * ���õݹ麯�����������Ѽ���
 * @author С����
 *
 */

public class GenerateParentheses {
	/**
	 * 
	 * @param steps ÿһ����x���߻�y���ߣ��ֱ���stepsΪ1��-1�����Լ�¼ÿһ�������
	 * @param now_value ��¼��ǰ1��-1��Ӻͣ����С��0��һ������y=x�ߵ��·���������
	 * @param now_x ��¼��ǰ���˶��ٲ�1����ֹ1�߶�
	 * @param now_step ��¼��ǰ���˼���
	 * @param all_num ��¼n�Ĵ�С
	 * @param results ���Լ�¼����б�
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
		// x��
		steps[now_step] = 1;
		nextStep(steps, now_value+1, now_x+1, now_step+1, all_num, results);
		// y��
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
		List<String> results = new LinkedList<String>();   // ��Ϊ����Ҫ�飬ֻ��Ҫ��Ӽ��ɣ�����ʹ��linkedlist
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
