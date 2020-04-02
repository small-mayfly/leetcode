package medium;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
	/**
	 * ����һ�����list��copy
	 * @param rem ��ǰ������Ľ��
	 * @return ����copy�Ķ���
	 */
	public List<Integer> getList(List<Integer> rem){
		List<Integer> trem = new LinkedList<Integer>();
		for(Integer t: rem) {
			trem.add(t);
		}
		return trem;
	}
	/**
	 * �������������������Ͳ��뵽results�У����������Ͳ���
	 * @param candidates ��ѡ��
	 * @param index ��ǰ�Ѿ�������������
	 * @param value ��ǰ�Ѿ���ȥ�Ľ��ֵ�����ڱ��μ���
	 * @param rem ��ǰ�Ѿ���������м�������
	 * @param results ���������
	 */
	public void search(int [] candidates, int index, int value, List<Integer> rem, List<List<Integer>> results){
		int result;   // ��¼��ȥ��ǰ����λ��ֵ�Ľ��
		if(index>=0 && value>=0) {
			result = value-candidates[index];   //��һ�ֽ����ȥ��ǰ����λ��ֵ�Ľ��
			if(result>0) {   // ������>0������һ�ּ���
				rem.add(candidates[index]);   // ����ǰ����ֵ���뵽�м�list��
				for(int i=index;i>=0;i--) {   // �������п��ܼ������������
					search(candidates, i, result, rem, results);
				}
				rem.remove(rem.size()-1);   // ��list���Ƴ���ǰ����ֵ
			}else if(result==0) {   // ����õ������ֱ�Ӳ��뵽results��
				rem.add(candidates[index]);   // ����ǰ����ֵ���뵽�м�list��
				results.add(getList(rem));   // �õ������ֱ�Ӳ��뵽results��
				rem.remove(rem.size()-1);   // ��list���Ƴ���ǰ����ֵ
				return;
			}
		}
	}
	/**
	 * ������
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		// ��¼���н����
		List<List<Integer>> results = new LinkedList<List<Integer>>();
		// ���ڼ�¼�м���
		List<Integer> rem = new LinkedList<Integer>();
		// �������п������������������������
		for(int i=candidates.length-1;i>=0;i--) {
			search(candidates, i, target, rem, results);
		}
		// ���ؽ����
		return results;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum cs = new CombinationSum();
		int target = 7;
		int[] candidates = {2,3,5};
		List<List<Integer>> results = cs.combinationSum(candidates, target);
		for(List<Integer> result : results) {
			for(Integer t: result) {
				System.out.print(t);
				System.out.print(", ");
			}
			System.out.println();
		}
	}
}
