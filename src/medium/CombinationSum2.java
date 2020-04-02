package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * 利用深度搜索查找结果
 * @author mayfly
 *
 */
public class CombinationSum2 {
	
	// 结果出一个结果后去重后加入最终结果
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
     * 生成一个结果list的copy
     * @param rem 当前计算出的结果
     * @return 返回copy的对象
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
     * 深度搜索结果，搜索到就插入到results中，搜索不到就不管
     * @param candidates 候选集
     * @param index 当前已经遍历到的索引
     * @param value 当前已经减去的结果值，用于本次计算
     * @param rem 当前已经计算出的中间结果引用
     * @param results 结果的引用
     */
    public void search(List<Integer> datas, int value, List<Integer> rem, List<List<Integer>> results){
        int result;   // 记录减去当前索引位置值的结果
        int tdata = 0;
        if(datas.size()>0 && value>=0) {
            result = value-datas.get(0);   //上一轮结果减去当前索引位置值的结果
            tdata = datas.get(0);
            if(result>0) {   // 如果结果>0继续下一轮计算
            	datas.remove(0);
                rem.add(tdata);   // 将当前索引值插入到中间list中
                search(datas, result, rem, results);
                rem.remove(rem.size()-1);   // 从list中移除当前索引值
                search(datas, value, rem, results);
                datas.add(tdata);   // 从list中移除当前索引值
            }else if(result==0) {   // 如果得到结果，直接插入到results中
                rem.add(tdata);   // 将当前索引值插入到中间list中
//                results.add(getList(rem));   // 得到结果，直接插入到results中
                addToList(results, rem);
                rem.remove(rem.size()-1);   // 从list中移除当前索引值
                datas.remove(0);
                search(datas, value, rem, results);
                datas.add(tdata);
            }else {
            	datas.remove(0);
            	search(datas, value, rem, results);
            	datas.add(tdata);   // 从list中移除当前索引值
            }
        }
    }
    /**
     * 方案2，不预先排序，所以无法像方案一那样进行轻松地剪枝操作，要想使用剪枝操作必须新建一个list来记录已经遍历的值，这里不再剪枝，而是采用得出结果后去重
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 记录所有结果集
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        // 用于记录中间结果
        List<Integer> rem = new LinkedList<Integer>();
        List<Integer> datas = new LinkedList<Integer>();
        for(int i=0;i<candidates.length;i++)
        	datas.add(candidates[i]);
        // 遍历所有可能索引，调用深度搜索函数
        search(datas, target, rem, results);
        // 返回结果集
        return results;
    }
    
    /**
     * 方案1，先对candidates排序，排序过后只需要按序遍历，使用深度搜索依次插入即可得到所有结果。但我在去除重复组合这里做了优化，对会出现重复组合的情况进行了剪枝
     * @param candidates 所有候选值
     * @param target 目标
     * @return 返回计算的结果
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 记录所有结果集
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        // 用于记录中间结果
        List<Integer> rem = new LinkedList<Integer>();
        // 候选值排序
        Arrays.sort(candidates);
        // 首先尝试最后一个值，也就是最大的值进行搜索
        cul(candidates, candidates.length-1, target, rem, results);
        // 记录当前遍历到的索引值
        int nowIndex;
        // 从倒数第二个开始搜索
        for(int i=candidates.length-2;i>=0;i--) {
        	// 这里进行一次剪枝，对于连续的相同值，只需要进行一次搜索即可
        	if(candidates[i]!=candidates[i+1]) {   
        		cul(candidates, i, target, rem, results);
        	}
        }
        // 返回结果集
        return results;
    }
    public void cul(int[] candidates, int nowIndex, int target, List<Integer> rem, List<List<Integer>> results) {
    	// 当前索引小于0，直接返回
    	if(nowIndex<0)
    		return;
    	// 结果<0，直接返回
    	if(target<0)
    		return;
    	// 减去当前索引值的结果
    	int nowResult = target-candidates[nowIndex];
    	// 计算出结果
    	if(nowResult==0) {
    		rem.add(candidates[nowIndex]);   // 将当前索引的值插入计算的结果
    		// 生成结果，用于插入最终的结果中
    		List<Integer> trem = new LinkedList<Integer>();
    		for(int data: rem) {
    			trem.add(data);
    		}
    		results.add(trem);   // 插入最终结果
    		rem.remove(rem.size()-1);   // 从序列中去掉当前索引值，看看不使用这个值是否还有其他结果
    		// 如果当前序列为空，则表示序列中没有使用第一个索引对应的值，不再进行向下遍历，这也是一个剪枝操作，防止和接下来的遍历操作出现重复
    		// 比如{5,2,2,1},target=4,防止出现遍历两次{2,2,1},{2,2,1}的情况产生重复结果
    		if(rem.size()>0) {
    			// 依次向前查找可能的结果
    			for(int i=1;i<candidates.length;i++) {
    				// 这里判断candidates[nowIndex-i]!=candidates[nowIndex]也是一个剪枝操作，
    				// 防止出现分别遍历{2,2,2,1},{2,2,1},target=4产生重复结果的情况
    				if(nowIndex-i>=0 && candidates[nowIndex-i]!=candidates[nowIndex]) {
    					cul(candidates, nowIndex-i, target, rem, results);
    					break;
    				}
    			}
    		}
    	}else if(nowResult>0) {
    		// 当前还没有计算出最终结果，则将当前索引值加入序列，同时开始下一次迭代
    		rem.add(candidates[nowIndex]);
			cul(candidates, nowIndex-1, nowResult, rem, results);
			rem.remove(rem.size()-1);
			// 如果当前值不是序列首位，则尝试不加向前遍历，原理同上一个判断相同，是剪枝操作
    		if(rem.size()>0) {
    			for(int i=1;i<candidates.length;i++) {
    				if(nowIndex-i>=0 && candidates[nowIndex-i]!=candidates[nowIndex]) {
    					cul(candidates, nowIndex-i, target, rem, results);
    					break;
    				}
    			}
    		}
    	}else {// 剩下结果小于0的情况，已经超出，不需要继续计算了
    		// 如果这是序列首位，直接结束搜索
    		if(rem.size()==0) {
    			return;
    		}else {
    			// 如果不是序列首位，可能接下来还存在结果，所以继续向前遍历，这样判断也是一个剪枝操作
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