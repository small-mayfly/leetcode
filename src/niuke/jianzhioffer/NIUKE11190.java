package niuke.jianzhioffer;
/**
 * 
 * ͳ��һ�����������������г��ֵĴ�����
 * @author mayfly
 *
 */
public class NIUKE11190 {
	/**
	 * ���ȶ��ֲ����ҵ�����һ��λ�ã�Ȼ�������߱����ҵ����Ҷ˵㣬Ȼ���Ҷ�-��˵õ����ȼ�Ϊ����
	 * @param array
	 * @param k
	 * @return
	 */
	public int GetNumberOfK(int [] array , int k) {
		// ������ֱ�ӷ���
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
