package niuke.jianzhioffer;
/**
 * 
 * 统计一个数字在排序数组中出现的次数。
 * @author mayfly
 *
 */
public class NIUKE11190 {
	/**
	 * 首先二分查找找到其中一个位置，然后向两边遍历找到左右端点，然后右端-左端得到长度即为个数
	 * @param array
	 * @param k
	 * @return
	 */
	public int GetNumberOfK(int [] array , int k) {
		// 空数组直接返回
		if(array.length==0)
			return 0;
	    
		int start = 0;
		int end = array.length;
		int mid = 0;
		while(start<end) {
			mid = (start+end)/2;
			if(array[mid]<k) {
				start = mid + 1;
			}else if(array[mid]>k) {
				end = mid;
			}else {
				break;
			}
		}
		if(array[mid]!=k) {
			return 0;
		}else {
			start = mid - 1;
			while(start>=0 && array[start]==k)
				start--;
			end = mid + 1;
			while(end<array.length && array[end]==k)
				end++;
			return end-start-1;
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] datas = {3,3,3,3,4,5};
		System.out.println(new NIUKE11190().GetNumberOfK(datas, 3));

	}

}
