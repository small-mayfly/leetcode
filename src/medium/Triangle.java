package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * �Ե����ϼ�����
 * �Ե�ǰ�е�����һ�����֣�����ӵײ�����ǰ���ֵ���С����
 * �ӵײ������n�е�i�����ֵĴ�����Ϊcost(n, i)
 * cost(n, i) = min(cost(n-1,i), cost(n-1,i+1))
 * ���μ��㵽������ֻ��Ψһһ�����
 * @author mayfly
 *
 */
public class Triangle {
	// ʹ��array����linkedlist
	public int minimumTotal_array(List<List<Integer>> triangle) {
		if(triangle.size()==0)
			return 0;
        int[] results = new int[triangle.get(triangle.size()-1).size()];
        
        for(int i=0;i<results.length;i++) {
        	results[i] = triangle.get(triangle.size()-1).get(i);
        }
        
        for(int i=triangle.size()-2;i>-1;i--) {
        	for(int j=0;j<triangle.get(i).size();j++) {
//        		results[j] = Math.min(results[j],results[j+1])+triangle.get(i).get(j);
        		results[j] = (results[j]>results[j+1]?results[j+1]:results[j])+triangle.get(i).get(j);
        	}
        }
		return results[0];
    }
	
	public int minimumTotal2(List<List<Integer>> triangle) {
		if(triangle.size()==0)
			return 0;
		// ����ʹ��list�����������������뵽��list���洢��¼�������ڼ�¼��ֻ��Ҫ��¼ǰһ�е��м��������Կ����ظ�ʹ��
        List<Integer> results = new ArrayList<Integer>();
        // ���ײ���ֱֵ�Ӹ�ֵ����¼������¼���һ�е����д���
        for (Integer integer : triangle.get(triangle.size()-1)) {
			results.add(integer);
		}
        // �Ե��������μ���
        for(int i=triangle.size()-2;i>-1;i--) {
        	for(int j=0;j<triangle.get(i).size();j++) {
        		results.set(j, (results.get(j)>results.get(j+1)?results.get(j+1):results.get(j))+triangle.get(i).get(j));
        	}
        }
		return results.get(0);
    }
	
	// ��������
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle.size()==0)
			return 0;
		// ����ʹ��list�����������������뵽��list���洢��¼�������ڼ�¼��ֻ��Ҫ��¼ǰһ�е��м��������Կ����ظ�ʹ��
        List<Integer> results = new LinkedList<Integer>();
        // ���ײ���ֱֵ�Ӹ�ֵ����¼������¼���һ�е����д���
        for (Integer integer : triangle.get(triangle.size()-1)) {
			results.add(integer);
		}
        // �Ե��������μ���
        for(int i=triangle.size()-2;i>-1;i--) {
        	for(int j=0;j<triangle.get(i).size();j++) {
        		results.set(j, (results.get(j)>results.get(j+1)?results.get(j+1):results.get(j))+triangle.get(i).get(j));
        	}
        }
		return results.get(0);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
