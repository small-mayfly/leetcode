package medium;

/**
 * 
 * 1. 目标解：给出一系列数字A，求出其中上下跌宕的数列的最大长度
 * 2. 假设长度为N：result(N) = maxLen(sequence)
 * 3. result(N) = maxLen{result(N-1), result(N-1)+A[N]}，当前解的最大长度等于上一个计算的最大长度和上一个计算的最大长度的序列加上当前数字组成的序列求解得出的最大长度，两个最大长度的最大值
 * 4. 迭代向后进行到N，求出最后解
 * @author mayfly
 *
 */
public class Wiggle_Subsequence {

	public int wiggleMaxLength(int[] nums) {
		if(nums.length==0)
			return 0;
		else if(nums.length==1) {
			return 1;
		}else if(nums.length==2) {
			if(nums[0]==nums[1])
				return 1;
			else {
				return 2;
			}
		}
		WiggleNode[] wns = new WiggleNode[nums.length];
		wns[0] = new WiggleNode(0, nums[0], 1);   // 第一个数字可以认为一定会加入最终结果序列中
		int flag;
		for(int i=1;i<nums.length;i++) {
			flag = nums[i]-wns[i-1].value;   // 判断当前值和上一个值的差值
			if(flag>0) {   // 如果当前值大于上一个值
				if(wns[i-1].direct==1) {   // 如果出现连续三个上升的局面，则用当前值覆盖上升的最后一个值，这样长度不变
					wns[i] = new WiggleNode(1, nums[i], wns[i-1].len);
				}else if(wns[i-1].direct==-1) {   // 如果出现了凹型，则加入最长序列
					wns[i] = new WiggleNode(1, nums[i], wns[i-1].len+1);
				}else {   // 出现重复，直接忽略
					wns[i] = new WiggleNode(1, nums[i], wns[i-1].len+1);
				}
			}else if(flag<0) {   // 如果当前值小于上一个值
				if(wns[i-1].direct==1) {   // 出现凸型，加入序列
					wns[i] = new WiggleNode(-1, nums[i], wns[i-1].len+1);
				}else if(wns[i-1].direct==-1) {   // 出现连续下降，则用当前值覆盖上升的最后一个值，这样长度不变
					wns[i] = new WiggleNode(-1, nums[i], wns[i-1].len);
				}else {   // 出现重复，直接忽略
					wns[i] = new WiggleNode(-1, nums[i], wns[i-1].len+1);
				}
			}else {   // 如果当前值等于上一个值，因为最终结果序列中不存在重复值，所以可以直接忽略
				wns[i] = new WiggleNode(wns[i-1].direct, wns[i-1].value, wns[i-1].len);
			}
		}
		// 最终最后一个值保留的是最长的满足条件的跌宕序列
		return wns[wns.length-1].len;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Wiggle_Subsequence ws = new Wiggle_Subsequence();
		int[] datas = {1,1,1};
		System.out.println(ws.wiggleMaxLength(datas));
	}

}

class WiggleNode{
	int direct;   // 用以记录当前最长序列的最后一个坡度是上还是下，上升为1，下降为-1，刚开始不知道设置为0
	int value;   // 用以记录当前最长值最后一个数字
	int len;   // 记录当前最大长度
	public WiggleNode(int direct, int value, int len) {
		this.direct = direct;
		this.value = value;
		this.len = len;
	}
}
