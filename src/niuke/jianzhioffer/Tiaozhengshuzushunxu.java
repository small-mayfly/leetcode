package niuke.jianzhioffer;
/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author mayfly
 * 一维动态规划问题。假设前n个都为奇数，接下来k个都为偶数，然后又遇到一个奇数，此时，只需要记录当前奇数值，然后把k个偶数依次向后移动一位，然后把当前奇数值放在n个奇数后面，这样就能保证前n+1+k位为满足条件的答案
 */
public class Tiaozhengshuzushunxu {
	
	public void reOrderArray(int [] array) {
		if(array.length<=1) {
			return;
		}
		int start = 0;
		int end;
		int temp;
		while(array[start]%2==1) {
			start++;
		}
		end = start;
		while(end<array.length) {
			if(array[end]%2==1) {
				temp = array[end];
				for(int i=end-1;i>=start;i--) {
					array[i+1] = array[i];
				}
				array[start] = temp;
				start++;
			}
			end++;
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tiaozhengshuzushunxu t = new Tiaozhengshuzushunxu();
		int[] datas = {1,2,3,4,5,6,7};
		t.reOrderArray(datas);
		for(int i=0;i<datas.length;i++) {
			System.out.println(datas[i]);
		}
	}

}
