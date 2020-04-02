package medium;

public class FindFirstandLastPositionofElementinSortedArray {
	/**
	 * �ҵ�target��һ�γ��ֵĵط�
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	public int getLeft(int[] nums, int left, int right) {
		if(left == right)  // ���left==right˵������Ǳ߽磬ֱ�ӷ���
			return left;
		else {
			int target = nums[right];   // ��ʱ���ұ߾���Ŀ��
			int result = left;   //������߽�Ϊleft
			int mid=left;  // �����м�λ��
			while(left<right) {   // ʹ�ö��ַ��ҵ���߽�
				mid = (left+right)/2;   // �м�λ��
				if(nums[mid]<target) {   // ����м�<target˵����߽���mid�ұߣ����µ�ǰ���ܵ���߽�
					left = mid + 1;
				}else {
					// ������˳������е������������������ж���
					if(mid>0 && nums[mid-1]==target) {   // �����������ߣ����������м�λ����Ȼ==target�����Լ����������
						right = mid - 1;
					}else if(mid>0 && nums[mid-1]<target) {   // ��������������߽�ֱ�ӷ���
						break;
					}else{   // ֻʣ��mid==0�������ֱ�ӷ���
						break;
					}
				}
			}
			if(left==right)
				return left;
			return mid;
		}
	}
	/**
	 * ��Ѱ����߽�˼·һ���������ǶԳƲ���
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	public int getRight(int[] nums, int left, int right) {
		if(left == right) {
			return left;
		}else {
			int target = nums[left];
			int result = left;
			int mid = left;
			while(left<right) {
				mid = (left+right)/2;
				if(nums[mid]>target) {
					right = mid - 1;
				}else {
					if(mid<right && nums[mid+1]==target) {
						left = mid + 1;
					}else if(mid<right && nums[mid+1]<target) {
						break;
					}else {
						break;
					}
				}
			}
			if(left==right)
				return left;
			return mid;
		}
	}
	
	/**
	 * ���ճ���˼·�����в��ң���ͨ�����ַ��ҵ�Ŀ������λ��֮һ��Ȼ��ͨ�����ַ���ȷ�����ұ߽�
	 * @param nums ����
	 * @param target Ŀ��
	 * @return �߽�����
	 */
	public int[] searchRange(int[] nums, int target) {
		if(nums.length==0) {   // �������Ϊ0����targetһ��������������
			int[] result = {-1, -1};
			return result;
		}else if(nums.length==1) {   // ������ݳ���Ϊ1����ֻ��Ҫ�ж��Ƿ����target����
			if(target==nums[0]) {
				int[] result = {0, 0};
				return result;
			}else {
				int[] result = {-1, -1};
				return result;
			}
		}else {   // ��ʼ����
			int left = 0;   // ��ʼ����߽�
			int right = nums.length-1;   // ��ʼ���ұ߽�
			int mid=0;   // ����mid�����ڳ����м�λ��
			int flag = 0;   // ���ڱ���Ƿ��ҵ�target
			while(right>=left) {   // ʹ�ö��ַ��ҵ�targetλ���е�һ��
				mid = (right+left)/2;
				if(nums[mid]==target) {
					flag = 1;
					break;
				}else if(nums[mid]>target) {
					right = mid - 1;
				}else {
					left = mid + 1;
				}
			}
			if(flag==0) {   // ���û���ҵ�target��ֱ�ӷ����Ҳ�������
				int[] result = {-1, -1};
				return result;
			}else {
				left = getLeft(nums, left, mid);   // �ҵ���߽磬Ҳ����target��һ�γ��ֵĵط�
				right = getRight(nums, mid, right);   // �ҵ��ұ߽磬Ҳ����target���һ�γ��ֵĵط�
				int[] result = {left, right};
				return result;
			}
		}
			
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindFirstandLastPositionofElementinSortedArray fflpes = new FindFirstandLastPositionofElementinSortedArray();
		int[] datas = {2,2};
		int target = 2;
		int[] result = fflpes.searchRange(datas, target);
		System.out.println(result[0]);
		System.out.println(result[1]);
		

	}

}
