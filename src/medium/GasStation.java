package medium;

public class GasStation {
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
        // 记录循环真正开始的位置
		int startIndex = 0;
		// 记录每一步当前的油量
		int nowGas = 0;
		// 记录当前走了多少步
		int index = 0;
		while(index<gas.length) {
			// 初试状态为刚加满油，当前状态为最好状态
			nowGas += gas[(startIndex+index)%gas.length];
			// 加过油之后开始移动
			nowGas -= cost[(startIndex+index)%gas.length];
			// 如果走不到下一个加油站，则重新开始判断
			if(nowGas<0) {
				// 重置开始位置
				startIndex = startIndex+index+1;
				// 转了一圈了，仍然不行，则返回无结果
				if(startIndex>gas.length)
					return -1;
				// 没有尝试所有情况，继续计算，重新开始计数
				index = 0;
				// 现有油量初始化
				nowGas = 0;
			}else {   // 走得到就继续走
				index++;
			}
		}
		return startIndex%gas.length;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas = {2,3,4};
		int[] cost = {3,4,3};
		System.out.println(new GasStation().canCompleteCircuit(gas, cost));
	}

}
