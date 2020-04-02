package hard;

/**
 * 计算存水量
 * @author mayfly
 *
 */
public class TrappingRainWater {
	/**
	 * 输入数组代表每根柱子的高度，如果两根柱子中间有空隙会存水，计算总的存水量
	 * @param height 每根柱子的高度
	 * @return
	 */
	public int trap(int[] height) {
		// 如果只有不多于两根柱子，则一定不会存水，所以直接返回0即可
		if(height.length<=2)   
			return 0;
		// 记录总的存水量
        int result = 0;
        // 记录所遍历到柱子的索引
        int index = 0;
        // 从左向右遍历，如果一开始的柱子高度为0，则一定不会存水，先过滤掉
        while(height[index]==0 && index<height.length) {
        	index++;
        }
        // 找到第一个有高度的柱子，记录它的高度
        int oldHeight = height[index++];
        // 记录这个柱子的索引
        int oldIndex = index;
        // 从左向右遍历，如果存在柱子比当前柱子高或者，和这个柱子一样高，则中间可能会存水，然后只需要遍历其中存在多少水就可以了
        for(;index<height.length;index++) {
        	// 找到可能存水的柱子
        	if(height[index]>=oldHeight) {
        		int nowHeight = Math.min(oldHeight, height[index]);   // 记录两个柱子中的较低者，它决定了最多能存多少水
        		while(oldIndex<index) {   // 开始将存水的多少记录总值
        			result += (nowHeight-height[oldIndex++]);
        		}
        		oldIndex = index+1;   // 记录之后更新当前记录
        		oldHeight = height[index];
        	}
        }
        // 从左到右遍历过后还存在一种情况，就是左边柱子比右边柱子高的情况，没有记录其中的存水量，所以一样的思路再从右向左走一遍
        index = height.length-1;
        while(height[index]==0 && index>=0) {
        	index--;
        }
        oldHeight = height[index--];
        oldIndex = index;
        for(;index>=0;index--) {
        	if(height[index]>oldHeight) {   // 因为两个柱子一样高的情况已经记录过了，所以只需要判断左边比右边高的情况就可以了
        		int nowHeight = Math.min(oldHeight, height[index]);
        		while(oldIndex>index) {
        			result += (nowHeight-height[oldIndex--]);
        		}
        		oldIndex = index-1;
        		oldHeight = height[index];
        	}
        }
        // 遍历结束，返回结果
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingRainWater trw = new TrappingRainWater();
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trw.trap(height));

	}

}
