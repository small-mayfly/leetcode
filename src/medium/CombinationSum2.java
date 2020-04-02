package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * ��������������ҽ��
 * @author mayfly
 *
 */
public class CombinationSum2 {
	
	// �����һ�������ȥ�غ�������ս��
	public void addToList(List<List<Integer>> results, List<Integer> rem) {
		boolean flag = false;
		List<Integer> trem = new LinkedList<Integer>();
        for(Integer t: rem) {
            trem.add(t);
        }
        trem.sort(null);
        int sameNum = 0;
		for(List<Integer> result: results) {
			if(result.size()!=rem.size())
				continue;
			else {
				sameNum = 0;
				for(int i=0;i<result.size();i++) {
					if(result.get(i)!=trem.get(i)) {
						break;
					}else {
						sameNum++;
					}
				}
				if(sameNum==rem.size()) {
					flag = true;
					break;
				}
			}
		}
		if(flag==false) {
			results.add(trem);
		}
	}
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
        trem.sort(null);
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
    public void search(List<Integer> datas, int value, List<Integer> rem, List<List<Integer>> results){
        int result;   // ��¼��ȥ��ǰ����λ��ֵ�Ľ��
        int tdata = 0;
        if(datas.size()>0 && value>=0) {
            result = value-datas.get(0);   //��һ�ֽ����ȥ��ǰ����λ��ֵ�Ľ��
            tdata = datas.get(0);
            if(result>0) {   // ������>0������һ�ּ���
            	datas.remove(0);
                rem.add(tdata);   // ����ǰ����ֵ���뵽�м�list��
                search(datas, result, rem, results);
                rem.remove(rem.size()-1);   // ��list���Ƴ���ǰ����ֵ
                search(datas, value, rem, results);
                datas.add(tdata);   // ��list���Ƴ���ǰ����ֵ
            }else if(result==0) {   // ����õ������ֱ�Ӳ��뵽results��
                rem.add(tdata);   // ����ǰ����ֵ���뵽�м�list��
//                results.add(getList(rem));   // �õ������ֱ�Ӳ��뵽results��
                addToList(results, rem);
                rem.remove(rem.size()-1);   // ��list���Ƴ���ǰ����ֵ
                datas.remove(0);
                search(datas, value, rem, results);
                datas.add(tdata);
            }else {
            	datas.remove(0);
            	search(datas, value, rem, results);
            	datas.add(tdata);   // ��list���Ƴ���ǰ����ֵ
            }
        }
    }
    /**
     * ����2����Ԥ�����������޷��񷽰�һ�����������ɵؼ�֦������Ҫ��ʹ�ü�֦���������½�һ��list����¼�Ѿ�������ֵ�����ﲻ�ټ�֦�����ǲ��õó������ȥ��
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // ��¼���н����
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        // ���ڼ�¼�м���
        List<Integer> rem = new LinkedList<Integer>();
        List<Integer> datas = new LinkedList<Integer>();
        for(int i=0;i<candidates.length;i++)
        	datas.add(candidates[i]);
        // �������п������������������������
        search(datas, target, rem, results);
        // ���ؽ����
        return results;
    }
    
    /**
     * ����1���ȶ�candidates�����������ֻ��Ҫ���������ʹ������������β��뼴�ɵõ����н����������ȥ���ظ�������������Ż����Ի�����ظ���ϵ���������˼�֦
     * @param candidates ���к�ѡֵ
     * @param target Ŀ��
     * @return ���ؼ���Ľ��
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // ��¼���н����
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        // ���ڼ�¼�м���
        List<Integer> rem = new LinkedList<Integer>();
        // ��ѡֵ����
        Arrays.sort(candidates);
        // ���ȳ������һ��ֵ��Ҳ��������ֵ��������
        cul(candidates, candidates.length-1, target, rem, results);
        // ��¼��ǰ������������ֵ
        int nowIndex;
        // �ӵ����ڶ�����ʼ����
        for(int i=candidates.length-2;i>=0;i--) {
        	// �������һ�μ�֦��������������ֵͬ��ֻ��Ҫ����һ����������
        	if(candidates[i]!=candidates[i+1]) {   
        		cul(candidates, i, target, rem, results);
        	}
        }
        // ���ؽ����
        return results;
    }
    public void cul(int[] candidates, int nowIndex, int target, List<Integer> rem, List<List<Integer>> results) {
    	// ��ǰ����С��0��ֱ�ӷ���
    	if(nowIndex<0)
    		return;
    	// ���<0��ֱ�ӷ���
    	if(target<0)
    		return;
    	// ��ȥ��ǰ����ֵ�Ľ��
    	int nowResult = target-candidates[nowIndex];
    	// ��������
    	if(nowResult==0) {
    		rem.add(candidates[nowIndex]);   // ����ǰ������ֵ�������Ľ��
    		// ���ɽ�������ڲ������յĽ����
    		List<Integer> trem = new LinkedList<Integer>();
    		for(int data: rem) {
    			trem.add(data);
    		}
    		results.add(trem);   // �������ս��
    		rem.remove(rem.size()-1);   // ��������ȥ����ǰ����ֵ��������ʹ�����ֵ�Ƿ����������
    		// �����ǰ����Ϊ�գ����ʾ������û��ʹ�õ�һ��������Ӧ��ֵ�����ٽ������±�������Ҳ��һ����֦��������ֹ�ͽ������ı������������ظ�
    		// ����{5,2,2,1},target=4,��ֹ���ֱ�������{2,2,1},{2,2,1}����������ظ����
    		if(rem.size()>0) {
    			// ������ǰ���ҿ��ܵĽ��
    			for(int i=1;i<candidates.length;i++) {
    				// �����ж�candidates[nowIndex-i]!=candidates[nowIndex]Ҳ��һ����֦������
    				// ��ֹ���ֱַ����{2,2,2,1},{2,2,1},target=4�����ظ���������
    				if(nowIndex-i>=0 && candidates[nowIndex-i]!=candidates[nowIndex]) {
    					cul(candidates, nowIndex-i, target, rem, results);
    					break;
    				}
    			}
    		}
    	}else if(nowResult>0) {
    		// ��ǰ��û�м�������ս�����򽫵�ǰ����ֵ�������У�ͬʱ��ʼ��һ�ε���
    		rem.add(candidates[nowIndex]);
			cul(candidates, nowIndex-1, nowResult, rem, results);
			rem.remove(rem.size()-1);
			// �����ǰֵ����������λ�����Բ�����ǰ������ԭ��ͬ��һ���ж���ͬ���Ǽ�֦����
    		if(rem.size()>0) {
    			for(int i=1;i<candidates.length;i++) {
    				if(nowIndex-i>=0 && candidates[nowIndex-i]!=candidates[nowIndex]) {
    					cul(candidates, nowIndex-i, target, rem, results);
    					break;
    				}
    			}
    		}
    	}else {// ʣ�½��С��0��������Ѿ�����������Ҫ����������
    		// �������������λ��ֱ�ӽ�������
    		if(rem.size()==0) {
    			return;
    		}else {
    			// �������������λ�����ܽ����������ڽ�������Լ�����ǰ�����������ж�Ҳ��һ����֦����
    			for(int i=1;i<candidates.length;i++) {
    				if(nowIndex-i>=0 && candidates[nowIndex-i]!=candidates[nowIndex]) {
    					cul(candidates, nowIndex-i, target, rem, results);
    					break;
    				}
    			}
    		}
    	}
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CombinationSum2 cs = new CombinationSum2();
        int target = 5;
        int[] candidates = {2,5,2,1,2};
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