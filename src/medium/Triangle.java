package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 自低向上计算结果
 * 对当前行的任意一个数字，求出从底部到当前数字的最小代价
 * 从底部到达第n行第i个数字的代价设为cost(n, i)
 * cost(n, i) = min(cost(n-1,i), cost(n-1,i+1))
 * 依次计算到顶部，只有唯一一个结果
 * @author mayfly
 *
 */
public class Triangle {
	// 使用array代替linkedlist
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
		// 数据使用list传进来，所以优先想到用list来存储记录本，由于记录本只需要记录前一行的中间结果，所以可以重复使用
        List<Integer> results = new ArrayList<Integer>();
        // 将底部的值直接赋值给记录本，记录最后一行的所有代价
        for (Integer integer : triangle.get(triangle.size()-1)) {
			results.add(integer);
		}
        // 自低向上依次计算
        for(int i=triangle.size()-2;i>-1;i--) {
        	for(int j=0;j<triangle.get(i).size();j++) {
        		results.set(j, (results.get(j)>results.get(j+1)?results.get(j+1):results.get(j))+triangle.get(i).get(j));
        	}
        }
		return results.get(0);
    }
	
	// 基础版结果
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle.size()==0)
			return 0;
		// 数据使用list传进来，所以优先想到用list来存储记录本，由于记录本只需要记录前一行的中间结果，所以可以重复使用
        List<Integer> results = new LinkedList<Integer>();
        // 将底部的值直接赋值给记录本，记录最后一行的所有代价
        for (Integer integer : triangle.get(triangle.size()-1)) {
			results.add(integer);
		}
        // 自低向上依次计算
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
