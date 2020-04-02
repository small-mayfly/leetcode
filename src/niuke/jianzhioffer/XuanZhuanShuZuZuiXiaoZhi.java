package niuke.jianzhioffer;
/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author mayfly
 *
 */
public class XuanZhuanShuZuZuiXiaoZhi {
	public int minNumberInRotateArray(int [] array) {
		// 若数组大小为0，返回0
		if(array.length==0)
			return 0;
		// 如果最后一个数字不大于第一个数字，说明发生过旋转，或者所有数字都相等
		if(array[0]>=array[array.length-1]) {
			int index = array.length-1;   // 获取最后一位数字的索引
			while(array[index]>=array[index-1] && index>0) {   // 向前依次遍历，知道出现前一个数字大于后一个数字的情况，此时这个后一个数字就是最小值
				index--;
			}
			return array[index];
		}else {   // 没有发生过旋转，一定是第一个数字最小
			return array[0];
		}
	    
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
