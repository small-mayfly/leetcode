package niuke.jianzhioffer;

import java.util.ArrayList;

/**
 * ��Ϊ�����������飬���賤��Ϊsum��ƽ��ֵΪmin���Ҷ�Ϊ����������sum/num=avg,avg-num/2>0�ɴ˿��Եó�num<=Math.floor(Math.sqrt(sum*2));
 * @author mayfly
 *
 */
public class NIUKE11194 {
	
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		// ��¼�ܵĽ��
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		// ������������Ϊ�೤
		int maxLen = (int)Math.floor(Math.sqrt(sum*2));
		int min;
		while(maxLen>1) {
			// �ж�ƽ��ֵ�����ƽ��ֵ��������˵�������������У������0.5˵����ż�������У����򲻿����е�ǰ���ȵ���������
			float avg = 1.0f*sum/maxLen;
			if((avg-Math.floor(avg))==0) {
				// ��ǰ����Ӧ��Ϊ��������ʵ����Ϊż�������Դ���ì�ܣ���������ɺ�sum����������
				if(maxLen%2==0) {
					maxLen--;
					continue;
				}
				min = (int)avg - (maxLen-1)/2;   // �������ǰ���е���Сֵ
				
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
			// ������д������
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
