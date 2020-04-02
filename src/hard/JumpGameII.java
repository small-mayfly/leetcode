package hard;

public class JumpGameII {
	
	public int jump2(int[] nums) {
		if(nums.length<=1)   // 如果长度为1，则初始状态就在末尾，直接返回
			return 0;
		
		// 因为初试是在index=0的位置，所以直接从step=1的情况开始遍历
		// step等于1的工作区间为1~nums[0]之间
		int nextStart = 1;   // 记录当前步所有可能位置的最小值
		int nextEnd = nums[0];   // 记录当前步所有可能的位置的最大值
		int index = nextStart;   // 从当前可能位置最小值开始遍历到最大值，找到下一步所有可能到达位置的区间
		int result = nextEnd;   // 记录当前所到达的最大位置
		int step = 1;   // 从step1开始遍历
		while(true) {   // 一直循环到遍历到最后一个数字结束
			if(result>=nums.length-1)   // 遍历到最后一个数字，结束程序，返回走了多少步
				return step;
			for(;index<=nextEnd;index++) {   // 从开始位置开始遍历，一直到本步可能位置的最大值结束
				if(index+nums[index]>result)   // 如果从当前位置出发，下一步可能到达的最大位置比result大，则表明本次能走更远，所以替换result
					result = index+nums[index];
			}
			// 经过一轮遍历，能找到下一步所能到达的位置的最大值
			
			// 下一步遍历的开始位置为当前步所能到达位置的最大值的下一个位置，这样可以减少重复遍历，同时这一步能到达的位置小于本轮可能到达的最大值的话如果继续运算，则会有多走路的情况
			nextStart = nextEnd + 1;
			// 更换下一步可能到达的最大位置
			nextEnd = result;
			// 设置下一轮遍历的开始位置
			index = nextStart;
			// 更新走了多少步
			step++;
		}
	}
	
	/**
	 * 采用广度优先遍历的方法从前向后依次走，时间复杂度为n^2
	 * 同时使用同一个数组记录到达当前点所有step，如果到达所用step比之前的要多，则剪枝，剪枝操作进一步降低复杂度
	 * @param nums
	 * @return
	 */
	public int jump(int[] nums) {
		if(nums.length<=1)   // 如果长度为1，则初始状态就在末尾，直接返回
			return 0;
		// 新建数组，用以记录是第几步到达当前位置
		int[] rem = new int[nums.length];
		// 初始状态为不可达
		for(int i=0;i<nums.length;i++)
			rem[i]=Integer.MAX_VALUE;
		// 初始状态在第一个数字上
		rem[0] = 0;
		int step = 1;   // 记录是第几步走到的当前位置
		for(int i=0;i<nums.length;i++) {
			step = rem[i]+1;   // 从当前位置出发，则下一次可到的点所有步数为当前步数
			for(int j=i+1;j<=i+nums[i] && j<nums.length;j++) {   // 查看所有从这一点出发一步可达的点
				if(rem[j]>step) {   // 如果这一点之前没有到达过，则认为从初始点到当前点最少需要step步
					rem[j]=step;
				}
			}
			// 如果已经找到最后一点，则直接返回，因为是一步一步迭代着向后走，所以第一个到达的一定是步数最少的
			if(rem[nums.length-1]!=Integer.MAX_VALUE)
				return step;
		}
		return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpGameII jgii = new JumpGameII();
		int[] datas = {2,3,1,1,4};
		System.out.println(jgii.jump(datas));
		System.out.println(jgii.jump2(datas));
	}

}
